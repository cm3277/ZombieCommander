package com.JustMoser.ZombieCommander.ImageActors;

import java.util.HashMap;
import java.util.Map;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Array;

public class Explosion extends AbstractImage{
	//Finish up explosion animations + add to death of banger + damage
	//animation
	private static Array<AtlasRegion> explosionRegions;
	private static Map<TextureRegion,Drawable> explosionAnimDrawables;
	private static Animation explosionAnimation;
	private static float ANIMATIONTIME = 0.08F;
	//private static int damage = 25;
	public float walkStateTime;
	private boolean isExploding;
	//private Rectangle explosionBody;
	//private boolean hasDamaged;

	public Explosion(Array<AtlasRegion> animationRegions, float x, float y, float rotation) {
		super(animationRegions.get(0));
		setPosition(x, y);
		setRotation(rotation);
		//explosionBody = new Rectangle(x,y, getWidth(),getHeight());
		walkStateTime = 0;
		isExploding = true;
		//hasDamaged = false;
	}
	
	public static Explosion create(float x, float y, float rotation)
    {
		

        // create the ship
		return new Explosion(explosionRegions, x, y, rotation);
    }
	
	public static void loadAssets()
	{
		//if (explosionRegions == null) {
			explosionRegions = getZombieAtlas().findRegions( "Explosion");
		//}
		//if (explosionAnimation == null) {
			explosionAnimation = new Animation( ANIMATIONTIME, explosionRegions );
		//}
		//if (explosionAnimDrawables == null) {
			explosionAnimDrawables = new HashMap<TextureRegion,Drawable>();
    		for( AtlasRegion region : explosionRegions ) {
    			explosionAnimDrawables.put( region, new TextureRegionDrawable( region ) );
    		}
    	//}
	}
	
	@Override
	public void act(float delta)
	{
		if (isExploding){
			animateExplosion(delta);
			//if (!hasDamaged)
				//damage();
		}
	}
	
	/*private void damage()
	{
		explosionBody = new Rectangle(this.getX() + this.getWidth()/2,this.getY() + this.getHeight()/2, getWidth()*1.5f,getHeight()*1.5f);
		for (Human human: getHumanArray()){
			if (explosionBody.overlaps(human.getRect())){
				human.hurt(damage);
			}
		}
		for (Blocker blocker: getBlockersArray()){
			if (explosionBody.overlaps(blocker.getRect())){
				blocker.hurt(damage);
			}
		}
		hasDamaged = true;
	}
	*/
	
	private void animateExplosion(float delta)
	{
		if (!explosionAnimation.isAnimationFinished(walkStateTime)){
			TextureRegion frame;
				frame = explosionAnimation.getKeyFrame( walkStateTime += delta, false );
				setDrawable(explosionAnimDrawables.get(frame));
		}
		else{
			destroy();
		}
	}
	
	private void destroy()
	{
		isExploding = false;
		this.remove();
	}

}