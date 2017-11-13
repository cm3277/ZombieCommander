package com.JustMoser.ZombieCommander.Helper;

import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.Json.Serializable;
import com.badlogic.gdx.utils.JsonValue;

public class Profile implements Serializable{

	private int numBrains;
	private UpgradeManager upgradeManager;
	private LevelManager levelManager;
	private AchievementManager achievmentManager;
	//private static int brainsMultiplier = 10;
	
	public Profile()
	{
		numBrains = 300;
		upgradeManager = new UpgradeManager();
		levelManager = new LevelManager();
		achievmentManager = new AchievementManager();
	}
	
	public void addBrains(int value)
	{
		setNumBrains(numBrains + value);
		RoundHelper.addBrainsEarned(value);
	}
	
	public void subtractBrains(int value)
	{
		setNumBrains(numBrains - value);
	}
	
	public void setNumBrains(int brains)
	{
		numBrains = brains;
		RoundHelper.updateBrainsLabel();
	}
	
	public int getNumBrains()
	{
		return numBrains;
	}
	
	// Serializable implementation 
    @Override
    public void read(Json json, JsonValue jsonData )
    {
        // read the some basic properties
        numBrains = json.readValue( "numBrains", Integer.class, jsonData );
        upgradeManager = json.readValue( "upgradeManager", UpgradeManager.class, jsonData );
        levelManager = json.readValue( "levelManager", LevelManager.class, jsonData );
        achievmentManager = json.readValue( "achievmentManager", AchievementManager.class, jsonData );
        //credits = json.readValue( "credits", Integer.class, jsonData );
        
        // finally, read the ship
        //ship = json.readValue( "ship", Ship.class, jsonData );
    }
 
    @Override
    public void write(Json json )
    {
        json.writeValue( "numBrains", numBrains );
        json.writeValue( "upgradeManager", upgradeManager );
        json.writeValue( "levelManager", levelManager );
        json.writeValue( "achievmentManager", achievmentManager );
        //json.writeValue( "credits", credits );
        //json.writeValue( "highScores", highScores );
        //json.writeValue( "ship", ship );
    }
}