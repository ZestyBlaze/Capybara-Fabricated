package net.teamdraco.capybara.client.renderer;

import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.teamdraco.capybara.Capybara;
import net.teamdraco.capybara.client.model.CapybaraModel;
import net.teamdraco.capybara.client.renderer.layer.CapybaraChestLayer;
import net.teamdraco.capybara.entity.CapybaraEntity;
import net.teamdraco.capybara.registry.CapybaraClientInit;

public class CapybaraRenderer extends MobEntityRenderer<CapybaraEntity, CapybaraModel> {
    private static final Identifier TEXTURE = new Identifier(Capybara.MODID, "textures/entity/capybara.png");
    private static final Identifier MARIO = new Identifier(Capybara.MODID, "textures/entity/mario.png");

    public CapybaraRenderer(EntityRendererFactory.Context context) {
        super(context, new CapybaraModel(context.getPart(CapybaraClientInit.CAPYBARA_ENTITY)), 0.5f);
        this.addFeature(new CapybaraChestLayer(this));
    }

    @Override
    public Identifier getTexture(CapybaraEntity entity) {
        if(entity.getName().getString().equals("Mario")) {
            return MARIO;
        }
        return TEXTURE;
    }

    @Override
    protected void setupTransforms(CapybaraEntity entity, MatrixStack matrices, float animationProgress, float bodyYaw, float tickDelta) {
        super.setupTransforms(entity, matrices, animationProgress, bodyYaw, tickDelta);
        matrices.scale(0.77f, 0.77f, 0.77f);
        if(entity.isTouchingWater() && !entity.isBaby()) {
            matrices.translate(0, -0.625, 0);
        }
    }
}
