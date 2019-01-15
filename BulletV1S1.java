import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BulletV1S1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BulletV1S1 extends Bullets
{
    //private int for bullet speed
    private int speed = 6;
    /**
     * Act sets its own location 6 less then it's own y location. If the bullet reaches the edge of the world it removes itself
     * 
     * @param None there are no parameters
     * @return there is no return
     */
    public void act() 
    {
        //the bullet does 1 damage to most enemies
        
        
        setLocation(getX(), getY()-speed);
        
        
        if(isAtEdge() == true)
        {
            getWorld().removeObject(this);
        }
    }    
}
