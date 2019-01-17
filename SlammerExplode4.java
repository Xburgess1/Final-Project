import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SlammerExplode4 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SlammerExplode4 extends Enemies
{
    /**
     * Act - do whatever the SlammerExplode4 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        setLocation(getX() + 13, getY() + 6);
        if(isAtEdge() == true)
        {
            getWorld().removeObject(this);
        }
    }    
}
