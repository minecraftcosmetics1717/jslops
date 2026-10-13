package com.stovetoptoad.jujutsuslop;

import com.mojang.blaze3d.platform.InputConstants.Type;
import net.minecraft.client.KeyMapping;
import net.minecraftforge.client.settings.KeyConflictContext;

public class KeyBindings {
   public static final KeyMapping OPEN_ADVANCED_MENU;
   public static final KeyMapping HOLLOW_WICKER_BASKET;
   public static final KeyMapping TOGGLE_OPEN_DOMAIN;
   public static final KeyMapping TRANSFORM_TO_CURSED_OBJECT;
   public static final KeyMapping TOGGLE_ABSORBED_TECHNIQUE;
   public static final KeyMapping GIVE_TECHNIQUE_STARTER;
   public static final KeyMapping OPEN_KEYBIND_MENU;
   public static final KeyMapping AT_WILL_BLACK_FLASH;
   public static final KeyMapping REGISTER_COPY;
   public static final KeyMapping RCT_OUTPUT;          // ← new
   public static final KeyMapping[] ABILITY_SLOTS;

   static {
      OPEN_ADVANCED_MENU = new KeyMapping("key.jujutsuslop.open_menu", KeyConflictContext.IN_GAME, Type.KEYSYM, 74, "key.categories.jujutsuslop");
      HOLLOW_WICKER_BASKET = new KeyMapping("key.jujutsuslop.hollow_wicker_basket", KeyConflictContext.IN_GAME, Type.KEYSYM, 86, "key.categories.jujutsuslop");
      TOGGLE_OPEN_DOMAIN = new KeyMapping("key.jujutsuslop.toggle_open_domain", KeyConflictContext.IN_GAME, Type.KEYSYM, -1, "key.categories.jujutsuslop");
      TRANSFORM_TO_CURSED_OBJECT = new KeyMapping("key.jujutsuslop.transform_to_cursed_object", KeyConflictContext.IN_GAME, Type.KEYSYM, -1, "key.categories.jujutsuslop");
      TOGGLE_ABSORBED_TECHNIQUE = new KeyMapping("key.jujutsuslop.toggle_absorbed_technique", KeyConflictContext.IN_GAME, Type.KEYSYM, -1, "key.categories.jujutsuslop");
      GIVE_TECHNIQUE_STARTER = new KeyMapping("key.jujutsuslop.give_technique_starter", KeyConflictContext.IN_GAME, Type.KEYSYM, -1, "key.categories.jujutsuslop");
      OPEN_KEYBIND_MENU = new KeyMapping("key.jujutsuslop.open_keybind_menu", KeyConflictContext.IN_GAME, Type.KEYSYM, -1, "key.categories.jujutsuslop");
      AT_WILL_BLACK_FLASH = new KeyMapping("key.jujutsuslop.at_will_black_flash", KeyConflictContext.IN_GAME, Type.KEYSYM, -1, "key.categories.jujutsuslop");
      REGISTER_COPY = new KeyMapping("key.jujutsuslop.register_copy", KeyConflictContext.IN_GAME, Type.KEYSYM, -1, "key.categories.jujutsuslop");
      RCT_OUTPUT = new KeyMapping("key.jujutsuslop.rct_output", KeyConflictContext.IN_GAME, Type.KEYSYM, -1, "key.categories.jujutsuslop");

      ABILITY_SLOTS = new KeyMapping[8];

      for (int i = 0; i < 8; ++i) {
         ABILITY_SLOTS[i] = new KeyMapping("key.jujutsuslop.ability_slot_" + (i + 1), KeyConflictContext.IN_GAME, Type.KEYSYM, -1, "key.categories.jujutsuslop");
      }
   }
}