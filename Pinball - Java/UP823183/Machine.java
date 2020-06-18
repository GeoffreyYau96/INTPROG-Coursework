import java.awt.*;
import java.util.*;
/**
 * A pinball machine, with a demo and check pinball collision method
 * 
 * @author (UP823183) 
 * @version (23/03/2017)
 */
public class Machine
{
    private Canvas machine;
    private int topEdge = 0;
    private int leftEdge = 0;
    private int bottomEdge;
    private int rightEdge;
    private int lengthToGap;        // the distance between the edge of the machine and the start of the gap
    private int gapWidth = 50;
    private ArrayList<PinballObject> pinballs;
    private int x1;
    private int x2;
    private int y1;
    private int y2;
    private int r1;
    private int r2;

    /**
     * Create a machine with default name and size
    */
    public Machine()
    {
        machine = new Canvas("Pinball Simulation", 600, 500);
        rightEdge = 600;
        bottomEdge = 500;
        lengthToGap = (rightEdge / 2) - gapWidth;
        drawMachine();
        pinballs = new ArrayList<PinballObject>();
    }
    
    /**
     *  Create a machine with given name and size
     *  @param name The name to give the machine
     *  @param rightEdge The maximum x coordinate
     *  @param bottomEdge The maximum y coordinate
     */
     public Machine(String name, int rightEdge, int bottomEdge)
    {
        machine = new Canvas(name, rightEdge, bottomEdge);
        this.rightEdge = rightEdge;
        this.bottomEdge = bottomEdge;
        lengthToGap = (rightEdge / 2) - gapWidth;
        drawMachine();
        pinballs = new ArrayList<PinballObject>();
    }
    
    /**
     * Erase a PinballObject from the view of the pinball machine
     * 
     * @param pinballObj The object to be erased
     */
    public void erase(PinballObject pinballObj)
    {
        machine.eraseCircle(pinballObj.getXPosition() - pinballObj.getIntRadius(), pinballObj.getYPosition()- pinballObj.getIntRadius(), pinballObj.getDiameter());
    }
    
    /**
    * Draw an PinballObject at its current position onto the view of the pinball machine
    * 
    * @param pinballObj The object to be drawn
    */
    public void draw(PinballObject pinballObj)
    {
        machine.setForegroundColor(pinballObj.getColor());
        machine.fillCircle(pinballObj.getXPosition() - pinballObj.getIntRadius(), pinballObj.getYPosition() - pinballObj.getIntRadius(), pinballObj.getDiameter());
    }
    
    /**
    * Draw the edge of the pinball machine 
    */
    public void drawMachine()
    {
        machine.setForegroundColor(Color.DARK_GRAY);
        
        machine.fillRectangle(0, 0, rightEdge, 10);  // top edge
        machine.fillRectangle(0, 0, 10, bottomEdge); // left edge
        machine.fillRectangle(rightEdge - 10, 0, 10, bottomEdge); // right edge
        
        machine.fillRectangle(0, bottomEdge - 10, lengthToGap, 10); // left-hand side of bottom edge
        machine.fillRectangle(rightEdge - lengthToGap, bottomEdge - 10, rightEdge, 10);     // right-hand side of bottom edge
    }
    
    /**
     * Return the edge of the left-hand wall
     */
    public int getLeftWall()
    {
        return leftEdge + 10;
    }
    
    /**
     * Return the edge of the right-hand wall
     */
    public int getRightWall()
    {
        return rightEdge - 10;
    }
    
    /**
     * Return the top of the wall
     */
    public int getTopWall()
    {
        return topEdge + 10;
    }
    
    /**
     * Return the bottom of the wall
     */
    public int getBottomWall()
    {
        return bottomEdge - 10;
    }
    
    /**
     * Introduces a small delay in ball movement, for smooth running
     */
    
    public void pauseMachine()
    {
        machine.wait(20);
    }
    
    /**
     * Resets the machine back to initial view, with no pinballs
     */
    public void resetMachine()
    {
        machine.erase();
        drawMachine();
    }
    
    /**
     * Add pinballs to the pinball arraylist
     * @param pinball the pinball object which is going to add the list
     */
    public void addPinballs(PinballObject pinball)
    {
        pinballs.add(pinball);
    }
    
    /**
     * compare the distance between the each pinball to check whether they are collide with each other
     * @param SelectedPinball the current pinball checks if it collides with other pinballs
     */
    public void checkPinball(PinballObject selectedPinball)
    {
        for(PinballObject pinball: pinballs)
        {
            x1 = selectedPinball.getXPosition();
            x2 = pinball.getXPosition();
            y1 = selectedPinball.getYPosition();
            y2 = pinball.getYPosition();
            r1 = selectedPinball.getIntRadius();
            r2 = pinball.getIntRadius();
            if(x1 != x2 && y1 != y2)
            {
                // compare distance (x2-x1)^2 + (y2-y2)^2 <= (r1+r2)^2
                double difference = Math.pow((x2-x1),2) + Math.pow((y2-y1),2);
                if (difference <= Math.pow((r2+r1),2))
                {
                    selectedPinball.collide();
                    pinball.collide();
                    System.out.println("Collide to pinballs");
                }
            }
        }
    }
}

