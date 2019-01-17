import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class S1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class S1 extends Ships
{
    //private int variable for the delay between missle
    private int missleDelay = 1700;
    //private int variable for the delay between shots
    private int shotDelay = 40;
    //priavte int variable for the delay between switching images
    private int imageDelay = 17;
    //private int variable for the delay between the secondary plasma shot
    private int plasmaSecDelay = 1000;
    //private int variable for the dealy between the nuke
    private int nukeDelay = 2000;
    //private boolean variable for checking if the bulletV1 has been selected
    private boolean bulletV1Selected = true;
    //private boolean variable for checking if the missleV1 has been selected
    private boolean missleV1Selected = true;
    //private booelan varaibale for checking if the plasmaV2 has been selected
    private boolean plasmaV2Selected = false;
    //private boolean variable for checking if the plasmaSec has been selected
    private boolean plasmaSecV2Selected = false;
    //private boolean variable for checking if the toxic waste has been selected
    private boolean toxicV1Selected = false;
    //private boolean variable for checking if the nuke has been selected
    private boolean nukeV3Selected = false;
    
    /**
     * Act - do whatever the S1 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        //adds one to all of the delay variables
        shotDelay = shotDelay + 1;
        imageDelay = imageDelay + 1;
        missleDelay = missleDelay + 1;
        plasmaSecDelay = plasmaSecDelay +1;
        nukeDelay = nukeDelay + 1;
        
        
        if(Greenfoot.isKeyDown("left") == true)
        {
            moveLeft();
        }
        
        
        if(Greenfoot.isKeyDown("right") == true)
        {
            moveRight();
        }
        
        
        if(Greenfoot.isKeyDown("space") == true && shotDelay >= 40 && bulletV1Selected == true)
        {
            shooting();
        }
        
        
        if(Greenfoot.isKeyDown("up") == true && missleDelay >= 1800 && missleV1Selected == true)
        {
            missleShooting();
        }
        
        if(Greenfoot.isKeyDown("space") == true && shotDelay >= 40 && plasmaV2Selected == true)
        {
            plasmaShooting();
        }
        
        if(Greenfoot.isKeyDown("up") == true && plasmaSecDelay >= 1200 && plasmaSecV2Selected == true)
        {
            plasmaSecShooting();
        }
        
        if(Greenfoot.isKeyDown("space") == true && shotDelay >= 40 && toxicV1Selected == true)
        {
            toxicShot();
        }
        
        if(Greenfoot.isKeyDown("up") == true && nukeDelay >= 2400 && nukeV3Selected == true)
        {
            nuke();
        }
        
        
        //if the imageDelay is less than or equal to 16 it sets the image to S.1 Shooting.png else it sets it to S.1 .png
        if(imageDelay <= 16)
        {
            setImage("S.1 Shooting.png");
        }
        else
        {
            setImage("S.1 .png");
        }
        
        if(isTouching(Enemies.class) == true)
        {
            die();
        }
    }
    
    /**
     * die removes the ship from the world and stops the program
     * 
     * @param None there are no parameters
     * @return there is no return
     */
    private void die()
    {
        getWorld().removeObject(this);
        Greenfoot.stop();
    }
    
    /**
     * adds two bullets and sets the shot and imageDelay to 0
     * 
     * @param there are no parameters
     * @return there is no return
     */
    private void shooting()
    {
        getWorld().addObject(new BulletV1S1(), getX()+24, 705);
        getWorld().addObject(new BulletV1S1(), getX()-24, 705);
        shotDelay = 0;
        imageDelay = 0;
    }
    
    /**
     * adds two plasma shots and sets the shot and imageDelay to 0
     * 
     * @param there are no parameters
     * @return there is no return
     */
    private void plasmaShooting()
    {
        getWorld().addObject(new PlasmaV2S1(), getX()+24, 705);
        getWorld().addObject(new PlasmaV2S1(), getX()-24, 705);
        shotDelay = 0;
        imageDelay = 0;
    }
    
    /**
     * adds two toxic waste shots and sets the shot and imageDelay to 0
     * 
     * @param there are no parameters
     * @return there is no return
     */
    private void toxicShot()
    {
        getWorld().addObject(new ToxicWasteV3S1(), getX()+24, 705);
        getWorld().addObject(new ToxicWasteV3S1(), getX()-24, 705);
        shotDelay = 0;
        imageDelay = 0;
    }
    
    /**
     * adds a missleV1S1 to the world and sets secShotDelay to 0
     * 
     * @param there are no parameters
     * @return there is no return
     */
    private void missleShooting()
    {
        getWorld().addObject(new MissleV1S1(), getX(), 708);
        missleDelay = 0;
    }
    
    /**
     * adds a plasmaSec to the world and sets plasmaSecDelay to 0
     * 
     * @param there are no parameters
     * @return there is no return
     */
    private void plasmaSecShooting()
    {
        getWorld().addObject(new PlasmaSecV2S1(), getX(), 708);
        plasmaSecDelay = 0;
    }
    
    /**
     * adds a nuke to the world and sets nukeDelay to 0
     * 
     * @param there are no parameters
     * @return there is no return
     */
    private void nuke()
    {
        getWorld().addObject(new NukeV3S1(), getX(), 708);
        nukeDelay = 0;
    }
    
    /**
     * moves the ship to the left by 2 pixels
     * 
     * @param there are no parameters
     * @return there is no return
     */
    private void moveLeft()
    {
        setLocation(getX()-2, getY());
        
    }
    
    /**
     * moves the ship to the right by 2 pixels
     * 
     * @param there are no paramters
     * @return there is no return
     */
    private void moveRight()
    {
        setLocation(getX()+2, getY());
        
    }
    
    /**
     * setBulletV1Selected allows other classes to change the bulletV1Selected variable
     * 
     * @param v1Select is used to set the value of bulletV1Selected
     * @return there is no return
     */
    public void setBulletV1Selected(boolean v1Select)
    {
        bulletV1Selected = v1Select;
    }
    /**
     * setPlasmaV2Selected allows other classes to change the plasmaV2Selected variable
     * 
     * @param v2Select is used to set the value of plasmaV2Selected
     * @return there is no return
     */
    public void setPlasmaV2Selected(boolean v2Select)
    {
        plasmaV2Selected = v2Select;
    }
    
    /**
     * setMissleV1Selected allows other classes to change the missleV1Selected variable
     * 
     * @param missleSelect is used to set the value of missleV1Selected
     * @return there is no return
     */
    public void setMissleV1Selected(boolean missleSelect)
    {
        missleV1Selected = missleSelect;
    }
    /**
     * setPlasmaSecV2Selected allows other classes to change the plasmaSecV2Selected variable
     * 
     * @param plasSecSelect is used to set the value of plasmaSecV2Selected
     * @return there is no return
     */
    public void setPlasmaSecV2Selected(boolean plasSecSelect)
    {
        plasmaSecV2Selected = plasSecSelect;
    }
}
