import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SlammerExplode1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SlammerExplode1 extends Enemies
{
    /**
     * Act - do whatever the SlammerExplode1 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        setLocation(getX() - 12, getY() - 5);
        if(isAtEdge() == true)
        {
            getWorld().removeObject(this);
        }
    }    
}
