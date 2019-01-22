import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class NukeSelect here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class NukeSelect extends WeaponSelect
{
    /**
     * Act - do whatever the NukeSelect wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        SpaceWorld space = (SpaceWorld)getWorld();
        S1 select = space.getShip();
        if(Greenfoot.mouseClicked(this) == true)
        {
            select.setMissleV1Selected(false);
            select.setPlasmaSecV2Selected(false);
            select.setNukeV3Selected(true);
        }
        
        if(select.getNukeSelected() == true)
        {
            space.removeObjects( space.getObjects(SecondarySelectBox.class) );
            space.addObject(new SecondarySelectBox(), getX(), getY());
        }
    }    
}
