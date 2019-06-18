import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Title world.
 * @author Jenna Tripoli
 */
public class Title extends World {
    private Button buttonInstructions, buttonBeginGame;
    
    /**
     * Constructor for objects of class Title.
     * Initialize instance variables and add them to the world.
     */
    public Title() {    
        super(1000, 750, 1); 
        this.buttonInstructions = new ButtonRectangle("ButtonInstructions.png");
        this.buttonBeginGame = new ButtonRectangle("ButtonBeginGame.png");
        addObject(buttonInstructions, 288, 598);
        addObject(buttonBeginGame, 715, 598);
    }
    
    /**
     * Go to the instructions screen if Instructions button is clicked.
     * Go to game if Begin Game button is clicked.
     */
    public void act() {
        if (Greenfoot.mouseClicked(buttonInstructions)) {
            buttonInstructions.increaseSize();
            Greenfoot.delay(5);
            Greenfoot.setWorld(new Instructions());
        } else if (Greenfoot.mouseClicked(buttonBeginGame)) {
            buttonBeginGame.increaseSize();
            Greenfoot.delay(5);
            Greenfoot.setWorld(new Board());
        }
    }
}