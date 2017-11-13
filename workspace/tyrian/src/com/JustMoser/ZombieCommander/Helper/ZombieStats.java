package com.JustMoser.ZombieCommander.Helper;

import com.JustMoser.ZombieCommander.ImageActors.AssassinZombie;
import com.JustMoser.ZombieCommander.ImageActors.BangerZombie;
import com.JustMoser.ZombieCommander.ImageActors.BatZombie;
import com.JustMoser.ZombieCommander.ImageActors.GrayZombie;
import com.JustMoser.ZombieCommander.ImageActors.HunterZombie;
import com.JustMoser.ZombieCommander.ImageActors.MeatHeadZombie;
import com.JustMoser.ZombieCommander.ImageActors.RiderZombie;
import com.JustMoser.ZombieCommander.ImageActors.SpiderZombie;
import com.JustMoser.ZombieCommander.ImageActors.Zombie;

public class ZombieStats {
	
	private static int brainsPerDamage = 10;
	private static int brainsPerHuman = 100;
	private static int brainsPerBlocker = 50;
	private static int brainsPerUpgrade = 400;
	
	public static int getBrainsPerDamage()
	{
		return brainsPerDamage;
	}
	
	public static int getBrainsPerHuman()
	{
		return brainsPerHuman;
	}
	
	public static int getBrainsPerBlocker()
	{
		return brainsPerBlocker;
	}
	
	public static int getBrainsPerUpgrade()
	{
		return brainsPerUpgrade;
	}

	public static int getHighestHealth()
	{
		int highestHealth = MeatHeadZombie.getStartHealth();
		if (highestHealth < AssassinZombie.getStartHealth())
			highestHealth = AssassinZombie.getStartHealth();
		
		if (highestHealth < BangerZombie.getStartHealth())
			highestHealth = BangerZombie.getStartHealth();
		
		if (highestHealth < BatZombie.getStartHealth())
			highestHealth = BatZombie.getStartHealth();
		
		if (highestHealth < GrayZombie.getStartHealth() + RiderZombie.getStartHealth())
			highestHealth = GrayZombie.getStartHealth() + RiderZombie.getStartHealth();
		
		if (highestHealth < HunterZombie.getStartHealth())
			highestHealth = HunterZombie.getStartHealth();
		
		if (highestHealth < SpiderZombie.getStartHealth())
			highestHealth = SpiderZombie.getStartHealth();
		
		if (highestHealth < Zombie.getStartHealth())
			highestHealth = Zombie.getStartHealth();
		
		return highestHealth;
	}
	
	public static int getHighestDamage()
	{
		int highestHealth = MeatHeadZombie.getDamage();
		if (highestHealth < AssassinZombie.getDamage())
			highestHealth = AssassinZombie.getDamage();
		
		if (highestHealth < BangerZombie.getDamage())
			highestHealth = BangerZombie.getDamage();
		
		if (highestHealth < BatZombie.getDamage())
			highestHealth = BatZombie.getDamage();
		
		if (highestHealth < RiderZombie.getDamage())
			highestHealth = RiderZombie.getDamage();
		
		if (highestHealth < HunterZombie.getDamage())
			highestHealth = HunterZombie.getDamage();
		
		if (highestHealth < SpiderZombie.getDamage())
			highestHealth = SpiderZombie.getDamage();
		
		if (highestHealth < Zombie.getDamage())
			highestHealth = Zombie.getDamage();
		
		return highestHealth;
	}
	
	public static int getHighestSpeed()
	{
		int highestHealth = MeatHeadZombie.getSpeed();
		if (highestHealth < AssassinZombie.getSpeed())
			highestHealth = AssassinZombie.getSpeed();
		
		if (highestHealth < BangerZombie.getSpeed())
			highestHealth = BangerZombie.getSpeed();
		
		if (highestHealth < BatZombie.getSpeed())
			highestHealth = BatZombie.getSpeed();
		
		if (highestHealth < RiderZombie.getSpeed())
			highestHealth = RiderZombie.getSpeed();
		
		if (highestHealth < HunterZombie.getSpeed())
			highestHealth = HunterZombie.getSpeed();
		
		if (highestHealth < SpiderZombie.getSpeed())
			highestHealth = SpiderZombie.getSpeed();
		
		if (highestHealth < Zombie.getSpeed())
			highestHealth = Zombie.getSpeed();
		
		return highestHealth;
	}
	
	public static String getDescription(int zombieType)
	{
		if (ClassType.isZombie(zombieType)){
			return "Base Zombie, Average and balanced all around. Good starter.";
		}
		else if (ClassType.isAssassin(zombieType)){
			return "After First shot is temporarily Invisible and Invincible.";
		}
		else if (ClassType.isBanger(zombieType)){
			return "Low Health but has TNT strapped to it's back. Explodes on contact.";
		}
		else if (ClassType.isBat(zombieType)){
			return "Can fly over objects to get directly to Humans. Good as distractions. Spawns 2 for one.";
		}
		else if (ClassType.isHunter(zombieType)){
			return "Hunts Humans down with arrows when in range.";
		}
		else if (ClassType.isMeatHead(zombieType)){
			return "Slow but very Powerful and strong. Can take many hits.";
		}
		else if (ClassType.isRider(zombieType)){
			return "After the wolf gets shot down the rider continues alone making this duo powerful.";
		}
		else if (ClassType.isSpider(zombieType)){
			return "When the queen is killed her babies are released, and they want revenge.";
		}
		else if (ClassType.isHealWitch(zombieType)){
			return "Heals and gives Zombies a temporary shield.";
		}
		else
			return "";
	}
	
	public static String getNeedsUnlock(int zombieType)
	{
		if (ClassType.isAssassin(zombieType)){
			return "You need to beat the Second Slayer Level to Unlock the Assassin.";
		}
		else if (ClassType.isBanger(zombieType)){
			return "You need to beat the Second Slayer Level to Unlock the Banger.";
		}
		else if (ClassType.isBat(zombieType)){
			return "You need to Unlock Search And Destroy to Unlock the Hell Bats.";
		}
		else if (ClassType.isHunter(zombieType)){
			return "You need to Unlock Capture The Flag to Unlock the Hunter.";
		}
		else if (ClassType.isMeatHead(zombieType)){
			return "You need to beat the first Slayer Level to Unlock the MeatHead.";
		}
		else if (ClassType.isRider(zombieType)){
			return "You need to beat the Fourth Slayer Level to Unlock the Wolf Rider.";
		}
		else if (ClassType.isSpider(zombieType)){
			return "You need to beat the Fourth Slayer Level to Unlock the Spider.";
		}
		else if (ClassType.isHealWitch(zombieType)){
			return "You need to beat the first Slayer Level to Unlock the Witch.";
		}
		else
			return "";
	}
	
	public static int getZombiePrice(int zombieType)
	{
		if (ClassType.isZombie(zombieType)){
			return 0;
		}
		else if (ClassType.isAssassin(zombieType)){
			return 50;
		}
		else if (ClassType.isBanger(zombieType)){
			return 25;
		}
		else if (ClassType.isBat(zombieType)){
			return 25;
		}
		else if (ClassType.isHunter(zombieType)){
			return 50;
		}
		else if (ClassType.isMeatHead(zombieType)){
			return 75;
		}
		else if (ClassType.isRider(zombieType)){
			return 100;
		}
		else if (ClassType.isSpider(zombieType)){
			return 75;
		}
		else if (ClassType.isHealWitch(zombieType)){
			return 50;
		}
		else
			return 0;
	}
}
