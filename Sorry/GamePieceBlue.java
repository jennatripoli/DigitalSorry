import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * GamePieceBlue actor.
 * @author Jenna Tripoli
 */
public class GamePieceBlue extends GamePiece {
    /**
     * Constructor for objects of class GamePieceBlue.
     * Set the image, start, home, end entrance, and end.
     */
    public GamePieceBlue() {
        super("GamePieceBlue.png");
        super.setStart(818, 225);
        super.setHome(745, 225);
        super.setEndEntrance(818, 140);
        super.setEnd(568, 140);
    }
}