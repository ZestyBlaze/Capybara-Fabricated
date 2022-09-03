package net.teamdraco.capybara.registry;

import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.GsonConfigSerializer;
import net.teamdraco.capybara.Capybara;
import net.teamdraco.capybara.config.CapybaraModConfig;

public class CapybaraConfigInit {
    public static void registerConfig() {
        AutoConfig.register(CapybaraModConfig.class, GsonConfigSerializer::new);

        if(CapybaraModConfig.get().debugMode) {
            Capybara.LOGGER.info("Capybara: Registry - Config Registered");
        }
    }
}
