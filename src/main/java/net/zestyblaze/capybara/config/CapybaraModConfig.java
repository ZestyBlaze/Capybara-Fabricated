package net.zestyblaze.capybara.config;

import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.cloth.clothconfig.shadowed.blue.endless.jankson.Comment;
import net.zestyblaze.capybara.Capybara;

@Config(name = Capybara.MODID)
public class CapybaraModConfig implements ConfigData {

    @Comment("Enables debug mode. NOTE: SPAMS THE CONSOLE")
    public boolean debugMode = false;

    @Comment("The spawn weight for the Capybara to spawn")
    public int spawnWeight = 3;

    @Comment("The min group size that the Capybara to spawn in")
    public int minGroupSize = 1;

    @Comment("The max group size that the Capybara spawn in. Higher values mean more lag")
    public int maxGroupSize = 4;

    public static CapybaraModConfig get() {
        return AutoConfig.getConfigHolder(CapybaraModConfig.class).getConfig();
    }
}
