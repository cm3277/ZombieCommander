package com.JustMoser.ZombieCommander.ImageActors;

import com.JustMoser.ZombieCommander.Helper.RoundHelper;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class BrokenChest extends AbstractImage{
	
	private static TextureRegion openChestRegion;
	private int numBrains;
	private float brainSpawnTimer = 0;
	private static float brainSpawnDelay = 0.4f;
	private boolean added = false;
	
	public BrokenChest(TextureRegion region, float x, float y)
	{
		super(region);
		this.setPosition(x, y);
		numBrains = RoundHelper.calcBonusBrains()/10;
		RoundHelper.addChestStarted();
	}
	
	public static BrokenChest create(float x, float y)
	{
		if (openChestRegion == null){
			openChestRegion = getZombieAtlas().findRegion( "OpenChest");
		}
		return new BrokenChest(openChestRegion, x, y);
	}
	
	public static void loadAssets()
	{
		//if (openChestRegion == null){
			openChestRegion = getZombieAtlas().findRegion( "OpenChest");
		//}
	}
	
	@Override
	public void publicAct(float delta)
	{
		if (numBrains > 0){
			if (brainSpawnTimer < brainSpawnDelay){
				brainSpawnTimer += delta;
			}
			else{
				this.getStage().addActor(Brain.create(this.getX() + this.getWidth()/2,
						this.getY() + this.getHeight()/2, 10, true));
				numBrains -= 1;
				brainSpawnTimer = 0;
			}
		}
		else if (!added){
			RoundHelper.addFinishedChest();
			added = true;
		}
	}

}
