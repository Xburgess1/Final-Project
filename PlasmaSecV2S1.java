import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PlasmaSecV2S1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PlasmaSecV2S1 extends Secondary
{
    /**
     * Act - do whatever the PlasmaSecV2S1 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        //does 3 damage and moves fast and charges fast
        
        setLocation(getX(), getY() -7);
        
        if(isAtEdge() == true)
        {
            getWorld().removeObject(this);
        }
    }    
}
