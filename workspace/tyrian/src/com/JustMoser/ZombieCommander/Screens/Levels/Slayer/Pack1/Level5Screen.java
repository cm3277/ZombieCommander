package com.JustMoser.ZombieCommander.Screens.Levels.Slayer.Pack1;

import com.JustMoser.ZombieCommander.Tyrian;
import com.JustMoser.ZombieCommander.Helper.LevelManager;
import com.JustMoser.ZombieCommander.ImageActors.Human;
import com.JustMoser.ZombieCommander.ImageActors.MachineGunHuman;
import com.JustMoser.ZombieCommander.ImageActors.ZombieSpawn;
import com.JustMoser.ZombieCommander.ImageActors.Blockers.BrickWall;
import com.JustMoser.ZombieCommander.ImageActors.Blockers.Sandbag;
import com.badlogic.gdx.math.Vector2;

public class Level5Screen extends World1Level
{
    public Level5Screen(Tyrian game)
    {
        super( game, LevelManager.getLevelId(5));
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
    	Human localHuman2 = MachineGunHuman.create(stage.getWidth()*0.5f - 20, stage.getHeight()*0.5f + 50);
    	stage.addActor(localHuman2);
    	Human localHuman = MachineGunHuman.create(stage.getWidth()*0.45f - localHuman2.getWidth(), stage.getHeight()*0.5f);
    	stage.addActor(localHuman);
    	Human localHuman3 = MachineGunHuman.create(stage.getWidth()*0.55f - localHuman2.getWidth()/2, stage.getHeight()*0.5f);
    	stage.addActor(localHuman3);
    }
    
    public void addSpawns()
    {
    	ZombieSpawn zombieSpawn = ZombieSpawn.create(new Vector2(stage.getWidth()*0.8f,stage.getHeight()*0.85f));
        stage.addActor(zombieSpawn);
        stage.addActor(ZombieSpawn.create(new Vector2(stage.getWidth()*0.2f - zombieSpawn.getWidth(),stage.getHeight()*0.85f)));
        stage.addActor(ZombieSpawn.create(new Vector2(stage.getWidth()*0.2f - zombieSpawn.getWidth(),stage.getHeight()*0.1f - zombieSpawn.getHeight())));
        stage.addActor(ZombieSpawn.create(new Vector2(stage.getWidth()*0.8f,stage.getHeight()*0.1f - zombieSpawn.getHeight())));
    }
    
    private void addBlockers()
    {
    	Sandbag localSandbag = null;
    	for (int i = 0; i < 5; i++){
    		localSandbag = Sandbag.create((stage.getWidth()*0.45f + (45*i)) , stage.getHeight()*0.7f - (36*i));
    		stage.addActor(localSandbag);
    	}
    	Vector2 lastSandbag = new Vector2();
    	lastSandbag.set(localSandbag.getX(), localSandbag.getY());
    	for (int i = 1; i < 5; i++){
    		localSandbag = Sandbag.create((lastSandbag.x - (45*i)) , lastSandbag.y - (36*i));
    		stage.addActor(localSandbag);
    	}
    	lastSandbag.set(localSandbag.getX(), localSandbag.getY());
    	for (int i = 1; i < 5; i++){
    		localSandbag = Sandbag.create((lastSandbag.x - (45*i)) , lastSandbag.y + (36*i));
    		stage.addActor(localSandbag);
    	}
    	lastSandbag.set(localSandbag.getX(), localSandbag.getY());
    	for (int i = 1; i < 5; i++){
    		localSandbag = Sandbag.create((lastSandbag.x + (45*i)) , lastSandbag.y + (36*i));
    		stage.addActor(localSandbag);
    	}
    	
    	BrickWall brickWall = BrickWall.create(0, 0);
    	
    	brickWall.setPosition(stage.getWidth()*0.5f - brickWall.getWidth()/2, stage.getHeight()*0.75f);
    	stage.addActor(brickWall);
    	
    	stage.addActor(BrickWall.create(stage.getWidth()*0.5f - brickWall.getWidth()/2, stage.getHeight()*0.3f));
    }
}