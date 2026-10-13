package com.stovetoptoad.jujutsuslop;

import com.stovetoptoad.jujutsuslop.network.ModNetwork;
import com.stovetoptoad.jujutsuslop.rika.RikaMenuTypes;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod("jujutsuslop")
public class JujutsuSlop {
   public static final String MOD_ID = "jujutsuslop";
   public static final Logger LOGGER = LogManager.getLogger();

   public JujutsuSlop() {
      IEventBus modBus = FMLJavaModLoadingContext.get().getModEventBus();
      JslopGamerules.init();
      ModItems.ITEMS.register(modBus);
      RikaMenuTypes.MENU_TYPES.register(modBus);
      ModNetwork.register();
      LOGGER.info("Jujutsu Slop initialising...");
   }
}
