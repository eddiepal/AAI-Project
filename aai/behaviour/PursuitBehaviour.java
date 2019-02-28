package aai.behaviour;

import aai.entity.MovingEntity;
import aai.entity.Vehicle;
import aai.util.Vector2D;

import java.util.List;


public class PursuitBehaviour extends SteeringBehaviour{

    private MovingEntity evader;

    public PursuitBehaviour(MovingEntity entity){
        super(entity); //invokes parent class constructor and passes the entity

    }

    @Override
    public Vector2D calculate() {

        SeekBehaviour seekBehaviour = new SeekBehaviour(entity);
        List entityList = entity.getWorld().getEntityList();
        evader = (Vehicle) entity.getWorld().getEntityList().get(0);
        Vector2D toEvader = evader.getPosition().clone();

        double RelativeHeading = entity.getHeading().dot(evader.getHeading());


        System.out.println(entity.getHeading());
        System.out.println(RelativeHeading + " Relative Heading");

        double lookAheadTime = toEvader.length() / (entity.getMaxSpeed());
       // lookAheadTime += TurnAroundTime(entity, evader.getPosition());


        if ((toEvader.dot(entity.getHeading()) > 0) && (RelativeHeading < -0.95))
        {
            System.out.println("Entity is head to head with target, heading to current position");
            entity.getWorld().setTarget(entity.getPosition());
            entity.setBehaviour(seekBehaviour);

        }
        else
        {
            System.out.println("Not head to head with target, heading to future position");
            Vector2D desiredVelocity = (new Vector2D(100,100).add(evader.getPosition()));
            entity.getWorld().setTarget(desiredVelocity);
            //entity.getWorld().setTarget(evader.getPosition().add(new Vector2D(400,400)));
            entity.setBehaviour(seekBehaviour);
            return desiredVelocity;
        }


        return new Vector2D();
    }

    public double TurnAroundTime(final MovingEntity pAgent, Vector2D TargetPos)
    {
        Vector2D toTarget = TargetPos.sub(pAgent.getPosition());
        toTarget.normalize();

        double dot = pAgent.getHeading().dot(toTarget);

        final double coefficient = 0.5;

        return (dot - 1.0) * -coefficient;
    }

    public MovingEntity getEvader()
    {
        return evader;
    }
}