package net.teamdraco.capybara.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.teamdraco.capybara.registry.CapybaraClientInit;

@Environment(EnvType.CLIENT)
public class CapybaraClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        CapybaraClientInit.registerRenders();
        CapybaraClientInit.registerModels();
    }
}
