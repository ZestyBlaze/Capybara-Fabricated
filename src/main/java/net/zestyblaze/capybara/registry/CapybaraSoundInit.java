package net.zestyblaze.capybara.registry;

import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.zestyblaze.capybara.Capybara;
import net.zestyblaze.capybara.config.CapybaraModConfig;

public class CapybaraSoundInit {
    public static SoundEvent CAPYBARA_AMBIENT = new SoundEvent(new Identifier(Capybara.MODID, "capybara.ambient"));
    public static SoundEvent CAPYBARA_DEATH = new SoundEvent(new Identifier(Capybara.MODID, "capybara.death"));
    public static SoundEvent CAPYBARA_HURT = new SoundEvent(new Identifier(Capybara.MODID, "capybara.hurt"));

    public static void registerSounds() {
        Registry.register(Registry.SOUND_EVENT, new Identifier(Capybara.MODID, "capybara.ambient"), CAPYBARA_AMBIENT);
        Registry.register(Registry.SOUND_EVENT, new Identifier(Capybara.MODID, "capybara.death"), CAPYBARA_DEATH);
        Registry.register(Registry.SOUND_EVENT, new Identifier(Capybara.MODID, "capybara.hurt"), CAPYBARA_HURT);

        if(CapybaraModConfig.get().debugMode) {
            Capybara.LOGGER.info("Capybara: Registry - Sounds Registered");
        }
    }
}
