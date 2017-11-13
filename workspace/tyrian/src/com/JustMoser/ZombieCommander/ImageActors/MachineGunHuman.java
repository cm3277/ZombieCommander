package com.JustMoser.ZombieCommander.ImageActors;

import com.JustMoser.ZombieCommander.Helper.Audio.SoundManager;
import com.JustMoser.ZombieCommander.Helper.Audio.SoundManager.SoundEffects;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

public class MachineGunHuman extends Human{
	
	//animation
	private static TextureRegion humanRegion;
	private static TextureRegionDrawable humanAnimDrawables;
	private float bulletDelay = 0.17f;
	private int maxAmmo = 60;

	public MachineGunHuman(TextureRegion animationRegion, float x, float y, boolean middle) 
	{
		super(animationRegion, x, y, middle);
		this.setBulletDelay(bulletDelay);
		this.setMaxAmmo(maxAmmo);
	}
	
	public static MachineGunHuman create(float x, float y)
    {
		
        return new MachineGunHuman(humanRegion, x, y, false);
    }
	
	public static MachineGunHuman createCenter(float x, float y)
    {
		
        return new MachineGunHuman(humanRegion, x, y, true);
    }
	
	public static void loadAssets()
	{
		//if (humanRegion == null) {
			humanRegion = getZombieAtlas().findRegion( "MachineGunHuman");
		//}
		//if (humanAnimDrawables == null) {
    		humanAnimDrawables = new TextureRegionDrawable(humanRegion);
    	//}
	}
	
	@Override
	public void setAnimation()
	{
		if (this.getDrawable() != humanAnimDrawables)
			setDrawable(humanAnimDrawables);
	}
	
	@Override
	public void createBullet()
	{
		SoundManager.play(SoundEffects.GUNSHOT, 1f);
		Bullet bullet = Bullet.createMachineGun(this.getX() + this.getWidth()/2, this.getY() + this.getHeight()/2);
		bullet.setRotation(getRotation());
		getStage().addActor(bullet);
	}

}
