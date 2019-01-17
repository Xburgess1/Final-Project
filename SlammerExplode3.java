import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SlammerExplode3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SlammerExplode3 extends Enemies
{
    /**
     * Act - do whatever the SlammerExplode3 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        setLocation(getX() - 13, getY() + 5);
        if(isAtEdge() == true)
        {
            getWorld().removeObject(this);
        }
    }    
}
