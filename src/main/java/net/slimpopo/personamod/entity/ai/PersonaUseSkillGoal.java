package net.slimpopo.personamod.entity.ai;

import net.minecraft.core.Holder;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.slimpopo.personamod.constant.spell.Spell;
import net.slimpopo.personamod.entity.custom.constants.PersonaEntity;
import net.slimpopo.personamod.entity.custom.group.*;
import net.slimpopo.personamod.entity.custom.personas.pyrojack.PyroJackEntity;
import net.slimpopo.personamod.entity.custom.projectile.PersonaThrowableItemProjectile;
import net.slimpopo.personamod.entity.custom.single.*;
import net.slimpopo.personamod.item.constants.SpellItem;
import net.slimpopo.personamod.item.constants.SpellList;
import net.slimpopo.personamod.item.constants.SupportSpellItem;

import java.util.List;
import java.util.Locale;
import java.util.Random;

public class PersonaUseSkillGoal extends MeleeAttackGoal {
    private final PersonaEntity entity;
    private int attackDelay = 10;
    private int ticksUntilNextAttack = 40;
    private boolean shouldCountTillNextAttack = false;

    private final List<SpellItem> spellsToChoose;

    public PersonaUseSkillGoal(PathfinderMob pMob, double pSpeedModifier, boolean pFollowingTargetEvenIfNotSeen, 
                               List<SpellItem> spellsToChoose) {
        super(pMob, pSpeedModifier, pFollowingTargetEvenIfNotSeen);
        entity = ((PersonaEntity) pMob);
        this.spellsToChoose = spellsToChoose;
    }


    @Override
    public void tick() {
        super.tick();
        if(shouldCountTillNextAttack){
            this.ticksUntilNextAttack = Math.max(this.ticksUntilNextAttack - 1, 0);
        }
    }

    @Override
    public void start() {
        super.start();
        this.attackDelay = 40;
        this.ticksUntilNextAttack = 80;
    }

    @Override
    public void stop() {
        entity.setAttacking(false);
        super.stop();
    }

    @Override
    protected void checkAndPerformAttack(LivingEntity pEnemy, double pDistToEnemySqr) {
        if(isWithinMeleeAttackDistance(pEnemy,pDistToEnemySqr)){
            shouldCountTillNextAttack = true;
            if(isTimeToStartAttackAnimation()){
                entity.setAttacking(true);
            }

            if(isTimeToAttack()){
                this.mob.getLookControl().setLookAt(pEnemy.getX(),pEnemy.getEyeY(),pEnemy.getZ());
                performPhysicalAttack(pEnemy);
            }
        }
        else if(isWithinRangedAttackDistance(pEnemy,pDistToEnemySqr)){
            shouldCountTillNextAttack = true;
            if(isTimeToStartAttackAnimation()){
                entity.setAttacking(true);
            }

            if(isTimeToAttack()){
                this.mob.getLookControl().setLookAt(pEnemy.getX(),pEnemy.getEyeY(),pEnemy.getZ());
                performSpellAttack(pEnemy);
            }
        }
        else{
            resetAttackCooldown();
            shouldCountTillNextAttack = false;
            entity.setAttacking(false);
            entity.attackAnimationTimeOut = 0;
        }
    }

    private void performPhysicalAttack(LivingEntity pEnemy) {
    }

    private boolean isWithinRangedAttackDistance(LivingEntity pEnemy, double pDistToEnemySqr) {
        return pDistToEnemySqr + 1 > this.getAttackReachSqr(pEnemy)   &&
                pDistToEnemySqr + 1 <= (this.getAttackReachSqr(pEnemy)*2d);
    }

    private void performSpellAttack(LivingEntity pEnemy) {
        SpellItem spellItem = pickRandomSkillToChoose();
        
        if(spellItem instanceof SupportSpellItem ssi){
            if(!ssi.isBeneficial()) {
                var players = getPlayersWithinRange(ssi.getSpellData().getSPELL_LEVEL().getRange() * 2);
                players.forEach(player -> {
                    addEffectsToTarget(player,ssi);
                });
            }
            else{
                var mobs = getNonPlayersWithinRange(ssi.getSpellData().getSPELL_LEVEL().getRange() * 2);
                mobs.forEach(mob -> {
                    addEffectsToTarget(mob,ssi);
                });
            }
        }
        else {
            PersonaThrowableItemProjectile basicProjectile = 
                    getProjectileFromSpellInformation(spellItem.getSpellData());
            double d0 = pEnemy.getEyeY() - (double)1.1F;
            double d1 = pEnemy.getX() - entity.getX();
            double d2 = d0 - basicProjectile.getY();
            double d3 = pEnemy.getZ() - entity.getZ();
            double d4 = Math.sqrt(d1 * d1 + d3 * d3) * (double)0.2F;
            basicProjectile.shoot(d1, d2 + d4, d3, 1.6F, 12.0F);
            entity.playSound(SoundEvents.SNOW_GOLEM_SHOOT, 1.0F, 0.4F / (entity.getRandom().nextFloat() * 0.4F + 0.8F));
            entity.level().addFreshEntity(basicProjectile);
        }
    }

    private SpellItem pickRandomSkillToChoose() {
        Random random = new Random();
        return spellsToChoose.get(Math.abs(random.nextInt() % spellsToChoose.size()));
    }

    private boolean isTimeToStartAttackAnimation() {
        return this.ticksUntilNextAttack >= attackDelay;
    }

    private boolean isWithinMeleeAttackDistance(LivingEntity pEnemy, double pDistToEnemySqr) {
        return pDistToEnemySqr <= this.getAttackReachSqr(pEnemy);
    }

    private List<Player> getPlayersWithinRange( int range) {
        return entity.level().getEntitiesOfClass(Player.class,entity.getBoundingBox().inflate(range));
    }

    private List<PersonaEntity> getNonPlayersWithinRange( int range) {
        return entity.level().getEntitiesOfClass(PersonaEntity.class,entity.getBoundingBox().inflate(range));
    }
    
    protected void addEffectsToTarget(LivingEntity targetplayer, SupportSpellItem supportSpellItem) {
        supportSpellItem.getMobEffectInstances().forEach(mobEffectInstance -> {
            targetplayer.addEffect(mobEffectInstance);
        });
    }
    
    private PersonaThrowableItemProjectile getProjectileFromSpellInformation(Spell spell){
        //check Element
        boolean hasMaInSpellName = spell.getSPELL_NAME().toLowerCase(Locale.ROOT).contains("ma") ||
                spell.getSPELL_NAME().toLowerCase(Locale.ROOT).contains("megido");
        if(hasMaInSpellName){
            switch (spell.getAFFINITY()){
                case FIRE -> {
                    return new MaFlameThrowable(entity.level(),entity,spell);
                }
                case ICE -> {
                    return new MaIceThrowable(entity.level(),entity,spell);
                }
                case ELECTRIC -> {
                    return new MaElectricThrowable(entity.level(),entity,spell);
                }
                case NUCLEAR -> {
                    return new MaNukeThrowable(entity.level(),entity,spell);
                }
                case PSYCHOKINESIS -> {
                    return new MaPsiThrowable(entity.level(),entity,spell);
                }
                case ALMIGHTY -> {
                    return new MaAlmightyThrowable(entity.level(),entity,spell);
                }
                case CURSE -> {
                    if(spell.getSPELL_NAME().toLowerCase(Locale.ROOT).contains("mudo"))
                        return new MaCurseMudoThrowable(entity.level(),entity, spell,0.0f);
                    return new MaCurseThrowable(entity.level(),entity, spell);
                } 
                case BLESS -> {
                    if(spell.getSPELL_NAME().toLowerCase(Locale.ROOT).contains("hama"))
                        return new MaBlessHamaThrowable(entity.level(),entity, spell,0.0f);
                    return new MaBlessThrowable(entity.level(),entity, spell);
                }
            }
        }
        else{
            switch (spell.getAFFINITY()){
                case FIRE -> {
                    return new FlameThrowable(entity.level(),entity,spell);
                }
                case ICE -> {
                    return new IceThrowable(entity.level(),entity,spell);
                }
                case ELECTRIC -> {
                    return new ElectricThrowable(entity.level(),entity,spell);
                }
                case NUCLEAR -> {
                    return new NukeThrowable(entity.level(),entity,spell);
                }
                case PSYCHOKINESIS -> {
                    return new PsiThrowable(entity.level(),entity,spell);
                }
                case ALMIGHTY -> {
                    return new AlmightyThrowable(entity.level(),entity,spell);
                }
                case CURSE -> {
                    if(spell.getSPELL_NAME().toLowerCase(Locale.ROOT).contains("mudo"))
                        return new CurseMudoThrowable(entity.level(),entity, spell,0.0f);
                    return new CurseThrowable(entity.level(),entity, spell);
                }
                case BLESS -> {
                    if(spell.getSPELL_NAME().toLowerCase(Locale.ROOT).contains("hama"))
                        return new BlessHamaThrowable(entity.level(),entity, spell,0.0f);
                    return new BlessThrowable(entity.level(),entity, spell);
                }
            }
        }
        return null;
    }
    
}
