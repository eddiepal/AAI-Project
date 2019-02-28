package aai.entity;

import aai.util.Vector2D;
import aai.world.World;

import java.awt.*;

/**
 * Created by gh0073874 on 13-2-2017.
 */
public abstract class BaseEntity {

    protected Vector2D position;
    protected World world;

    protected double radius = 5;

    public BaseEntity(Vector2D position, World world) {
        this.position = position;
        this.world = world;
    }

    public abstract void update(float delta);

    public void render(Graphics g) {
        g.drawOval((int)(position.x-radius), (int)(position.y-radius), (int)radius*2, (int)radius*2);
    }

    public Vector2D getPosition() {
        return position;
    }

    public World getWorld() {
        return world;
    }
}
