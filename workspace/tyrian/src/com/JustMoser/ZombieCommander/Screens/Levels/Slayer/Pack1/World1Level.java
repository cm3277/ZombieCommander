package com.JustMoser.ZombieCommander.Screens.Levels.Slayer.Pack1;

import com.JustMoser.ZombieCommander.Tyrian;
import com.JustMoser.ZombieCommander.Helper.LevelManager;
import com.JustMoser.ZombieCommander.Screens.Levels.AbstractLevel;

public class World1Level extends AbstractLevel
{
	
    public World1Level(Tyrian game, int level )
    {
        super( game, "GrassBackground", LevelManager.getSlayerPackId(1), level, LevelManager.getSlayer() );
    }
}