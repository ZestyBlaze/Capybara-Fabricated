package net.zestyblaze.capybara;

import net.fabricmc.api.ModInitializer;
import net.zestyblaze.capybara.config.CapybaraModConfig;
import net.zestyblaze.capybara.registry.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Capybara implements ModInitializer {

	public static final String MODID = "capybara";
	public static final String MODNAME = "Capybara";

	public static final Logger LOGGER = LogManager.getLogger(MODNAME);

	@Override
	public void onInitialize() {
		LOGGER.info(MODNAME + " is installed correctly, loading now! Thanks for installing! <3");
		CapybaraConfigInit.registerConfig();
		CapybaraItemInit.registerItems();
		CapybaraEntityInit.registerEntities();
		CapybaraSoundInit.registerSounds();
		CapybaraWorldInit.registerSpawns();

		if(CapybaraModConfig.get().debugMode) {
			LOGGER.info("Capybara: Registry - Mod Fully Loaded!");
		}
	}
}
