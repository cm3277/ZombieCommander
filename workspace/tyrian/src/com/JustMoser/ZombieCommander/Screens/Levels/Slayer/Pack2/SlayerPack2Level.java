package com.JustMoser.ZombieCommander.Screens.Levels.Slayer.Pack2;

import com.JustMoser.ZombieCommander.Tyrian;
import com.JustMoser.ZombieCommander.Helper.LevelManager;
import com.JustMoser.ZombieCommander.Screens.Levels.AbstractLevel;

public class SlayerPack2Level extends AbstractLevel
{
	
    public SlayerPack2Level(Tyrian game, int level )
    {
        super( game, "DesertBackground", LevelManager.getSlayerPackId(2), level, LevelManager.getSlayer() );
    }
}