import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Card actor.
 * @author Jenna Tripoli 
 */
public class Card extends Actor {
    /**
     * Constructor for objects of class Card.
     * Set the image of the card and the scale.
     */
    public Card(String fileName) {
        setImage(new GreenfootImage(fileName));
        getImage().scale(120, 160);
    }
}