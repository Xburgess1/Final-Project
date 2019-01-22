import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class S1Select here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class S1Select extends CharacterSelect
{
    //s1Selecting is used for if the s1 ship is being selected
    private boolean s1Selecting = false;
    
    /**
     * Act if the user clicks of the ship it sets s1Selecting to true and if s1Selecting is true it calls the weapons class
     * 
     * @param None there are no parameters
     * @return there is no return
     */
    public void act() 
    {
        if(Greenfoot.mouseClicked(this) == true)
        {
            s1Selecting = true;
            if(s1Selecting == true)
            {
                weapons();
            }
        }
    }
    
    /**
     * weapons add the V1S1Select and MissleSelect to the world. If lev2Complete is true it adds the V2S1Select to the world and if Lev4Complete
     * is true it adds PlasmaSecSelect to the world. If Lev5Complete is true it adds the Toxic Waste Select
     * 
     * @param None there are no parameters
     * @return there is no return
     */
    private void weapons()
    {
        getWorld().addObject(new V1S1Select(), 500, 500);
        getWorld().addObject(new MissleSelect(), 500, 550);
        
        
        
        if(((SpaceWorld)getWorld()).getLev2Complete() == true)
        {
            getWorld().addObject(new V2S1Select(), 550, 502);
        }
        if(((SpaceWorld)getWorld()).getLev4Complete() == true)
        {
            getWorld().addObject(new PlasmaSecSelect(), 550, 550);
        }
        if(((SpaceWorld)getWorld()).getLev5Complete() == true)
        {
            getWorld().addObject(new V3S1Select(), 600, 503);
        }
        if(((SpaceWorld)getWorld()).getLev6Complete() == true)
        {
            getWorld().addObject(new NukeSelect(), 600, 550);
        }
    }
    
}
