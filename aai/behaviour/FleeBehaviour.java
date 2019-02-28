package aai.behaviour;

import aai.entity.MovingEntity;
import aai.util.Vector2D;


public class FleeBehaviour extends SteeringBehaviour{
    public FleeBehaviour(MovingEntity entity){
        super(entity); //invokes parent class constructor and passes the entity
    }

    @Override
    public Vector2D calculate() {

        if (entity.getWorld().getTarget() != null)
        {
            Vector2D car = entity.getPosition().clone();
            car.sub(entity.getWorld().getTarget());
            car.normalize();
            car.multiply(entity.getMaxSpeed());
            return car;
        }
        else{
            return new Vector2D();

        }
    }
}