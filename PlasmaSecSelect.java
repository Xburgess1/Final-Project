import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PlasmaSecSelect here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PlasmaSecSelect extends WeaponSelect
{
    /**
     * Act - do whatever the PlasmaSecSelect wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        SpaceWorld space = (SpaceWorld)getWorld();
        S1 select = space.getShip();
        if(Greenfoot.mouseClicked(this) == true)
        {
            select.setMissleV1Selected(false);
            select.setPlasmaSecV2Selected(true);
        }
    }    
}
