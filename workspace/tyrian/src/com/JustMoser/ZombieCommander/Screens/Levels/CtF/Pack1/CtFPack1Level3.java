package com.JustMoser.ZombieCommander.Screens.Levels.CtF.Pack1;

import com.JustMoser.ZombieCommander.Tyrian;
import com.JustMoser.ZombieCommander.Helper.LevelManager;
import com.JustMoser.ZombieCommander.ImageActors.Flag;
import com.JustMoser.ZombieCommander.ImageActors.FlagStand;
import com.JustMoser.ZombieCommander.ImageActors.HumanTeleporter;
import com.JustMoser.ZombieCommander.ImageActors.ZombieSpawn;
import com.JustMoser.ZombieCommander.ImageActors.Blockers.BrickWall;
import com.badlogic.gdx.math.Vector2;

public class CtFPack1Level3 extends CtFLevel
{
	private ZombieSpawn zombieSpawn;
	//private Human localHuman;
	
    public CtFPack1Level3(Tyrian game)
    {
        super( game, LevelManager.getLevelId(3));
    }
    
    @Override
    public void onShow()
    {
        addSpawns();
        addBlockers();
        addHumans();
        addFlags();
    }
    
    private void addHumans()
    {
    	stage.addActor(HumanTeleporter.createSniper(stage.getWidth()*0.01f, stage.getHeight()*0.9f));
    	stage.addActor(HumanTeleporter.createMachineGunner(stage.getWidth()*0.05f, stage.getHeight()*0.8f));
    }
    
    public void addSpawns()
    {
    	zombieSpawn = ZombieSpawn.create(new Vector2(stage.getWidth()*0.1f,stage.getHeight()*0.13f));
        stage.addActor(zombieSpawn);
    }
   
    private void addBlockers()
    {
    	//stage.addActor(Sandbag.create(stage.getWidth()*0.6f, stage.getHeight()*0.75f ));
    	//stage.addActor(Sandbag.create(stage.getWidth()*0.8f, stage.getHeight()*0.65f ));
    	//brick wall
    	stage.addActor(BrickWall.create(stage.getWidth()*0.1f , stage.getHeight()*0.3f));
    	BrickWall brickWall2 = BrickWall.create(stage.getWidth()*0.3f , stage.getHeight()*0.25f);
    	brickWall2.setRotation(-45);
    	stage.addActor(brickWall2);
    }
    
    private void addFlags()
    {
    	//Human flagStand
    	FlagStand flagStand = FlagStand.createHumanStand(stage.getWidth()*0.17f, stage.getHeight()*0.8f);
    	stage.addActor(flagStand);
    	//flag
    	Flag flag = Flag.create(flagStand.getX() + flagStand.getWidth()/2, flagStand.getY() + flagStand.getHeight()/2);
    	stage.addActor(flag);
    	//Zombie Flagstand
    	stage.addActor(FlagStand.createZombieStand(stage.getWidth()*0.75f, stage.getHeight()*0.1f));
    }
}