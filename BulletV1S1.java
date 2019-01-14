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
     * Act - do whatever the BulletV1S1 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        //does 1 damage
        
        //moves the bullets by the set speed
        setLocation(getX(), getY()-speed);
        
        //if is at edge it removes itself
        if(isAtEdge() == true)
        {
            getWorld().removeObject(this);
        }
    }    
}
