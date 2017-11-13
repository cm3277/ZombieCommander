package com.JustMoser.ZombieCommander.Screens.Levels.SnD.Pack1;

import com.JustMoser.ZombieCommander.Tyrian;
import com.JustMoser.ZombieCommander.Helper.LevelManager;
import com.JustMoser.ZombieCommander.ImageActors.Human;
import com.JustMoser.ZombieCommander.ImageActors.MachineGunHuman;
import com.JustMoser.ZombieCommander.ImageActors.SniperHuman;
import com.JustMoser.ZombieCommander.ImageActors.ZombieSpawn;
import com.JustMoser.ZombieCommander.ImageActors.Blockers.BrickWall;
import com.JustMoser.ZombieCommander.ImageActors.Blockers.Chest;
import com.badlogic.gdx.math.Vector2;

public class SnDPack1Level4 extends SnDLevel
{
	private ZombieSpawn zombieSpawn;
	private Chest chest;
	
    public SnDPack1Level4(Tyrian game)
    {
        super( game, LevelManager.getLevelId(4));
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
        stage.addActor(MachineGunHuman.create(stage.getWidth()*0.45f, stage.getHeight()*0.75f));
        stage.addActor(SniperHuman.create(stage.getWidth()*0.1f, stage.getHeight()*0.85f));
        stage.addActor(SniperHuman.create(stage.getWidth()*0.85f, stage.getHeight()*0.85f));
        stage.addActor(Human.create(stage.getWidth()*0.2f, stage.getHeight()*0.1f));
    }
    
    public void addSpawns()
    {
    	zombieSpawn = ZombieSpawn.create(new Vector2(stage.getWidth()*0.8f, stage.getHeight()*0.05f));
        stage.addActor(zombieSpawn);
        //stage.addActor(ZombieSpawn.create(new Vector2(stage.getWidth()*0.2f,stage.getHeight()*0.95f)));
    }
   
    private void addBlockers()
    {
    	chest = Chest.create(0,0 );
    	chest.setPosition(stage.getWidth()/2 - chest.getWidth()/2, stage.getHeight()/2 - chest.getHeight()/2);
        stage.addActor(chest);
        BrickWall brickWall = BrickWall.create(stage.getWidth()*0.5f, stage.getHeight()*0.4f );
        brickWall.setRotation(45);
        stage.addActor(brickWall);
        stage.addActor(BrickWall.create(stage.getWidth()*0.75f, stage.getHeight()*0.4f ));
    }
}