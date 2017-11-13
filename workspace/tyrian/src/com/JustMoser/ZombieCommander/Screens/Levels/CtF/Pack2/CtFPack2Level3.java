package com.JustMoser.ZombieCommander.Screens.Levels.CtF.Pack2;

import com.JustMoser.ZombieCommander.Tyrian;
import com.JustMoser.ZombieCommander.Helper.LevelManager;
import com.JustMoser.ZombieCommander.ImageActors.Flag;
import com.JustMoser.ZombieCommander.ImageActors.FlagStand;
import com.JustMoser.ZombieCommander.ImageActors.HumanTeleporter;
import com.JustMoser.ZombieCommander.ImageActors.MachineGunHuman;
import com.JustMoser.ZombieCommander.ImageActors.SniperHuman;
import com.JustMoser.ZombieCommander.ImageActors.ZombieSpawn;
import com.JustMoser.ZombieCommander.ImageActors.Blockers.BrickWall;
import com.JustMoser.ZombieCommander.ImageActors.Blockers.Sandbag;
import com.badlogic.gdx.math.Vector2;

public class CtFPack2Level3 extends CtFPack2Level
{
	private ZombieSpawn zombieSpawn;
	
    public CtFPack2Level3(Tyrian game)
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
    	stage.addActor(SniperHuman.create(stage.getWidth()*0.49f, stage.getHeight()*0.89f));
    	stage.addActor(MachineGunHuman.create(stage.getWidth()*0.4f, stage.getHeight()*0.8f));
    	stage.addActor(HumanTeleporter.createMachineGunner(stage.getWidth()*0.56f, stage.getHeight()*0.8f));
    	stage.addActor(HumanTeleporter.create(stage.getWidth()*0.49f, stage.getHeight()*0.4f));
    }
    
    public void addSpawns()
    {
    	zombieSpawn = ZombieSpawn.create(new Vector2(stage.getWidth()*0.8f,stage.getHeight()*0.85f));
        stage.addActor(zombieSpawn);
        stage.addActor(ZombieSpawn.create(new Vector2(stage.getWidth()*0.03f,stage.getHeight()*0.85f)));
    }
   
    private void addBlockers()
    {
        BrickWall brickWall = BrickWall.create(0,0);
        brickWall.setPosition(stage.getWidth()*0.23f , stage.getHeight()-brickWall.getWidth());
    	brickWall.setRotation(90);
    	stage.addActor(brickWall);
    	BrickWall brickWall2 = BrickWall.create(0, 0);
    	for (int i = 1; i < 6; i++){
    		brickWall2 = BrickWall.create(stage.getWidth()*0.23f , brickWall.getY() - brickWall.getWidth()*i);
    		brickWall2.setRotation(90);
    		stage.addActor(brickWall2);
    	}
    	for (int i = 0; i < 6; i++){
    		brickWall2 = BrickWall.create(stage.getWidth()*0.6f , brickWall.getY() - brickWall.getWidth()*i);
    		brickWall2.setRotation(90);
    		stage.addActor(brickWall2);
    	}
    	stage.addActor(Sandbag.create(brickWall2.getX() - 25, brickWall2.getY() ));
        stage.addActor(Sandbag.create(brickWall2.getX()- 85, brickWall2.getY() ));
    }
    
    private void addFlags()
    {
    	FlagStand flagStand = FlagStand.createHumanStand(stage.getWidth()*0.45f, stage.getHeight()*0.65f);
    	stage.addActor(flagStand);
    	Flag flag = Flag.create(flagStand.getX() + flagStand.getWidth()/2, flagStand.getY() + flagStand.getHeight()/2);
    	stage.addActor(flag);
    	stage.addActor(FlagStand.createZombieStand(stage.getWidth()*0.45f, stage.getHeight()*0.15f));
    }
}