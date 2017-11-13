package com.JustMoser.ZombieCommander.Screens.Levels.SnD.Pack2;

import com.JustMoser.ZombieCommander.Tyrian;
import com.JustMoser.ZombieCommander.Helper.LevelManager;
import com.JustMoser.ZombieCommander.ImageActors.Human;
import com.JustMoser.ZombieCommander.ImageActors.MachineGunHuman;
import com.JustMoser.ZombieCommander.ImageActors.SniperHuman;
import com.JustMoser.ZombieCommander.ImageActors.ZombieSpawn;
import com.JustMoser.ZombieCommander.ImageActors.Blockers.BrickWall;
import com.JustMoser.ZombieCommander.ImageActors.Blockers.Chest;
import com.JustMoser.ZombieCommander.ImageActors.Blockers.Sandbag;
import com.badlogic.gdx.math.Vector2;

public class SnDPack2Level3 extends SnDPack2Level
{
	private ZombieSpawn zombieSpawn;
	private Chest chest;
	
    public SnDPack2Level3(Tyrian game)
    {
        super( game, LevelManager.getLevelId(3));
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
    	stage.addActor(SniperHuman.create(stage.getWidth()*0.89f, stage.getHeight()*0.89f));
    	stage.addActor(MachineGunHuman.create(stage.getWidth()*0.75f, stage.getHeight()*0.8f));
    	stage.addActor(Human.create(stage.getWidth()*0.1f, stage.getHeight()*0.58f));
    }
    
    public void addSpawns()
    {
    	zombieSpawn = ZombieSpawn.create(new Vector2(stage.getWidth()*0.8f, stage.getHeight()*0.15f));
        stage.addActor(zombieSpawn);
        //stage.addActor(ZombieSpawn.create(new Vector2(stage.getWidth()*0.2f,stage.getHeight()*0.95f)));
    }
   
    private void addBlockers()
    {
    	chest = Chest.create(stage.getWidth()*0.84f, stage.getHeight()*0.84f );
        stage.addActor(chest);
        BrickWall brickWall = BrickWall.create(0, 0);
        brickWall.setPosition(brickWall.getWidth() + 25, stage.getHeight()*0.6f);
        stage.addActor(brickWall);
        for (int i = 1; i < 5; i++){
        	BrickWall brickWall2 = BrickWall.create(0, 0);
        	brickWall2.setPosition(brickWall.getWidth()*i + 25, stage.getHeight()*0.6f);
        	stage.addActor(brickWall2);
        }
        BrickWall brickWall3 = BrickWall.create(brickWall.getX(), brickWall.getY());
        brickWall3.setOrigin(0, 0);
        brickWall3.setRotation(-90);
        stage.addActor(brickWall3);
        stage.addActor(Sandbag.create(stage.getWidth()*0.02f, brickWall.getY() - brickWall.getWidth()));
        stage.addActor(Sandbag.create(stage.getWidth()*0.13f, brickWall.getY() - brickWall.getWidth()));
    }
}