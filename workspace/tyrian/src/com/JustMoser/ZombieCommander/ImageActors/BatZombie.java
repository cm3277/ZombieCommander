package com.JustMoser.ZombieCommander.ImageActors;

import java.util.HashMap;
import java.util.Map;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Array;

public class BatZombie extends Zombie{
	
	//do class type and in zombie create stuff!
	private static int CLASSTYPE = 8;
	private static int startHealth = 200;
	private static int damage = 10;
	private static int speed = 95;
	//animation
	private static Array<AtlasRegion> zombieRegions;
	private static Map<TextureRegion,Drawable> zombieAnimDrawables;
	private static Animation walkAnimation;

	public BatZombie(Array<AtlasRegion> animationRegions, float x, float y) {
		super(animationRegions, x, y);
		setClassType(CLASSTYPE);
		setHealth(startHealth);
		setBody(new Rectangle(this.getX(), this.getY(), this.getWidth()*1.5f, this.getHeight()*1.5f));
		setSpeed(MathUtils.random(80, 110));
		setDamage(damage);
	}
	
	public static BatZombie create(float x, float y)//percent chance to paralyze humans upgrade
    {
		

        // create the ship
		return new BatZombie(zombieRegions, x, y);
    }
	
	public static void loadAssets()
	{
		//if (zombieRegions == null) {
			zombieRegions = getZombieAtlas().findRegions( "Bat");
		//}
		//if (walkAnimation == null) {
			walkAnimation = new Animation( 0.2f, zombieRegions );
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
	public void blockZombie()
	{
		//do nothing bats fly over blockers!
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
	
	public static int getDamage()
	{
		return damage;
	}
	
	public static int getSpeed()
	{
		return speed;
	}
	

}