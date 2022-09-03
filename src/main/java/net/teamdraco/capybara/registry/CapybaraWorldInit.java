package net.teamdraco.capybara.registry;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.tag.BiomeTags;
import net.teamdraco.capybara.Capybara;
import net.teamdraco.capybara.config.CapybaraModConfig;

public class CapybaraWorldInit {
    public static void registerSpawns() {
        BiomeModifications.addSpawn(BiomeSelectors.tag(BiomeTags.IS_JUNGLE), SpawnGroup.CREATURE, CapybaraEntityInit.CAPYBARA, CapybaraModConfig.get().spawnWeight, CapybaraModConfig.get().minGroupSize, CapybaraModConfig.get().maxGroupSize);

        if(CapybaraModConfig.get().debugMode) {
            Capybara.LOGGER.info("Capybara: Registry - Entity Spawns Registered");
        }
    }

}
