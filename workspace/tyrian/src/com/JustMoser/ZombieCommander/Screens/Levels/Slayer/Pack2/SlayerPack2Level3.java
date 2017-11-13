package com.JustMoser.ZombieCommander.Screens.Levels.Slayer.Pack2;

import com.JustMoser.ZombieCommander.Tyrian;
import com.JustMoser.ZombieCommander.Helper.LevelManager;
import com.JustMoser.ZombieCommander.ImageActors.Human;
import com.JustMoser.ZombieCommander.ImageActors.MachineGunHuman;
import com.JustMoser.ZombieCommander.ImageActors.SniperHuman;
import com.JustMoser.ZombieCommander.ImageActors.ZombieSpawn;
import com.JustMoser.ZombieCommander.ImageActors.Blockers.BrickWall;
import com.JustMoser.ZombieCommander.ImageActors.Blockers.Sandbag;
import com.badlogic.gdx.math.Vector2;

public class SlayerPack2Level3 extends SlayerPack2Level
{
	private ZombieSpawn zombieSpawn;
	
    public SlayerPack2Level3(Tyrian game)
    {
        super( game, LevelManager.getLevelId(3));
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
    	stage.addActor(SniperHuman.create(stage.getWidth()*0.9f, stage.getHeight()*0.9f));
    	stage.addActor(MachineGunHuman.create(stage.getWidth()*0.85f, stage.getHeight()*0.83f));
    	stage.addActor(Human.create(stage.getWidth()*0.85f, stage.getHeight()*0.76f));
    	stage.addActor(Human.create(stage.getWidth()*0.2f, stage.getHeight()*0.85f));
    }
    
    public void addSpawns()
    {
    	zombieSpawn = ZombieSpawn.create(new Vector2(stage.getWidth()*0.8f,stage.getHeight()*0.3f));
        stage.addActor(zombieSpawn);
        stage.addActor(ZombieSpawn.create(new Vector2(stage.getWidth()*0.6f,stage.getHeight()*0.12f)));
        //stage.addActor(ZombieSpawn.create(new Vector2(stage.getWidth()*0.2f,stage.getHeight()*0.95f)));
    }
   
    private void addBlockers()
    {
        BrickWall brickWall = BrickWall.create(0,0);
        brickWall.setPosition(stage.getWidth()-brickWall.getWidth() , stage.getHeight()*0.7f);
    	stage.addActor(brickWall);
    	BrickWall brickWall2 = BrickWall.create(0, 0);
    	for (int i = 1; i < 5; i++){
    		if (i == 4){
    			brickWall2 = BrickWall.create(stage.getWidth()-brickWall.getWidth()*i + 35, stage.getHeight()*0.74f);
    			brickWall2.setRotation(90);
    		}
    		else{
    			brickWall2 = BrickWall.create(stage.getWidth()-brickWall.getWidth()*i , stage.getHeight()*0.7f);
    		}
    		stage.addActor(brickWall2);
    	}
    	stage.addActor(Sandbag.create(brickWall2.getX()+40, stage.getHeight()*0.9f ));
        stage.addActor(Sandbag.create(brickWall2.getX()+40, stage.getHeight()*0.83f ));
        stage.addActor(Sandbag.create(stage.getWidth()*0.2f, stage.getHeight()*0.7f));
    }
}