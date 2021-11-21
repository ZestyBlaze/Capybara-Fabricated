package net.zestyblaze.capybara.client.renderer.layer;

import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.feature.FeatureRenderer;
import net.minecraft.client.render.entity.feature.FeatureRendererContext;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.zestyblaze.capybara.Capybara;
import net.zestyblaze.capybara.client.model.CapybaraModel;
import net.zestyblaze.capybara.entity.CapybaraEntity;

public class CapybaraChestLayer extends FeatureRenderer<CapybaraEntity, CapybaraModel> {
    private static final Identifier SINGLE_CHEST = new Identifier(Capybara.MODID, "textures/entity/single_chest.png");
    private static final Identifier DOUBLE_CHEST = new Identifier(Capybara.MODID, "textures/entity/double_chest.png");

    public CapybaraChestLayer(FeatureRendererContext<CapybaraEntity, CapybaraModel> context) {
        super(context);
    }

    @Override
    public void render(MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, CapybaraEntity entity, float limbAngle, float limbDistance, float tickDelta, float animationProgress, float headYaw, float headPitch) {
        final int chestCount = entity.getChestCount();
        if(chestCount > 0) {
            CapybaraModel model = getContextModel();
            model.animateModel(entity, limbAngle, limbDistance, tickDelta);
            model.setAngles(entity, limbAngle, limbDistance, animationProgress, headYaw, headPitch);
            model.render(matrices, vertexConsumers.getBuffer(RenderLayer.getEntityCutoutNoCull(chestCount > 1 ? DOUBLE_CHEST : SINGLE_CHEST)), light, OverlayTexture.DEFAULT_UV, 1.0F, 1.0F, 1.0F, 1.0F);
        }
    }
}
