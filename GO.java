import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GO here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GO extends Actor
{
    //the level2 boolean is used to know if level 2 has started
    private boolean level2 = false;
    //the level3 boolean is used to know if level 3 has started
    private boolean level3 = false;
    //the level4 boolean is used to know if level 4 has started
    private boolean level4 = false;
    //the level5 boolean is used to know if level 5 has started
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
    
    /**
     * getLevel2 returns the level2 variable
     * 
     * @param None there are no parameters
     * @return the level2 at the given value
     */
    public boolean getLevel2()
    {
        return level2;
    }
    /**
     * setLevel2 allows other classes to set the level2 variable
     * 
     * @param l2 is value used to set the level2 value
     * @return there is no return
     */
    public void setLevel2(boolean l2)
    {
        level2 = l2;
    }
    
    /**
     * getLevel3 returns the level3 variable
     * 
     * @param None there are no parameters
     * @return the level3 at the given value
     */
    public boolean getLevel3()
    {
        return level3;
    }
    /**
     * setLevel3 allows other classes to set the level3 variable
     * 
     * @param l3 is value used to set the level3 value
     * @return there is no return
     */
    public void setLevel3(boolean l3)
    {
        level3 = l3;
    }
    
    /**
     * getLevel4 returns the level4 variable
     * 
     * @param None there are no parameters
     * @return the level4 at the given value
     */
    public boolean getLevel4()
    {
        return level4;
    }
    /**
     * setLevel4 allows other classes to set the level4 variable
     * 
     * @param l4 is value used to set the level4 value
     * @return there is no return
     */
    public void setLevel4(boolean l4)
    {
        level4 = l4;
    }
    
    /**
     * getLevel5 returns the level5 variable
     * 
     * @param None there are no parameters
     * @return the level5 at the given value
     */
    public boolean getLevel5()
    {
        return level5;
    }
    /**
     * setLevel5 allows other classes to set the level5 variable
     * 
     * @param l5 is value used to set the level5 value
     * @return there is no return
     */
    public void setLevel5(boolean l5)
    {
        level5 = l5;
    }
}
