import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * GamePiece class for Sorry.
 * 
 * @author Jenna Tripoli
 * @version 6/5/19
 */
public class SorryGamePiece extends Actor {
    /**
     * Constructor for objects of class SorryGamePiece.
     */
    public SorryGamePiece(String fileName) {
        setImage(new GreenfootImage(fileName));
        getImage().scale(35, 35);
    }
    
    /**
     * Act - do whatever the SorryGamePiece wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() {
        // Add your action code here.
    }
}
