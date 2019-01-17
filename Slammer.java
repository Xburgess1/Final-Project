import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Slammer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Slammer extends Enemies
{
    private double health = 200;
    
    private boolean midSlam = false;
    
    private int slamDelay;
    
    private boolean slam = false;
    
    private int slamTime;
    
    private boolean stop = false;
    
    private boolean sideMovements = false;
    
    private boolean doneSlam = false;
    
    private boolean moveRight = false;
    
    private boolean moveLeft = false;
    
    private int movingRight;
    
    private int movingLeft;
    
    private boolean damaged = false;
    
    private boolean hasMoved = true;
    
    private boolean noRight = false;
    
    private int damagedSlamTime;
    
    private boolean doneDamagedSlam = false;

    private int dying = 0;
    /**
     * The constructor sets up the variables for the Slammer
     * 
     * @param None there are no parameters
     * @return there is no return
     */
    public Slammer()
    {
        slamDelay = 0;
        slamTime = 0;
        movingRight = 0;
        movingLeft = 0;
        damagedSlamTime = 0;
    }
    
    /**
     * Act - do whatever the Slammer wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        checkHit();
        
        settingImage();
        if(midSlam == false && Greenfoot.getRandomNumber(400) < 1)
        {
            midSlam = true;
        }
        
        if( midSlam == true )
        {
            if( slamDelay < 20 && stop == false)
            {
                setLocation( getX(), getY() - 1 );
            }
            slamDelay++;
        }
        
        if( slamDelay > 100 )
        {
            slam = true;
            slamDelay = 0;
        }
        
        if(slam == true)
        {
            if(slamTime < 21)
            {
                setLocation( getX(), getY() + 24 );
            }
            slamTime++;
            stop = true;
            if(slamTime > 45 && slamTime < 68)
            {
                setLocation( getX(), getY() - 22);
            }
        }
        
        if(slamTime >= 80)
        {
            doneSlam = true;
            hasMoved = false;
        }
        
        if(doneSlam == true && damaged == false)
        {
            midSlam = false;
            slam = false;
            slamTime = 0;
            stop = false;
            slamDelay = 0;
            doneSlam = false;
            
        }
        
        if(doneSlam == true && damaged == true && hasMoved == false )
        {
            if(Greenfoot.getRandomNumber(10) < 5 && moveLeft == false)
            {
                moveRight = true;
                hasMoved = true;
            }
            else if(moveRight == false)
            {
                noRight = true;
                hasMoved = true;
            }
            slam = false;
        }
        
        if(noRight == true)
        {
            moveLeft = true;
            
        }
        
        if(moveRight == true)
        {
            if(movingRight < 28)
            {
                setLocation(getX() + 10, getY());
                
            }
            movingRight++;
            hasMoved = true;
        }
        else if(moveLeft == true)
        {
            if(movingLeft < 28)
            {
                setLocation(getX() - 10, getY());
                
            }
            movingLeft++;
            hasMoved = true;
        }
        
        if(movingLeft > 35 || movingRight > 35)
        {
            if(damagedSlamTime < 21)
            {
                setLocation( getX(), getY() + 24 );
            }
            damagedSlamTime++;
            
            if(damagedSlamTime > 45 && damagedSlamTime < 67)
            {
                setLocation( getX(), getY() - 24);
            }
            
        }
        
        if(damagedSlamTime >= 80 && moveLeft == true)
        {
            
            if(movingRight < 28)
            {
                setLocation(getX() + 10, getY());
            }
            movingRight++;
        }
        
        if(damagedSlamTime >= 80 && moveRight == true)
        {
            
            if(movingLeft < 28)
            {
                setLocation(getX() - 10, getY());
            }
            movingLeft++;
        }
        
        if(damagedSlamTime > 500)
        {
            doneDamagedSlam = true;
        }
        
        if(doneDamagedSlam == true)
        {
            midSlam = false;
            slam = false;
            slamTime = 0;
            stop = false;
            slamDelay = 0;
            doneSlam = false;
            doneDamagedSlam = false;
            moveRight = false;
            moveLeft = false;
            movingLeft = 0;
            movingRight = 0;
            noRight = false;
            damagedSlamTime = 0;
            
        }
        
        
        /**
         * This bit of code does not work in its own method
         */
        if(health <= 0)
        {
            die();
        }
        else if(health <= 91)
        {
            damaged = true;
        }
        
        if(dying >= 3)
        {
            
            getWorld().addObject(new SlammerExplode1(), getX() - 120, getY() - 120);
            getWorld().addObject(new SlammerExplode2(), getX(), getY() - 120);
            getWorld().addObject(new SlammerExplode3(), getX() - 120, getY() + 120);
            getWorld().addObject(new SlammerExplode4(), getX(), getY() + 120);
            getWorld().removeObject(this);
        }
    }
    
    /**
     * checkHit checks to see if the Slammer has been touched by a bullet or a missle. If so Slammer will take the right amount of damage. The damage 
     * is reduced form the normal amount. If it is touching a toxic waste bullet and dies the toxic waste does not get destroyed. If it is touching a
     * nuke the Slammer takes 9 damage.
     * 
     * @param None there are no parameters
     * @return there is no return
     */
    private void checkHit()
    {
        
        if(isTouching(BulletV1S1.class))
        {
            removeTouching(BulletV1S1.class);
            health = health - 0.8;
        }
        
        else if(isTouching(MissleV1S1.class))
        {
            removeTouching(MissleV1S1.class);
            health = health - 2.5;
        }
        
        else if(isTouching(PlasmaV2S1.class))
        {
            removeTouching(PlasmaV2S1.class);
            health = health - 1.2;
        }
        else if(isTouching(PlasmaSecV2S1.class))
        {
            removeTouching(PlasmaSecV2S1.class);
            health = health - 2.8;
        }
        else if(isTouching(ToxicWasteV3S1.class) && health > 2)
        {
            removeTouching(ToxicWasteV3S1.class);
            health = health - 1.4;
        }
        else if(isTouching(ToxicWasteV3S1.class) && health <= 2)
        {
            health = health - 1.4;
        }
        else if(isTouching(NukeV3S1.class))
        {
            health = health = 9;
            removeTouching(NukeV3S1.class);
        }
    }
    
    
    /**
     * settingImage sets the image of Slammer depending on how much health it is at. if it is between 135 and 112 it sets it to SlammerDamaged1.
     * If the health is at 111 to 92 it sets the image to SlammerDamaged2, if the health is at 91 to 71 it sets the image to SlammerDamaged3, if the
     * health is at 70 to 39 it sets the image to SlammerDamaged4, and if the health is 38 or lower it sets the image to SlammerDamaged5. 
     * 
     * @param None there are no parameters
     * @return there is no return
     */
    private void settingImage()
    {
        
        if(health <= 185 && health >= 154)
        {
            setImage("SlammerDamaged1.png");
        }
        else if(health <= 153 && health >= 121)
        {
            setImage("SlammerDamaged2.png");
            
        }
        else if(health <= 120 && health >= 92)
        {
            setImage("SlammerDamaged3.png");
            
        }
        else if(health <= 91 && health >= 56)
        {
            setImage("SlammerDamaged4.png");
        }
        else if(health <= 55)
        {
            setImage("SlammerDamaged5.png");
        }
        
    }
    
    /**
     * die removes the Slammer from the world
     * 
     * @param there are no parameters
     * @return there is no return
     */
    private void die()
    {
        GreenfootImage[] deathAnims = {new GreenfootImage("SlammerDeath1.png"), new GreenfootImage("SlammerDeath2.png"), new GreenfootImage("SlammerDeath3.png")};
        
        for(int i = 0; i < deathAnims.length; i++)
        {
            setImage(deathAnims[i]);
            Greenfoot.delay(90);
            dying++;
        }
    }
} 


