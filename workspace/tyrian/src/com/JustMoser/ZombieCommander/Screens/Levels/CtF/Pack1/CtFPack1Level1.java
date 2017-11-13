package com.JustMoser.ZombieCommander.Screens.Levels.CtF.Pack1;

import com.JustMoser.ZombieCommander.Tyrian;
import com.JustMoser.ZombieCommander.Helper.LevelManager;
import com.JustMoser.ZombieCommander.ImageActors.Flag;
import com.JustMoser.ZombieCommander.ImageActors.FlagStand;
import com.JustMoser.ZombieCommander.ImageActors.HumanTeleporter;
import com.JustMoser.ZombieCommander.ImageActors.ZombieSpawn;
import com.JustMoser.ZombieCommander.Tutorial.CtFTutorial;
import com.badlogic.gdx.math.Vector2;

public class CtFPack1Level1 extends CtFLevel
{
	private ZombieSpawn zombieSpawn;
	private static FlagStand humanFlagStand;
	private static FlagStand zombieFlagStand;
	//private Human localHuman;
	
    public CtFPack1Level1(Tyrian game)
    {
        super( game, LevelManager.getLevelId(1));
    }
    
    @Override
    public void onShow()
    {
        addSpawns();
        addBlockers();
        addHumans();
        addFlags();
        if (!LevelManager.getTutorial(LevelManager.getCaptureTheFlag())){
        	stage.addActor(new CtFTutorial());
        }
    }
    
    private void addHumans()
    {
    	stage.addActor(HumanTeleporter.create(stage.getWidth()*0.35f, stage.getHeight()*0.8f));
    }
    
    public void addSpawns()
    {
    	zombieSpawn = ZombieSpawn.create(new Vector2(stage.getWidth()*0.81f,stage.getHeight()*0.1f));
        stage.addActor(zombieSpawn);
        //stage.addActor(ZombieSpawn.create(new Vector2(stage.getWidth()*0.2f,stage.getHeight()*0.95f)));
    }
   
    private void addBlockers()
    {
    	//
    }
    
    private void addFlags()
    {
    	humanFlagStand = FlagStand.createHumanStand(stage.getWidth()*0.2f, stage.getHeight()*0.8f);
    	stage.addActor(humanFlagStand);
    	Flag flag = Flag.create(humanFlagStand.getX() + humanFlagStand.getWidth()/2, humanFlagStand.getY() + humanFlagStand.getHeight()/2);
    	stage.addActor(flag);
    	zombieFlagStand = FlagStand.createZombieStand(stage.getWidth()*0.77f, stage.getHeight()*0.2f);
    	stage.addActor(zombieFlagStand);
    }
    
    public static FlagStand getHumanFlagStand()
    {
    	return humanFlagStand;
    }
    
    public static FlagStand getZombieFlagStand()
    {
    	return zombieFlagStand;
    }
}