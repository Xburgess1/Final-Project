import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GO here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GO extends Actor
{
    private boolean level2 = false;
    private boolean level3 = false;
    private boolean level4 = false;
    private boolean level5 = false;
    
    /**
     * Act - do whatever the GO wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(Greenfoot.mouseClicked(this))
        {
            if(((SpaceWorld)getWorld()).getLev1Complete() == true && ((SpaceWorld)getWorld()).getLev2Complete() == false)
            {
                level2 = true;
            }
            else if(((SpaceWorld)getWorld()).getLev2Complete() == true && ((SpaceWorld)getWorld()).getLev3Complete() == false)
            {
                level3 = true;
            }
            else if(((SpaceWorld)getWorld()).getLev3Complete() == true && ((SpaceWorld)getWorld()).getLev4Complete() == false)
            {
                level4 = true;
            }
            else if(((SpaceWorld)getWorld()).getLev4Complete() == true && ((SpaceWorld)getWorld()).getLev5Complete() == false)
            {
                level5 = true;
            }
        }
    }
    
    public boolean getLevel2()
    {
        return level2;
    }
    public void setLevel2(boolean l2)
    {
        level2 = l2;
    }
    
    public boolean getLevel3()
    {
        return level3;
    }
    public void setLevel3(boolean l3)
    {
        level3 = l3;
    }
    
    public boolean getLevel4()
    {
        return level4;
    }
    public void setLevel4(boolean l4)
    {
        level4 = l4;
    }
    
    public boolean getLevel5()
    {
        return level5;
    }
    public void setLevel5(boolean l5)
    {
        level5 = l5;
    }
}
