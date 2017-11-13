package com.JustMoser.ZombieCommander.Helper;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.Json.Serializable;
import com.badlogic.gdx.utils.JsonValue;

public class UpgradeManager implements Serializable{
	
	private static int HEALTHUPGRADE = 0;
	private static int DAMAGEUPGRADE = 1;
	private static int SPEEDUPGRADE = 2;
	private static int CUSTOMUPGRADE = 3;
	private static int walkerUpgradeNum[]; 
	private static int assassinUpgradeNum[]; 
	private static int bangerUpgradeNum[]; 
	private static int batUpgradeNum[]; 
	private static int healWitchUpgradeNum[]; 
	private static int hunterUpgradeNum[]; 
	private static int meatheadUpgradeNum[]; 
	private static int riderUpgradeNum[];
	private static int spiderUpgradeNum[]; 
	private static float baseUpgradePercent = 1.15f;
	private static float upgradePercentChange = 0.987f;
	
	public UpgradeManager()
	{
		walkerUpgradeNum = new int[] {0, 0, 0};
		assassinUpgradeNum = new int[] {0, 0, 0, 0};
		bangerUpgradeNum = new int[] {0, 0, 0};
		batUpgradeNum = new int[] {0, 0, 0};
		healWitchUpgradeNum = new int[] {0, 0, 0, 0};
		hunterUpgradeNum = new int[] {0, 0, 0, 0};
		meatheadUpgradeNum = new int[] {0, 0, 0};
		riderUpgradeNum = new int[] {0, 0, 0};
		spiderUpgradeNum = new int[] {0, 0, 0};
	}
	
	public static void upgrade(int zombieType, int upgradeType)
	{
		//zombie/walker
		if (ClassType.isZombie(zombieType)){
			walkerUpgradeNum[upgradeType]++;
		}
		//assassin
		else if (ClassType.isAssassin(zombieType)){
			assassinUpgradeNum[upgradeType]++;
		}
		//banger
		else if (ClassType.isBanger(zombieType)){
			bangerUpgradeNum[upgradeType]++;
		}
		//bat
		else if (ClassType.isBat(zombieType)){
			batUpgradeNum[upgradeType]++;
		}
		//healwitch
		else if (ClassType.isHealWitch(zombieType)){
			healWitchUpgradeNum[upgradeType]++;
		}
		//hunter
		else if (ClassType.isHunter(zombieType)){
			hunterUpgradeNum[upgradeType]++;
		}
		//meathead
		else if (ClassType.isMeatHead(zombieType)){
			meatheadUpgradeNum[upgradeType]++;
		}
		//rider
		else if (ClassType.isRider(zombieType)){
			riderUpgradeNum[upgradeType]++;
		}
		//spider
		else if (ClassType.isSpider(zombieType)){
			spiderUpgradeNum[upgradeType]++;
		}
	}
	
	public static void upgradeHealth(int zombieType)
	{
		upgrade(zombieType, HEALTHUPGRADE);
	}
	
	public static void upgradeDamage(int zombieType)
	{
		upgrade(zombieType, DAMAGEUPGRADE);
	}
	
	public static void upgradeSpeed(int zombieType)
	{
		upgrade(zombieType, SPEEDUPGRADE);
	}
	
	public static void upgradeCustom(int zombieType)
	{
		upgrade(zombieType, CUSTOMUPGRADE);
	}
	
	private static int getUpgradeNum(int zombieType, int upgradeType)
	{
		if (ClassType.isZombie(zombieType)){
			return walkerUpgradeNum[upgradeType];
		}
		//assassin
		else if (ClassType.isAssassin(zombieType)){
			return assassinUpgradeNum[upgradeType];
		}
		//banger
		else if (ClassType.isBanger(zombieType)){
			return bangerUpgradeNum[upgradeType];
		}
		//bat
		else if (ClassType.isBat(zombieType)){
			return batUpgradeNum[upgradeType];
		}
		//healwitch
		else if (ClassType.isHealWitch(zombieType)){
			return healWitchUpgradeNum[upgradeType];
		}
		//hunter
		else if (ClassType.isHunter(zombieType)){
			return hunterUpgradeNum[upgradeType];
		}
		//meathead
		else if (ClassType.isMeatHead(zombieType)){
			return meatheadUpgradeNum[upgradeType];
		}
		//rider
		else if (ClassType.isRider(zombieType)){
			return riderUpgradeNum[upgradeType];
		}
		//spider
		else if (ClassType.isSpider(zombieType)){
			return spiderUpgradeNum[upgradeType];
		}
		else
			return 0;
	}
	
	public static int getHealthUpgrade(int zombieType)
	{
		return getUpgradeNum(zombieType, HEALTHUPGRADE);
	}
	
	public static int getDamageUpgrade(int zombieType)
	{
		return getUpgradeNum(zombieType, DAMAGEUPGRADE);
	}
	
	public static int getSpeedUpgrade(int zombieType)
	{
		return getUpgradeNum(zombieType, SPEEDUPGRADE);
	}
	
	public static int getCustomUpgrade(int zombieType)
	{
		return getUpgradeNum(zombieType, CUSTOMUPGRADE);
	}
	
	public static float getUpgradedCustom(int zombieType, float startCustom)
	{
		return getUpgradedStatFloat(zombieType, startCustom, CUSTOMUPGRADE);
	}
	
	public static int getUpgradedHealth(int zombieType, int startHealth)
	{
		return getUpgradedStat(zombieType, startHealth, HEALTHUPGRADE);
	}
	
	public static int getUpgradedDamage(int zombieType, int startDamage)
	{
		return getUpgradedStat(zombieType, startDamage, DAMAGEUPGRADE);
	}
	
	public static int getUpgradedSpeed(int zombieType, int startSpeed)
	{
		return getUpgradedStat(zombieType, startSpeed, SPEEDUPGRADE);
	}
	
	private static int getUpgradedStat(int zombieType, int startStat, int upgradeType)
	{
		int upgradeNum = getUpgradeNum(zombieType, upgradeType);
		int upgradedStat = startStat;
		for (int i = 0; i < upgradeNum; i++){
			upgradedStat = MathUtils.roundPositive(upgradedStat * getUpgradePercent(i));
		}
		return upgradedStat;
	}
	
	private static float getUpgradedStatFloat(int zombieType, float startStat, int upgradeType)
	{
		int upgradeNum = getUpgradeNum(zombieType, upgradeType);
		float upgradedStat = startStat;
		for (int i = 0; i < upgradeNum; i++){
			upgradedStat = upgradedStat * getUpgradePercent(i);
		}
		return upgradedStat;
	}
	
	public static float getUpgradePercent(int upgradeNum)
	{
		float percent = (float) (baseUpgradePercent * Math.pow(upgradePercentChange, upgradeNum));
		if (percent < 1.02)
			percent = 1.02f;
		return percent;
	}
	
	public static int getHealthUpgradeType()
	{
		return HEALTHUPGRADE;
	}
	
	public static int getDamageUpgradeType()
	{
		return DAMAGEUPGRADE;
	}
	
	public static int getSpeedUpgradeType()
	{
		return SPEEDUPGRADE;
	}
	
	public static int getCustomUpgradeType()
	{
		return CUSTOMUPGRADE;
	}
	
	// Serializable implementation 
    @Override
    public void read(Json json, JsonValue jsonData )
    {
        // read the some basic properties
    	walkerUpgradeNum = json.readValue( "walkerUpgradeNum", int[].class, jsonData );
    	assassinUpgradeNum = json.readValue( "assassinUpgradeNum", int[].class, jsonData );
    	bangerUpgradeNum = json.readValue( "bangerUpgradeNum", int[].class, jsonData );
    	batUpgradeNum = json.readValue( "batUpgradeNum", int[].class, jsonData );
    	healWitchUpgradeNum = json.readValue( "healWitchUpgradeNum", int[].class, jsonData );
    	hunterUpgradeNum = json.readValue( "hunterUpgradeNum", int[].class, jsonData );
    	meatheadUpgradeNum = json.readValue( "meatheadUpgradeNum", int[].class, jsonData );
    	riderUpgradeNum = json.readValue( "riderUpgradeNum", int[].class, jsonData );
    	spiderUpgradeNum = json.readValue( "spiderUpgradeNum", int[].class, jsonData );
        
    }
 
    @Override
    public void write(Json json )
    {
        json.writeValue( "walkerUpgradeNum", walkerUpgradeNum );
        json.writeValue( "assassinUpgradeNum", assassinUpgradeNum );
        json.writeValue( "bangerUpgradeNum", bangerUpgradeNum );
        json.writeValue( "batUpgradeNum", batUpgradeNum );
        json.writeValue( "healWitchUpgradeNum", healWitchUpgradeNum );
        json.writeValue( "hunterUpgradeNum", hunterUpgradeNum );
        json.writeValue( "meatheadUpgradeNum", meatheadUpgradeNum );
        json.writeValue( "riderUpgradeNum", riderUpgradeNum );
        json.writeValue( "spiderUpgradeNum", spiderUpgradeNum );
    }

}
