package dk.sdu.cbse.shooting;

import dk.sdu.cbse.common.data.Entity;
import dk.sdu.cbse.common.data.GameData;
import dk.sdu.cbse.common.data.World;
import dk.sdu.cbse.common.services.IProcessingService;

public class BasicMissileProcessing implements IMissile,IProcessingService{

    @Override
    public Entity createMissile(Entity shooter,Class<?> origin) {
        Entity missile = new BasicMissile(origin);
        missile.setPolygonCoordinates(2, -1, 1, 1, -1, 1, -1, -2);
        missile.setX(shooter.getX()+Math.cos(Math.toRadians(shooter.getRotation()))*15);
        missile.setY(shooter.getY()+Math.sin(Math.toRadians(shooter.getRotation()))*15);
        missile.setRotation(shooter.getRotation());
        missile.setRadius(1);
        return missile;
    }

    @Override
    public void process(GameData gameData, World world) {
        for (Entity e : world.getEntities(BasicMissile.class)){
            if(e.getX()<=0 || e.getX()>=gameData.getDisplayWidth() || e.getY()<=0 || e.getY()>=gameData.getDisplayHeight()){
                world.removeEntity(e);
            }
            e.setX(e.getX()+Math.cos(Math.toRadians(e.getRotation()))*5);
            e.setY(e.getY()+Math.sin(Math.toRadians(e.getRotation()))*5);
        }
    }
}
