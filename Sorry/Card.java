import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Card actor.
 * @author Jenna Tripoli 
 */
public class Card extends Actor {
    /**
     * Constructor for objects of class Card.
     */
    public Card(String fileName) {
        setImage(new GreenfootImage(fileName));
        getImage().scale(120, 160);
    }
}