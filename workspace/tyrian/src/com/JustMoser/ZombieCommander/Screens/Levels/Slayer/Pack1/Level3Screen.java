package com.JustMoser.ZombieCommander.Screens.Levels.Slayer.Pack1;

import com.JustMoser.ZombieCommander.Tyrian;
import com.JustMoser.ZombieCommander.Helper.LevelManager;
import com.JustMoser.ZombieCommander.ImageActors.Human;
import com.JustMoser.ZombieCommander.ImageActors.ZombieSpawn;
import com.JustMoser.ZombieCommander.ImageActors.Blockers.BrickWall;
import com.JustMoser.ZombieCommander.ImageActors.Blockers.Sandbag;
import com.badlogic.gdx.math.Vector2;

public class Level3Screen extends World1Level
{
    public Level3Screen(Tyrian game)
    {
        super( game, LevelManager.getLevelId(3));
    }
    
    @Override
    public void onShow()
    {
        addSpawns();
        addBlockers();
        addHumans();
    }
    
    private void addHumans()
    {
    	Human localHuman = Human.create(stage.getWidth()*0.8f, stage.getHeight()*0.2f);
    	stage.addActor(localHuman);
    	Human localHuman2 = Human.create(stage.getWidth()*0.8f + 50, stage.getHeight()*0.2f);
    	stage.addActor(localHuman2);
    	Human localHuman3 = Human.create(stage.getWidth()*0.8f + 25, stage.getHeight()*0.3f);
    	stage.addActor(localHuman3);
    }
    
    public void addSpawns()
    {
    	ZombieSpawn zombieSpawn = ZombieSpawn.create(new Vector2(stage.getWidth()*0.2f,stage.getHeight()*0.8f));
        stage.addActor(zombieSpawn);
        //stage.addActor(ZombieSpawn.create(new Vector2(stage.getWidth()*0.2f,stage.getHeight()*0.95f)));
    }
    
    private void addBlockers()
    {
    	Sandbag localSandbag = Sandbag.create(stage.getWidth()*0.7f , stage.getHeight()*0.3f + 50);
    	stage.addActor(localSandbag);
    	Sandbag localSandbag2 = Sandbag.create(stage.getWidth()*0.8f , stage.getHeight()*0.4f);
    	stage.addActor(localSandbag2);
    	BrickWall brickWall = BrickWall.create(stage.getWidth()*0.4f , stage.getHeight()*0.35f);
    	brickWall.setRotation(45);
    	stage.addActor(brickWall);
    }
}