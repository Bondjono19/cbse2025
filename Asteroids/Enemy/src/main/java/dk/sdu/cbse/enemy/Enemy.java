package dk.sdu.cbse.enemy;

import dk.sdu.cbse.common.data.Entity;
import dk.sdu.cbse.common.data.ShipEntity;
import dk.sdu.cbse.common.data.World;

public class Enemy extends ShipEntity{
    Enemy(){
        this.pointValue = 1;
        this.health = 200;
    }

    @Override
    public void collision(World world, Entity collidingEntity) {
        if(collidingEntity instanceof ShipEntity && collidingEntity.getClass() != this.getClass()){
            world.removeEntity(collidingEntity);
            world.removeEntity(this);
        }
    }
}
