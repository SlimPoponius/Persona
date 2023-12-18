package net.slimpopo.personamod.util;

import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.minecraftforge.client.settings.KeyConflictContext;
import org.lwjgl.glfw.GLFW;

public class KeyBinding {
    public static final String KEY_CATEGORY_PERSONA = "key.category.personamod.persona";

    public static final String KEY_BINDINGS_PERSONA_SUMMON = "key.personamod.persona.summon";
    public static final String KEY_BINDINGS_PERSONA_ATTACK = "key.personamod.persona.attack";

    public static final KeyMapping SUMMON_KEY = new KeyMapping(KEY_BINDINGS_PERSONA_SUMMON, KeyConflictContext.IN_GAME,
            InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_P,KEY_CATEGORY_PERSONA);
    public static final KeyMapping ATTACK_KEY = new KeyMapping(KEY_BINDINGS_PERSONA_ATTACK, KeyConflictContext.IN_GAME,
            InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_O,KEY_CATEGORY_PERSONA);



}
