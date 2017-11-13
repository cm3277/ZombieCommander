package com.JustMoser.ZombieCommander.Screens.Levels.Slayer.Pack2;

import com.JustMoser.ZombieCommander.Tyrian;
import com.JustMoser.ZombieCommander.Helper.LevelManager;
import com.JustMoser.ZombieCommander.ImageActors.MachineGunHuman;
import com.JustMoser.ZombieCommander.ImageActors.SniperHuman;
import com.JustMoser.ZombieCommander.ImageActors.ZombieSpawn;
import com.JustMoser.ZombieCommander.ImageActors.Blockers.BrickWall;
import com.JustMoser.ZombieCommander.ImageActors.Blockers.Sandbag;
import com.badlogic.gdx.math.Vector2;

public class SlayerPack2Level2 extends SlayerPack2Level
{
	private ZombieSpawn zombieSpawn;
	
    public SlayerPack2Level2(Tyrian game)
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
    	stage.addActor(SniperHuman.create(stage.getWidth()*0.05f, stage.getHeight()*0.9f));
    	stage.addActor(MachineGunHuman.create(stage.getWidth()*0.2f, stage.getHeight()*0.9f));
    }
    
    public void addSpawns()
    {
    	zombieSpawn = ZombieSpawn.create(new Vector2(stage.getWidth()*0.85f,stage.getHeight()*0.83f));
        stage.addActor(zombieSpawn);
        //stage.addActor(ZombieSpawn.create(new Vector2(stage.getWidth()*0.2f,stage.getHeight()*0.95f)));
    }
   
    private void addBlockers()
    {
        stage.addActor(Sandbag.create(stage.getWidth()*0.07f, stage.getHeight()*0.45f ));
        stage.addActor(Sandbag.create(stage.getWidth()*0.23f, stage.getHeight()*0.45f ));
        BrickWall brickWall = BrickWall.create(0,0);
        brickWall.setPosition(stage.getWidth()*0.35f , stage.getHeight()-brickWall.getWidth());
    	brickWall.setRotation(90);
    	stage.addActor(brickWall);
    	for (int i = 1; i < 7; i++){
    		BrickWall brickWall2 = BrickWall.create(stage.getWidth()*0.35f , brickWall.getY() - brickWall.getWidth()*i);
    		brickWall2.setRotation(90);
    		stage.addActor(brickWall2);
    	}
    }
}