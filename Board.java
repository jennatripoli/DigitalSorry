import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
        
/**
 * Board world.
 * @author Jenna Tripoli 
 */
public class Board extends World {
    private Card drawnCard, prevDrawnCard, backCard;
    private int drawValue, totalDrawn;
    private Text drawnValue, prevDrawnValue;
    private Button buttonDrawCard, buttonPauseGame;
    private GamePiece red, blue, yellow, green;
    private String currentPlayer;
    private Image intersection;
    private GreenfootSound congrats;
    private int i = 0;
            
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
        this.congrats = new GreenfootSound("Congrats.mp3");
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
            if (currentPlayer.equals("red") && red.isAtEnd()) {
                congrats.play();
                Greenfoot.setWorld(new End("CongratsRed.png"));
            } else if (currentPlayer.equals("blue") && blue.isAtEnd()) {
                congrats.play();
                Greenfoot.setWorld(new End("CongratsBlue.png"));
            } else if (currentPlayer.equals("yellow") && yellow.isAtEnd()) {
                congrats.play();
                Greenfoot.setWorld(new End("CongratsYellow.png"));
            } else if (currentPlayer.equals("green") && green.isAtEnd()) {
                congrats.play();
                Greenfoot.setWorld(new End("CongratsGreen.png"));
            }
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
            buttonDrawCard.playClickSound();
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
        checkForIntersectingGamePiece();
    }
    
    /**
     * Checks for a game piece already in the desired location and
     * sends the piece back to its home if it exists.
     */
    public void checkForIntersectingGamePiece() {
        String color = "";
        if (currentPlayer.equals("red") && red.isIntersectingGamePiece()) {
            if (red.getIntersectingGamePiece() == blue) color = "blue";
            else if (red.getIntersectingGamePiece() == yellow) color = "yellow";
            else if (red.getIntersectingGamePiece() == green) color = "green";
            red.moveIntersectingGamePiece();
        } else if (currentPlayer.equals("blue") && blue.isIntersectingGamePiece()) {
            if (blue.getIntersectingGamePiece() == red) color = "red";
            else if (blue.getIntersectingGamePiece() == yellow) color = "yellow";
            else if (blue.getIntersectingGamePiece() == green) color = "green";
            blue.moveIntersectingGamePiece();
        } else if (currentPlayer.equals("yellow") && yellow.isIntersectingGamePiece()) {
            if (yellow.getIntersectingGamePiece() == red) color = "red";
            else if (yellow.getIntersectingGamePiece() == blue) color = "blue";
            else if (yellow.getIntersectingGamePiece() == green) color = "green";
            yellow.moveIntersectingGamePiece();
        } else if (currentPlayer.equals("green") && green.isIntersectingGamePiece()) {
            if (green.getIntersectingGamePiece() == red) color = "red";
            else if (green.getIntersectingGamePiece() == blue) color = "blue";
            else if (green.getIntersectingGamePiece() == yellow) color = "yellow";
            green.moveIntersectingGamePiece();
        }
        
        if (color.equals("red")) {
            intersection = new Image("SorryRed.png", 1380, 330);
            addObject(intersection, 500, 375);
            intersection.reduceImage(460, 110);
            removeObject(intersection);
            intersection = new Image("SorryRed.png", 460, 110);
            addObject(intersection, 500, 375);
            Greenfoot.delay(180);
            removeObject(intersection);
        } else if (color.equals("blue")) {
            intersection = new Image("SorryBlue.png", 1380, 330);
            addObject(intersection, 500, 375);
            intersection.reduceImage(460, 110);
            removeObject(intersection);
            intersection = new Image("SorryBlue.png", 460, 110);
            addObject(intersection, 500, 375);
            Greenfoot.delay(180);
            removeObject(intersection);
        } else if (color.equals("yellow")) {
            intersection = new Image("SorryYellow.png", 1380, 330);
            addObject(intersection, 500, 375);
            intersection.reduceImage(460, 110);
            removeObject(intersection);
            intersection = new Image("SorryYellow.png", 460, 110);
            addObject(intersection, 500, 375);
            Greenfoot.delay(180);
            removeObject(intersection);
        } else if (color.equals("green")) {
            intersection = new Image("SorryGreen.png", 1380, 330);
            addObject(intersection, 500, 375);
            intersection.reduceImage(460, 110);
            removeObject(intersection);
            intersection = new Image("SorryGreen.png", 460, 110);
            addObject(intersection, 500, 375);
            Greenfoot.delay(180);
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
            buttonPauseGame.playClickSound();
            Greenfoot.delay(5);
            Greenfoot.setWorld(new Paused(this));
        }
    }
}