package net.slimpopo.personamod.item.constants;

import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.SlotAccess;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ClickAction;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.minecraft.world.phys.AABB;
import net.slimpopo.personamod.capability.persona.PlayerPersonaProvider;
import net.slimpopo.personamod.constant.damage.Affinity;
import net.slimpopo.personamod.constant.damage.RangeType;
import net.slimpopo.personamod.constant.entity.ControlledPersona;
import net.slimpopo.personamod.constant.spell.PhysicalSpell;
import net.slimpopo.personamod.constant.spell.Spell;
import net.slimpopo.personamod.damagesource.ModDamageSources;
import net.slimpopo.personamod.entity.custom.constants.PersonaEntity;
import net.slimpopo.personamod.networking.ModMessages;
import net.slimpopo.personamod.networking.packet.PersonaPlayerSpS2CPacket;

import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicReference;

public class PhysicalSpellItem extends SpellItem {

    public PhysicalSpellItem(Properties pProperties, String spellName) {
        super(pProperties,spellName);
    }

    public PhysicalSpellItem(Properties pProperties, Spell spellData) {
        super(pProperties, spellData);
    }

    protected boolean hasEnoughHealthToCast(float health, float maxHealth) {
        return health >= maxHealth * this.spellData.getHealthCost();
    }

    protected boolean hasEnoughSpToCast(int sp) {
        return sp >= this.spellData.getSpCost();
    }

    protected boolean doesSpellHaveSpCost() {
        return null != this.spellData.getSpCost();
    }

    @Override
    public boolean isDamageable(ItemStack stack) {
        return false;
    }

    public Spell getSpellData() {
        return spellData;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        if(!pLevel.isClientSide){
            if(isAbleToPerformSkill(pLevel,pPlayer)){
                var mobs = getMobsWithinRange((ServerPlayer) pPlayer,(ServerLevel) pLevel,10);
                mobs.forEach(livingEntity -> {
                    if(livingEntity instanceof PersonaEntity shadow){
                        float damage = getDamageFromPersonaEntitySource(pPlayer,shadow);
                        shadow.hurt(new ModDamageSources(pLevel.registryAccess())
                                .personaDamage(pPlayer, shadow), damage);


                    }
                    else{
                        livingEntity.hurt(new ModDamageSources(pLevel.registryAccess())
                                .personaDamage(pPlayer, livingEntity), 1.0f);
                    }

                    if(null != this.spellData.getSPELL_EFFECT()){
                        Random random = new Random();
                        if(random.nextFloat() > 0.85f){
                            livingEntity.addEffect(this.spellData.getSPELL_EFFECT());
                        }
                    }
                });
                return super.use(pLevel, pPlayer, pUsedHand);

            }
        }
        return InteractionResultHolder.fail(pPlayer.getItemInHand(pUsedHand));

    }

    protected List<ServerPlayer> getPlayersWithinRange(ServerPlayer player, ServerLevel level, int range) {
        if(((PhysicalSpell)spellData).getSPELL_RANGE_TYPE() == RangeType.NARROW){
            return level.getEntitiesOfClass(ServerPlayer.class, AABB.of(new BoundingBox(player.blockPosition().north()
                    .above())).inflate(2,10,3));
        }
        else
            return level.getEntitiesOfClass(ServerPlayer.class,player.getBoundingBox().inflate(range));
    }

    protected List<LivingEntity> getMobsWithinRange(ServerPlayer player, ServerLevel level, int range) {
        if(((PhysicalSpell)spellData).getSPELL_RANGE_TYPE() == RangeType.NARROW){
            return level.getEntitiesOfClass(LivingEntity.class, AABB.of(new BoundingBox(player.blockPosition().north()
                    .above())).inflate(2,10,3));
        }
        else
            return level.getEntitiesOfClass(LivingEntity.class,player.getBoundingBox().inflate(range));
    }

    private float getDamageFromPersonaEntitySource(Entity source, PersonaEntity personaEntity) {
        if(source instanceof Player player){
            return calculatePersonaDamage(player, personaEntity);

        }
        else if(source instanceof PersonaEntity pe){
            return calculatePersonaDamage(pe, personaEntity);
        }
        return 1f;
    }

    private float calculatePersonaDamage(Entity source, PersonaEntity personaEntity) {
        AtomicReference<Float> damage = new AtomicReference<>(0f);
        if(personaEntity.getPersonaData().getReflectAgainst().contains(this.spellData.getAFFINITY())){
            this.spellData.setHasBeenRepelled(true);
            if(source instanceof Player player) {
                calculatePlayerPersonaDamage(player, damage, personaEntity);
            }
            else if(source instanceof PersonaEntity personaEntity1)
                damage.set(personaEntity.getPersonaData()
                        .getDamageNumberBasedOnSpell(this.spellData, personaEntity1.getPersonaData(),1f));
        }
        else {
            if(source instanceof PersonaEntity personaEntity1)
                damage.set(personaEntity.getPersonaData()
                        .getDamageNumberBasedOnSpell(this.spellData, personaEntity1.getPersonaData(),1f));
            else if(source instanceof Player player)
                calculatePlayerPersonaDamage(player, damage, personaEntity);
            else
                damage.set(1f);

        }
        return damage.get();
    }

    private void calculatePlayerPersonaDamage(Player player, AtomicReference<Float> damage, PersonaEntity personaEntity) {
        player.getCapability(PlayerPersonaProvider.PLAYER_PERSONA).ifPresent(playerPersona -> {
            ControlledPersona cp = playerPersona
                    .getControlledPersonaFromIndex(playerPersona.getCurrentPersonaIndex());

            float multiplier = 1f;

            if(playerPersona.isUsedChargeSkill() && (this.spellData.getAFFINITY() == Affinity.PHYSICAL || this.spellData.getAFFINITY() == Affinity.GUN)){
                playerPersona.setUsedChargeSkill(false);
                multiplier = 2f;
            }

            if(playerPersona.isUsedConcentrateSkill() &&
                    (this.spellData.getAFFINITY() != Affinity.PHYSICAL && this.spellData.getAFFINITY() != Affinity.GUN)){
                playerPersona.setUsedConcentrateSkill(false);
                multiplier = 2f;
            }

            if(this.spellData.getAFFINITY() != Affinity.PHYSICAL && this.spellData.getAFFINITY() != Affinity.GUN){
                multiplier *= playerPersona.getStrMultiplier();
            }

            damage.set(multiplier * cp.getDamageNumberBasedOnSpell(this.spellData, personaEntity.getPersonaData(),playerPersona.getEndMultiplier()));


        });
    }

    private float calculatePersonaDamage(Entity source, ControlledPersona cp) {
        AtomicReference<Float> damage = new AtomicReference<>(0f);

        if(cp.getReflectAgainst().contains(this.spellData.getAFFINITY())){
            this.spellData.setHasBeenRepelled(true);
            if(source instanceof Player playerSrc) {
                playerSrc.getCapability(PlayerPersonaProvider.PLAYER_PERSONA).ifPresent(playerPersona -> {
                    ControlledPersona cp2 = playerPersona.getCurrentPersona();
                    damage.set(cp.getDamageNumberBasedOnSpell(this.spellData, cp2,playerPersona.getEndMultiplier()));


                });
            }
        }
        else {
            if(source instanceof PersonaEntity pe)
                damage.set(cp.getDamageNumberBasedOnSpell(this.spellData, pe.getPersonaData(),1f));
            else
                damage.set(1f);

        }
        return damage.get();
    }


}
