package dk.sdu.cbse.enemy;

import dk.sdu.cbse.common.data.Entity;
import dk.sdu.cbse.common.data.GameData;
import dk.sdu.cbse.common.data.World;
import dk.sdu.cbse.common.services.IPlugin;

/**
 * Hello world!
 */
public class EnemyPlugin implements IPlugin{

    @Override
    public void start(GameData gameData, World world) {
        for(int i = 0; i < 5;i++){
            Entity e = new Enemy();
            e.setPolygonCoordinates(-5,-5,10,0,-5,5);
            e.setX(Math.random()*gameData.getDisplayWidth());
            e.setY(Math.random()*gameData.getDisplayWidth());
            e.setRadius(5);
            world.addEntity(e);
        }
    }

    @Override
    public void stop(GameData gameData, World world) {
        for(Entity e : world.getEntities(Enemy.class)){
            world.removeEntity(e);
        }
    }
    


}
