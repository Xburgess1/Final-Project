import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class V3S1Select here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class V3S1Select extends WeaponSelect
{
    /**
     * Act - do whatever the V3S1Select wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        SpaceWorld space = (SpaceWorld)getWorld();
        S1 select = space.getShip();
        
        if(Greenfoot.mouseClicked(this) == true)
        {
            select.setPlasmaV2Selected(false);
            select.setBulletV1Selected(false);
            select.setToxicV3Selected(true);
        }
        
        if(select.getToxicSelected() == true)
        {
            space.removeObjects( space.getObjects(PrimarySelectBox.class) );
            space.addObject(new PrimarySelectBox(), getX(), getY());
        }
    }    
}
