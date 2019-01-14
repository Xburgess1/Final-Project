import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class DualShot here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DualShot extends Enemies
{
    private double health;
    
    private int movementCount = 0;
    
    private int imageDelay = 0;
    
    private boolean charging = false;
    public DualShot()
    {
        health = 6;
    }
    
    /**
     * Act - do whatever the DualShot wants to do. This method is called whenever
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
        
        movementCount++;
        
        if(Greenfoot.getRandomNumber(1300) < 1)
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
    
    private void shoot()
    {
        getWorld().addObject(new DualBullet(), getX() + 20, getY() + 20);
        getWorld().addObject(new DualBullet(), getX() - 20, getY() + 20);
        imageDelay = 0;
    }
}
