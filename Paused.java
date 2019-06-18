import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Paused world.
 * @author Jenna Tripoli
 */
public class Paused extends World {
    private Button buttonResume, buttonReturnToTitle, buttonRestart;
    private Board prevBoard;
    
    /**
     * Constructor for objects of class Paused.
     * Initialize instance variables and add them to the world.
     */
    public Paused(Board prevBoard) {    
        super(1000, 750, 1); 
        this.buttonResume = new ButtonRectangle("ButtonResume.png");
        this.buttonReturnToTitle = new ButtonRectangle("ButtonReturnToTitle.png");
        this.buttonRestart = new ButtonRectangle("ButtonRestart.png");
        this.prevBoard = prevBoard;
        addObject(buttonResume, 175, 598);
        addObject(buttonReturnToTitle, 500, 598);
        addObject(buttonRestart, 825, 598);
    }
    
    /**
     * Go back to game if Resume button is clicked.
     * Go to the title screen if the Return to Title button is clicked.
     * Go to new game if Restart button is clicked.
     */
    public void act() {
        if (Greenfoot.mouseClicked(buttonResume)) {
            buttonResume.decreaseSize();
            buttonResume.playClickSound();
            Greenfoot.delay(5);
            Greenfoot.setWorld(prevBoard);
        } else if (Greenfoot.mouseClicked(buttonReturnToTitle)) {
            buttonReturnToTitle.decreaseSize();
            buttonReturnToTitle.playClickSound();
            Greenfoot.delay(5);
            Greenfoot.setWorld(new Title());
        } else if (Greenfoot.mouseClicked(buttonRestart)) {
            buttonRestart.decreaseSize();
            buttonRestart.playClickSound();
            Greenfoot.delay(5);
            Greenfoot.setWorld(new Board());
        }
    }
}