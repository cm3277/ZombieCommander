package com.JustMoser.ZombieCommander.Screens.Levels.Slayer.Pack1;

import com.JustMoser.ZombieCommander.Tyrian;
import com.JustMoser.ZombieCommander.Helper.LevelManager;
import com.JustMoser.ZombieCommander.ImageActors.Human;
import com.JustMoser.ZombieCommander.ImageActors.ZombieSpawn;
import com.JustMoser.ZombieCommander.ImageActors.Blockers.Sandbag;
import com.badlogic.gdx.math.Vector2;

public class Level2Screen extends World1Level
{
	private ZombieSpawn zombieSpawn;
	Human localHuman;
	Sandbag localSandbag;
	
    public Level2Screen(Tyrian game)
    {
        super( game, LevelManager.getLevelId(2));
    }
    
    @Override
    public void onShow()
    {
        addSpawns();
        addBlockers();
        addHumans();
    }
    
    private void addHumans()
    {
    	for (int i = 0; i < 2; i++){
    		localHuman = Human.create(stage.getWidth()*0.2f + 50*i, stage.getHeight()*0.2f + 50*i);
        	stage.addActor(localHuman);
        }
    }
    
    public void addSpawns()
    {
    	zombieSpawn = ZombieSpawn.create(new Vector2(stage.getWidth()*0.8f,stage.getHeight()*0.8f));
        stage.addActor(zombieSpawn);
        //stage.addActor(ZombieSpawn.create(new Vector2(stage.getWidth()*0.2f,stage.getHeight()*0.95f)));
    }
   
    private void addBlockers()
    {
    	for (int i = 0; i < 2; i++){
    		localSandbag = Sandbag.create(stage.getWidth()*0.3f + 50*i, stage.getHeight()*0.3f + 50*i);
        	stage.addActor(localSandbag);
        }
    }
}