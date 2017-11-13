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

public class HealWitchZombie extends Zombie{
	
	//do class type and in zombie create stuff!
	private static int CLASSTYPE = 12;
	private static int startHealth = 500;
	private static int damage = 20;//does little damage heals
	private boolean madeCircle;
	private static int speed = 50;
	//heal circle
	private WitchHealCircle healCircle;
	//animation
	private static Array<AtlasRegion> zombieRegions;
	private static Map<TextureRegion,Drawable> zombieAnimDrawables;
	private static Animation walkAnimation;

	public HealWitchZombie(Array<AtlasRegion> animationRegions, float x, float y) {
		super(animationRegions, x, y);
		setClassType(CLASSTYPE);
		setHealth(startHealth);
		setSpeed(MathUtils.random(40, 60));
		setDamage(damage);
		madeCircle = false;
	}
	
	public static HealWitchZombie create(float x, float y)
    {
		

        // create the ship
		return new HealWitchZombie(zombieRegions, x, y);
    }
	
	public static void loadAssets()
	{
		//if (zombieRegions == null) {
			zombieRegions = getZombieAtlas().findRegions( "Witch");
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
		if (getMoving()){
			TextureRegion frame;
			frame = walkAnimation.getKeyFrame( walkStateTime += delta, true );
			setDrawable(zombieAnimDrawables.get(frame));
		}
	}
	
	@Override
	public void createDeadBody()
	{
		getStage().addActor(DeadBody.create(CLASSTYPE, getX(), getY(), getRotation()));
		if (healCircle != null){
			healCircle.destroy();
		}
	}
	
	@Override
    public void publicAct(float delta )
    {
		super.publicAct(delta);
		 if (!madeCircle){
			madeCircle = true;
			healCircle = WitchHealCircle.create(this.getX() + this.getWidth()/2, this.getY() + this.getHeight()/2);
			healCircle.setRotation(this.getRotation());
			this.getStage().addActor(healCircle);
		}
		 else if (healCircle != null){
			 healCircle.setPosition((this.getX() + this.getWidth()/2) - healCircle.getWidth()/2, (this.getY() + this.getHeight()/2) - healCircle.getHeight()/2);
			 healCircle.setRotation(this.getRotation());
		 }
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