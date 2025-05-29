package dk.sdu.cbse.asteroidsystem;
import dk.sdu.cbse.asteroidsystem.Asteroid.AsteroidSize;
import dk.sdu.cbse.common.data.Entity;
import dk.sdu.cbse.common.data.GameData;
import dk.sdu.cbse.common.data.World;
import dk.sdu.cbse.common.services.IEntityProcessingService;
public class AsteroidProcessing implements IEntityProcessingService {

    @Override
    public void process(GameData gameData, World world) {
        double spawnAsteroid = Math.random();
        if(spawnAsteroid < 0.01){
            Entity e = new Asteroid();
            e.setPolygonCoordinates(-10, -15,
            -5, -25,
             5, -20,
            15, -10,
            10, 5,
             0, 10,
           -10, 5,
           -15, -5);
            e.setRadius(20);
            e.setRotation(360*Math.random());
            if(e.getRotation()<=90){
                e.setX(0);
                e.setY(gameData.getDisplayHeight()*Math.random());
            } else if(e.getRotation() > 90 && e.getRotation() <=180){
                e.setX(gameData.getDisplayWidth());
                e.setY(gameData.getDisplayHeight()*Math.random());
            }else if (e.getRotation() >180 && e.getRotation() <=270){
                e.setX(gameData.getDisplayWidth()*Math.random());
                e.setY(0);
            }else{
                e.setX(gameData.getDisplayWidth()*Math.random());
                e.setY(gameData.getDisplayHeight());
            }
            world.addEntity(e);
        }
        for (Asteroid e : world.getEntitiesStrict(Asteroid.class)){
            if(e.getHealth()<65 && e.getHealth()>35 && e.getSize()==AsteroidSize.FULL){
                split(e, world);
                world.removeEntity(e);
            }
            if(e.getHealth()<=35 && e.getHealth()>0 && e.getSize()==AsteroidSize.HALF){
                split(e,world);
                world.removeEntity(e);
            }
            if(e.getHealth()<=0){
                world.removeEntity(e);
            }
            double[] coords = move(1,e.getRotation());
            e.setX(e.getX() +coords[0]);
            e.setY(e.getY()+coords[1]);
            if(e.getX()<=-e.getRadius()*2 || e.getX()>=gameData.getDisplayWidth()+e.getRadius()*2 || e.getY()<=-e.getRadius()*2 || e.getY()>=gameData.getDisplayHeight()+e.getRadius()*2){
                world.removeEntity(e);
            }
        }
    }

    private void split(Asteroid e,World world){
        if(e.getSize() == AsteroidSize.FULL){
            Asteroid[] asteroids = new Asteroid[2];
            asteroids[0] = new Asteroid(64,AsteroidSize.HALF);
            asteroids[1] = new Asteroid(64,AsteroidSize.HALF);
            for(Asteroid a : asteroids){
                a.setPolygonCoordinates(
                    -5, -7.5,
                    -2.5, -12.5,
                     2.5, -10,
                     7.5, -5,
                     5, 2.5,
                     0, 5,
                    -5, 2.5,
                    -7.5, -2.5
                );
                a.setRadius(10);
                a.setX(e.getX()+Math.cos(Math.toRadians(a.getRotation()))*e.getRadius());
                a.setY(e.getY()+Math.sin(Math.toRadians(a.getRotation()))*e.getRadius());
            }
            asteroids[0].setRotation(e.getRotation()+30);
            asteroids[1].setRotation(e.getRotation()-30);
            world.addEntity(asteroids[0]);
            world.addEntity(asteroids[1]);
        }
        if(e.getSize() == AsteroidSize.HALF){
            Asteroid[] asteroids = new Asteroid[2];
            asteroids[0] = new Asteroid(35,AsteroidSize.QUARTER);
            asteroids[1] = new Asteroid(35,AsteroidSize.QUARTER);
            for(Asteroid a : asteroids){
                a.setPolygonCoordinates(
                    -2.5, -3.75,
                    -1.25, -6.25,
                     1.25, -5,
                     3.75, -2.5,
                     2.5, 1.25,
                     0, 2.5,
                    -2.5, 1.25,
                    -3.75, -1.25
                );
                a.setRadius(5);
                a.setX(e.getX()+Math.cos(Math.toRadians(a.getRotation()))*e.getRadius());
                a.setY(e.getY()+Math.sin(Math.toRadians(a.getRotation()))*e.getRadius());
            }
            asteroids[0].setRotation(e.getRotation()+30);
            asteroids[1].setRotation(e.getRotation()-30);
            world.addEntity(asteroids[0]);
            world.addEntity(asteroids[1]);
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
