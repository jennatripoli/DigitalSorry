import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * SorryBoard world.
 * 
 * @author Jenna Tripoli 
 * @version 6/7/19
 */
public class SorryBoard extends World {
    private SorryCardFront drawnCard, newCard;
    private int drawValue, totalDrawn;
    private Label drawnValue;
    private ButtonDrawCard buttonDrawCard;
    
    /**
     * Constructor for objects of class SorryBoard.
     */
    public SorryBoard() {    
        // Create a new world with 1000x750 cells with a cell size of 1x1 pixels.
        super(1000, 750, 1);
        buttonDrawCard = new ButtonDrawCard();
        drawnCard = new SorryCardFront();
        newCard = new SorryCardFront();
        totalDrawn = 0;
        addObject(buttonDrawCard, 925, 85);
        addObject(new SorryBlueGamePiece(), 727, 207);
        addObject(new SorryBlueGamePiece(), 763, 207);
        addObject(new SorryBlueGamePiece(), 727, 246);
        addObject(new SorryBlueGamePiece(), 763, 246);
        addObject(new SorryCardBack(), 75, 105);
    }
    
    public void drawCard() {
        if (Greenfoot.mouseClicked(buttonDrawCard)) {
            //randomizeDrawValue();
            buttonDrawCard.changeSize();
            if (this.totalDrawn == 0) {
                randomizeDrawValue();
                addObject(drawnCard, 75, 105);
                addObject(drawnValue, 75, 105);
            } else {
                removeObject(drawnValue);
                randomizeDrawValue();
                drawnCard.setLocation(75, 105);
                addObject(drawnValue, 75, 105);
            }
            while(drawnCard.getY() < 285) {
                drawnValue.setLocation(75, drawnCard.getY() + 5);
                drawnCard.setLocation(75, drawnCard.getY() + 5);
                Greenfoot.delay(1);
            }      
            this.totalDrawn++;
        }
    }
    
    public void randomizeDrawValue() {
        drawValue = (int)(Math.random() * 7) + 1;
        drawnValue = new Label(Integer.toString(drawValue), 100);
    }
    
    public void act() {
        drawCard();
    }
}
