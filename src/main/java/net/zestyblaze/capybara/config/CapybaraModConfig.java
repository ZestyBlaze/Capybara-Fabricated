package net.zestyblaze.capybara.config;

import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import net.zestyblaze.capybara.Capybara;

@Config(name = Capybara.MODID)
public class CapybaraModConfig implements ConfigData {
    public boolean debugMode = false;
    public int spawnWeight = 3;
    public int minGroupSize = 1;
    public int maxGroupSize = 4;

    public static CapybaraModConfig get() {
        return AutoConfig.getConfigHolder(CapybaraModConfig.class).getConfig();
    }
}
