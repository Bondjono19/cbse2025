package dk.sdu.cbse.common.data;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.springframework.stereotype.Component;

@Component
public class World {
    private final Map<String, Entity> entityMap = new ConcurrentHashMap<>();
    private int points;
    private double playerHealth;

    public double getPlayerHealth() {
        return this.playerHealth;
    }

    public void setPlayerHealth(double playerHealth) {
        this.playerHealth = playerHealth;
    }

    public int getDESTROYED_ASTEROID_POINTS() {
        return this.DESTROYED_ASTEROID_POINTS;
    }

    public final int DESTROYED_ASTEROID_POINTS = 3;

    public Map<String,Entity> getEntityMap() {
        return this.entityMap;
    }


    public int getPoints() {
        return this.points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public String addEntity(Entity entity){
        entityMap.put(entity.getID(),entity);
        return entity.getID();
    }

    public void removeEntity(String entityId){
        setPoints(getPoints()+getEntity(entityId).getPointValue());
        entityMap.remove(entityId);
    }
    public void removeEntity(Entity entity){
        setPoints(getPoints()+entity.getPointValue());
        entityMap.remove(entity.getID());
    }

    public Collection<Entity> getEntities(){
        return entityMap.values();
    }

    public <E extends Entity> List<Entity> getEntities(Class<E>... entityTypes){
        List<Entity> r = new ArrayList<>();
        for (Entity e : getEntities()) {
            for (Class<E> entityType : entityTypes){
                if (entityType.equals(e.getClass())){
                    r.add(e);
                }
            }
        }
        return r;
    }
    public <E extends Entity> List<E> getEntitiesStrict(Class<E>... entityTypes){
        List<E> r = new ArrayList<>();
        for (Entity e : getEntities()) {
            for (Class<E> entityType : entityTypes){
                if (entityType.isAssignableFrom(e.getClass())){
                    r.add((E)e);
                }
            }
        }
        return r;
    }
    public Entity getEntity(String ID){
        return entityMap.get(ID);
    }
}
