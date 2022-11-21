package net.zestyblaze.capybara.client.renderer;

import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.zestyblaze.capybara.Capybara;
import net.zestyblaze.capybara.client.model.CapybaraModel;
import net.zestyblaze.capybara.client.renderer.layer.CapybaraChestLayer;
import net.zestyblaze.capybara.entity.CapybaraEntity;
import net.zestyblaze.capybara.registry.CapybaraClientInit;

import java.util.Locale;

public class CapybaraRenderer extends MobEntityRenderer<CapybaraEntity, CapybaraModel> {
    private static final Identifier TEXTURE = new Identifier(Capybara.MODID, "textures/entity/capybara.png");
    private static final Identifier MARIO = new Identifier(Capybara.MODID, "textures/entity/mario.png");

    public CapybaraRenderer(EntityRendererFactory.Context context) {
        super(context, new CapybaraModel(context.getPart(CapybaraClientInit.CAPYBARA_ENTITY)), 0.5f);
        this.addFeature(new CapybaraChestLayer(this));
    }

    @Override
    public Identifier getTexture(CapybaraEntity entity) {
        if(entity.getName().getString().toLowerCase(Locale.ROOT).equals("mario")) {
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
