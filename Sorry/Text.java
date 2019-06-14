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
     * Initialize instance variables and update the text.
     */
    public Text(String text, int size) {
        this.text = text;
        this.size = size;
        this.outline = Color.BLACK;
        this.foreground = Color.WHITE;
        this.background = new Color(0, 0, 0, 0);
        updateText();
    }
    
    /**
     * Change the content of the text.
     * @param text new text.
     */
    public void changeText(String text) {
        this.text = text;
        updateText();
    }
    
    /**
     * Change the size of the text.
     * @param size new size.
     */
    public void changeSize(int size) {
        this.size = size;
        updateText();
    }

    /**
     * Update the text with current values.
     */
    private void updateText() {
        setImage(new GreenfootImage(text, size, foreground, background, outline));
    }
}