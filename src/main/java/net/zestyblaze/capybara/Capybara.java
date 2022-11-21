package net.zestyblaze.capybara;

import net.fabricmc.api.ModInitializer;
import net.zestyblaze.capybara.registry.*;

public class Capybara implements ModInitializer {
	public static final String MODID = "capybara";

	@Override
	public void onInitialize() {
		CapybaraConfigInit.registerConfig();
		CapybaraItemInit.registerItems();
		CapybaraEntityInit.registerEntities();
		CapybaraSoundInit.registerSounds();
		CapybaraWorldInit.registerSpawns();
	}
}
