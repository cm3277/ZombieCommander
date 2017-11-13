package com.JustMoser.ZombieCommander.ImageActors;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;

public class GrayZombie extends Zombie{
	
	//do class type and in zombie create stuff!
	private static int CLASSTYPE = 10;
	private static int startHealth = 400;

	public GrayZombie(Array<AtlasRegion> animationRegions, float x, float y, float rotation, Array<Vector2> targetArray, int targetNum) 
	{
		super(animationRegions, x, y);
		this.setColor(Color.GRAY);
		setRotation(rotation);
		setClassType(CLASSTYPE);
		setHealth(startHealth);
		getZombieArray().add(this);
		setTargetArrayNum(targetNum);
		copyTargetArray(targetArray);
		//default speed setSpeed(MathUtils.random(25, 35));
		//default damage setDamage(damage);
	}
	
	public static GrayZombie create(float x, float y, float rotation, Array<Vector2> targetArray, int targetNum)
    {
        // create the ship
		return new GrayZombie(getWalkerRegions(), x, y, rotation, targetArray, targetNum);
    }
	
	@Override
	public void colorZombie()
	{
		this.setColor(Color.GRAY);
	}
	
	@Override
	public void createDeadBody()
	{
		getStage().addActor(DeadBody.create(CLASSTYPE, getX(), getY(), getRotation()));
	}
	
	public static int getStartHealth()
	{
		return startHealth;
	}

}