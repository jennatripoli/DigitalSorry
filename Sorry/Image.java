import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Image actor.
 * @author Jenna Tripoli
 */
public class Image extends Actor {
    /**
     * Constructor for objects of class Image.
     * Set the image and the scale.
     */
    public Image(String fileName, int x, int y) {
        setImage(fileName);
        getImage().scale(x, y);
    }
    
    /**
     * Move the image to the center of the world.
     * @param direction "down", "up", "right", or "left"
     */
    public void moveImage(String direction) {
        if (direction.equals("down")) {
            while(getY() < 375) {
                setLocation(500, getY() + 6);
                Greenfoot.delay(1);
            }   
        } else if (direction.equals("up")) {
            while(getY() > 375) {
                setLocation(500, getY() - 6);
                Greenfoot.delay(1);
            } 
        } else if (direction.equals("right")) {
            while(getX() > 500) {
                setLocation(getX() + 6, 375);
                Greenfoot.delay(1);
            } 
        } else if (direction.equals("left")) {
            while(getX() < 500) {
                setLocation(getX() - 6, 375);
                Greenfoot.delay(1);
            } 
        }
    }
}