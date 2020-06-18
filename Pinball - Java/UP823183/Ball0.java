import java.awt. *;
import java.util. *;
/**
 * Ball0 class inherits the parameters of PinballObject class
 * 
 * @author (UP823183) 
 * @version (23/03/2017)
 */
public class Ball0 extends PinballObject
{
    private Color[] colours;
    /**
     * Constructor for objects of class Ball0
     * @param xPos  the horizontal coordinate of the object
     * @param yPos  the vertical coordinate of the object
     * @param xVel  the horizontal speed of the object
     * @param yVel  the vertical speed of the object
     * @param objectRadius  the radius (in pixels) of the object
     * @param objectColor  the color of the object
     * @param theMachine  the machine this object is in
     */
    public Ball0(int xPos, int yPos, int xVel, int yVel, Color objectColor, double objectRadius, Machine theMachine)
    {
        super(xPos, yPos, xVel, yVel, objectColor, objectRadius, theMachine);
    }

    /**
     * Select a new colour randomly in the colour list
     */
    public void getRandomColour()
    {
        Color colours[] = {Color.ORANGE, Color.RED, Color.MAGENTA};
        boolean colorCheck = true;
        while (colorCheck)
        {
            Color nextColor = colours[new Random().nextInt(colours.length)];
            if(getColor() != nextColor)
            {
                setNewColor(nextColor);
                colorCheck = false;
            }
        }
    }
    
    /**
     * set new random colour when the pinball collide to the wall
     * it overrides the collideToWall method in PinballOject class
     */
    public void collideToWall()
    {
        getRandomColour();
    }
}