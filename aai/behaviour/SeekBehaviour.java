package aai.behaviour;

import aai.entity.MovingEntity;
import aai.util.Vector2D;


public class SeekBehaviour extends SteeringBehaviour{
    public SeekBehaviour(MovingEntity entity){
        super(entity); //invokes parent class constructor and passes the entity
    }

    @Override
    public Vector2D calculate() {
        if (entity.getWorld().getTarget() != null)
        {
            Vector2D desiredVelocity = entity.getWorld().getTarget().clone();
            desiredVelocity.sub(entity.getPosition());
            desiredVelocity.normalize();
            desiredVelocity.multiply(entity.getMaxSpeed());
            //return (desiredVelocity.sub(entity.getVelocity()));
            return (desiredVelocity);

        }
        else{
            System.out.println("Target is null!");
            return new Vector2D();

        }
    }
}