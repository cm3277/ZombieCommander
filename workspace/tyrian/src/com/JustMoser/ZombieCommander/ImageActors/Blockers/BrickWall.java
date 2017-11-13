package com.JustMoser.ZombieCommander.ImageActors.Blockers;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Polygon;

public class BrickWall extends Blocker{
	
	private static TextureRegion brickWallRegion;
	
	public BrickWall(float x, float y) {
		super(brickWallRegion, x, y);
		polyBody = new Polygon(new float[]{0,0,this.getWidth(),0,this.getWidth(),this.getHeight(),0,this.getHeight()});
		polyBody.setOrigin(this.getWidth()/2, this.getHeight()/2);
		this.setBrick(true);
	}
	
	public static BrickWall create(float x, float y )
	    {
			
	        
	        return new BrickWall(x, y);
	    }
	
	public static void loadAssets()
	{
		//if (brickWallRegion == null) {
			brickWallRegion = getZombieAtlas().findRegion( "BrickWall");
		//}
	}
	
	@Override
	public void hurt(int damage)
	{
		//do nothing brick walls can't get hurt!
	}
	
	@Override
	public void setOrigin(float x, float y)
	{
		super.setOrigin(x, y);
		if (polyBody != null)
			polyBody.setOrigin(x, y);
	}
}