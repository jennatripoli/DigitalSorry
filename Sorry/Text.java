import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Text actor.
 * @author Jenna Tripoli
 */
public class Text extends Actor {
    private String text;
    private int size;
    private Color outline, foreground, background;

    /**
     * Constructor for objects of class Text.
     */
    public Text(String text, int size) {
        this.text = text;
        this.size = size;
        this.outline = Color.BLACK;
        this.foreground = Color.WHITE;
        this.background = new Color(0, 0, 0, 0);
        updateImage();
    }
    
    /**
     * Change the content of the text.
     * @param text new text.
     */
    public void changeText(String text) {
        this.text = text;
        updateImage();
    }
    
    /**
     * Change the size of the text.
     * @param size new size.
     */
    public void changeSize(int size) {
        this.size = size;
        updateImage();
    }

    /**
     * Update the text with current values.
     */
    private void updateImage() {
        setImage(new GreenfootImage(text, size, foreground, background, outline));
    }
}