import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ToxicWasteV3S1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ToxicWasteV3S1 extends Bullets
{
    /**
     * Act sets the location 4 less then it's own Y location and if it reaches the edge of the world it removes itself
     */
    public void act() 
    {
        //the toxic waste does 1.5 damage and continues to move if it kills the opponent
        
        setLocation(getX(), getY() -4);
        
        if(isAtEdge() == true)
        {
            getWorld().removeObject(this);
        }
    }    
}
