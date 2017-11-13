package com.JustMoser.ZombieCommander.Helper;

public class ClassType {
	
	private static int ZOMBIE = 1;
	private static int HUMAN = 2;
	private static int MEATHEAD = 3;
	private static int BANGER = 4;
	private static int ASSASSIN = 5;
	private static int SPIDER = 6;
	private static int MINISPIDER = 7;
	private static int BAT = 8;
	private static int RIDER = 9;
	private static int GRAYZOMBIE = 10;
	private static int HUNTER = 11;
	private static int HEALWITCH = 12;
	
	public static boolean isZombie(int classType)
	{
		if (classType == ZOMBIE)
			return true;
		else
			return false;
	}
	
	public static int getZombie()
	{
		return ZOMBIE;
	}
	
	public static boolean isHuman(int classType)
	{
		if (classType == HUMAN)
			return true;
		else
			return false;
	}
	
	public static int getHuman()
	{
		return HUMAN;
	}
	
	public static boolean isMeatHead(int classType)
	{
		if (classType == MEATHEAD)
			return true;
		else
			return false;
	}
	
	public static int getMeatHead()
	{
		return MEATHEAD;
	}
	
	public static boolean isBanger(int classType)
	{
		if (classType == BANGER)
			return true;
		else
			return false;
	}
	
	public static int getBanger()
	{
		return BANGER;
	}
	
	public static boolean isAssassin(int classType)
	{
		if (classType == ASSASSIN)
			return true;
		else
			return false;
	}
	
	public static int getAssassin()
	{
		return ASSASSIN;
	}
	
	public static boolean isSpider(int classType)
	{
		if (classType == SPIDER)
			return true;
		else
			return false;
	}
	
	public static int getSpider()
	{
		return SPIDER;
	}
	
	public static boolean isMiniSpider(int classType)
	{
		if (classType == MINISPIDER)
			return true;
		else
			return false;
	}
	
	public static int getMiniSpider()
	{
		return MINISPIDER;
	}
	
	public static boolean isBat(int classType)
	{
		if (classType == BAT)
			return true;
		else
			return false;
	}
	
	public static int getBat()
	{
		return BAT;
	}
	
	public static boolean isRider(int classType)
	{
		if (classType == RIDER)
			return true;
		else
			return false;
	}
	
	public static int getRider()
	{
		return RIDER;
	}
	
	public static boolean isGrayZombie(int classType)
	{
		if (classType == GRAYZOMBIE)
			return true;
		else
			return false;
	}
	
	public static int getGrayZombie()
	{
		return GRAYZOMBIE;
	}
	
	public static boolean isHunter(int classType)
	{
		if (classType == HUNTER)
			return true;
		else
			return false;
	}
	
	public static int getHunter()
	{
		return HUNTER;
	}
	
	public static boolean isHealWitch(int classType)
	{
		if (classType == HEALWITCH)
			return true;
		else
			return false;
	}
	
	public static int getHealWitch()
	{
		return HEALWITCH;
	}

}
