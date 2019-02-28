package aai.behaviour;

import aai.entity.MovingEntity;
import aai.util.Vector2D;

/**
 * Created by gh0073874 on 13-2-2017.
 */
public class AccelerateHorizontalBehaviour extends SteeringBehaviour {

    public AccelerateHorizontalBehaviour(MovingEntity entity) {
        super(entity);
    }

    @Override
    public Vector2D calculate() {
        return new Vector2D(60, 60);
    }
}
