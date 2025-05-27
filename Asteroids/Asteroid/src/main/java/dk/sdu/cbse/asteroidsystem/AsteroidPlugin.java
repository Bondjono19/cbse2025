package dk.sdu.cbse.asteroidsystem;

import dk.sdu.cbse.common.data.Entity;
import dk.sdu.cbse.common.data.GameData;
import dk.sdu.cbse.common.data.World;
import dk.sdu.cbse.common.services.IPlugin;

public class AsteroidPlugin implements IPlugin {

    @Override
    public void start(GameData gameData, World world) {
        
    }

    @Override
    public void stop(GameData gameData, World world) {
        for(Entity e : world.getEntities(Asteroid.class)){
            world.removeEntity(e);
        }
    }
   
}
