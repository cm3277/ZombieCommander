package com.JustMoser.ZombieCommander.Screens.Levels.SnD.Pack2;

import com.JustMoser.ZombieCommander.Tyrian;
import com.JustMoser.ZombieCommander.Helper.LevelManager;
import com.JustMoser.ZombieCommander.ImageActors.MachineGunHuman;
import com.JustMoser.ZombieCommander.ImageActors.ZombieSpawn;
import com.JustMoser.ZombieCommander.ImageActors.Blockers.BrickWall;
import com.JustMoser.ZombieCommander.ImageActors.Blockers.Chest;
import com.badlogic.gdx.math.Vector2;

public class SnDPack2Level2 extends SnDPack2Level
{
	private ZombieSpawn zombieSpawn;
	private Chest chest;
	
    public SnDPack2Level2(Tyrian game)
    {
        super( game, LevelManager.getLevelId(2));
    }
    
    @Override
    public void onShow()
    {
        addSpawns();
        addBlockers();
        addHumans();
        super.addFog();
    }
    
    private void addHumans()
    {
    	stage.addActor(MachineGunHuman.create(stage.getWidth()*0.4f, stage.getHeight()*0.7f));
    	stage.addActor(MachineGunHuman.create(stage.getWidth()*0.6f, stage.getHeight()*0.7f));
    }
    
    public void addSpawns()
    {
    	zombieSpawn = ZombieSpawn.create(new Vector2(stage.getWidth()*0.45f, stage.getHeight()*0.15f));
        stage.addActor(zombieSpawn);
        //stage.addActor(ZombieSpawn.create(new Vector2(stage.getWidth()*0.2f,stage.getHeight()*0.95f)));
    }
   
    private void addBlockers()
    {
    	chest = Chest.create(stage.getWidth()*0.47f, stage.getHeight()*0.65f );
        stage.addActor(chest);
        BrickWall brickWall = BrickWall.create(0, 0);
        brickWall.setPosition(brickWall.getWidth() + 25, stage.getHeight()*0.6f);
        stage.addActor(brickWall);
        for (int i = 1; i < 4; i++){
        	BrickWall brickWall2 = BrickWall.create(0, 0);
        	brickWall2.setPosition(brickWall.getWidth()*i + 25, stage.getHeight()*0.6f);
        	stage.addActor(brickWall2);
        }
    }
}