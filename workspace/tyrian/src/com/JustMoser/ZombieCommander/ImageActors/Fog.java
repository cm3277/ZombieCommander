package com.JustMoser.ZombieCommander.ImageActors;

import static com.badlogic.gdx.scenes.scene2d.actions.Actions.fadeOut;
import static com.badlogic.gdx.scenes.scene2d.actions.Actions.sequence;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Action;

public class Fog extends AbstractImage{
	
	private static TextureRegion fogRegion;
	private boolean active;
	private Rectangle body;
	private boolean checked = false;
	private float rotationValue;
	
	public Fog(TextureRegion region, float x, float y)
	{
		super(region);
		this.setPosition(x, y);
		this.setOrigin(getWidth()/2, getHeight()/2);
		body = new Rectangle(x,y, getWidth()*0.8f,getHeight()*0.8f);
		active = true;
		getFogArray().add(this);
		rotationValue = MathUtils.random(-2, 2);
		if (rotationValue >= 0)
			rotationValue += 1;
		else
			rotationValue -= 1;
	}
	
	public static Fog create(float x, float y)
	{
		
		return new Fog(fogRegion, x, y);
	}
	
	public static void loadAssets()
	{
		//if (fogRegion == null){
			fogRegion = getZombieAtlas().findRegion( "Fog");
		//}
	}
	
	@Override
	public void publicAct(float delta)
	{
		if (active)
		{
			if (!checked){
				checkSpawnCollision();
				checked = true;
			}
			checkZombieCollisions();
			slowRotate();
		}
	}
	
	private void slowRotate()
	{
		this.setRotation(getRotation() + rotationValue);
	}
	
	private void checkZombieCollisions()
	{
		for (Zombie zombie: getZombieArray()){
			if (zombie.getAlive()){
				if (this.body.overlaps(zombie.getRect())){
					fadeAway();
				}
			}
		}
	}
	
	public void fadeAway()
	{
		active = false;
		getFogArray().removeValue(this, true);
		this.addAction( sequence( fadeOut( 1.5f ),
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
	
	private void checkSpawnCollision()
	{
		for (ZombieSpawn zSpawn: getZombieSpawnArray()){
			if (this.body.overlaps(zSpawn.getRect())){
				fadeAway();
			}
		}
	}
	
	private void destroy()
	{
		this.remove();
	}
	
	public boolean isActive()
	{
		return active;
	}
	
	public Rectangle getRect()
	{
		return body;
	}
}
