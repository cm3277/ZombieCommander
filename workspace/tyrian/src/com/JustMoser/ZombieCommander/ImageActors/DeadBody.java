package com.JustMoser.ZombieCommander.ImageActors;

import static com.badlogic.gdx.scenes.scene2d.actions.Actions.delay;
import static com.badlogic.gdx.scenes.scene2d.actions.Actions.fadeOut;
import static com.badlogic.gdx.scenes.scene2d.actions.Actions.sequence;

import com.JustMoser.ZombieCommander.Helper.ClassType;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Action;

public class DeadBody extends AbstractImage{
	
	private static TextureRegion zombieDead;
	private static TextureRegion meatheadDead;
	private static TextureRegion assassinDead;
	private static TextureRegion spiderDead;
	private static TextureRegion batDead;
	private static TextureRegion riderDead;
	private static TextureRegion humanDead;
	private boolean setIndex = false;
	
	public DeadBody(TextureRegion bodyRegion, float x, float y, float rotation) {
		super(bodyRegion);
		//humanAnimDrawables = getHumanAnimDrawable();
		this.setOrigin(getWidth()/2, getHeight()/2);
		this.setX(x);
		this.setY(y);
		this.setRotation(rotation);
		this.addAction( sequence( delay( 0.6f ), fadeOut( 1f ),
	            new Action() {
	                @Override
	                public boolean act(
	                    float delta )
	                {
	                    // the last action will remove object
	                    destroy();
	                    return true;
	                }
	            } ) );
	            
		
	}
	
	public DeadBody(TextureRegion bodyRegion, float x, float y, float rotation, int classType) 
	{
		this(bodyRegion, x, y, rotation);
		if (ClassType.isMiniSpider(classType)){
			this.setScale(0.3f);
			this.setColor(Color.BLACK);
		}
		else if (ClassType.isGrayZombie(classType)){
			this.setColor(Color.GRAY);
		}
	}
	
	public static DeadBody create(int classType, float x, float y, float rotation )
	    {
			if (ClassType.isZombie(classType)){
				//if (zombieDead == null) {
				//	zombieDead = getZombieAtlas().findRegion( "ZombieDead");
				//}
				return new DeadBody(zombieDead, x, y, rotation);
			}
			else if (ClassType.isMeatHead(classType)){
				//if (meatheadDead == null) {
				//	meatheadDead = getZombieAtlas().findRegion( "MeatHeadDead");
				//}
				return new DeadBody(meatheadDead, x, y, rotation);
			}
			else if (ClassType.isAssassin(classType)){
				
				return new DeadBody(assassinDead, x, y, rotation);
			}
			else if (ClassType.isSpider(classType)){
				
				return new DeadBody(spiderDead, x, y, rotation);
			}
			else if (ClassType.isBat(classType)){
				
				return new DeadBody(batDead, x, y, rotation);
			}
			else if (ClassType.isRider(classType)){
				
				return new DeadBody(riderDead, x, y, rotation);
			}
			else if (ClassType.isMiniSpider(classType)){
				
				return new DeadBody(spiderDead, x, y, rotation, classType);
			}
			else if (ClassType.isGrayZombie(classType)){
				
				return new DeadBody(zombieDead, x, y, rotation, classType);
			}
			else if (ClassType.isHuman(classType)){
				
				return new DeadBody(humanDead, x, y, rotation);
			}
			else{
				
				return new DeadBody(zombieDead, x, y, rotation);
			}
	    }
	
	public static void loadAssets()
	{
		//if (ClassType.isZombie(classType)){
		//	if (zombieDead == null) {
				zombieDead = getZombieAtlas().findRegion( "ZombieDead");
		//	}
		//	return new DeadBody(zombieDead, x, y, rotation);
		//}
		//else if (ClassType.isMeatHead(classType)){
		//	if (meatheadDead == null) {
				meatheadDead = getZombieAtlas().findRegion( "MeatHeadDead");
		//	}
		//	return new DeadBody(meatheadDead, x, y, rotation);
		//}
		//else if (ClassType.isAssassin(classType)){
		//	if (assassinDead == null) {
				assassinDead = getZombieAtlas().findRegion( "AssassinDead");
		//	}
		//	return new DeadBody(assassinDead, x, y, rotation);
		//}
		//else if (ClassType.isSpider(classType)){
		//	if (spiderDead == null) {
				spiderDead = getZombieAtlas().findRegion( "SpiderDead");
		//	}
		//	return new DeadBody(spiderDead, x, y, rotation);
		//}
		//else if (ClassType.isBat(classType)){
		//	if (batDead == null) {
				batDead = getZombieAtlas().findRegion( "BatDead");
		//	}
		//	return new DeadBody(batDead, x, y, rotation);
		//}
		//else if (ClassType.isRider(classType)){
		//	if (riderDead == null) {
				riderDead = getZombieAtlas().findRegion( "RiderDead");
		//	}
		//	return new DeadBody(riderDead, x, y, rotation);
		//}
		//else if (ClassType.isMiniSpider(classType)){
		//	if (spiderDead == null) {
				spiderDead = getZombieAtlas().findRegion( "SpiderDead");
		//	}
		//	return new DeadBody(spiderDead, x, y, rotation, classType);
		//}
		//else if (ClassType.isGrayZombie(classType)){
		//	if (zombieDead == null) {
		//	}
		//	return new DeadBody(zombieDead, x, y, rotation, classType);
		//}
		//else if (ClassType.isHuman(classType)){
		//	if (humanDead == null) {
				humanDead = getZombieAtlas().findRegion( "HumanDead");
		//	}
		//	return new DeadBody(humanDead, x, y, rotation);
		//}
		//else{
		//	if (zombieDead == null) {
		//		zombieDead = getZombieAtlas().findRegion( "ZombieDead");
		//	}
	}
	
	@Override
    public void publicAct(float delta )
    {
		if (this.getStage() != null && !setIndex){
			this.setZIndex(5);
			setIndex = true;
		}
    }

	private void destroy()
	{
		this.remove();
	}
}