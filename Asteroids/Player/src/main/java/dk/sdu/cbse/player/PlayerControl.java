package dk.sdu.cbse.player;


import java.util.ServiceLoader;

import dk.sdu.cbse.common.data.Entity;
import dk.sdu.cbse.common.data.GameData;
import dk.sdu.cbse.common.data.GameKeys;
import dk.sdu.cbse.common.data.World;
import dk.sdu.cbse.common.services.IProcessingService;
import dk.sdu.cbse.shooting.IMissile;

import static java.util.stream.Collectors.toList;
public class PlayerControl implements IProcessingService{

    private int velocity = 3;

    @Override
    public void process(GameData gameData, World world) {
        GameKeys keys = gameData.getKeys();
        for(Entity  player : world.getEntities(Player.class)){
            //update player health globally
            world.setPlayerHealth(player.getHealth());
            //remove player if health <0
            if(player.getHealth()<=0){
                world.removeEntity(player);
            }

            double r = player.getRotation();
            double x = player.getX();
            double y = player.getY();
            if(keys.isDown(GameKeys.LEFT)){
                player.setRotation(r-3);
            }
            if(keys.isDown(GameKeys.RIGHT)){
                player.setRotation(r+3);
            }
            if(keys.isDown(GameKeys.UP)){
                double[] coords = calculateXY(r);
                player.setX(coords[0]+x);
                player.setY(coords[1]+y);
            }
            if(keys.isDown(GameKeys.SPACE)){
                ServiceLoader.load(IMissile.class).stream().map(ServiceLoader.Provider::get).collect(toList()).stream().findFirst().ifPresent(
                        spi -> {world.addEntity(spi.createMissile(player,Player.class));}
                );
            }
            if(x>gameData.getDisplayWidth()){
                player.setX(gameData.getDisplayWidth());
            }
            if(y>gameData.getDisplayHeight()){
                player.setY(gameData.getDisplayHeight());
            }
            if(x<0){
                player.setX(0);
            }
            if(y<0){
                player.setY(0);
            }
        }
    }

    private double[] calculateXY(double rotation){
        rotation = Math.toRadians(rotation);
        double x = Math.cos(rotation) * velocity;
        double y = Math.sin(rotation) * velocity;
        double[] val = new double[2];
        val[0] = x;
        val[1] = y;
        return val;
    }
    
}
