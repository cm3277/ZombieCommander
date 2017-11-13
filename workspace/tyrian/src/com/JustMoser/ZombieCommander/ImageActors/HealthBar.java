package com.JustMoser.ZombieCommander.ImageActors;

import static com.badlogic.gdx.scenes.scene2d.actions.Actions.delay;
import static com.badlogic.gdx.scenes.scene2d.actions.Actions.fadeOut;
import static com.badlogic.gdx.scenes.scene2d.actions.Actions.sequence;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Action;

public class HealthBar extends AbstractImage{
	
	private static TextureRegion healthBarRegion;

	public HealthBar(TextureRegion animationRegion, float x, float y, float healthPercent, boolean fill) {
		super(animationRegion);
		if (fill)
			this.setColor(Color.GREEN);
		else
			this.setColor(Color.BLACK);
		this.setX(x);
		this.setY(y);
		if (fill)
			this.setScaleX(healthPercent);
		this.addAction( sequence( delay( 0.5f ), fadeOut( 0.5f ),
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
	
	public static HealthBar create(float x, float y, float healthPercent, boolean fill )
	{
	        
	    return new HealthBar(getHealthBarRegion(), x, y, healthPercent, fill);
	}
	
	public static HealthBar createBlue(float x, float y, float healthPercent, boolean fill )
	{   
		if (fill){
			HealthBar healthBar = new HealthBar(getHealthBarRegion(), x, y, healthPercent, fill);
			healthBar.setBlue();
			return healthBar;
		}
		else{
			return new HealthBar(getHealthBarRegion(), x, y, healthPercent, fill);
		}
	}
	
	private void setBlue()
	{
		this.setColor(Color.BLUE);
	}
	
	public static TextureRegion getHealthBarRegion()
	{
		
		return healthBarRegion;
	}
	
	public static void loadAssets()
	{
		//if (healthBarRegion == null) {
			healthBarRegion = getZombieAtlas().findRegion( "HealthBar");
		//}
	}

	private void destroy()
	{
		this.remove();
	}
}