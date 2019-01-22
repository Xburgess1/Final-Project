import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BasicDefender here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BasicDefender extends Enemies
{
    //private double variable for the amount of health the BasicDefender has
    private double health = 4;
    //private int variable for counting the movements of the BasicDefender
    private int movementCount = 0;
    
    /**
     * Act calls the die method if the health is less then or equal to 0 and adds 1 to the movementCount. If the health is equal to or is greater
     * then 1 it continues to do a series of movements which makes the BasicDefender move from side to side. It also calls the checkDamage method.
     * 
     * @param None there are no parameters
     * @return there is no return
     */
    public void act() 
    {
        movementCount++;
        
        if(health >= 1)
        {
            if( movementCount < 20 )
            {
                setLocation(getX() +1, getY());
            }
            else if( movementCount < 60 )
            {
                setLocation(getX() -1, getY());
            }
            else if( movementCount < 81 )
            {
                setLocation(getX() +1, getY());
            }
            else
            {
                movementCount = 0;
            }
        }
        
        checkDamage();
        
        if(health <= 0)
        {
            die();
        }
    }
    
    /**
     * checkDamage checks to see if the BasicDefender has been hit by any bullets or missles. If so it will take a different amount of damage
     * depending on what bullet it is. If it is touching toxic waste and it's health is less then or equal to 1.5 it calls the die method. If it is 
     * touching a nuke it dies.
     * 
     * @param None there are no parameters
     * @return there is no return
     */
    private void checkDamage()
    {
        if(isTouching(BulletV1S1.class))
        {
            removeTouching(BulletV1S1.class);
            health = health - 1;
        }
        else if(isTouching(MissleV1S1.class))
        {
            removeTouching(MissleV1S1.class);
            health = health - 3;
        }
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
        else if(isTouching(ToxicWasteV3S1.class) && health > 1.5)
        {
            removeTouching(ToxicWasteV3S1.class);
            health = health - 1.5;
        }
        else if(isTouching(ToxicWasteV3S1.class) && health <= 1.5)
        {
            health = health - 1.5;
        }
        else if(isTouching(NukeV3S1.class))
        {
            removeTouching(NukeV3S1.class);
            die();
            
        }
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
