package net.zestyblaze.capybara.registry;

import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;
import net.zestyblaze.capybara.Capybara;
import net.zestyblaze.capybara.client.model.CapybaraModel;
import net.zestyblaze.capybara.client.renderer.CapybaraRenderer;

public class CapybaraClientInit {

    public static final EntityModelLayer CAPYBARA_ENTITY = new EntityModelLayer(new Identifier(Capybara.MODID, "capybara"), "capybara_model");

    public static void registerRenders() {
        EntityRendererRegistry.register(CapybaraEntityInit.CAPYBARA, CapybaraRenderer::new);
    }

    public static void registerModels() {
        EntityModelLayerRegistry.registerModelLayer(CAPYBARA_ENTITY, CapybaraModel::getTexturedModelData);
    }

}
