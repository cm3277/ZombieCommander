package com.JustMoser.ZombieCommander.Screens.Levels.CtF.Pack1;

import com.JustMoser.ZombieCommander.Tyrian;
import com.JustMoser.ZombieCommander.Helper.LevelManager;
import com.JustMoser.ZombieCommander.ImageActors.Flag;
import com.JustMoser.ZombieCommander.ImageActors.FlagStand;
import com.JustMoser.ZombieCommander.ImageActors.HumanTeleporter;
import com.JustMoser.ZombieCommander.ImageActors.ZombieSpawn;
import com.JustMoser.ZombieCommander.ImageActors.Blockers.BrickWall;
import com.badlogic.gdx.math.Vector2;

public class CtFPack1Level4 extends CtFLevel
{
	private ZombieSpawn zombieSpawn;
	//private Human localHuman;
	
    public CtFPack1Level4(Tyrian game)
    {
        super( game, LevelManager.getLevelId(4));
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
    	stage.addActor(HumanTeleporter.createMachineGunner(stage.getWidth()*0.8f, stage.getHeight()*0.35f));
    	stage.addActor(HumanTeleporter.createMachineGunner(stage.getWidth()*0.6f, stage.getHeight()*0.15f));
    	stage.addActor(HumanTeleporter.create(stage.getWidth()*0.7f, stage.getHeight()*0.25f));
    }
    
    public void addSpawns()
    {
    	zombieSpawn = ZombieSpawn.create(new Vector2(0,0));
    	zombieSpawn.setPosition(stage.getWidth()*0.95f - zombieSpawn.getWidth(), stage.getHeight()*0.95f - zombieSpawn.getHeight());
        stage.addActor(zombieSpawn);
    }
   
    private void addBlockers()
    {
    	//stage.addActor(Sandbag.create(stage.getWidth()*0.6f, stage.getHeight()*0.75f ));
    	//stage.addActor(Sandbag.create(stage.getWidth()*0.8f, stage.getHeight()*0.65f ));
    	//brick wall
    	stage.addActor(BrickWall.create(stage.getWidth()*0.8f , stage.getHeight()*0.7f));
    	BrickWall brickWall2 = BrickWall.create(stage.getWidth()*0.5f , stage.getHeight()*0.75f);
    	brickWall2.setRotation(-45);
    	stage.addActor(brickWall2);
    }
    
    private void addFlags()
    {
    	//Human flagStand
    	FlagStand flagStand = FlagStand.createHumanStand(stage.getWidth()*0.85f, stage.getHeight()*0.1f);
    	stage.addActor(flagStand);
    	//flag
    	Flag flag = Flag.create(flagStand.getX() + flagStand.getWidth()/2, flagStand.getY() + flagStand.getHeight()/2);
    	stage.addActor(flag);
    	//Zombie Flagstand
    	stage.addActor(FlagStand.createZombieStand(stage.getWidth()*0.02f, stage.getHeight()*0.85f));
    }
}