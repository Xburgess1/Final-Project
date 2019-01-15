import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PlasmaV2S1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PlasmaV2S1 extends Bullets
{
    /**
     * Act - Act sets its own location 6 less then it's own y location. If the plasma bullet reaches the edge of the world it removes itself
     * 
     * @param None there are no parameters
     * @return there is no return
     */
    public void act() 
    {
        //The plasma bullet does 1.5 damage to most enemies
        
        setLocation(getX(), getY() -6);
        
        if(isAtEdge() == true)
        {
            getWorld().removeObject(this);
        }
        
        
    }    
}
