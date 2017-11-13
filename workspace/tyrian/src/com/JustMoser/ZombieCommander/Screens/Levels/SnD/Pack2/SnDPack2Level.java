package com.JustMoser.ZombieCommander.Screens.Levels.SnD.Pack2;

import com.JustMoser.ZombieCommander.Tyrian;
import com.JustMoser.ZombieCommander.Helper.LevelManager;
import com.JustMoser.ZombieCommander.ImageActors.Fog;
import com.JustMoser.ZombieCommander.Screens.Levels.AbstractLevel;
import com.badlogic.gdx.math.MathUtils;

public class SnDPack2Level extends AbstractLevel{
	
	 public SnDPack2Level(Tyrian game, int level )
	    {
	        super( game, "GrassBackground", LevelManager.getSearchAndDestroyPackId(1), level, LevelManager.getSearchAndDestroy() );
	    }
	    
	    public void addFog()
	    {
	    	int widthFogs = MathUtils.roundPositive(stage.getWidth()/50)+2;
	    	int heightFogs = MathUtils.roundPositive(stage.getHeight()/50)+2;
	    	for (int y = -1; y < heightFogs; y++){
	    		for (int i = -1; i < widthFogs; i++){
	    			Fog fog = Fog.create(i*50, 50*y);
	    			fog.setRotation(MathUtils.random(0, 360));
	    			stage.addActor(fog);
	    		}
	    	}
	    }

}