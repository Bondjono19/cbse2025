package dk.sdu.cbse.common.data;

import java.io.Serializable;
import java.util.UUID;

public abstract class Entity implements Serializable{
    private final UUID ID = UUID.randomUUID();
    public abstract void collision(World world, Entity collidingEntity);
    private double[] polygonCoordinates;
    private double x;
    private double y;
    private double rotation;
    private float radius;
    private Class<?> origin;
    protected int pointValue;
    protected double health;

    public double getHealth() {
        return this.health;
    }

    public void setHealth(double health) {
        this.health = health;
    }
    public void setOrigin(Class<?> origin) {
        this.origin = origin;
    }

    public int getPointValue() {
        return this.pointValue;
    }

    public void setPointValue(int pointValue) {
        this.pointValue = pointValue;
    }

    public String getID() {
        return ID.toString();
    }

    public Class<?> getOrigin(){
        return origin;
    }

    public double[] getPolygonCoordinates() {
        return this.polygonCoordinates;
    }

    public void setPolygonCoordinates(double... polygonCoordinates) {
        this.polygonCoordinates = polygonCoordinates;
    }

    public double getX() {
        return this.x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return this.y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getRotation() {
        return this.rotation;
    }

    public void setRotation(double rotation) {
        this.rotation = rotation;
    }

    public float getRadius() {
        return this.radius;
    }

    public void setRadius(float radius) {
        this.radius = radius;
    }
}
