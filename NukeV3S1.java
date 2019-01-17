import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class NukeV3S1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class NukeV3S1 extends Secondary
{
    /**
     * Act - do whatever the NukeV3S1 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        //does 10 damage and charges slow meant for bosses 
        
        setLocation(getX(), getY() -2);
        
        if(isAtEdge() == true)
        {
            getWorld().removeObject(this);
        }
    }    
}
