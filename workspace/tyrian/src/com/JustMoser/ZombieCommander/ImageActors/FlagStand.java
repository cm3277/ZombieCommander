package com.JustMoser.ZombieCommander.ImageActors;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;

public class FlagStand extends AbstractImage{
	
	private static TextureRegion flagStandRegion;
	private Rectangle body;
	
	public FlagStand(float x, float y, boolean zombie) {
		super(flagStandRegion);
		this.setPosition(x, y);
		body = new Rectangle(this.getX(), this.getY(), this.getWidth(), this.getHeight());
		if (zombie){
			this.setColor(Color.BLUE);
			setZombieFlagStand(this);
		}
		else
			this.setColor(Color.RED);
	}
	
	public static FlagStand createHumanStand(float x, float y )
	{
		
	        
	    return new FlagStand(x, y, false);
	}
	
	public static FlagStand createZombieStand(float x, float y )
	{
		
	    return new FlagStand(x, y, true);  
	}
	
	public static void loadAssets()
	{
		//if (flagStandRegion == null) {
			flagStandRegion = getZombieAtlas().findRegion( "FlagStand");
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

}
