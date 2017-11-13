package com.JustMoser.ZombieCommander.ImageActors.Blockers;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Sandbag extends Blocker{
	
	private static TextureRegion sandbagRegion;
	
	public Sandbag(float x, float y) {
		super(sandbagRegion, x, y);
		
	}
	
	public static Sandbag create(float x, float y )
	    {
			
	        
	        return new Sandbag(x, y);
	    }
	
	public static void loadAssets()
	{
		//if (sandbagRegion == null) {
			sandbagRegion = getZombieAtlas().findRegion( "Sandbags");
		//}
	}
}