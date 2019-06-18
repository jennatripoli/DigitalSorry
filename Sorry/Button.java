import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Button actor.
 * @author Jenna Tripoli 
 */
public class Button extends Actor {
    private int x, y;
    
    /**
     * Constructor for objects of class Button.
     * Set the image of the card and the scale and initialize instance variables.
     * @param fileName name of image file.
     * @param x width of button.
     * @param y height of button.
     */
    public Button(String fileName, int x, int y) {
        setImage(new GreenfootImage(fileName));
        getImage().scale(x, y);
        this.x = x;
        this.y = y;
    } 
    
    /**
     * Increases the size of the button for a small amount of time.
     */
    public void increaseSize() {
        getImage().scale((int)(x * 1.2), (int)(y * 1.2));
        Greenfoot.delay(15);
        getImage().scale(x, y);
    }
    
    /**
     * Decreases the size of the button for a small amount of time.
     */
    public void decreaseSize() {
        getImage().scale((int)(x * 0.8), (int)(y * 0.8));
        Greenfoot.delay(15);
        getImage().scale(x, y);
    }
}