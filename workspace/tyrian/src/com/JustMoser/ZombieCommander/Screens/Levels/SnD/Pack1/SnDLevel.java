package com.JustMoser.ZombieCommander.Screens.Levels.SnD.Pack1;

import com.JustMoser.ZombieCommander.Tyrian;
import com.JustMoser.ZombieCommander.Helper.LevelManager;
import com.JustMoser.ZombieCommander.ImageActors.Fog;
import com.JustMoser.ZombieCommander.Screens.Levels.AbstractLevel;
import com.badlogic.gdx.math.MathUtils;

public class SnDLevel extends AbstractLevel
{
	
    public SnDLevel(Tyrian game, int level )
    {
        super( game, "DesertBackground", LevelManager.getSearchAndDestroyPackId(1), level, LevelManager.getSearchAndDestroy() );
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