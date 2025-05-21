package dk.sdu.cbse.asteroidsystem;

import dk.sdu.cbse.common.data.BulletEntity;
import dk.sdu.cbse.common.data.Entity;
import dk.sdu.cbse.common.data.ShipEntity;
import dk.sdu.cbse.common.data.World;

public class Asteroid extends Entity{

    AsteroidSize size;

    public AsteroidSize getSize() {
        return this.size;
    }

    public void setSize(AsteroidSize size) {
        this.size = size;
    }

    public enum AsteroidSize {
        FULL,
        HALF,
        QUARTER
    }



    Asteroid(double health,AsteroidSize size){
        this.health = health;
        this.size = size;
    }

    Asteroid(){
        this.health = 100;
        this.size = AsteroidSize.FULL;
    }

    @Override
    public void collision(World world, Entity collidingEntity) {
        if(collidingEntity instanceof ShipEntity){
            collidingEntity.setHealth(collidingEntity.getHealth()-5);
        }
        if(collidingEntity instanceof BulletEntity){
            this.health--;
        }
    }
}
