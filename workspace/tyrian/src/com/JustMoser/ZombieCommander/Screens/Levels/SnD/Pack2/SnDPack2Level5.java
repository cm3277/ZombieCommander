package com.JustMoser.ZombieCommander.Screens.Levels.SnD.Pack2;

import com.JustMoser.ZombieCommander.Tyrian;
import com.JustMoser.ZombieCommander.Helper.LevelManager;
import com.JustMoser.ZombieCommander.ImageActors.MachineGunHuman;
import com.JustMoser.ZombieCommander.ImageActors.SniperHuman;
import com.JustMoser.ZombieCommander.ImageActors.ZombieSpawn;
import com.JustMoser.ZombieCommander.ImageActors.Blockers.BrickWall;
import com.JustMoser.ZombieCommander.ImageActors.Blockers.Chest;
import com.JustMoser.ZombieCommander.ImageActors.Blockers.Sandbag;
import com.badlogic.gdx.math.Vector2;

public class SnDPack2Level5 extends SnDPack2Level
{
	private ZombieSpawn zombieSpawn;
	private Chest chest;
	
    public SnDPack2Level5(Tyrian game)
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
    	//stage.addActor(SniperHuman.create(stage.getWidth()*0.02f, stage.getHeight()*0.89f));
    	stage.addActor(MachineGunHuman.create(stage.getWidth()*0.2f, stage.getHeight()*0.75f));
    	stage.addActor(SniperHuman.create(stage.getWidth()*0.37f, stage.getHeight()*0.75f));
    	//stage.addActor(Human.create(stage.getWidth()*0.05f, stage.getHeight()*0.32f));
    	stage.addActor(MachineGunHuman.create(stage.getWidth()*0.7f, stage.getHeight()*0.75f));
    	stage.addActor(SniperHuman.create(stage.getWidth()*0.55f, stage.getHeight()*0.75f));
    }
    
    public void addSpawns()
    {
    	zombieSpawn = ZombieSpawn.create(new Vector2(0,0));
    	zombieSpawn.setPosition(stage.getWidth()/2 - zombieSpawn.getWidth()/2, stage.getHeight()*0.15f);
        stage.addActor(zombieSpawn);
        //stage.addActor(ZombieSpawn.create(new Vector2(stage.getWidth()*0.2f,stage.getHeight()*0.95f)));
    }
   
    private void addBlockers()
    {
    	chest = Chest.create(stage.getWidth()*0.1f, stage.getHeight()*0.86f );
        stage.addActor(chest);
        stage.addActor(Chest.create(stage.getWidth()*0.8f, stage.getHeight()*0.86f ));
        BrickWall brickWall = BrickWall.create(0, 0);
        brickWall.setPosition(stage.getWidth()/2 - brickWall.getHeight(), stage.getHeight() - 30);
        brickWall.setOrigin(0, 0);
        brickWall.setRotation(-90);
        stage.addActor(brickWall);
        BrickWall brickWall2 = BrickWall.create(0, 0);
        for (int i = 1; i < 5; i++){
        	brickWall2 = BrickWall.create(brickWall.getX(), brickWall.getY() - brickWall.getWidth()*i);
        	//brickWall2.setPosition(brickWall.getX(), brickWall.getY() - brickWall.getWidth()*i);
        	brickWall2.setOrigin(0, 0);
            brickWall2.setRotation(-90);
        	stage.addActor(brickWall2);
        }
        BrickWall brickWall3 = BrickWall.create(brickWall2.getX() - brickWall.getWidth(), brickWall2.getY() - brickWall.getWidth());
        stage.addActor(brickWall3);
        stage.addActor(BrickWall.create(brickWall2.getX() + brickWall.getHeight(), brickWall2.getY() - brickWall.getWidth()));
        stage.addActor(Sandbag.create(stage.getWidth()*0.02f, brickWall3.getY() - brickWall.getHeight()));
        stage.addActor(Sandbag.create(stage.getWidth()*0.13f, brickWall3.getY() - brickWall.getHeight()));
        
        stage.addActor(Sandbag.create(stage.getWidth()*0.75f, brickWall3.getY() - brickWall.getHeight()));
        stage.addActor(Sandbag.create(stage.getWidth()*0.85f, brickWall3.getY() - brickWall.getHeight()));
    }
}