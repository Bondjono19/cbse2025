package dk.sdu.cbse.enemy;

import java.util.ServiceLoader;

import dk.sdu.cbse.common.data.Entity;
import dk.sdu.cbse.common.data.GameData;
import dk.sdu.cbse.common.data.World;
import dk.sdu.cbse.common.services.IProcessingService;
import dk.sdu.cbse.shooting.IMissile;
import dk.sdu.cbse.shooting.Missile;

import static java.util.stream.Collectors.toList;

public class EnemyProcessing implements IProcessingService{

    @Override
    public void process(GameData gameData, World world) {
        for(Entity e : world.getEntities(Enemy.class)){
            //remove if health <0
            if(e.getHealth()<=0){
                world.removeEntity(e);
            }
            
            if(e.getX()<=0 || e.getX() >=gameData.getDisplayWidth() || e.getY()<=0 || e.getY() >= gameData.getDisplayHeight()){
                e.setRotation((e.getRotation()+180)%360);
            }
            double dir = Math.random();
            if(dir<0.1){
                e.setRotation(e.getRotation()+3);
            }
            if(dir>=0.1 && dir < 0.2){
                e.setRotation(e.getRotation()-3);
            }
            if(dir<0.05){
                ServiceLoader.load(IMissile.class).stream().map(ServiceLoader.Provider::get).collect(toList()).stream().findFirst().ifPresent(
                        spi -> {world.addEntity(spi.createMissile(e,Enemy.class));}
                );
            }
            double[] coords = move(1,e.getRotation());
            e.setX(e.getX() +coords[0]);
            e.setY(e.getY()+coords[1]);
        }
    }

    private double[] move(int velocity,double rotation){
        rotation = rotation % 360;
        if(rotation<0){
            rotation = 360 - Math.abs(rotation);
        }
        rotation = Math.toRadians(rotation);
        double x = Math.cos(rotation) * velocity;
        double y = Math.sin(rotation) * velocity;
        double[] val = new double[2];
        val[0] = x;
        val[1] = y;
        return val;
    }
    
}
