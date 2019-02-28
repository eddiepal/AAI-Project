package aai.world;

import aai.entity.Vehicle;
import aai.util.Vector2D;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by gh0073874 on 13-2-2017.
 */
public class World {

    private int width;
    private int height;

    private Vector2D target;
    private double targetRadius = 5;

    private java.util.List<Vehicle> entityList = new ArrayList<Vehicle>();

    public World(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public void update(float delta) {
        for (Vehicle entity : entityList) {
            entity.update(delta);
        }
    }

    public void render(Graphics g) {
        g.setColor(Color.DARK_GRAY);
        g.fillRect(0, 0, width, height);

        if(target != null) {
            g.setColor(Color.RED);
            g.drawOval((int) (target.x - targetRadius), (int) (target.y - targetRadius), (int) targetRadius * 2, (int) targetRadius * 2);
        }

        for (Vehicle entity : entityList) {
            entity.render(g);
        }
    }

    public Vector2D wrapAround(Vector2D position) {
        return new Vector2D(position.x = position.x % width, position.y = position.y % height);
    }

    public void setTarget(Vector2D target) {
        this.target = target;
    }

    public void clearTarget() {target = null;}

    public Vector2D getTarget() {
        return target;
    }

    public void addEntity(Vehicle entity) {
        entityList.add(entity);
    }

    public List<Vehicle> getEntityList()
    {
        return entityList;
    }
}
