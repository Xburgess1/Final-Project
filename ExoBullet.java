import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ExoBullet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ExoBullet extends Enemies
{
    /**
     * Act - do whatever the ExoBullet wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        
        setLocation(getX() + Greenfoot.getRandomNumber(16) - 8, getY()+ 5);
        
        if(isAtEdge() == true)
        {
            getWorld().removeObject(this);
        }
    }    
}
