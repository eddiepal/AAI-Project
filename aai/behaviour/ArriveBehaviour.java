package aai.behaviour;

import aai.entity.MovingEntity;
import aai.util.Vector2D;


public class ArriveBehaviour extends SteeringBehaviour{
    public ArriveBehaviour(MovingEntity entity){
        super(entity); //invokes parent class constructor and passes the entity
    }

    @Override
    public Vector2D calculate() {

        double deceleration = .1;

        if(entity.getWorld().getTarget() != null)
        {
            Vector2D target = entity.getWorld().getTarget().clone();

            Vector2D ToTarget = target.sub(entity.getPosition());

            double dist = ToTarget.length();

            if(dist > 0)
            {

                final double DecelerationTweaker = 0.3;

                double speed = dist / deceleration * DecelerationTweaker;


                Vector2D desiredVelocity = ToTarget.multiply(speed).divide(dist);


                return (desiredVelocity.sub(entity.getVelocity()));
        }

        }
        return new Vector2D();
    }
}