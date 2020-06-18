import java.awt. *;
/**
 * Hole class inherits the parameters of PinballObject class.
 * Both speed X and speed Y are set to zero
 * 
 * @author (UP823183) 
 * @version (23/03/2017)
 */
public class Hole extends PinballObject
{
    /**
     * Constructor for objects of class Ball8
     * @param xPos  the horizontal coordinate of the object
     * @param yPos  the vertical coordinate of the object
     * @param xVel  the horizontal speed of the object
     * @param yVel  the vertical speed of the object
     * @param objectRadius  the radius (in pixels) of the object
     * @param objectColor  the color of the object
     * @param theMachine  the machine this object is in
     */
    public Hole(int xPos, int yPos, int xVel, int yVel, Color objectColor, double objectRadius, Machine theMachine)
    {
        super(xPos, yPos, xVel, yVel, objectColor, objectRadius, theMachine);
        xVel = 0;
        yVel = 0;
    }
}
