package aai.behaviour;

import aai.entity.MovingEntity;
import aai.util.Vector2D;

/**
 * Created by gh0073874 on 13-2-2017.
 */
public abstract class SteeringBehaviour {

    protected MovingEntity entity;

    public SteeringBehaviour(MovingEntity entity) {
        this.entity = entity;
    }

    public abstract Vector2D calculate();



}
