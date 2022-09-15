package net.teamdraco.capybara.entity.ai;

import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.TameableEntity;

public class CapybaraAnimalAttractionGoal extends Goal {
    private final MobEntity entity;

    public CapybaraAnimalAttractionGoal(MobEntity entity) {
        this.entity = entity;
    }

    @Override
    public boolean canStart() {
        return entity.age % 60 == 0 && entity.getPassengerList().isEmpty();
    }

    @Override
    public boolean shouldContinue() {
        return entity.age % 80 != 0;
    }

    @Override
    public void start() {
        super.start();
        for(MobEntity mobEntity : entity.world.getEntitiesByClass(MobEntity.class, entity.getBoundingBox().expand(5), e -> e != entity && e.getVehicle() == null)) {
            if(mobEntity.getWidth() <= 0.75f && mobEntity.getHeight() <= 0.75f && !((TameableEntity)mobEntity).isSitting()) {
                mobEntity.getNavigation().startMovingTo(entity, mobEntity.getMovementSpeed() + 0.4);
            }
        }
    }
}
