package dk.sdu.cbse.player;

import dk.sdu.cbse.common.data.Entity;
import dk.sdu.cbse.common.data.ShipEntity;
import dk.sdu.cbse.common.data.World;

public class Player extends ShipEntity{

    Player(){
        this.health = 500;
    }

    @Override
    public void collision(World world, Entity collidingEntity) {
        if(collidingEntity instanceof ShipEntity && collidingEntity.getClass()!=this.getClass()){
            world.removeEntity(this);
        }
    }

    
}
