package com.JustMoser.ZombieCommander.Screens.Levels.CtF.Pack1;

import com.JustMoser.ZombieCommander.Tyrian;
import com.JustMoser.ZombieCommander.Helper.LevelManager;
import com.JustMoser.ZombieCommander.Screens.Levels.AbstractLevel;

public class CtFLevel extends AbstractLevel
{
	
    public CtFLevel(Tyrian game, int level )
    {
        super( game, "MoonBackground", LevelManager.getCaptureTheFlagPackId(1), level, LevelManager.getCaptureTheFlag() );
    }
}