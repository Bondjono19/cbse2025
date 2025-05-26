package dk.sdu.cbse.collision;

import java.util.ServiceLoader;

import dk.sdu.cbse.common.data.Entity;
import dk.sdu.cbse.common.data.GameData;
import dk.sdu.cbse.common.data.World;
import dk.sdu.cbse.common.services.IPostProcess;
import static java.util.stream.Collectors.toList;

import java.util.Collection;

/**
 * Hello world!
 */
public class Collision implements IPostProcess {

    @Override
    public void process(GameData gameData, World world) {
        for (Entity e1 : world.getEntities()){
            for(Entity e2 : world.getEntities()){
                if(e1.getID().equals(e2.getID())){
                    continue;
                }
                if(collides(e1,e2)){
                    e1.collision(world, e2);
                }
            }
        }
    }

    private boolean collides(Entity e1, Entity e2){
        //calculate distance using the pythagorean theorem
        double diffInX = Math.abs(e1.getX()-e2.getX());
        double diffInY = Math.abs(e1.getY()-e2.getY());
        double hypotenuse = Math.sqrt((diffInX*diffInX+diffInY*diffInY));
        if(hypotenuse < (e1.getRadius()+e2.getRadius())){
            return true;
        }
        return false;
    }
}
