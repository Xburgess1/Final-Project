import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MissleV1S1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MissleV1S1 extends Secondary
{
    /**
     * Act - do whatever the MissleV1S1 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        //does 3 damage 

        setLocation(getX(),getY()-4);
        
        if(isAtEdge() == true)
        {
            getWorld().removeObject(this);
        }
    }    
}
