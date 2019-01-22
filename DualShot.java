import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class DualShot here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DualShot extends Enemies
{
    //private double varaible for the amount of health the DualShot has
    private double health = 8;
    //private int variable for counting the movement of the DualShot
    private int movementCount = 0;
    //private int imageDelay for delaying the time between image switching
    private int imageDelay = 0;
    //private boolean variable for if the DualShot is charging it's weapon
    private boolean charging = false;
    
    /**
     * Act - do whatever the DualShot wants to do. This method is called whenever
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
        
        if(Greenfoot.getRandomNumber(980) < 1)
        {
            charging = true;
        }
        
        if(charging == true)
        {
            imageDelay++;
            
            if(imageDelay <= 120)
            {
                setImage("DualShotCharging.png");
            }
            else
            {
                setImage("DualShot.png");
                shoot();
                charging = false;
            }
        }  
        
        checkDamage();
        
        if(health <= 0)
        {
            die();
        }
    }
    
    
    /**
     * chackDamage checks to see if the DualShot has been hit by any bullets or missles. If it is touching a toxic waste bullet and it's health is
     * equal to or less than 1.5 it dies and doesn't remove the toxic waste bullet. If it is touching a nuke it dies.
     * 
     * @param None the are no parameters
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
        else if(isTouching(ToxicWasteV3S1.class) && health > 1.6)
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
     * removes the DualShot from the world
     * 
     * @param there are no parameters
     * @return there is no return
     */
    private void die()
    {
        getWorld().removeObject(this);
    }
    
    /**
     * shoot adds two DualBullets at the ends of the barrels and sets the imageDelay to 0.
     * 
     * @param None there are no parameters
     * @return there is no return
     */
    private void shoot()
    {
        getWorld().addObject(new DualBullet(), getX() + 20, getY() + 20);
        getWorld().addObject(new DualBullet(), getX() - 20, getY() + 20);
        imageDelay = 0;
    }
}
