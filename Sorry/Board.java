import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
        
/**
 * Board world.
 * @author Jenna Tripoli 
 */
public class Board extends World {
    private Card drawnCard, prevDrawnCard, backCard;
    private int drawValue, totalDrawn;
    private Text drawnValue, prevDrawnValue;
    private Button buttonDrawCard, buttonPauseGame, buttonReturnToTitle;
    private GamePiece red, blue, yellow, green;
    private String currentPlayer;
    private Image intersection;
            
    /**
     * Constructor for objects of class Board.
     * Initialize instance variables and add them to the world.
     */
    public Board() {
        super(1000, 750, 1);
        
        this.drawnCard = new CardFront();
        this.prevDrawnCard = new CardFront();
        this.backCard = new CardBack();
        this.totalDrawn = 0;
        this.buttonDrawCard = new ButtonCircle("ButtonDrawCard.png");
        this.buttonPauseGame = new ButtonCircle("ButtonPauseGame.png");
        this.red = new GamePieceRed();
        this.blue = new GamePieceBlue();
        this.yellow = new GamePieceYellow();
        this.green = new GamePieceGreen();
        this.currentPlayer = "red";
        
        addObject(buttonDrawCard, 75, 85);
        addObject(buttonPauseGame, 925, 85);
        addObject(backCard, 75, 245);
        addObject(green, 253, 522);
        addObject(yellow, 648, 620);
        addObject(blue, 745, 225);
        addObject(red, 352, 129);
    }
    
    /**
     * When the game is happening, go through the steps of a turn.
     * If the current game piece is at its respective end entrance,
     * that piece has the ability to enter the path to the end.
     * Once a player gets to their end, stop the game and change to end world.
     */
    public void act() {
        pauseGame();
        if (drawCard() && !moveToStart()) {
            moveGamePiece();
            if (currentPlayer.equals("red") && red.isAtEnd()) Greenfoot.setWorld(new End("CongratsRed.png"));
            else if (currentPlayer.equals("blue") && blue.isAtEnd()) Greenfoot.setWorld(new End("CongratsBlue.png"));
            else if (currentPlayer.equals("yellow") && yellow.isAtEnd()) Greenfoot.setWorld(new End("CongratsYellow.png"));
            else if (currentPlayer.equals("green") && green.isAtEnd()) Greenfoot.setWorld(new End("CongratsGreen.png"));
            changePlayer();
        }
    }
            
    /**
     * Draws a card if the button is clicked or the space bar key is pressed.
     * Moves the card from the deck to the drawn pile and displays the numerical value.
     * @return true if card was drawn, false if card was not drawn.
     */
    public boolean drawCard() {
        if (Greenfoot.mouseClicked(buttonDrawCard) || Greenfoot.isKeyDown("space")) {
            buttonDrawCard.increaseSize();
            if (totalDrawn == 0) {
                randomizeDrawValue();
                addObject(drawnCard, 75, 245);
                addObject(drawnValue, 75, 245);
            } else {
                prevDrawnValue = drawnValue;
                removeObject(drawnValue);
                removeObject(drawnCard);
                addObject(prevDrawnCard, 75, 425);
                addObject(prevDrawnValue, 75, 425);
                randomizeDrawValue();
                addObject(drawnCard, 75, 245);
                addObject(drawnValue, 75, 245);                               
            }
            while(drawnCard.getY() < 425) {
                drawnValue.setLocation(75, drawnCard.getY() + 5);
                drawnCard.setLocation(75, drawnCard.getY() + 5);
                Greenfoot.delay(1);
            }      
            removeObject(prevDrawnValue);
            removeObject(prevDrawnCard);
            totalDrawn++;
            return true;
        }
        return false;
    }
    
    /**
     * Randomizes the draw value to be a value from 1 to 7, inclusive.
     */
    public void randomizeDrawValue() {
        drawValue = (int)(Math.random() * 7) + 1;
        drawnValue = new Text(Integer.toString(drawValue), 100);
    }
    
    /**
     * Moves current game piece to starting position on board if a 1 or 2 is drawn.
     * @return true if piece was moved to start, false if piece was not moved to start.
     */
    public boolean moveToStart() {
        if ((drawValue == 1 || drawValue == 2)) {         
            if (currentPlayer.equals("red") && red.getX() == red.getHomeX() && red.getY() == red.getHomeY()) {
                red.moveToStart();
                return true;
            } else if (currentPlayer.equals("blue") && blue.getX() == blue.getHomeX() && blue.getY() == blue.getHomeY()) {
                blue.moveToStart();
                return true;
            } else if (currentPlayer.equals("yellow") && yellow.getX() == yellow.getHomeX() && yellow.getY() == yellow.getHomeY()) {
                yellow.moveToStart();
                return true;
            } else if (currentPlayer.equals("green") && green.getX() == green.getHomeX() && green.getY() == green.getHomeY()) {
                green.moveToStart();
                return true;
            }
        }
        return false;
    }
    
    /**
     * Moves current game piece a certain number of spaces based on the value of the card they drew.
     */
    public void moveGamePiece() {
        for (int i = 0; i < drawValue; i++) {
            if (currentPlayer.equals("red")) {
                red.moveGamePiece();
                if (red.getX() != red.getHomeX() && red.getY() != red.getHomeY()) Greenfoot.delay(20);
            } else if (currentPlayer.equals("blue")) {
                blue.moveGamePiece();
                if (blue.getX() != blue.getHomeX() && blue.getY() != blue.getHomeY()) Greenfoot.delay(20);
            } else if (currentPlayer.equals("yellow")) {
                yellow.moveGamePiece();
                if (yellow.getX() != yellow.getHomeX() && yellow.getY() != yellow.getHomeY()) Greenfoot.delay(20);
            } else if (currentPlayer.equals("green")) {
                green.moveGamePiece();
                if (green.getX() != green.getHomeX() && green.getY() != green.getHomeY()) Greenfoot.delay(20);
            }
        }
        checkForIntersctingGamePiece();
    }
    
    /**
     * Checks for a game piece already in the desired location and
     * sends the piece back to its home if it exists.
     */
    public void checkForIntersctingGamePiece() {
        if (currentPlayer.equals("red") && red.isIntersectingGamePiece()) {
            if (red.getIntersectingGamePiece() == blue) intersection = new Image("SorryBlue.png", 46, 11);
            else if (red.getIntersectingGamePiece() == yellow) intersection = new Image("SorryYellow.png", 46, 11);
            else if (red.getIntersectingGamePiece() == green) intersection = new Image("SorryGreen.png", 46, 11);
            red.moveIntersectingGamePiece();
            addObject(intersection, 500, 375);
            intersection.enlargeImage(460, 110);
            removeObject(intersection);
            addObject(intersection, 500, 375);
            Greenfoot.delay(150);
            removeObject(intersection);
        } else if (currentPlayer.equals("blue") && blue.isIntersectingGamePiece()) {
            if (blue.getIntersectingGamePiece() == red) intersection = new Image("SorryRed.png", 46, 11);
            else if (blue.getIntersectingGamePiece() == yellow) intersection = new Image("SorryYellow.png", 46, 11);
            else if (blue.getIntersectingGamePiece() == green) intersection = new Image("SorryGreen.png", 46, 11);
            blue.moveIntersectingGamePiece();
            addObject(intersection, 500, 375);
            intersection.enlargeImage(458, 110);
            removeObject(intersection);
            addObject(intersection, 500, 375);
            Greenfoot.delay(150);
            removeObject(intersection);
        } else if (currentPlayer.equals("yellow") && yellow.isIntersectingGamePiece()) {
            if (yellow.getIntersectingGamePiece() == red) intersection = new Image("SorryRed.png", 46, 11);
            else if (yellow.getIntersectingGamePiece() == blue) intersection = new Image("SorryBlue.png", 46, 11);
            else if (yellow.getIntersectingGamePiece() == green) intersection = new Image("SorryGreen.png", 46, 11);
            yellow.moveIntersectingGamePiece();
            addObject(intersection, 500, 375);
            intersection.enlargeImage(458, 110);
            removeObject(intersection);
            addObject(intersection, 500, 375);
            Greenfoot.delay(150);
            removeObject(intersection);
        } else if (currentPlayer.equals("green") && green.isIntersectingGamePiece()) {
            if (green.getIntersectingGamePiece() == red) intersection = new Image("SorryRed.png", 46, 11);
            else if (green.getIntersectingGamePiece() == blue) intersection = new Image("SorryBlue.png", 46, 11);
            else if (green.getIntersectingGamePiece() == yellow) intersection = new Image("SorryYellow.png", 46, 11);
            green.moveIntersectingGamePiece();
            addObject(intersection, 500, 375);
            intersection.enlargeImage(458, 110);
            removeObject(intersection);
            addObject(intersection, 500, 375);
            Greenfoot.delay(150);
            removeObject(intersection);
        }
    }
    
    /**
     * Changes current player in the order of red -> blue -> yellow -> green.
     */
    public void changePlayer() {
        if (currentPlayer.equals("red")) currentPlayer = "blue";
        else if (currentPlayer.equals("blue")) currentPlayer = "yellow";
        else if (currentPlayer.equals("yellow")) currentPlayer = "green";
        else if (currentPlayer.equals("green")) currentPlayer = "red";
    }
    
    /**
     * Pause the current game when the Pause Game button is clicked.
     */
    public void pauseGame() {
        if (Greenfoot.mouseClicked(buttonPauseGame)) {
            buttonPauseGame.increaseSize();
            Greenfoot.setWorld(new Paused(this));
        }
    }
}