package net.slimpopo.personamod.networking;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkDirection;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.PacketDistributor;
import net.minecraftforge.network.simple.SimpleChannel;
import net.slimpopo.personamod.PersonaMod;
import net.slimpopo.personamod.networking.packet.*;

public class ModMessages {
    private static SimpleChannel INSTANCE;
    private static int packetId = 0;
    private static int id(){
        return packetId++;
    }

    public static void register(){
        SimpleChannel net = NetworkRegistry.ChannelBuilder
                .named(new ResourceLocation(PersonaMod.MOD_ID,"messages"))
                .networkProtocolVersion(()->"1.0")
                .clientAcceptedVersions(s -> true)
                .serverAcceptedVersions(s -> true)
                .simpleChannel();

        INSTANCE = net;

        net.messageBuilder(PersonaSummonC2SPacket.class,id(), NetworkDirection.PLAY_TO_SERVER)
                .decoder(PersonaSummonC2SPacket::new)
                .encoder(PersonaSummonC2SPacket::toBytes)
                .consumerMainThread(PersonaSummonC2SPacket::handle)
                .add();

        net.messageBuilder(PersonaAttackC2SPacket.class,id(), NetworkDirection.PLAY_TO_SERVER)
                .decoder(PersonaAttackC2SPacket::new)
                .encoder(PersonaAttackC2SPacket::toBytes)
                .consumerMainThread(PersonaAttackC2SPacket::handle)
                .add();

        net.messageBuilder(PersonaPlayerSpC2SPacket.class,id(), NetworkDirection.PLAY_TO_SERVER)
                .decoder(PersonaPlayerSpC2SPacket::new)
                .encoder(PersonaPlayerSpC2SPacket::toBytes)
                .consumerMainThread(PersonaPlayerSpC2SPacket::handle)
                .add();

        net.messageBuilder(PersonaPlayerSpS2CPacket.class,id(), NetworkDirection.PLAY_TO_CLIENT)
                .decoder(PersonaPlayerSpS2CPacket::new)
                .encoder(PersonaPlayerSpS2CPacket::toBytes)
                .consumerMainThread(PersonaPlayerSpS2CPacket::handle)
                .add();

        net.messageBuilder(PersonaPlayerPersonasS2CPacket.class,id(), NetworkDirection.PLAY_TO_CLIENT)
                .decoder(PersonaPlayerPersonasS2CPacket::new)
                .encoder(PersonaPlayerPersonasS2CPacket::toBytes)
                .consumerMainThread(PersonaPlayerPersonasS2CPacket::handle)
                .add();

        net.messageBuilder(PersonaPlayerUnlockS2CPacket.class,id(), NetworkDirection.PLAY_TO_CLIENT)
                .decoder(PersonaPlayerUnlockS2CPacket::new)
                .encoder(PersonaPlayerUnlockS2CPacket::toBytes)
                .consumerMainThread(PersonaPlayerUnlockS2CPacket::handle)
                .add();
    }

    public static <MSG> void sendToServer(MSG message){
        INSTANCE.sendToServer(message);
    }

    public static <MSG> void sendToPlayer(MSG message, ServerPlayer player){
        INSTANCE.send(PacketDistributor.PLAYER.with(() -> player),message );
    }
}
