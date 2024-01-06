package net.slimpopo.personamod.entity.custom.single;

import net.minecraft.client.Minecraft;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
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
import net.slimpopo.personamod.constant.spell.Spell;
import net.slimpopo.personamod.damagesource.ModDamageSources;
import net.slimpopo.personamod.effects.ModEffects;
import net.slimpopo.personamod.entity.ModEntities;
import net.slimpopo.personamod.entity.custom.SkillThrowable;
import net.slimpopo.personamod.entity.custom.constants.PersonaEntity;
import net.slimpopo.personamod.entity.custom.projectile.PersonaThrowableItemProjectile;
import net.slimpopo.personamod.item.ModItems;

import java.util.Random;

public class CurseMudoThrowable extends PersonaThrowableItemProjectile {

    private Spell spellInformation;
    private float chanceIncrease;

    public CurseMudoThrowable(EntityType<? extends ThrowableItemProjectile> entityType, Level pLevel){
        super(entityType,pLevel,null);
    }

    public CurseMudoThrowable(Level pLevel){
        super(ModEntities.CURSE_MUDO_THROWABLE.get(),pLevel,null);
    }

    public CurseMudoThrowable(Level pLevel, LivingEntity livingEntity){
        super(ModEntities.CURSE_MUDO_THROWABLE.get(), livingEntity, pLevel,null);
    }

    public CurseMudoThrowable(Level pLevel, Spell spellData) {
        super(ModEntities.CURSE_MUDO_THROWABLE.get(), pLevel,spellData);
    }

    public CurseMudoThrowable(Level pLevel, LivingEntity livingEntity, Spell spellInformation,
                              float chanceIncrease) {
        super(ModEntities.CURSE_MUDO_THROWABLE.get(), livingEntity,pLevel,spellInformation);
        this.spellInformation = spellInformation;
        this.chanceIncrease = chanceIncrease;

    }

    @Override
    protected void onHitEntity(EntityHitResult pResult) {
        super.onHitEntity(pResult);
        if (!this.level().isClientSide) {
            this.level().broadcastEntityEvent(this, (byte)3);

            Entity entity = pResult.getEntity();
            if (!entity.fireImmune()) {
                Entity entity1 = this.getOwner();
                if (entity1 instanceof LivingEntity) {
                    Random random = new Random();
                    if(random.nextFloat() > 0.90f - chanceIncrease) {
                        if(entity instanceof PersonaEntity personaEntity) {
                            if(personaEntity.getPersonaData().isUsedTetrajaSkill()){
                                personaEntity.getPersonaData().setUsedTetrajaSkill(false);
                            }
                            else
                                personaEntity.die(new ModDamageSources(level().registryAccess())
                                        .personaDamage(entity1, null));
                        }
                        if(entity instanceof Player player) {
                            player.getCapability(PlayerPersonaProvider.PLAYER_PERSONA).ifPresent(playerPersona -> {
                                if(playerPersona.isUsedTetrajaSkill()){
                                    playerPersona.setUsedTetrajaSkill(false);
                                }
                                else
                                    player.die(new ModDamageSources(level().registryAccess())
                                            .personaDamage(entity1, null));
                            });

                        }
                        else {
                            ((LivingEntity) entity).die(new ModDamageSources(level().registryAccess())
                                    .personaDamage(entity1, null));
                        }
                    }
                    this.doEnchantDamageEffects((LivingEntity)entity1, entity);
                }
            }

        }

        this.discard();

    }



    @Override
    protected Item getDefaultItem() {
        return ModItems.CURSETHROWABLE.get();
    }
}
