import java.awt.*;

/**
 * Class to demonstrate functionality of the Pinball machine
 * 
 * @author (UP823183) 
 * @version (23/03/2017)
 */
public class Demo
{
    private Machine machine;
    private boolean running;
    /**
     * Constructor for objects of class Demo
     */
    public Demo()
    {
        machine = new Machine();
    }

    /**
     * Demo method - demonstrates what happens when different pinball objects rebounds off the all four sides of the wall
     */
    public void sampleDemo()
    {
        // sample demo
        machine.resetMachine();
        
        Ball0 obj1 = new Ball0(50, 200, -5, 3, Color.BLUE, 10, machine);
        Ball0 obj2 = new Ball0(100, 300, 1, 2, Color.BLUE, 55, machine);
        Ball0 obj3 = new Ball0(50, 125, -1, -1, Color.BLUE, 40, machine);
        Ball3 obj4 = new Ball3(100, 50, 5, -2, Color.YELLOW, 30, machine);
        Ball3 obj5 = new Ball3(200, 125, 2, 1, Color.YELLOW, 25, machine);
        Ball3 obj6 = new Ball3(450, 125, 4, 2, Color.YELLOW, 20, machine);
        Bumper obj7 = new Bumper(50, 200, 0, 0, Color.GRAY, 30, machine);
        Bumper obj8 = new Bumper(400, 350, 0, 0, Color.GRAY, 30, machine);
        Hole obj9 = new Hole(500, 50, 0, 0, Color.BLACK, 15, machine);
        Hole obj10 = new Hole(50, 400, 0, 0, Color.BLACK, 15, machine);
        
        machine.addPinballs(obj1);
        machine.addPinballs(obj2);
        machine.addPinballs(obj3);
        machine.addPinballs(obj4);
        machine.addPinballs(obj5);
        machine.addPinballs(obj6);
        
        running = true;
        while (running == true)
        {
            {
                machine.pauseMachine();           // small delay
                obj1.move();
                obj2.move();
                obj3.move();
                obj4.move();
                obj5.move();
                obj6.move();
                machine.draw(obj7);
                machine.draw(obj8);
                machine.draw(obj9);
                machine.draw(obj10);
            }
        }
    }
}
