package net.slimpopo.personamod.entity.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.minecraft.world.phys.AABB;
import net.slimpopo.personamod.effects.ModEffects;
import net.slimpopo.personamod.constant.damage.Affinity;
import net.slimpopo.personamod.constant.spell.Spell;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Objects;
import java.util.Random;

public class SkillThrowable{

    public void  getBlockArea(BlockPos bPos, Level pLevel, Spell spellInformation){
        if(null != spellInformation) {
            int sideWidth = spellInformation.getSPELL_LEVEL().getRange() / 2;
            int sideLength = spellInformation.getSPELL_LEVEL().getRange() / 2;

            BlockPos pos = bPos.relative(Direction.DOWN);
            BlockState affectState = spellInformation.getBlock().defaultBlockState();


            if (sideLength < 1 && sideWidth < 1) {
                pLevel.setBlock(pos.above(), affectState, 11);
            } else {
                for (int i = -sideLength; i < sideLength; i++) {
                    for (int j = -sideWidth; j < sideWidth; j++) {
                        BlockPos tempPos = pos.offset(i, 0, j);
                        pLevel.setBlock(tempPos.above(), affectState, 11);
                    }
                }
            }
        }
    }

    public void  getBlockAreaForMaSpells(BlockPos bPos, Level pLevel, Spell spellInformation,
                                         boolean isBlock, boolean hasChangeBlock){
        if(null != spellInformation) {
            int sideWidth = spellInformation.getSPELL_LEVEL().getRange() / 2;
            int sideLength = spellInformation.getSPELL_LEVEL().getRange() / 2;

            BlockPos pos = bPos;
            BlockState affectStateBlockChange = null;
            if (!isBlock)
                pos = bPos.relative(Direction.DOWN);
            if (hasChangeBlock)
                affectStateBlockChange = spellInformation.getBlock().defaultBlockState();
            BlockState affectState = pLevel.getBlockState(pos);


            if (sideLength < 1 && sideWidth < 1) {
                if (changeBlockType() && hasChangeBlock)
                    pLevel.setBlock(pos.above(), affectStateBlockChange, 11);
                damageEntityAndMaybeGiveEffect(pLevel, spellInformation, pos, affectState,
                        checkForElectricAffinity(spellInformation.getAFFINITY()),
                        checkForNuclearAffinity(spellInformation.getAFFINITY()),
                        checkForWindAffinity(spellInformation.getAFFINITY()));

            } else {
                for (int i = -sideLength; i < sideLength; i++) {
                    for (int j = -sideWidth; j < sideWidth; j++) {
                        affectState = pLevel.getBlockState(pos);
                        if (changeBlockType() && hasChangeBlock)
                            pLevel.setBlock(pos.above(), affectStateBlockChange, 11);
                        damageEntityAndMaybeGiveEffect(pLevel, spellInformation, pos.offset(i, 0, j),
                                affectState, checkForElectricAffinity(spellInformation.getAFFINITY()),
                                checkForNuclearAffinity(spellInformation.getAFFINITY()),
                                checkForWindAffinity(spellInformation.getAFFINITY()));

                    }
                }
            }
        }

    }

    public void  getBlockAreaForMudoSpells(BlockPos bPos, Level pLevel, Spell spellInformation,
                                           boolean isBlock, float chanceIncrease){
        if(null != spellInformation) {
            int sideWidth = spellInformation.getSPELL_LEVEL().getRange() / 2;
            int sideLength = spellInformation.getSPELL_LEVEL().getRange() / 2;

            BlockPos pos = bPos;
            if (!isBlock)
                pos = bPos.relative(Direction.DOWN);
            BlockState affectState = pLevel.getBlockState(pos);

            if (Objects.isNull(chanceIncrease)) {
                chanceIncrease = 0.0f;
            }

            if (sideLength < 1 && sideWidth < 1) {
                damageEntityForInstaKill(pLevel, spellInformation, pos, affectState, chanceIncrease);
            } else {
                for (int i = -sideLength; i < sideLength; i++) {
                    for (int j = -sideWidth; j < sideWidth; j++) {
                        affectState = pLevel.getBlockState(pos);
                        damageEntityForInstaKill(pLevel, spellInformation, pos.offset(i, 0, j),
                                affectState, chanceIncrease);
                    }
                }
            }
        }

    }

    private void damageEntityForInstaKill(Level pLevel, Spell spellInformation,  BlockPos pos,
                                          BlockState affectState, float chanceIncrease) {
        if (!affectState.isAir()) {
            AABB bounds = AABB.of(new BoundingBox(pos.above()));
            List<Entity> entities = pLevel.getEntities(null, bounds);
            if (!entities.isEmpty()) {
                entities.forEach(le -> {
                    if (le instanceof LivingEntity living && !(le instanceof Player)) {

                        Random random = new Random();
                        if(random.nextFloat() > (0.9f - chanceIncrease))
                            living.die(pLevel.damageSources().magic());
                    }
                });
            }
        }
    }

    private boolean checkForWindAffinity(Affinity affinity) {
        return affinity == Affinity.WIND;
    }

    private boolean checkForNuclearAffinity(Affinity affinity) {
        return affinity == Affinity.NUCLEAR;
    }

    private boolean checkForElectricAffinity(Affinity affinity) {
        return affinity == Affinity.ELECTRIC;
    }

    private boolean changeBlockType() {
        Random random = new Random();
        return random.nextFloat() > 0.9f;
    }

    private void damageEntityAndMaybeGiveEffect(Level pLevel, Spell spellInformation, BlockPos pos,
                                                BlockState affectState, boolean isElectric,
                                                boolean isNuke, boolean isWInd) {
        if (!affectState.isAir()) {
            AABB bounds = AABB.of(new BoundingBox(pos.above()));
            List<Entity> entities = pLevel.getEntities(null, bounds);
            if (!entities.isEmpty()) {
                entities.forEach(le -> {
                    if (le instanceof LivingEntity living && !(le instanceof Player)) {
                        int multiplier = isNuke ? hasStatusesToNuke(living) : 1;
                        living.hurt(pLevel.damageSources().magic(), 5.0F * multiplier);
                        if(isElectric){
                            if(getHitByLightning()) {
                                EntityType.LIGHTNING_BOLT.spawn((ServerLevel) pLevel, living.blockPosition(),
                                        MobSpawnType.TRIGGERED);
                            }
                        }
                        if(isWInd){
                           living.knockback(spellInformation.getSPELL_LEVEL().getLevel(),
                                    -3.0 * spellInformation.getSPELL_LEVEL().getLevel(),
                                    -3.0 * spellInformation.getSPELL_LEVEL().getLevel());
                        }
                        if(null != spellInformation.getSPELL_EFFECT()){
                            boolean hitEffect = checkIfEffectHit();
                            if(hitEffect){
                                living.addEffect(spellInformation.getSPELL_EFFECT());
                            }
                        }
                    }
                });
            }
        }
    }

    private boolean getHitByLightning() {
        Random random = new Random();
        return random.nextFloat() > 0.75f;
    }

    public void  getBlockArea(BlockPos bPos, int width, int length, Level pLevel, Spell spellInformation){
        if(null != spellInformation) {
            int sideWidth = spellInformation.getSPELL_LEVEL().getRange() / 2;
            int sideLength = spellInformation.getSPELL_LEVEL().getRange() / 2;

            BlockPos pos = bPos.relative(Direction.DOWN);
            BlockState affectState = spellInformation.getBlock().defaultBlockState();


            if (sideLength < 1 && sideWidth < 1) {
                pLevel.setBlock(pos.above(), affectState, 11);
            } else {
                for (int i = -sideLength; i < sideLength; i++) {
                    for (int j = -sideWidth; j < sideWidth; j++) {
                        BlockPos tempPos = pos.offset(i, 0, j);
                        pLevel.setBlock(tempPos.above(), affectState, 11);
                    }
                }
            }
        }
    }



    private boolean checkIfEffectHit() {
        Random random = new Random();
        return random.nextFloat() > 0.0f;
    }

    private int hasStatusesToNuke(LivingEntity entity) {
        return entity.hasEffect(ModEffects.BURN.get()) ||
                entity.hasEffect(ModEffects.FREEZE.get()) ||
                entity.hasEffect(ModEffects.SHOCK.get()) ? 2 : 1;
    }

//    public void shootFromGround(EntityType<? extends ThrowableItemProjectile> projectile, Spell spellInformation,
//                                BlockPos bPos,Level pLevel){
//        int sideWidth = spellInformation.getSPELL_LEVEL().getRange()/2;
//        int sideLength = spellInformation.getSPELL_LEVEL().getRange()/2;
//
//
//        for(int i = -sideLength ; i < sideLength; i++){
//            for(int j = -sideWidth ; j< sideWidth;j++) {
//                BlockPos pos = bPos.relative(Direction.DOWN);
//                pos.offset(i,0,j);
//                projectile.
//                pLevel.setBlock(pos.above(), affectState, 11);
//
//            }
//        }
//    }



}
