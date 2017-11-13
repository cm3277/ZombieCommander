package com.JustMoser.ZombieCommander.ImageActors.Blockers;

import com.JustMoser.ZombieCommander.Helper.RoundHelper;
import com.JustMoser.ZombieCommander.ImageActors.BrokenChest;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Chest extends Blocker{
	
	private static TextureRegion chestRegion;
	private static int fullHealth = 1000;
	
	public Chest(float x, float y) {
		super(chestRegion, x, y);
		setHealth(fullHealth);
		RoundHelper.addChest();
	}
	
	public static Chest create(float x, float y )
	    {
	        
	        return new Chest(x, y);
	    }
	
	public static void loadAssets()
	{
		//if (chestRegion == null) {
			chestRegion = getZombieAtlas().findRegion( "Chest");
		//}
	}
	
	@Override
	public void destroy()
	{
		this.getStage().addActor(BrokenChest.create(this.getX(), this.getY()));
		super.destroy();
	}
}