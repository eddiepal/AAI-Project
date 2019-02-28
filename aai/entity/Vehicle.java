package aai.entity;

import aai.util.Vector2D;
import aai.world.World;

/**
 * Created by gh0073874 on 13-2-2017.
 */
public class Vehicle extends MovingEntity {

    public Vehicle(Vector2D position, World world) {
        super(position, world);
    }

    public Vehicle(double x, double y, World world) {
        this(new Vector2D(x, y), world);
    }
}
