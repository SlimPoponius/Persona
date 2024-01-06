package net.slimpopo.personamod.networking.packet;

import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.network.NetworkEvent;
import net.slimpopo.personamod.capability.persona.PlayerPersonaProvider;
import net.slimpopo.personamod.constant.entity.ControlledPersona;
import net.slimpopo.personamod.entity.ModEntities;
import net.slimpopo.personamod.entity.custom.constants.ControlledPersonaEntity;
import net.slimpopo.personamod.entity.custom.constants.ControlledPersonaEntityList;
import net.slimpopo.personamod.entity.custom.personas.PyroJackSummonEntity;

import java.util.function.Supplier;

public class PersonaSummonC2SPacket {
    private ControlledPersonaEntityList controlledPersonaEntityList;

    public PersonaSummonC2SPacket(){

    }

    public PersonaSummonC2SPacket(FriendlyByteBuf buf){

    }

    public void toBytes(FriendlyByteBuf buf){

    }

    public boolean handle(Supplier<NetworkEvent.Context> supplier){
        NetworkEvent.Context context = supplier.get();
        context.enqueueWork(() -> {
           //HERE ON SERVER
            ServerPlayer player = context.getSender();
            ServerLevel level = player.serverLevel();

//            //Check if Persona is already summoned
            if(personaHasBeenSummoned(player,level)){
                //get Persona
                ControlledPersonaEntity entity = getPersonaOwnedByPlayer(player,level);
                //remove/kill persona
                entity.remove(Entity.RemovalReason.DISCARDED);
            }
            else{
                //summon persona entity that is currently being looked at
                player.getCapability(PlayerPersonaProvider.PLAYER_PERSONA).ifPresent( playerPersona -> {
                    ControlledPersona persona = playerPersona
                            .getControlledPersonaFromIndex(playerPersona.getCurrentPersonaIndex());

//                    var type = ControlledPersonaEntityList
//                            .getEntityFromId(persona.getPersonaName());

                    ControlledPersonaEntity entity =
                           new ControlledPersonaEntity(ControlledPersonaEntityList
                                    .getEntityFromId(persona.getPersonaName()),level,persona);

                    BlockPos pos = player.blockPosition().north(2);
                    entity.setPos(pos.getX(),pos.getY(),pos.getZ());
                    entity.setOwnerUUID(player.getUUID());
                    entity.tame(player);

                    level.addFreshEntity(entity);

//                     ModEntities.PYRO_JACK_SUMMON.get().spawn(level,ItemStack.EMPTY,null,pos,MobSpawnType.COMMAND,
//                            true,false);
                });
            }
        });
        return true;
    }

    private boolean personaHasBeenSummoned(ServerPlayer player, ServerLevel level) {
        for(ControlledPersonaEntity entity: level.getEntitiesOfClass(ControlledPersonaEntity.class,player.getBoundingBox().inflate(5))){
            if(entity.getOwnerUUID().equals(player.getUUID()))
                return true;
        }
        return false;
    }

    private ControlledPersonaEntity getPersonaOwnedByPlayer(ServerPlayer player, ServerLevel level) {
        for(ControlledPersonaEntity entity: level.getEntitiesOfClass(ControlledPersonaEntity.class,player.getBoundingBox().inflate(5))){
            if(entity.getOwnerUUID().equals(player.getUUID()))
                return entity;
        }
        return null;
    }


}
