package com.JustMoser.ZombieCommander.Helper;

import com.JustMoser.ZombieCommander.Helper.SwarmConsts.Achievement;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.Json.Serializable;
import com.badlogic.gdx.utils.JsonValue;
import com.swarmconnect.SwarmAchievement;

public class AchievementManager implements Serializable{
	
	private static int numZombiesSpawned[];
	private static int NOOBZOMBIES = 3;
	private static int MASTERZOMBIES = 100;
	private static boolean levelPackNoob[];
	private static boolean levelPackMaster[];
	private static boolean unlockedZombie[];
	
	public AchievementManager()
	{
		numZombiesSpawned = new int[] {0,0,0,0,0,0,0,0,0,0,0,0,0};
		levelPackNoob = new boolean[] {false, false, false, false, false, false};
		levelPackMaster = new boolean[] {false, false, false, false, false, false};
		unlockedZombie = new boolean[] {false, true, false, false, false, false, false, false, false, false, false, false, false};
	}
	
	public static void unlockZombie(int zombieType)
	{
		unlockedZombie[zombieType] = true;
	}
	
	public static boolean getUnlockedZombie(int zombieType)
	{
		return unlockedZombie[zombieType];
	}
	
	public static void unlockLevelPackMaster(int packId)
	{
		levelPackMaster[packId] = true;
		//unlock achievement
		unlockLevelPackAchievement(packId, false);
	}
	
	public static boolean getLevelPackMaster(int packId)
	{
		return levelPackMaster[packId];
	}
	
	public static void unlockLevelPackNoob(int packId)
	{
		levelPackNoob[packId] = true;
		//unlock achievement
		unlockLevelPackAchievement(packId, true);
	}
	
	public static boolean getLevelPackNoob(int packId)
	{
		return levelPackNoob[packId];
	}
	
	private static void unlockLevelPackAchievement(int packId, boolean noob)
	{
		if (RoundHelper.getGameTypeId() == LevelManager.getSlayer()){
			if (packId == LevelManager.getSlayerPackId(1)){
				if (noob)
					SwarmAchievement.unlock(Achievement.SLAYER_BEGINNER_NOOB_ID);
				else
					SwarmAchievement.unlock(Achievement.SLAYER_BEGINNER_MASTER_ID);
			}
			else if (packId == LevelManager.getSlayerPackId(2)){
				if (noob)
					SwarmAchievement.unlock(Achievement.SLAYER_ADVANCED_NOOB_ID);
				else
					SwarmAchievement.unlock(Achievement.SLAYER_ADVANCED_MASTER_ID);
			}
		}
		else if (RoundHelper.getGameTypeId() == LevelManager.getSearchAndDestroy()){
			if (packId == LevelManager.getSearchAndDestroyPackId(1)){
				if (noob)
					SwarmAchievement.unlock(Achievement.SEARCH_AND_DESTROY_BEGINNER_NOOB_ID);
				else
					SwarmAchievement.unlock(Achievement.SEARCH_AND_DESTROY_BEGINNER_MASTER_ID);
			}
			else if (packId == LevelManager.getSearchAndDestroyPackId(2)){
				if (noob)
					SwarmAchievement.unlock(Achievement.SEARCH_AND_DESTROY_ADVANCED_NOOB_ID);
				else
					SwarmAchievement.unlock(Achievement.SEARCH_AND_DESTROY_ADVANCED_MASTER_ID);
			}
		}
		else if (RoundHelper.getGameTypeId() == LevelManager.getCaptureTheFlag()){
			if (packId == LevelManager.getCaptureTheFlagPackId(1)){
				if (noob)
					SwarmAchievement.unlock(Achievement.CAPTURE_THE_FLAG_BEGINNER_NOOB_ID);
				else
					SwarmAchievement.unlock(Achievement.CAPTURE_THE_FLAG_BEGINNER_MASTER_ID);
			}
			else if (packId == LevelManager.getCaptureTheFlagPackId(2)){
				if (noob)
					SwarmAchievement.unlock(Achievement.CAPTURE_THE_FLAG_ADVANCED_NOOB_ID);
				else
					SwarmAchievement.unlock(Achievement.CAPTURE_THE_FLAG_ADVANCED_MASTER_ID);
			}
		}
	}
	
	public static void addZombiesSpawned(int zombieType)
	{
		numZombiesSpawned[zombieType]++;
		if (numZombiesSpawned[zombieType] == NOOBZOMBIES){
			//unlock noob achievement
			/*if (zombieType == ClassType.getZombie())
				SwarmAchievement.unlock(14394);*/
			unlockZombieAchievement(zombieType, true);
		}
		else if (numZombiesSpawned[zombieType] == MASTERZOMBIES){
			//unlock master 
			unlockZombieAchievement(zombieType, false);
		}
	}
	
	public static void unlockZombieAchievement(int zombieType, boolean noob)
	{
		if (ClassType.isZombie(zombieType)){
			if (noob)
				SwarmAchievement.unlock(Achievement.WALKER_NOOB_ID);
			else
				SwarmAchievement.unlock(Achievement.WALKER_MASTER_ID);
		}
		else if (ClassType.isAssassin(zombieType)){
			if (noob)
				SwarmAchievement.unlock(Achievement.ASSASSIN_NOOB_ID);
			else
				SwarmAchievement.unlock(Achievement.ASSASSIN_MASTER_ID);	
		}
		else if (ClassType.isBanger(zombieType)){
			if (noob)
				SwarmAchievement.unlock(Achievement.BANGER_NOOB_ID);
			else
				SwarmAchievement.unlock(Achievement.BANGER_MASTER_ID);	
		}
		else if (ClassType.isBat(zombieType)){
			if (noob)
				SwarmAchievement.unlock(Achievement.BATS_NOOB_ID);
			else
				SwarmAchievement.unlock(Achievement.BATS_MASTER_ID);	
		}
		else if (ClassType.isHunter(zombieType)){
			if (noob)
				SwarmAchievement.unlock(Achievement.HUNTER_NOOB_ID);
			else
				SwarmAchievement.unlock(Achievement.HUNTER_MASTER_ID);	
		}
		else if (ClassType.isMeatHead(zombieType)){
			if (noob)
				SwarmAchievement.unlock(Achievement.MEATHEAD_NOOB_ID);
			else
				SwarmAchievement.unlock(Achievement.MEATHEAD_MASTER_ID);	
		}
		else if (ClassType.isRider(zombieType)){
			if (noob)
				SwarmAchievement.unlock(Achievement.WOLF_RIDER_NOOB_ID);
			else
				SwarmAchievement.unlock(Achievement.WOLF_RIDER_MASTER_ID);	
		}
		else if (ClassType.isSpider(zombieType)){
			if (noob)
				SwarmAchievement.unlock(Achievement.SPIDER_QUEEN_NOOB_ID);
			else
				SwarmAchievement.unlock(Achievement.SPIDER_QUEEN_MASTER_ID);	
		}
		else if (ClassType.isHealWitch(zombieType)){
			if (noob)
				SwarmAchievement.unlock(Achievement.HEALING_WITCH_NOOB_ID);
			else
				SwarmAchievement.unlock(Achievement.HEALING_WITCH_MASTER_ID);	
		}
	}
	
	public static int getNumZombiesSpawned(int zombieType)
	{
		return numZombiesSpawned[zombieType];
	}
	
	public static int getNumNoobZombies()
	{
		return NOOBZOMBIES;
	}
	
	public static int getNumMasterZombies()
	{
		return MASTERZOMBIES;
	}
	
	// Serializable implementation 
    @Override
    public void read(Json json, JsonValue jsonData )
    {
        // read the some basic properties
    	numZombiesSpawned = json.readValue( "numZombiesSpawned", int[].class, jsonData );
    	levelPackNoob = json.readValue( "levelPackNoob", boolean[].class, jsonData );
    	levelPackMaster = json.readValue( "levelPackMaster", boolean[].class, jsonData );
    	unlockedZombie = json.readValue( "unlockedZombie", boolean[].class, jsonData );
    }
 
    @Override
    public void write(Json json )
    {
        json.writeValue( "numZombiesSpawned", numZombiesSpawned );
        json.writeValue( "levelPackNoob", levelPackNoob );
        json.writeValue( "levelPackMaster", levelPackMaster );
        json.writeValue( "unlockedZombie", unlockedZombie );
    }

}
