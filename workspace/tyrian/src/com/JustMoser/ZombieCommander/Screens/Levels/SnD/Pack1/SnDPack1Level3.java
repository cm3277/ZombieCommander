package com.JustMoser.ZombieCommander.Screens.Levels.SnD.Pack1;

import com.JustMoser.ZombieCommander.Tyrian;
import com.JustMoser.ZombieCommander.Helper.LevelManager;
import com.JustMoser.ZombieCommander.ImageActors.Human;
import com.JustMoser.ZombieCommander.ImageActors.SniperHuman;
import com.JustMoser.ZombieCommander.ImageActors.ZombieSpawn;
import com.JustMoser.ZombieCommander.ImageActors.Blockers.BrickWall;
import com.JustMoser.ZombieCommander.ImageActors.Blockers.Chest;
import com.badlogic.gdx.math.Vector2;

public class SnDPack1Level3 extends SnDLevel
{
	private ZombieSpawn zombieSpawn;
	private Human localHuman;
	private Chest chest;
	
    public SnDPack1Level3(Tyrian game)
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
    	localHuman = Human.create(stage.getWidth()*0.1f, stage.getHeight()*0.8f);
        stage.addActor(localHuman);
        stage.addActor(Human.create(stage.getWidth()*0.45f, stage.getHeight()*0.8f));
        stage.addActor(SniperHuman.create(stage.getWidth()*0.3f, stage.getHeight()*0.85f));
    }
    
    public void addSpawns()
    {
    	zombieSpawn = ZombieSpawn.create(new Vector2(stage.getWidth()*0.75f, stage.getHeight()*0.1f));
        stage.addActor(zombieSpawn);
        //stage.addActor(ZombieSpawn.create(new Vector2(stage.getWidth()*0.2f,stage.getHeight()*0.95f)));
    }
   
    private void addBlockers()
    {
    	chest = Chest.create(stage.getWidth()*0.4f, stage.getHeight()*0.7f );
        stage.addActor(chest);
        BrickWall brickWall = BrickWall.create(stage.getWidth()*0.5f, stage.getHeight()*0.4f );
        brickWall.setRotation(45);
        stage.addActor(brickWall);
    }
}