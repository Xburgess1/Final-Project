import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class DualBullet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DualBullet extends Enemies
{
    /**
     * Act - do whatever the DualBullet wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        setLocation(getX(), getY() +18);
        if(isAtEdge() == true)
        {
            getWorld().removeObject(this);
        }
    }    
}
