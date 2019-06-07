import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Button actor.
 * 
 * @author Jenna Tripoli 
 * @version 6/7/19
 */
public class Button extends Actor {
    /**
     * Constructor for objects of class Button.
     */
    public Button(String fileName) {
        setImage(new GreenfootImage(fileName));
        getImage().scale(120, 120);
    }
    
    /**
     * Act - do whatever the Button wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() {
        changeSize();
    }    
    
    public void changeSize() {
        if (Greenfoot.mouseClicked(this)) {
            getImage().scale(100, 100);
            Greenfoot.delay(20);
            getImage().scale(120, 120);
        }
    }
}
