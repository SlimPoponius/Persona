package net.slimpopo.personamod.entity.custom.projectile;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.slimpopo.personamod.capability.persona.PlayerPersonaProvider;
import net.slimpopo.personamod.constant.damage.Affinity;
import net.slimpopo.personamod.constant.entity.ControlledPersona;
import net.slimpopo.personamod.constant.spell.Spell;
import net.slimpopo.personamod.damagesource.ModDamageSources;
import net.slimpopo.personamod.effects.ModEffects;
import net.slimpopo.personamod.entity.custom.SkillThrowable;
import net.slimpopo.personamod.entity.custom.constants.ControlledPersonaEntity;
import net.slimpopo.personamod.entity.custom.constants.PersonaEntity;
import net.slimpopo.personamod.item.constants.SpellList;

import java.util.concurrent.atomic.AtomicReference;

public class PersonaThrowableItemProjectile extends ThrowableItemProjectile {

    private Spell spell;

    public PersonaThrowableItemProjectile(EntityType<? extends ThrowableItemProjectile> pEntityType, Level pLevel,
                                          Spell spell) {
        super(pEntityType, pLevel);
        this.spell = spell;
    }

    public PersonaThrowableItemProjectile(EntityType<? extends ThrowableItemProjectile> pEntityType, LivingEntity pShooter,
                                          Level pLevel, Spell spell) {
        super(pEntityType, pShooter, pLevel);
        this.spell = spell;
    }

    @Override
    protected Item getDefaultItem() {
        return null;
    }

    @Override
    protected void onHitBlock(BlockHitResult pResult) {
        Level pLevel = this.level();

        if(!pLevel.isClientSide){
            this.level().broadcastEntityEvent(this, (byte)3);
            SkillThrowable projectile = new SkillThrowable();
            projectile.getBlockArea(pResult.getBlockPos(),pLevel,spell);
        }

        this.discard();
        super.onHitBlock(pResult);
    }

    @Override
    protected void onHitEntity(EntityHitResult pResult) {

        if(!this.level().isClientSide) {

            this.level().broadcastEntityEvent(this, (byte)3);

            Entity entity = pResult.getEntity();
            Entity source = this.getOwner();

            int multiplier = 1;
            if(entity instanceof LivingEntity){
                if(hasStatusesToNuke((LivingEntity) entity)){
                    multiplier = 2;
                }
            }

            float damage = 1f;
            if (entity instanceof PersonaEntity personaEntity) {
                damage = multiplier * getDamageFromPersonaEntitySource(source, personaEntity);
            }
            else if (entity instanceof Player player) {
                AtomicReference<Float> dataFromPlayer = new AtomicReference<>(1f);
                player.getCapability(PlayerPersonaProvider.PLAYER_PERSONA).ifPresent(playerPersona -> {
                    ControlledPersona cp = playerPersona.getCurrentPersona();
                    dataFromPlayer.set(getDamageFromControlledPersonaEntitySource(source, cp));
                });
                damage = multiplier * dataFromPlayer.get();
            }

            entity.hurt(new ModDamageSources(level().registryAccess())
                    .personaDamage(source, null), damage);
        }
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

    private float getDamageFromControlledPersonaEntitySource(Entity source, ControlledPersona personaEntity) {
        return calculatePersonaDamage(source, personaEntity);
    }

    private float calculatePersonaDamage(Entity source, PersonaEntity personaEntity) {
        AtomicReference<Float> damage = new AtomicReference<>(0f);
        if(personaEntity.getPersonaData().getReflectAgainst().contains(spell.getAFFINITY())){
            spell.setHasBeenRepelled(true);
            if(source instanceof Player player) {
                calculatePlayerPersonaDamage(player, damage, personaEntity);
            }
            else if(source instanceof PersonaEntity personaEntity1)
                damage.set(personaEntity.getPersonaData()
                        .getDamageNumberBasedOnSpell(spell, personaEntity1.getPersonaData(),1f));
        }
        else {
            if(source instanceof PersonaEntity personaEntity1)
                damage.set(personaEntity.getPersonaData()
                        .getDamageNumberBasedOnSpell(spell, personaEntity1.getPersonaData(),1f));
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

            if(playerPersona.isUsedChargeSkill() && (spell.getAFFINITY() == Affinity.PHYSICAL || spell.getAFFINITY() == Affinity.GUN)){
                playerPersona.setUsedChargeSkill(false);
                multiplier = 2f;
            }

            if(playerPersona.isUsedConcentrateSkill() &&
                    (spell.getAFFINITY() != Affinity.PHYSICAL && spell.getAFFINITY() != Affinity.GUN)){
                playerPersona.setUsedConcentrateSkill(false);
                multiplier = 2f;
            }

            if(spell.getAFFINITY() != Affinity.PHYSICAL && spell.getAFFINITY() != Affinity.GUN){
                multiplier *= playerPersona.getStrMultiplier();
            }

            damage.set(multiplier * cp.getDamageNumberBasedOnSpell(spell, personaEntity.getPersonaData(),playerPersona.getEndMultiplier()));


        });
    }

    private float calculatePersonaDamage(Entity source, ControlledPersona cp) {
        AtomicReference<Float> damage = new AtomicReference<>(0f);

        if(cp.getReflectAgainst().contains(spell.getAFFINITY())){
            spell.setHasBeenRepelled(true);
            if(source instanceof Player playerSrc) {
                playerSrc.getCapability(PlayerPersonaProvider.PLAYER_PERSONA).ifPresent(playerPersona -> {
                    ControlledPersona cp2 = playerPersona.getCurrentPersona();
                    damage.set(cp.getDamageNumberBasedOnSpell(spell, cp2,playerPersona.getEndMultiplier()));


                });
            }
        }
        else {
            if(source instanceof PersonaEntity pe)
                damage.set(cp.getDamageNumberBasedOnSpell(spell, pe.getPersonaData(),1f));
            else
                damage.set(1f);

        }
        return damage.get();
    }

    @Override
    public void addAdditionalSaveData(CompoundTag pCompound) {
        pCompound.putString("spell",spell.getSPELL_NAME());
        super.addAdditionalSaveData(pCompound);
    }

    @Override
    public void readAdditionalSaveData(CompoundTag pCompound) {
        this.spell = SpellList.getSpellDataWithName(pCompound.getString("spell"));
        super.readAdditionalSaveData(pCompound);
    }

    private boolean hasStatusesToNuke(LivingEntity entity) {
        return entity.hasEffect(ModEffects.BURN.get()) ||
                entity.hasEffect(ModEffects.FREEZE.get()) ||
                entity.hasEffect(ModEffects.SHOCK.get());
    }
}
