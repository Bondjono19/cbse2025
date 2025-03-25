package dk.sdu.cbse.shooting;

import dk.sdu.cbse.common.data.BulletEntity;
import dk.sdu.cbse.common.data.Entity;
import dk.sdu.cbse.common.data.ShipEntity;
import dk.sdu.cbse.common.data.World;
/**
 * Hello world!
 */
public class Missile extends BulletEntity {
    private Class<?> origin;

    Missile(Class<?> origin){
        this.origin = origin;
    }

    public Class<?> getOrigin(){
        return origin;
    }

    @Override
    public void collision(World world, Entity collidingEntity) {
        if(this.origin == collidingEntity.getClass()){
            return;
        }
        if(collidingEntity instanceof ShipEntity){
            collidingEntity.setHealth(collidingEntity.getHealth()-1);
            if(collidingEntity.getHealth()<=0){
                world.removeEntity(collidingEntity);
            }
        }
    }
}
