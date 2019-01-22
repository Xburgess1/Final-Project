 
    import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
    import java.util.List;
    
    /**
     * Name: Xavier Burgess
     * Teacher: Mr. Hardman
     * Course: Software Development
     * Date Last Modified: January 22nd 2019
     */
    public class SpaceWorld extends greenfoot.World
    {
        //selection is a boolean variable that determines if the selection menu will open
        private boolean selection = false;
        //populated is a boolean variable that determines if the world has been populated with enemies
        private boolean populated = false;
        //The levComplete boolean variables determine if the player has beat a level. They will become true once the level is complete
        private boolean lev1Complete = false;
        private boolean lev2Complete = false;
        private boolean lev3Complete = false;
        private boolean lev4Complete = false;
        private boolean lev5Complete = false;
        private boolean lev6Complete = false;
        private boolean lev7Complete = false;
        private boolean lev8Complete = false;
        private boolean level1 = true;
        /**
         * If there are levels you would like to skip, first set selection to true, second set the right amount of levCompletes to true. (ie. 
         * if you want to skip to level 4 you set levels 1 to 3 to true). Lastly you set level1 to false.
         */
        
        //goButton is a variable used to access different methods in GO
        private GO goButton = new GO();
        //s1Ship is used to set the weapon type of the ship
        private S1 s1Ship = new S1();

        
        /**
         * Constructor for objects of class MyWorld.
         * 
         */
        public SpaceWorld()
        {    
            // Create a new world with 800x800 cells with a cell size of 1x1 pixels.
            super(910, 760, 1);
            
            addObject(s1Ship,getWidth()/2, 715);
        }
        
        /**
         * act calls the checkLev1, 2, 3, 4, 5, 6, 7 and 8 methods. It also calls the checkWin method. While selection is set to true it calls the 
         * selectMenu and sets selection to false.If all of the enemies in level 1 are killed it sets selection to true, removes the ship, sets
         * level1 to false, sets populated to false and sets lev1Complete to true.
         * 
         * @param None there are no parameters
         * @return there is no return
         */
        public void act()
        {
            checkLev1();
            
            checkLev2();
            
            checkLev3();
            
            checkLev4();
            
            checkLev5();
            
            checkLev6();
            
            checkLev7();
            
            checkLev8();
           
            checkWin();
            
            while(selection == true)
            {
                selectMenu();
                selection = false;
            }
            
            if(getObjects(Enemies.class).size() == 0 && level1 == true)
            {
                selection = true;
                removeObjects(getObjects(Ships.class));
                level1 = false;
                populated = false;
                lev1Complete = true;
                
            }

        }
        
        /**
         * selectMenu sets up the two GreenfootImages ships and weapons. Then it draws those two images on the screen. It then adds a new S1Select 
         * and a goButton.
         * 
         * @param None there are no parameters
         * @return there is no return
         */
        private void selectMenu()
        {
            GreenfootImage ships = new GreenfootImage("SHIPS", 40, Color.WHITE, null);
            GreenfootImage weapons = new GreenfootImage("WEAPONS", 40, Color.BLACK, null);
            
            getBackground().drawImage(ships, 100, 50);
            getBackground().drawImage(weapons, 520, 450);
            
            addObject(new S1Select(), 70, 70);
            addObject(goButton, 850, 70);
        }
        
        /**
         * checkLev1 sets up the level1 boolean variable which determines if level 1 is on. The if level1 is true and populated is false it calls
         * the level1Spawn method.
         * 
         * @param None there are no parameters
         * @return there is no return
         */
        private void checkLev1()
        {
            if(level1 == true && populated == false)
            {
                level1Spawn();
            }
        }
        
        /**
         * checkLev2 checks to see if getLevel2 is true and populated is false, if so it calls level2Spawn, selection to false and removes the GO 
         * button, CharacterSelect and WeaponSelect. If all of the enemies in level2 are killed it sets selection to true, removes the ship, 
         * setLevel2 to false, populated to false and lev2Complete to true.
         * 
         * @param None there are no parameters
         * @return there is no return
         */
        private void checkLev2()
        {
            if(goButton.getLevel2() == true && populated == false)
            {
                level2Spawn();
                selection = false;
                removeObjects(getObjects(CharacterSelect.class));
                removeObjects(getObjects(WeaponSelect.class));
                removeObjects(getObjects(GO.class));
                removeObjects(getObjects(SecondarySelectBox.class));
                removeObjects(getObjects(PrimarySelectBox.class));
            }
            
            if(getObjects(Enemies.class).size() == 0 && goButton.getLevel2() == true)
            {
                selection = true;
                removeObjects(getObjects(Ships.class));
                goButton.setLevel2(false);
                populated = false;
                lev2Complete = true;
            }
        }
        
        /**
         * checkLev3 checks to see if getLevel3 is true and populated is false, if so it calls level3Spawn, selection to false and removes the GO 
         * button, CharacterSelect and WeaponSelect. If all of the enemies in level3 are killed it sets selection to true, removes the ship, 
         * setLevel3 to false, populated to false and lev3Complete to true.
         * 
         * @param None there are no parameters
         * @return there is no return
         */
        private void checkLev3()
        {
            if(goButton.getLevel3() == true && populated == false)
            {
                level3Spawn();
                selection = false;
                removeObjects(getObjects(CharacterSelect.class));
                removeObjects(getObjects(WeaponSelect.class));
                removeObjects(getObjects(GO.class));
                removeObjects(getObjects(SecondarySelectBox.class));
                removeObjects(getObjects(PrimarySelectBox.class));
            }
            
            if(getObjects(Enemies.class).size() == 0 && goButton.getLevel3() == true)
            {
                selection = true;
                removeObjects(getObjects(Ships.class));
                goButton.setLevel3(false);
                populated = false;
                lev3Complete = true;
            }
        }
        
        /**
         * checkLev4 checks to see if getLevel4 is true and populated is false, if so it calls level4Spawn, selection to false and removes the GO 
         * button, CharacterSelect and WeaponSelect. If all of the enemies in level4 are killed it sets selection to true, removes the ship, 
         * setLevel4 to false, populated to false and lev4Complete to true.
         * 
         * @param None there are no parameters
         * @return there is no return
         */
        private void checkLev4()
        {
            if(goButton.getLevel4() == true && populated == false)
            {
                level4Spawn();
                selection = false;
                removeObjects(getObjects(CharacterSelect.class));
                removeObjects(getObjects(WeaponSelect.class));
                removeObjects(getObjects(GO.class));
                removeObjects(getObjects(SecondarySelectBox.class));
                removeObjects(getObjects(PrimarySelectBox.class));
            }
            
            if(getObjects(Enemies.class).size() == 0 && goButton.getLevel4() == true)
            {
                selection = true;
                removeObjects(getObjects(Ships.class));
                goButton.setLevel4(false);
                populated = false;
                lev4Complete = true;
            }
        }
        
        /**
         * checkLev5 checks to see if getLevel5 is true and populated is false, if so it calls level5Spawn, selection to false and removes the GO 
         * button, CharacterSelect and WeaponSelect. If all of the enemies on level 5 are killed it sets selection to true, removes the ship, sets
         * level5 to false, sets populated to false, lev5Complete to true.
         * 
         * @param None there are no parameters
         * @return there is no return
         */
        private void checkLev5()
        {
            if(goButton.getLevel5() == true && populated == false)
            {
                level5Spawn();
                selection = false;
                removeObjects(getObjects(CharacterSelect.class));
                removeObjects(getObjects(WeaponSelect.class));
                removeObjects(getObjects(GO.class));
                removeObjects(getObjects(SecondarySelectBox.class));
                removeObjects(getObjects(PrimarySelectBox.class));
            }
            
            if(getObjects(Enemies.class).size() == 0 && goButton.getLevel5() == true)
            {
                selection = true;
                removeObjects(getObjects(Ships.class));
                goButton.setLevel5(false);
                populated = false;
                lev5Complete = true;
            }
        }
        
        /**
         * checkLev6 checks to see if getLevel6 is true and populated is false, if so it calls level6Spawn, selection to false and removes the GO 
         * button, CharacterSelect and WeaponSelect. If all of the enemies on level 6 are killed it sets selection to true, removes the ship, sets
         * level6 to false, sets populated to false, lev6Complete to true.
         * 
         * @param None there are no parameters
         * @return there is no return
         */
        private void checkLev6()
        {
            if(goButton.getLevel6() == true && populated == false)
            {
                level6Spawn();
                selection = false;
                removeObjects(getObjects(CharacterSelect.class));
                removeObjects(getObjects(WeaponSelect.class));
                removeObjects(getObjects(GO.class));
                removeObjects(getObjects(SecondarySelectBox.class));
                removeObjects(getObjects(PrimarySelectBox.class));
            }
            
            if(getObjects(Enemies.class).size() == 0 && goButton.getLevel6() == true)
            {
                selection = true;
                removeObjects(getObjects(Ships.class));
                goButton.setLevel6(false);
                populated = false;
                lev6Complete = true;
            }
        }
        
        /**
         * checkLev7 checks to see if getLevel7 is true and populated is false, if so it calls level7Spawn, selection to false and removes the GO 
         * button, CharacterSelect and WeaponSelect. If all of the enemies on level 7 are killed it sets selection to true, removes the ship, sets
         * level7 to false, sets populated to false, lev7Complete to true.
         * 
         * @param None there are no parameters
         * @return there is no return
         */
        private void checkLev7()
        {
            if(goButton.getLevel7() == true && populated == false)
            {
                level7Spawn();
                selection = false;
                removeObjects(getObjects(CharacterSelect.class));
                removeObjects(getObjects(WeaponSelect.class));
                removeObjects(getObjects(GO.class));
                removeObjects(getObjects(SecondarySelectBox.class));
                removeObjects(getObjects(PrimarySelectBox.class));
            }
            
            if(getObjects(Enemies.class).size() == 0 && goButton.getLevel7() == true)
            {
                selection = true;
                removeObjects(getObjects(Ships.class));
                goButton.setLevel7(false);
                populated = false;
                lev7Complete = true;
            }
        }
        
        /**
         * checkLev8 checks to see if getLevel8 is true and populated is false, if so it calls level8Spawn, selection to false and removes the GO 
         * button, CharacterSelect and WeaponSelect. If all of the enemies on level 8 are killed it sets selection to true, removes the ship, sets
         * level8 to false, sets populated to false, lev8Complete to true.
         * 
         * @param None there are no parameters
         * @return there is no return
         */
        private void checkLev8()
        {
             if(goButton.getLevel8() == true && populated == false)
            {
                level8Spawn();
                selection = false;
                removeObjects(getObjects(CharacterSelect.class));
                removeObjects(getObjects(WeaponSelect.class));
                removeObjects(getObjects(GO.class));
                removeObjects(getObjects(SecondarySelectBox.class));
                removeObjects(getObjects(PrimarySelectBox.class));
            }
            
            if(getObjects(Enemies.class).size() == 0 && goButton.getLevel8() == true)
            {
                lev8Complete = true;
            }   
        }
        
        /**
         * checkWin sets up a GreenfootImage that says "You Win!", then if lev8Complete is true it adds the win text to the world and stops
         * the program.
         * 
         * @param None there are no parameters
         * @return there is no return
         */
        private void checkWin()
        {
            GreenfootImage win = new GreenfootImage("You Win!", 120, Color.WHITE, null);
            if(lev8Complete == true)
            {
                getBackground().drawImage(win, getWidth()/2 - 150, getHeight()/2 - 120);
                Greenfoot.stop();
            }
        }
        
        /**
         * level1Spawn sets populated to true and creates a line of BasicDefenders.
         * 
         * @param None there are no parameters
         * @return there is no return
         */
        private void level1Spawn()
        {
            populated = true;
            
            addObject(new BasicDefender(), 70, 50);
            addObject(new BasicDefender(), 140, 50);
            addObject(new BasicDefender(), 210, 50);
            addObject(new BasicDefender(), 280, 50);
            addObject(new BasicDefender(), 350, 50);
            addObject(new BasicDefender(), 420, 50);
            addObject(new BasicDefender(), 490, 50);
            addObject(new BasicDefender(), 560, 50);
            addObject(new BasicDefender(), 630, 50);
            addObject(new BasicDefender(), 700, 50);
            addObject(new BasicDefender(), 770, 50);
            addObject(new BasicDefender(), 840, 50);
        }
        
        /**
         * level2Spawn sets populated to true and sets sthe background to the Planet.png picture. The it adds an object to the middle of the screen
         * and a row of BasicDefenders with a few BackFires inbetween.
         * 
         * @param None there are no parameters
         * @return there is no return
         */
        private void level2Spawn()
        {
            populated = true;
            
            setBackground("Planet.png");
            
            addObject(s1Ship, getWidth()/2, 715);
            
            addObject(new BasicDefender(), 70, 50);
            addObject(new BackFire(), 140, 50);
            addObject(new BasicDefender(), 210, 50);
            addObject(new BasicDefender(), 280, 50);
            addObject(new BackFire(), 350, 50);
            addObject(new BasicDefender(), 420, 50);
            addObject(new BasicDefender(), 490, 50);
            addObject(new BackFire(), 560, 50);
            addObject(new BasicDefender(), 630, 50);
            addObject(new BasicDefender(), 700, 50);
            addObject(new BackFire(), 770, 50);
            addObject(new BasicDefender(), 840, 50);
        }
        
        /**
         * level3Spawn sets populated to true and sets the background to the planet.png picture. Then it adds the ship to the middle of the screen 
         * and makes a row of backFires with a row of BasicDefenders below them.
         * 
         * @param None there are no parameters
         * @return there is no return
         */
        private void level3Spawn()
        {
            populated = true;
            
            setBackground("Planet.png");
            
            addObject(s1Ship, getWidth()/2, 715);
            
            addObject(new BackFire(), 140, 50);
            addObject(new BackFire(), 210, 50);
            addObject(new BackFire(), 280, 50);
            addObject(new BackFire(), 350, 50);
            addObject(new BackFire(), 420, 50);
            addObject(new BackFire(), 490, 50);
            addObject(new BackFire(), 560, 50);
            addObject(new BackFire(), 630, 50);
            addObject(new BackFire(), 700, 50);
            addObject(new BackFire(), 770, 50);
            addObject(new BasicDefender(), 210, 100);
            addObject(new BasicDefender(), 280, 100);
            addObject(new BasicDefender(), 350, 100);
            addObject(new BasicDefender(), 420, 100);
            addObject(new BasicDefender(), 490, 100);
            addObject(new BasicDefender(), 560, 100);
            addObject(new BasicDefender(), 630, 100);
            addObject(new BasicDefender(), 700, 100);
            addObject(new BasicDefender(), 770, 100);
            addObject(new BasicDefender(), 140, 100);
        }
        
        /**
         * level4Spawn sets populated to true and sets the background to the planet.png picture. Then it adds the ship to the screen and adds two
         * rows of BasicDefenders with DualShots behind them.
         * 
         * @param None there are no parameters
         * @return there is no return
         */
        private void level4Spawn()
        {
            populated = true;
            
            setBackground("Planet.png");
            
            addObject(s1Ship, getWidth()/2, 715);
            
            addObject(new BasicDefender(), 210, 170);
            addObject(new BasicDefender(), 280, 170);
            addObject(new BasicDefender(), 350, 170);
            addObject(new BasicDefender(), 420, 170);
            addObject(new BasicDefender(), 490, 170);
            addObject(new BasicDefender(), 560, 170);
            addObject(new BasicDefender(), 630, 170);
            addObject(new BasicDefender(), 700, 170);
            addObject(new BasicDefender(), 770, 170);
            addObject(new BasicDefender(), 140, 170);
            
            addObject(new BasicDefender(), 210, 110);
            addObject(new BasicDefender(), 280, 110);
            addObject(new BasicDefender(), 350, 110);
            addObject(new BasicDefender(), 420, 110);
            addObject(new BasicDefender(), 490, 110);
            addObject(new BasicDefender(), 560, 110);
            addObject(new BasicDefender(), 630, 110);
            addObject(new BasicDefender(), 700, 110);
            addObject(new BasicDefender(), 770, 110);
            addObject(new BasicDefender(), 140, 110);
            
            addObject(new DualShot(), 210, 50);
            addObject(new DualShot(), 280, 50);
            addObject(new DualShot(), 350, 50);
            addObject(new DualShot(), 420, 50);
            addObject(new DualShot(), 490, 50);
            addObject(new DualShot(), 560, 50);
            addObject(new DualShot(), 630, 50);
            addObject(new DualShot(), 700, 50);
            addObject(new DualShot(), 770, 50);
            addObject(new DualShot(), 140, 50);
        }
        
        /**
         * level5Spawn sets populated to true and sets the background to the planet.png picture. Then it adds the ship to the screen and adds a row
         * of DualShots whith a Slammer in the middle of the screen.
         * 
         * @param None there is no parameters
         * @return there is no return
         */
        private void level5Spawn()
        {
            populated = true;
            
            setBackground("Planet.png");
            
            addObject(s1Ship, getWidth()/2, 715);
            
            addObject(new DualShot(), 210, 50);
            addObject(new DualShot(), 280, 50);
            addObject(new DualShot(), 350, 50);
            addObject(new DualShot(), 420, 50);
            addObject(new DualShot(), 490, 50);
            addObject(new DualShot(), 560, 50);
            addObject(new DualShot(), 630, 50);
            addObject(new DualShot(), 700, 50);
            addObject(new DualShot(), 770, 50);
            addObject(new DualShot(), 140, 50);
            addObject(new Slammer(), 445, 230);
        }
        
        /**
         * level6Spawn sets populated to true, sets the background to the Planet.png and adds the ship to the middle of the screen. Then it adds a row
         * of Exos and below that it adds a row of DualShots. Lastly it adds a row of BasicDefenders.
         * 
         * @param None there are no parameters
         * @return There is no return
         */
        private void level6Spawn()
        {
            populated = true;
            
            setBackground("Planet.png");
            
            addObject(s1Ship, getWidth()/2, 715);
            
            addObject(new Exo(), 140, 50);
            addObject(new Exo(), 210, 50);
            addObject(new Exo(), 280, 50);
            addObject(new Exo(), 350, 50);
            addObject(new Exo(), 420, 50);
            addObject(new Exo(), 490, 50);
            addObject(new Exo(), 560, 50);
            addObject(new Exo(), 630, 50);
            addObject(new Exo(), 700, 50);
            addObject(new Exo(), 770, 50);
            
            addObject(new DualShot(), 210, 110);
            addObject(new DualShot(), 280, 110);
            addObject(new DualShot(), 350, 110);
            addObject(new DualShot(), 420, 110);
            addObject(new DualShot(), 490, 110);
            addObject(new DualShot(), 560, 110);
            addObject(new DualShot(), 630, 110);
            addObject(new DualShot(), 700, 110);
            addObject(new DualShot(), 770, 110);
            addObject(new DualShot(), 140, 110);
            
            addObject(new BasicDefender(), 210, 170);
            addObject(new BasicDefender(), 280, 170);
            addObject(new BasicDefender(), 350, 170);
            addObject(new BasicDefender(), 420, 170);
            addObject(new BasicDefender(), 490, 170);
            addObject(new BasicDefender(), 560, 170);
            addObject(new BasicDefender(), 630, 170);
            addObject(new BasicDefender(), 700, 170);
            addObject(new BasicDefender(), 770, 170);
            addObject(new BasicDefender(), 140, 170);
        }
        
        /**
         * level7Spawn sets populated to true and sets the background to the planet.png. Then it adds the ship to the world and adds a row of Exos to
         * the top of the world. Below that it adds two rows of DualShots and below those two a row of BasicDefenders.
         * 
         * @param None there are no parameters
         * @return there is no return
         */
        private void level7Spawn()
        {
            populated = true;
            
            setBackground("Planet.png");
            
            addObject(s1Ship, getWidth()/2, 715);
            
            addObject(new BasicDefender(), 210, 230);
            addObject(new BasicDefender(), 280, 230);
            addObject(new BasicDefender(), 350, 230);
            addObject(new BasicDefender(), 420, 230);
            addObject(new BasicDefender(), 490, 230);
            addObject(new BasicDefender(), 560, 230);
            addObject(new BasicDefender(), 630, 230);
            addObject(new BasicDefender(), 700, 230);
            addObject(new BasicDefender(), 770, 230);
            addObject(new BasicDefender(), 140, 230);
            
            addObject(new DualShot(), 210, 170);
            addObject(new DualShot(), 280, 170);
            addObject(new DualShot(), 350, 170);
            addObject(new DualShot(), 420, 170);
            addObject(new DualShot(), 490, 170);
            addObject(new DualShot(), 560, 170);
            addObject(new DualShot(), 630, 170);
            addObject(new DualShot(), 700, 170);
            addObject(new DualShot(), 770, 170);
            addObject(new DualShot(), 140, 170);
            
            addObject(new DualShot(), 210, 110);
            addObject(new DualShot(), 280, 110);
            addObject(new DualShot(), 350, 110);
            addObject(new DualShot(), 420, 110);
            addObject(new DualShot(), 490, 110);
            addObject(new DualShot(), 560, 110);
            addObject(new DualShot(), 630, 110);
            addObject(new DualShot(), 700, 110);
            addObject(new DualShot(), 770, 110);
            addObject(new DualShot(), 140, 110);
            
            addObject(new Exo(), 140, 50);
            addObject(new Exo(), 210, 50);
            addObject(new Exo(), 280, 50);
            addObject(new Exo(), 350, 50);
            addObject(new Exo(), 420, 50);
            addObject(new Exo(), 490, 50);
            addObject(new Exo(), 560, 50);
            addObject(new Exo(), 630, 50);
            addObject(new Exo(), 700, 50);
            addObject(new Exo(), 770, 50);
        }
        
        /**
         * level8Spawn sets populated to true and sets the background to the planet.png. Then it adds the ship to the world and adds a row of Exos to
         * the top of the world. Below that it adds two rows of DualShots and below those two a row of AdvancedDefenders.
         * 
         * @param None there are no parameters
         * @return there is no return
         */
        private void level8Spawn()
        {
            populated = true;
            
            setBackground("Planet.png");
            
            addObject(s1Ship, getWidth()/2, 715);
            
            addObject(new AdvancedDefender(), 210, 230);
            addObject(new AdvancedDefender(), 280, 230);
            addObject(new AdvancedDefender(), 350, 230);
            addObject(new AdvancedDefender(), 420, 230);
            addObject(new AdvancedDefender(), 490, 230);
            addObject(new AdvancedDefender(), 560, 230);
            addObject(new AdvancedDefender(), 630, 230);
            addObject(new AdvancedDefender(), 700, 230);
            addObject(new AdvancedDefender(), 770, 230);
            addObject(new AdvancedDefender(), 140, 230);
            
            addObject(new DualShot(), 210, 170);
            addObject(new DualShot(), 280, 170);
            addObject(new DualShot(), 350, 170);
            addObject(new DualShot(), 420, 170);
            addObject(new DualShot(), 490, 170);
            addObject(new DualShot(), 560, 170);
            addObject(new DualShot(), 630, 170);
            addObject(new DualShot(), 700, 170);
            addObject(new DualShot(), 770, 170);
            addObject(new DualShot(), 140, 170);
            
            addObject(new DualShot(), 210, 110);
            addObject(new DualShot(), 280, 110);
            addObject(new DualShot(), 350, 110);
            addObject(new DualShot(), 420, 110);
            addObject(new DualShot(), 490, 110);
            addObject(new DualShot(), 560, 110);
            addObject(new DualShot(), 630, 110);
            addObject(new DualShot(), 700, 110);
            addObject(new DualShot(), 770, 110);
            addObject(new DualShot(), 140, 110);
            
            addObject(new Exo(), 140, 50);
            addObject(new Exo(), 210, 50);
            addObject(new Exo(), 280, 50);
            addObject(new Exo(), 350, 50);
            addObject(new Exo(), 420, 50);
            addObject(new Exo(), 490, 50);
            addObject(new Exo(), 560, 50);
            addObject(new Exo(), 630, 50);
            addObject(new Exo(), 700, 50);
            addObject(new Exo(), 770, 50);
        }
        
        /**
         * getLev2Complete returns the boolean lev2Complete
         * 
         * @param None there are no parameters
         * @return the lev2Complete boolean variable
         */
        public boolean getLev2Complete()
        {
            return lev2Complete;
        }
        
        /**
         * getLev1Complete return the boolean lev1Complete
         * 
         * @param None there are no parameters
         * @return the lev1Complete boolean variable
         */
        public boolean getLev1Complete()
        {
            return lev1Complete;
        }
        
        /**
         * getlev3Complete returns the boolean lev3Complete
         * 
         * @param None there are no parameters
         * @return the lev3Complete boolean variable
         */
        public boolean getLev3Complete()
        {
            return lev3Complete;
        }
        
        /**
         * getLev4Complete returns the boolean lev4Complete
         * 
         * @param None there are no parameters
         * @return the lev4Complete booelan variable
         */
        public boolean getLev4Complete()
        {
            return lev4Complete;
        }
        
        /**
         * getLev5Complete returns the boolean lev5Complete
         * 
         * @param None there are no parameters
         * @return the lev5Complete boolean variable
         */
        public boolean getLev5Complete()
        {
            return lev5Complete;
        }
        
        /**
         * getLev6Complete returns the boolean lev6Complete
         * 
         * @param None there are no parameters
         * @return the lev6Complete boolean variable
         */
        public boolean getLev6Complete()
        {
            return lev6Complete;
        }
        
        /**
         * getLev7Complete returns the boolean lev7Complete
         * 
         * @param None there are no parameters
         * @return the lev7Complete boolean variable
         */
        public boolean getLev7Complete()
        {
            return lev7Complete;
        }
        
        /**
         * getLev8Complete returns the boolean lev8Complete
         * 
         * @param None there are no parameters
         * @return the lev8Complete boolean variable
         */
        public boolean getLev8Complete()
        {
            return lev8Complete;
        }
        
        /**
         * getShip returns a s1Ship variable
         * 
         * @param None there are no parameters
         * @return the s1Ship variable
         */
        public S1 getShip()
        {
            return s1Ship;
        }
    }

