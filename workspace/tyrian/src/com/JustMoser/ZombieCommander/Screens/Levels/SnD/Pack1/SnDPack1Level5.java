package com.JustMoser.ZombieCommander.Screens.Levels.SnD.Pack1;

import com.JustMoser.ZombieCommander.Tyrian;
import com.JustMoser.ZombieCommander.Helper.LevelManager;
import com.JustMoser.ZombieCommander.ImageActors.MachineGunHuman;
import com.JustMoser.ZombieCommander.ImageActors.SniperHuman;
import com.JustMoser.ZombieCommander.ImageActors.ZombieSpawn;
import com.JustMoser.ZombieCommander.ImageActors.Blockers.BrickWall;
import com.JustMoser.ZombieCommander.ImageActors.Blockers.Chest;
import com.badlogic.gdx.math.Vector2;

public class SnDPack1Level5 extends SnDLevel
{
	private ZombieSpawn zombieSpawn;
	private Chest chest;
	
    public SnDPack1Level5(Tyrian game)
    {
        super( game, LevelManager.getLevelId(5));
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
        stage.addActor(MachineGunHuman.create(stage.getWidth()*0.9f, stage.getHeight()*0.9f));
        stage.addActor(MachineGunHuman.create(stage.getWidth()*0.85f, stage.getHeight()*0.85f));
        stage.addActor(SniperHuman.create(stage.getWidth()*0.02f, stage.getHeight()*0.05f));
        stage.addActor(SniperHuman.create(stage.getWidth()*0.05f, stage.getHeight()*0.01f));
    }
    
    public void addSpawns()
    {
    	zombieSpawn = ZombieSpawn.create(new Vector2(0, 0));
    	zombieSpawn.setPosition(stage.getWidth()/2 - zombieSpawn.getWidth()/2, stage.getHeight()/2 - zombieSpawn.getHeight()/2);
        stage.addActor(zombieSpawn);
        //stage.addActor(ZombieSpawn.create(new Vector2(stage.getWidth()*0.2f,stage.getHeight()*0.95f)));
    }
   
    private void addBlockers()
    {
    	chest = Chest.create(stage.getWidth()*0.8f, stage.getHeight()*0.75f);
        stage.addActor(chest);
        stage.addActor(Chest.create(stage.getWidth()*0.15f, stage.getHeight()*0.2f));
        
        BrickWall brickWall = BrickWall.create(stage.getWidth()*0.55f, stage.getHeight()*0.6f );
        brickWall.setRotation(-45);
        stage.addActor(brickWall);
        
        BrickWall brickWall2 = BrickWall.create(stage.getWidth()*0.3f, stage.getHeight()*0.35f );
        brickWall2.setRotation(-45);
        stage.addActor(brickWall2);
    }
}