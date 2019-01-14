import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MissleV1S1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MissleV1S1 extends Secondary
{
    //private int for spped of missle
    private int speed = 4;
    
    /**
     * Act - do whatever the MissleV1S1 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        //does 3 damage 
        
        //moves the location up by the amount of speed set
        setLocation(getX(),getY()-speed);
        
        //if is at edge it removes itself
        if(isAtEdge() == true)
        {
            getWorld().removeObject(this);
        }
    }    
}
