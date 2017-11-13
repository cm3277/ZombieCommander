package com.JustMoser.ZombieCommander.Screens.Levels.Slayer.Pack2;

import com.JustMoser.ZombieCommander.Tyrian;
import com.JustMoser.ZombieCommander.Helper.LevelManager;
import com.JustMoser.ZombieCommander.ImageActors.Human;
import com.JustMoser.ZombieCommander.ImageActors.SniperHuman;
import com.JustMoser.ZombieCommander.ImageActors.ZombieSpawn;
import com.JustMoser.ZombieCommander.ImageActors.Blockers.BrickWall;
import com.JustMoser.ZombieCommander.ImageActors.Blockers.Sandbag;
import com.badlogic.gdx.math.Vector2;

public class SlayerPack2Level1 extends SlayerPack2Level
{
	private ZombieSpawn zombieSpawn;
	
    public SlayerPack2Level1(Tyrian game)
    {
        super( game, LevelManager.getLevelId(1));
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
    	stage.addActor(SniperHuman.create(stage.getWidth()*0.9f, stage.getHeight()*0.1f));
    	stage.addActor(Human.create(stage.getWidth()*0.8f, stage.getHeight()*0.15f));
    }
    
    public void addSpawns()
    {
    	zombieSpawn = ZombieSpawn.create(new Vector2(stage.getWidth()*0.01f,stage.getHeight()*0.85f));
        stage.addActor(zombieSpawn);
        //stage.addActor(ZombieSpawn.create(new Vector2(stage.getWidth()*0.2f,stage.getHeight()*0.95f)));
    }
   
    private void addBlockers()
    {
        stage.addActor(Sandbag.create(stage.getWidth()*0.7f, stage.getHeight()*0.2f ));
        BrickWall brickWall = BrickWall.create(stage.getWidth()*0.2f , stage.getHeight()*0.7f);
    	brickWall.setRotation(45);
    	stage.addActor(brickWall);
    }
}