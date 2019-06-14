import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Button actor.
 * @author Jenna Tripoli 
 */
public class Button extends Actor {
    private int xScale, yScale, xChangeScale, yChangeScale;
    
    /**
     * Constructor for objects of class Button.
     */
    public Button(String fileName, int x, int y) {
        setImage(new GreenfootImage(fileName));
        this.xScale = x;
        this.yScale = y;
        getImage().scale(xScale, yScale);
    } 
    
    /**
     * Changes the size of the button for a small amount of time.
     */
    public void changeSize() {
        getImage().scale(xChangeScale, yChangeScale);
        Greenfoot.delay(15);
        getImage().scale(xScale, yScale);
    }
    
    /**
     * Sets the scale of the button.
     * @param x normal scale of x.
     * @param y normal scale of y.
     * @param xChange changed scale of x.
     * @param yChange changed scale of y.
     */
    public void setScale(int x, int y, int xChange, int yChange) {
        this.xScale = x;
        this.yScale = y;
        this.xChangeScale = xChange;
        this.yChangeScale = yChange;
    }
}