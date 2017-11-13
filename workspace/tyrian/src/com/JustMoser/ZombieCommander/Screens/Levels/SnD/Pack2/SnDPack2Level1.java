package com.JustMoser.ZombieCommander.Screens.Levels.SnD.Pack2;

import com.JustMoser.ZombieCommander.Tyrian;
import com.JustMoser.ZombieCommander.Helper.LevelManager;
import com.JustMoser.ZombieCommander.ImageActors.Human;
import com.JustMoser.ZombieCommander.ImageActors.SniperHuman;
import com.JustMoser.ZombieCommander.ImageActors.ZombieSpawn;
import com.JustMoser.ZombieCommander.ImageActors.Blockers.BrickWall;
import com.JustMoser.ZombieCommander.ImageActors.Blockers.Chest;
import com.badlogic.gdx.math.Vector2;

public class SnDPack2Level1 extends SnDPack2Level
{
	private ZombieSpawn zombieSpawn;
	private Chest chest;
	
    public SnDPack2Level1(Tyrian game)
    {
        super( game, LevelManager.getLevelId(1));
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
    	stage.addActor(SniperHuman.create(stage.getWidth()*0.01f, stage.getHeight()*0.89f));
    	stage.addActor(Human.create(stage.getWidth()*0.03f, stage.getHeight()*0.8f));
    }
    
    public void addSpawns()
    {
    	zombieSpawn = ZombieSpawn.create(new Vector2(stage.getWidth()*0.8f, stage.getHeight()*0.15f));
        stage.addActor(zombieSpawn);
        //stage.addActor(ZombieSpawn.create(new Vector2(stage.getWidth()*0.2f,stage.getHeight()*0.95f)));
    }
   
    private void addBlockers()
    {
    	chest = Chest.create(stage.getWidth()*0.1f, stage.getHeight()*0.86f );
        stage.addActor(chest);
        BrickWall brickWall = BrickWall.create(0, 0);
        brickWall.setPosition(0, stage.getHeight()*0.7f);
        stage.addActor(brickWall);
        BrickWall brickWall2 = BrickWall.create(0, 0);
        brickWall2.setPosition(brickWall.getWidth(), stage.getHeight()*0.7f);
        stage.addActor(brickWall2);
    }
}