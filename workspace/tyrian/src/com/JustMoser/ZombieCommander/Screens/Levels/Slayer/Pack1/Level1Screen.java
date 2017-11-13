package com.JustMoser.ZombieCommander.Screens.Levels.Slayer.Pack1;

import com.JustMoser.ZombieCommander.Tyrian;
import com.JustMoser.ZombieCommander.Helper.LevelManager;
import com.JustMoser.ZombieCommander.ImageActors.Human;
import com.JustMoser.ZombieCommander.ImageActors.ZombieSpawn;
import com.JustMoser.ZombieCommander.ImageActors.Blockers.BrickWall;
import com.JustMoser.ZombieCommander.ImageActors.Blockers.Sandbag;
import com.JustMoser.ZombieCommander.Tutorial.SlayerTutorial;
import com.badlogic.gdx.math.Vector2;

public class Level1Screen extends World1Level
{
	private static ZombieSpawn zombieSpawn;
	private static Human localHuman;
	private static Sandbag localSandbag;
	private static BrickWall brickwall;
	
    public Level1Screen(Tyrian game)
    {
        super( game, LevelManager.getLevelId(1));
    }
    
    @Override
    public void onShow()
    {
        addSpawns();
        addBlockers();
        addHumans();
        if (!LevelManager.getTutorial(LevelManager.getSlayer())){
        	stage.addActor(new SlayerTutorial());
        }
    }
    
    private void addHumans()
    {
    		localHuman = Human.create(stage.getWidth()/2, stage.getHeight()*0.2f);
        	stage.addActor(localHuman);
    }
    
    public void addSpawns()
    {
    	zombieSpawn = ZombieSpawn.create(new Vector2(stage.getWidth()/2,stage.getHeight()*0.8f));
        stage.addActor(zombieSpawn);
        //stage.addActor(ZombieSpawn.create(new Vector2(stage.getWidth()*0.2f,stage.getHeight()*0.95f)));
    }
   
    private void addBlockers()
    {
    		localSandbag = Sandbag.create(stage.getWidth()/2, stage.getHeight()*0.3f );
        	stage.addActor(localSandbag);
        	brickwall = BrickWall.create(stage.getWidth()*0.2f, stage.getHeight()*0.35f);
        	brickwall.setRotation(45);
        	stage.addActor(brickwall);
    }
    
    public static Human getHuman()
    {
    	return localHuman;
    }
    
    public static ZombieSpawn getZombieSpawn()
    {
    	return zombieSpawn;
    }
    
    public static Sandbag getSandbag()
    {
    	return localSandbag;
    }
    
    public static BrickWall getBrickWall()
    {
    	return brickwall;
    }
}