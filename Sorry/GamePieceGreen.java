import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * GamePieceGreen actor.
 * @author Jenna Tripoli
 */
public class GamePieceGreen extends GamePiece {
    /**
     * Constructor for objects of class GamePieceGreen.
     * Sets the image, start position, and home position.
     */
    public GamePieceGreen() {
        super("GamePieceGreen.png");
        super.setStart(180, 522);
        super.setHome(253, 522);
        super.setEndEntrance(180, 610);
        super.setEnd(430, 610);
    }
}