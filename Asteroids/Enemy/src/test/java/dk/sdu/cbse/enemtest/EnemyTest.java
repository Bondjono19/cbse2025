package dk.sdu.cbse.enemtest;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

import dk.sdu.cbse.common.data.Entity;
import dk.sdu.cbse.common.data.World;
import dk.sdu.cbse.enemy.Enemy;



public class EnemyTest {

    //test that enemies that collide are not removed from world
    @Test
    public void enemiesShouldNotCollideTest(){
        World world = new World();
        Entity enemy1 = new Enemy();
        Entity enemy2 = new Enemy();
        world.addEntity(enemy1);
        world.addEntity(enemy2);
        enemy1.collision(world, enemy2);
        List<Entity> worldEntities = world.getEntities(Enemy.class);
        for (Entity entity : worldEntities) {
            if(enemy1.equals(entity)){
                assertTrue(true);
                return;
            }
        }
        assertFalse(true);

    }
}