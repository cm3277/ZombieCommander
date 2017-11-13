package com.JustMoser.ZombieCommander.ImageActors;

import com.JustMoser.ZombieCommander.Helper.ClassType;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;

public class Flag extends AbstractImage{
	
	private static TextureRegion flagRegion;
	private Rectangle body;
	private boolean isCarried;
	private Zombie zombieCarrier;
	
	public Flag(float x, float y) {
		super(flagRegion);
		this.setOrigin(getWidth()/2, getHeight()/2);
		this.setPosition(x, y);
		body = new Rectangle(this.getX(), this.getY(), this.getWidth(), this.getHeight());
		isCarried = false;
		setFlag(this);
	}
	
	public static Flag create(float x, float y )
	{
		
	        
	    return new Flag(x, y);
	}
	
	public static void loadAssets()
	{
		//if (flagRegion == null) {
			flagRegion = getZombieAtlas().findRegion( "Flag");
		//}
	}
	
	public Rectangle getRect()
	{
		if (body.getX() != this.getX())
			body.setX(this.getX());
		if (body.getY() != this.getY())
			body.setY(this.getY());
		return body;
	}
	
	@Override
    public void publicAct(float delta )
    {
		if (!isCarried){
			checkCarrier();
		}
		else{
			matchZombie();
		}
			
    }
	
	private void checkCarrier()
	{
		for (Zombie zombie: getZombieArray()){
			if (zombie.getAlive() && !ClassType.isBat(zombie.getClassType())){
				if (this.getRect().overlaps(zombie.getRect())){
					isCarried = true;
					zombieCarrier = zombie;
					this.toFront();
				}
			}
		}
	}
	
	private void matchZombie()
	{
		if (zombieCarrier.getAlive()){
			if (this.getX() != zombieCarrier.getX() + zombieCarrier.getWidth()/2)
				this.setX(zombieCarrier.getX() + zombieCarrier.getWidth()/2);
			if (this.getY() != zombieCarrier.getY() + zombieCarrier.getHeight()/2)
				this.setY(zombieCarrier.getY() + zombieCarrier.getHeight()/2);
			//if (this.getRotation() != zombieCarrier.getRotation())
				//this.setRotation(zombieCarrier.getRotation());
		}
		else{
			isCarried = false;
		}
	}
	
	public boolean getIsCarried()
	{
		return isCarried;
	}
	
	public Zombie getZombieCarrier()
	{
		return zombieCarrier;
	}

}