package dk.sdu.cbse.asteroidsystem;

import org.springframework.stereotype.Component;

import dk.sdu.cbse.common.data.Entity;
import dk.sdu.cbse.common.data.GameData;
import dk.sdu.cbse.common.data.World;
import dk.sdu.cbse.common.services.IGamePluginService;

@Component
public class AsteroidPlugin implements IGamePluginService {

    public AsteroidPlugin(){}

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
