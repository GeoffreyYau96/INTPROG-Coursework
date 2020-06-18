import java.awt. *;
import java.util. *;
/**
 * Ball3 class inherits the parameters of PinballObject class
 * 
 * @author (UP823183) 
 * @version (23/03/2017)
 */
public class Ball3 extends PinballObject
{
    /**
     * Constructor for objects of class Ball3
     * @param xPos  the horizontal coordinate of the object
     * @param yPos  the vertical coordinate of the object
     * @param xVel  the horizontal speed of the object
     * @param yVel  the vertical speed of the object
     * @param objectRadius  the radius (in pixels) of the object
     * @param objectColor  the color of the object
     * @param theMachine  the machine this object is in
     */
    public Ball3(int xPos, int yPos, double xVel, double yVel, Color objectColor, double objectRadius, Machine theMachine)
    {
        super(xPos, yPos, xVel, yVel, objectColor, objectRadius, theMachine);
    }
    
    /**
     * return a random speed between the range 0.05 and 0.10
     */
    private double getRandomSpeed() 
    {
        double rangeMin = 0.05;
        double rangeMax = 0.10;
        Random newSpeed = new Random();
        double randomSpeed = rangeMin + (rangeMax - rangeMin) * newSpeed.nextDouble();
        return newSpeed.nextDouble();
    }
    
    /**
     * return a random next boolean, true or false
     */
    public boolean getRandomBoolean() 
    {
        Random random = new Random();
        return random.nextBoolean();
    }
    
    /**
     * set a new speed for the Ball3 objects when it collides with other pinbal
     * it ovverides the collide method in the 
     */
    public void collide()
    {   
        if (getRandomBoolean())
        {  
            setXSpeed(getXSpeed() + getRandomSpeed());
            setYSpeed(getYSpeed() + getRandomSpeed());
        }
        else
        {
            setXSpeed(getXSpeed() - getRandomSpeed());
            setYSpeed(getYSpeed() - getRandomSpeed());
        }
    }
}
