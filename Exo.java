import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Exo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Exo extends Enemies
{
    //private double varaible for the amount of health the Exo has
    private double health = 14;
    //private int variable for counting the movement of the Exo
    private int movementCount = 0;
    /**
     * Act - do whatever the Exo wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        movementCount++;
        
        checkDamage();
        
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
        
        if(Greenfoot.getRandomNumber(730) < 1)
        {
            shoot();
        }
        
        if(health <= 0)
        {
            die();
        }
    }
    /**
     * chackDamage checks to see if the Exo has been hit by any bullets or missles. If it is touching a toxic waste bullet and it's health is
     * equal to or less than 1.5 it dies and doesn't remove the toxic waste bullet..
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
            health = health - 10;
            removeTouching(NukeV3S1.class);
        }
    }
    
    /**
     * removes the Exo from the world
     * 
     * @param there are no parameters
     * @return there is no return
     */
    private void die()
    {
        getWorld().removeObject(this);
    }
    
    /**
     * shoot adds two ExoBullets at the ends of the barrels.
     * 
     * @param None there are no parameters
     * @return there is no return
     */
    private void shoot()
    {
        getWorld().addObject(new ExoBullet(), getX() + 25, getY() + 35);
        getWorld().addObject(new ExoBullet(), getX() - 25, getY() + 35);
    }
}
