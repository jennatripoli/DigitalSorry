import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Title world.
 * @author Jenna Tripoli
 */
public class Title extends World {
    private Button buttonInstructions, buttonBeginGame;
    
    /**
     * Constructor for objects of class Title.
     */
    public Title() {    
        super(1000, 750, 1); 
        this.buttonInstructions = new ButtonRectangle("ButtonInstructions.png");
        this.buttonBeginGame = new ButtonRectangle("ButtonBeginGame.png");
        addObject(buttonInstructions, 288, 598);
        addObject(buttonBeginGame, 715, 598);
    }
    
    public void act() {
        if (Greenfoot.mouseClicked(buttonInstructions)) {
            buttonInstructions.changeSize();
            Greenfoot.delay(5);
            Greenfoot.setWorld(new Instructions());
        } else if (Greenfoot.mouseClicked(buttonBeginGame)) {
            buttonBeginGame.changeSize();
            Greenfoot.delay(5);
            Greenfoot.setWorld(new Board());
        }
    }
}