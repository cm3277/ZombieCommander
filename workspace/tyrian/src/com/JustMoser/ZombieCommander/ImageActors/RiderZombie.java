package com.JustMoser.ZombieCommander.ImageActors;

import java.util.HashMap;
import java.util.Map;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Array;

public class RiderZombie extends Zombie{
	
	//do class type and in zombie create stuff!
	private static int CLASSTYPE = 9;
	private static int startHealth = 500;
	private static int damage = 200;
	private static int speed = 65;
	//animation
	private static Array<AtlasRegion> zombieRegions;
	private static Map<TextureRegion,Drawable> zombieAnimDrawables;
	private static Animation walkAnimation;

	public RiderZombie(Array<AtlasRegion> animationRegions, float x, float y) {
		super(animationRegions, x, y);
		setClassType(CLASSTYPE);
		setHealth(startHealth);
		setSpeed(MathUtils.random(55, 75));
		setDamage(damage);
	}
	
	public static RiderZombie create(float x, float y)
    {
		

        // create the ship
		return new RiderZombie(zombieRegions, x, y);
    }
	
	public static void loadAssets()
	{
		//if (zombieRegions == null) {
			zombieRegions = getZombieAtlas().findRegions( "Rider");
		//}
		//if (walkAnimation == null) {
			walkAnimation = new Animation( 0.3f, zombieRegions );
		//}
		//if (zombieAnimDrawables == null) {
    		zombieAnimDrawables = new HashMap<TextureRegion,Drawable>();
    		for( AtlasRegion region : zombieRegions ) {
    			zombieAnimDrawables.put( region, new TextureRegionDrawable( region ) );
    		}
    	//}
	}
	
	@Override
	public void animateZombie(float delta)
	{
		TextureRegion frame;
			frame = walkAnimation.getKeyFrame( walkStateTime += delta, true );
			setDrawable(zombieAnimDrawables.get(frame));
	}
	
	@Override
	public void createDeadBody()
	{
		getStage().addActor(DeadBody.create(CLASSTYPE, getX(), getY(), getRotation()));
		//create the rider
		getStage().addActor(GrayZombie.create(this.getX() + MathUtils.random(-20, 20), this.getY() + MathUtils.random(-20, 20),
												this.getRotation(), this.getTargetArray(), this.getTargetArrayNum()));
	}
	
	public static int getStartHealth()
	{
		return startHealth;
	}
	
	public static int getDamage()
	{
		return damage;
	}
	
	public static int getSpeed()
	{
		return speed;
	}
	

}