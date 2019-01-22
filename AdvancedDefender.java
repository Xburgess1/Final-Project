import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class AdvancedDefender here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class AdvancedDefender extends Enemies
{
    //private double variable for the amount of health the AdvancedDefender has
    private double health = 8;
    //private int variable for counting the movements of the AdvancedDefender
    private int movementCount = 0;
    
    /**
     * Act - do whatever the AdvancedDefender wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        movementCount++;
        
        if(health >= 0.1)
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
     * checkDamage checks to see if the AdvancedDefender has been hit by any bullets or missles. If so it will take a different amount of damage
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
     * removes the AdvancedDefender from the world
     * 
     * @param there are no parameters
     * @return there is no return
     */
    private void die()
    {
        getWorld().removeObject(this);
    }
}
