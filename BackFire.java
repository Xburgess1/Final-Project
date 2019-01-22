import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BackFire here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BackFire extends Enemies
{
    //private double variable for the health of the BackFire
    private double health = 5;
    //private int variable for counting the movements of the BackFire
    private int movementCount = 0;

    /**
     * Act calls the shooting method and if the health of the BackFire reaches 0 or less it calls the die method, it calls the checkDamage method and
     * ands 1 to the movementCount variable. If the health is equal to or more then 1 it continues a series of movements which get the BackFire to
     * move side to side over and over.
     * 
     * @param None there are no parameters
     * @return there is no return
     */
    public void act() 
    {
        shooting();
        
        movementCount++;
        
        checkDamage();

        if(health <= 0)
        {
            die();
        }
        
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
    }
    
    /**
     * checkDamaged checks to see if the BackFire is touching any of the bullets. Depending on what bullet or missle it is touching it will lose the 
     * right amount of health. If it is touching a toxic waste and it's health is less then or equal to 1.5 it will die but not remoe the bullet like
     * the other ones. If it is touching a nuke it dies.
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
     * shooting gets a random number between 0 and 999, if that number rolled is a 0 it adds an EnemyBullet at the end of the barrel.
     * 
     * @param None there are no parameters
     * @return there is no return
     */
    private void shooting()
    {
        if(Greenfoot.getRandomNumber(1000) < 1)
        {
            getWorld().addObject(new EnemyBullet(), getX(), getY() + 15);
        }
    }
    
    /**
     * die removes the BackFire from the world
     * 
     * @param there are no parameters
     * @return there is no return
     */
    private void die()
    {
        getWorld().removeObject(this);
    }
}
