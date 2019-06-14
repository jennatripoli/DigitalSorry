import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * GamePieceRed actor.
 * @author Jenna Tripoli
 */
public class GamePieceRed extends GamePiece {
    /**
     * Constructor for objects of class GamePieceRed.
     * Sets the image, start position, and home position.
     */
    public GamePieceRed() {
        super("GamePieceRed.png");
        super.setStart(352, 56);
        super.setHome(352, 129);
        super.setEndEntrance(264, 56);
        super.setEnd(264, 306);
    }
}