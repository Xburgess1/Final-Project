import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BasicDefender here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BasicDefender extends Enemies
{
    //private variable for the BasicDefender's health
    private double health = 4;
    
    private int movementCount = 0;
    
    /**
     * Act - do whatever the BasicDefender wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        //if is touchign a BulletV1S1 it removes the bullet and takes one damage
        if(isTouching(BulletV1S1.class))
        {
            removeTouching(BulletV1S1.class);
            health = health - 1;
        }
        //if is touching MissleV1S1 it removes the missle and takes 3 damage
        else if(isTouching(MissleV1S1.class))
        {
            removeTouching(MissleV1S1.class);
            health = health - 3;
        }
        //if is touching PlasmaV2S1 it removes the plasma and takes 2 damage
        else if(isTouching(PlasmaV2S1.class))
        {
            removeTouching(PlasmaV2S1.class);
            health = health - 1.5;
        }
        else if(isTouching(PlasmaSecV2S1.class))
        {
            removeTouching(PlasmaSecV2S1.class);
            health = health - 3;
        }
        else if(isTouching(ToxicWasteV3S1.class) && health > 2)
        {
            removeTouching(ToxicWasteV3S1.class);
            health = health - 1.5;
        }
        else if(isTouching(ToxicWasteV3S1.class) && health <= 2)
        {
            health = health - 1.5;
        }
        else if(isTouching(NukeV3S1.class))
        {
            die();
            removeTouching(NukeV3S1.class);
        }
        
        
        //if the health reaches 0 it calls the die method
        if(health <= 0)
        {
            die();
        }
        
        if(health >= 1)
        {
            if( movementCount < 20 )
            {
                setLocation(getX() +1, getY());
            }
            else if( movementCount < 60 )
            {
            //Greenfoot.delay(30);
                setLocation(getX() -1, getY());
            }
            else if( movementCount < 81 )
            {
                //Greenfoot.delay(30);
                setLocation(getX() +1, getY());
                //Greenfoot.delay(30);
            }
            else
            {
                movementCount = 0;
            }
        }
        
        movementCount++;
    }
    
    /**
     * removes the BasicDefender from the world
     * 
     * @param there are no parameters
     * @return there is no return
     */
    private void die()
    {
        getWorld().removeObject(this);
    }
}
