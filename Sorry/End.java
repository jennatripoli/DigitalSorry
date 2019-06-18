import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * End world.
 * @author Jenna Tripoli
 */
public class End extends World {
    private Button buttonReturnToTitle;
    
    /**
     * Constructor for objects of class End.
     * Set image, initialize instance variable, and add it to the world.
     */
    public End(String fileName) {    
        super(1000, 750, 1);
        setBackground(fileName);
        
        this.buttonReturnToTitle = new ButtonRectangle("ButtonReturnToTitle.png");
        
        addObject(buttonReturnToTitle, 500, 500);
    }
    
    /**
     * Go to the title screen if the Return to Title button is clicked.
     */
    public void act() {
        if (Greenfoot.mouseClicked(buttonReturnToTitle)) {
            buttonReturnToTitle.decreaseSize();
            Greenfoot.setWorld(new Title());
        }
    }
}