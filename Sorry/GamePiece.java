import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * GamePiece actor.
 * @author Jenna Tripoli
 */
public class GamePiece extends Actor {
    private int xStart, yStart, xHome, yHome, xEndEntrance, yEndEntrance, xEnd, yEnd;
    
    /**
     * Constructor for objects of class GamePiece.
     */
    public GamePiece(String fileName) {
        setImage(new GreenfootImage(fileName));
        getImage().scale(35, 35);
    }
    
    public void setStart(int x, int y) { 
        this.xStart = x; 
        this.yStart = y;
    }
    
    public void setHome(int x, int y) {
        this.xHome = x;
        this.yHome = y;
    }
    
    public void setEndEntrance(int x, int y) {
        this.xEndEntrance = x;
        this.yEndEntrance = y;
    }
    
    public void setEnd(int x, int y) {
        this.xEnd = x;
        this.yEnd = y;
    }
    
    public int getHomeX() { return this.xHome; }
    public int getHomeY() { return this.yHome; }
    public int getEndEntranceX() { return this.xEndEntrance; }
    public int getEndEntranceY() { return this.yEndEntrance; }
    public int getEndX() { return this.xEnd; }
    public int getEndY() { return this.yEnd; }
    
    public void moveGamePiece() {
        if (xEndEntrance == 264 && yEndEntrance == 56 && getX() >= 248 && getX() <= 272 && getY() >= 48 && getY() <= 64) setLocation(264, 56 + 42);
        else if (xEndEntrance == 818 && yEndEntrance == 140 && getX() >= 800 && getX() <= 826 && getY() >= 132 && getY() <= 148) setLocation(818 - 42, 140);
        else if (xEndEntrance == 734 && yEndEntrance == 694 && getX() >= 726 && getX() <= 742 && getY() >= 686 && getY() <= 702) setLocation(734, 694 - 42);
        else if (xEndEntrance == 180 && yEndEntrance == 610 && getX() >= 172 && getX() <= 188 && getY() >= 602 && getY() <= 618) setLocation(180 + 42, 610);
        
        else if (xEndEntrance == 264 && yEndEntrance == 56 && getX() == 264 && getY() == 56 + 42) setLocation(264, getY() + 42);
        else if (xEndEntrance == 818 && yEndEntrance == 140 && getX() == 818 - 42 && getY() == 140) setLocation(getX() - 42, 140);
        else if (xEndEntrance == 734 && yEndEntrance == 694 && getX() == 734 && getY() == 694 - 42) setLocation(734, getY() - 42);
        else if (xEndEntrance == 180 && yEndEntrance == 610 && getX() == 180 + 42 && getY() == 610) setLocation(getX() + 42, 610);
        
        else if (xEndEntrance == 264 && yEndEntrance == 56 && getX() == 264 && getY() == 98 + 42) setLocation(264, getY() + 42);
        else if (xEndEntrance == 818 && yEndEntrance == 140 && getX() == 776 - 42 && getY() == 140) setLocation(getX() - 42, 140);
        else if (xEndEntrance == 734 && yEndEntrance == 694 && getX() == 734 && getY() == 652 - 42) setLocation(734, getY() - 42);
        else if (xEndEntrance == 180 && yEndEntrance == 610 && getX() == 222 + 42 && getY() == 610) setLocation(getX() + 42, 610);
        
        else if (xEndEntrance == 264 && yEndEntrance == 56 && getX() == 264 && getY() == 140 + 42) setLocation(264, getY() + 42);
        else if (xEndEntrance == 818 && yEndEntrance == 140 && getX() == 734 - 42 && getY() == 140) setLocation(getX() - 42, 140);
        else if (xEndEntrance == 734 && yEndEntrance == 694 && getX() == 734 && getY() == 610 - 42) setLocation(734, getY() - 42);
        else if (xEndEntrance == 180 && yEndEntrance == 610 && getX() == 264 + 42 && getY() == 610) setLocation(getX() + 42, 610);
        
        else if (xEndEntrance == 264 && yEndEntrance == 56 && getX() == 264 && getY() == 182 + 42) setLocation(264, getY() + 42);
        else if (xEndEntrance == 818 && yEndEntrance == 140 && getX() == 692 - 42 && getY() == 140) setLocation(getX() - 42, 140);
        else if (xEndEntrance == 734 && yEndEntrance == 694 && getX() == 734 && getY() == 568 - 42) setLocation(734, getY() - 42);
        else if (xEndEntrance == 180 && yEndEntrance == 610 && getX() == 306 + 42 && getY() == 610) setLocation(getX() + 42, 610);
    
        else if (xEndEntrance == 264 && yEndEntrance == 56 && getX() == 264 && getY() == 224 + 42) setLocation(xEnd, yEnd);
        else if (xEndEntrance == 818 && yEndEntrance == 140 && getX() == 650 - 42 && getY() == 140) setLocation(xEnd, yEnd);
        else if (xEndEntrance == 734 && yEndEntrance == 694 && getX() == 734 && getY() == 526 - 42) setLocation(xEnd, yEnd);
        else if (xEndEntrance == 180 && yEndEntrance == 610 && getX() == 348 + 42 && getY() == 610) setLocation(xEnd, yEnd);

        else if (getX() >= 810 && getX() <= 824 && getY() >= 48 && getY() <= 64) setLocation(818, 56 + 42);
        else if (getX() >= 810 && getX() <= 824 && getY() >= 686 && getY() <= 702) setLocation(818 - 42, 694);
        else if (getX() >= 172 && getX() <= 188 && getY() >= 686 && getY() <= 702) setLocation(180, 694 - 42);
        else if (getX() >= 172 && getX() <= 188 && getY() >= 48 && getY() <= 64) setLocation(180 + 42, 56);
        
        else if (getX() > 180 && getX() < 818 && getY() >= 48 && getY() <= 64) setLocation(getX() + 42, getY());
        else if (getX() > 180 && getX() < 818 && getY() >= 686 && getY() <= 702) setLocation(getX() - 42, getY());
        else if (getX() >= 172 && getX() <= 188 && getY() > 56 && getY() < 694) setLocation(getX(), getY() - 42);
        else if (getX() >= 810 && getX() <= 824 && getY() > 56 && getY() < 694) setLocation(getX(), getY() + 42);
    }
    
    public void moveToStart() {
        setLocation(xStart, yStart);
    }
    
    public void moveToHome() {
        setLocation(xHome, yHome);
    }
    
    public boolean isIntersectingGamePiece() {
        return isTouching(null);
    }
    
    public GamePiece getIntersectingGamePiece() {
        return (GamePiece)getOneIntersectingObject(GamePiece.class);
    }
    
    public void moveIntersectingGamePiece() {
        getIntersectingGamePiece().moveToHome();
    }
    
    public boolean isAtEnd() {
        if (getX() == xEnd && getY() == yEnd) return true;
        else return false;
    }
}