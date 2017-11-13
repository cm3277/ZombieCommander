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

public class SlayerPack2Level5 extends SlayerPack2Level
{
	private ZombieSpawn zombieSpawn;
	
    public SlayerPack2Level5(Tyrian game)
    {
        super( game, LevelManager.getLevelId(5));
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
    	stage.addActor(SniperHuman.create(stage.getWidth()*0.49f, stage.getHeight()*0.89f));
    	stage.addActor(MachineGunHuman.create(stage.getWidth()*0.1f, stage.getHeight()*0.72f));
    	stage.addActor(MachineGunHuman.create(stage.getWidth()*0.85f, stage.getHeight()*0.72f));
    	stage.addActor(Human.create(stage.getWidth()*0.49f, stage.getHeight()*0.52f));
    }
    
    public void addSpawns()
    {
    	zombieSpawn = ZombieSpawn.create(new Vector2(stage.getWidth()*0.8f,stage.getHeight()*0.15f));
        stage.addActor(zombieSpawn);
        stage.addActor(ZombieSpawn.create(new Vector2(stage.getWidth()*0.03f,stage.getHeight()*0.15f)));
    }
   
    private void addBlockers()
    {
        BrickWall brickWall = BrickWall.create(0,0);
        brickWall.setPosition(1 , stage.getHeight()*0.5f);
    	stage.addActor(brickWall);
    	BrickWall brickWall2 = BrickWall.create(0, 0);
    	for (int i = 1; i < 2; i++){
    		brickWall2 = BrickWall.create(brickWall.getX() + brickWall.getWidth()*i ,stage.getHeight()*0.5f );
    		stage.addActor(brickWall2);
    	}
    	BrickWall brickWall3 = BrickWall.create(brickWall2.getX() + brickWall.getWidth() - brickWall.getHeight(), stage.getHeight()*0.5f);
    	brickWall3.setOrigin(0, 0);
    	brickWall3.setRotation(-90);
    	stage.addActor(brickWall3);
    	for (int i = 1; i < 3; i++){
    		brickWall2 = BrickWall.create(stage.getWidth()- brickWall.getWidth()*i , stage.getHeight()*0.5f);
    		stage.addActor(brickWall2);
    	}
    	BrickWall brickWall4 = BrickWall.create(brickWall2.getX(), stage.getHeight()*0.5f);
    	brickWall4.setOrigin(0, 0);
    	brickWall4.setRotation(-90);
    	stage.addActor(brickWall4);
    	stage.addActor(Sandbag.create(brickWall2.getX() - 45, stage.getHeight()*0.4f ));
        stage.addActor(Sandbag.create(brickWall2.getX()- 115, stage.getHeight()*0.4f ));
    }
}