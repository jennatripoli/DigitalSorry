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
    
    public void act() {
        if (Greenfoot.mouseClicked(buttonResume)) {
            buttonResume.changeSize();
            Greenfoot.delay(5);
            Greenfoot.setWorld(prevBoard);
        } else if (Greenfoot.mouseClicked(buttonReturnToTitle)) {
            buttonReturnToTitle.changeSize();
            Greenfoot.delay(5);
            Greenfoot.setWorld(new Title());
        } else if (Greenfoot.mouseClicked(buttonRestart)) {
            buttonRestart.changeSize();
            Greenfoot.delay(5);
            Greenfoot.setWorld(new Board());
        }
    }
}