package net.slimpopo.personamod.event;

import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.client.event.RegisterGuiOverlaysEvent;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.slimpopo.personamod.PersonaMod;
import net.slimpopo.personamod.capability.persona.PlayerPersonaProvider;
import net.slimpopo.personamod.client.PersonaSelectedOverlay;
import net.slimpopo.personamod.client.PersonaSpOverlay;
import net.slimpopo.personamod.constant.entity.ControlledPersona;
import net.slimpopo.personamod.networking.ModMessages;
import net.slimpopo.personamod.networking.packet.PersonaAttackC2SPacket;
import net.slimpopo.personamod.networking.packet.PersonaPlayerSpC2SPacket;
import net.slimpopo.personamod.networking.packet.PersonaPlayerSpS2CPacket;
import net.slimpopo.personamod.networking.packet.PersonaSummonC2SPacket;
import net.slimpopo.personamod.networking.packet.personanetwork.PlayerPersonaUpdateC2SPacket;
import net.slimpopo.personamod.networking.packet.personanetwork.PlayerPersonaUpdateCurrentPersonaC2SPacket;
import net.slimpopo.personamod.networking.packet.personanetwork.PlayerPersonaUpdateCurrentPersonaSkillC2SPacket;
import net.slimpopo.personamod.util.KeyBinding;

import java.util.Arrays;

public class ClientEvents {

    @Mod.EventBusSubscriber(modid = PersonaMod.MOD_ID, value = Dist.CLIENT)
    public static class ClientForgeEvents{
        @SubscribeEvent
        public static void onKeyInput(InputEvent.Key event){
            if(KeyBinding.SUMMON_KEY.consumeClick()){
                ModMessages.sendToServer(new PersonaSummonC2SPacket());
            }
            if(KeyBinding.NEXT_PERSONA_SKILL_KEY.consumeClick()){
                ModMessages.sendToServer(new PlayerPersonaUpdateCurrentPersonaSkillC2SPacket());
            }
            if(KeyBinding.NEXT_PERSONA_KEY.consumeClick()){
                ModMessages.sendToServer(new PlayerPersonaUpdateCurrentPersonaC2SPacket());
            }
            if(KeyBinding.ATTACK_KEY.consumeClick()){
                ModMessages.sendToServer(new PersonaAttackC2SPacket());
            }
        }

    }

    @Mod.EventBusSubscriber(modid = PersonaMod.MOD_ID,bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModBusEvents{
        @SubscribeEvent
        public static void onKeyRegister(RegisterKeyMappingsEvent event){
            event.register(KeyBinding.SUMMON_KEY);
            event.register(KeyBinding.ATTACK_KEY);
            event.register(KeyBinding.NEXT_PERSONA_SKILL_KEY);
            event.register(KeyBinding.NEXT_PERSONA_KEY);

        }

        @SubscribeEvent
        public static void registerGuiOverlays(RegisterGuiOverlaysEvent event){
            event.registerAboveAll("personasp", PersonaSpOverlay.PERSONA_SP);
            event.registerAboveAll("persona_sel", PersonaSelectedOverlay.PERSONA_SEL);

        }
    }
}
