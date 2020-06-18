import java.awt.*; 
import java.util.Random;

/**
 * An object that exists in the pinball. The object bounces off
 * the all four walls of the machine.
 * 
 * Movement can be initiated by repeated calls to the "move" method.
 * 
 * @author (UP823183) 
 * @version (a version number or a date)
 * 
 */

public class PinballObject
{
    private int currentXLocation;
    private int currentYLocation;
    private double speedXTravel;
    private double speedYTravel;
    private Color colour;
    private double radius;
    private Machine machine;
    private final int leftWallPosition;
    private final int rightWallPosition;
    private final int topWallPosition;
    private final int bottomWallPosition;

    /**
     * Constructor for objects of class Pinball_Obj
     * 
     * @param xPos  the horizontal coordinate of the object
     * @param yPos  the vertical coordinate of the object
     * @param xVel  the horizontal speed of the object
     * @param yVel  the vertical speed of the object
     * @param objectRadius  the radius (in pixels) of the object
     * @param objectColor  the color of the object
     * @param theMachine  the machine this object is in
     */
    public PinballObject(int xPos, int yPos, double xVel, double yVel, Color objectColor, double objectRadius, Machine theMachine)
    {
        currentXLocation = xPos;
        currentYLocation = yPos;
        speedXTravel = xVel;
        speedYTravel = yVel;
        colour = objectColor;
        radius = objectRadius;
        machine = theMachine;
        leftWallPosition = machine.getLeftWall();
        rightWallPosition = machine.getRightWall();
        topWallPosition = machine.getTopWall();
        bottomWallPosition = machine.getBottomWall();
    }

    /**
     * Move this object according to its position and speed and redraw.
     **/
    public void move()
    {
        // remove from universe at the current position
        machine.erase(this);
        // check Pinball whether they are colliding each other
        machine.checkPinball(this);
        // compute new position
        currentYLocation += speedYTravel;
        currentXLocation += speedXTravel;
        // check if it has hit the leftwall
        if(currentXLocation <= (leftWallPosition + radius)) 
        {
            currentXLocation = leftWallPosition + getIntRadius();
            speedXTravel = -speedXTravel;
            collideToWall();
        }
        // check if it has hit the rightwall
        if(currentXLocation >= (rightWallPosition - radius)) 
        {
            currentXLocation = rightWallPosition - getIntRadius();
            speedXTravel = -speedXTravel;
            collideToWall();
        }
        // check if it has hit the top wall
        if(currentYLocation <= (topWallPosition + radius)) 
        {
            currentYLocation = topWallPosition + getIntRadius();
            speedYTravel = -speedYTravel; 
            collideToWall();
        }
        // check if it has hit the bottom wall
        if(currentYLocation >= (bottomWallPosition - radius)) 
        {
            currentYLocation = bottomWallPosition - getIntRadius();
            speedYTravel = -speedYTravel; 
            collideToWall();
        }
        // draw again at new position
        machine.draw(this);
    }
    
    /**
     * return the horizontal position of this object
     */
    public int getXPosition()
    {
        return currentXLocation;
    }
    
    /**
     * return the vertical position of this object
     */
    public int getYPosition()
    {
        return currentYLocation;
    }
    
    /**
     * return the radius of this object
     */
    public double getRadius()
    {
        return radius;
    }
    
    /**
     * return the radius of this object as an integer
     */
    public int getIntRadius()
    {
        int r = (int) Math.round(getRadius()); 
        return r ;
    }
    
    /**
     * return the diameter of this object
     */
    public int getDiameter()
    {
        return 2*getIntRadius();
    }
    
    /**
     * return the colour of this object
     */
    public Color getColor()
    {
        return colour;
    }
    
    /**
     * return the travel speed on the x axis of this object
     */
    public double getXSpeed()
    {
        return speedXTravel;
    }
    
    /**
     * return the travel speed on the x axis of this object as an integer
     */
    public int getIntXSpeed()
    {
        int Xspeed = (int) Math.round(getXSpeed()); 
        return Xspeed ;
    }
    
    /**
     * return the travel speed on the y axis of this object
     */
    public double getYSpeed()
    {
        return speedYTravel;
    }
    
    /**
     * return the travel speed on the y axis of this object as an integer
     */
    public int getIntYSpeed()
    {
        int Yspeed = (int) Math.round(getYSpeed()); 
        return Yspeed ;
    }
    
    /**
     * set a new colour for the object
     * @param newColor  a new colour for the object
     */
    public void setNewColor(Color newColor)
    {
        colour = newColor;
    }
    
    /**
     * Perform a normal collision when two objects are collide with each other 
     */
    public void collide()
    {
        // speedXTravel = -speedXTravel;
        // speedYTravel = -speedYTravel;
        speedXTravel *= -1;
        speedYTravel *= -1; 
    }
    
    /**
     * Prints out a message when the main object pinball collide to the wall
     */
    public void collideToWall()
    {
        System.out.println("Collide to Wall");
    }
    
    /**
     * set a new Xspeed value for the object
     * @param newXSpeed  a new speed value on the x axis for the object
     */
    public void setXSpeed(double newXSpeed)
    {
        speedXTravel = newXSpeed;
    }
    
    /**
     * set a new Yspeed value for the object
     * @param newYSpeed  a new speed value on the y axis for the object
     */
    public void setYSpeed(double newYSpeed)
    {
        speedYTravel = newYSpeed;
    }
}
