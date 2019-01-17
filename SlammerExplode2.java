import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SlammerExplode2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SlammerExplode2 extends Enemies
{
    /**
     * Act - do whatever the SlammerExplode2 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        setLocation(getX() + 10, getY() - 11);
        if(isAtEdge() == true)
        {
            getWorld().removeObject(this);
        }
    }    
}
