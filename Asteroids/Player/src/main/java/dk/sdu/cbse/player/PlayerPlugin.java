package dk.sdu.cbse.player;

import dk.sdu.cbse.common.data.GameData;
import dk.sdu.cbse.common.data.World;
import dk.sdu.cbse.common.services.IGamePluginService;
import dk.sdu.cbse.common.data.Entity;

public class PlayerPlugin implements IGamePluginService{

    private Entity player;

    @Override
    public void start(GameData gameData, World world) {
        player = new Player();
        player.setPolygonCoordinates(-5,-5,10,0,-5,5);
        player.setX(gameData.getDisplayHeight()/2);
        player.setY(gameData.getDisplayWidth()/2);
        player.setRadius(5);
        world.addEntity(player);
    }

    @Override
    public void stop(GameData gameData, World world) {
        world.removeEntity(player);
    }
    
}
