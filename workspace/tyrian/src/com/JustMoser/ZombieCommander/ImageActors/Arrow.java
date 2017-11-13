package com.JustMoser.ZombieCommander.ImageActors;

import com.JustMoser.ZombieCommander.Helper.ClassType;
import com.JustMoser.ZombieCommander.Helper.UpgradeManager;
import com.JustMoser.ZombieCommander.ImageActors.Blockers.Blocker;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;

public class Arrow extends Bullet{
	
	private static TextureRegion arrowRegion;
	private static int startDamage = 30;
	private int damage = 30;
	private static int baseArrowSpeed = 650;
	
	public Arrow(TextureRegion animationRegion, float x, float y) {
		super(animationRegion, x, y);
		setBaseSpeed(baseArrowSpeed);
		this.damage = MathUtils.roundPositive(UpgradeManager.getUpgradedCustom(ClassType.getHunter(), this.damage));
	}
	
	public static Arrow create(float x, float y)
	    {
			
	        return new Arrow(arrowRegion, x, y);
	    }
	
	public static void loadAssets()
	{
		arrowRegion = getZombieAtlas().findRegion( "Arrow");
	}
	
	@Override
	public void checkZombies()
	{
		//don't check our comrades Check Humans and blockers!
		for (Human human : getHumanArray()){
			if (human.getRect().contains(getX(), getY())){
				human.hurt(damage);
				destroy();
				break;
			}
		}
		if (getAlive()){
			for (Blocker blocker : getBlockersArray()){
				if (blocker.getRect().contains(getX(), getY())){
					blocker.hurt(damage);
					destroy();
					break;
				}
			}
		}
	}
	
	public static int getDamage()
	{
		return startDamage = MathUtils.roundPositive(UpgradeManager.getUpgradedCustom(ClassType.getHunter(), startDamage));
	}

}
