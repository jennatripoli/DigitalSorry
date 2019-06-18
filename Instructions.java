import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Instructions world.
 * @author Jenna Tripoli 
 */
public class Instructions extends World {
    private Button buttonReturnToTitle;
    
    /**
     * Constructor for objects of class Instructions.
     * Initialize instance variable and add it to the world.
     */
    public Instructions() {    
        super(1000, 750, 1); 
        this.buttonReturnToTitle = new ButtonRectangle("ButtonReturnToTitle.png");   
        addObject(buttonReturnToTitle, 500, 695);
    }
    
    /**
     * Go to the title screen if the Return to Title button is clicked.
     */
    public void act() {
        if (Greenfoot.mouseClicked(buttonReturnToTitle)) {
            buttonReturnToTitle.decreaseSize();
            buttonReturnToTitle.playClickSound();
            Greenfoot.delay(5);
            Greenfoot.setWorld(new Title());
        }
    }
}