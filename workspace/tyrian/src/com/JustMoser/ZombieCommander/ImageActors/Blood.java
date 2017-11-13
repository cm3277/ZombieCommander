package com.JustMoser.ZombieCommander.ImageActors;

import static com.badlogic.gdx.scenes.scene2d.actions.Actions.delay;
import static com.badlogic.gdx.scenes.scene2d.actions.Actions.fadeOut;
import static com.badlogic.gdx.scenes.scene2d.actions.Actions.sequence;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Action;

public class Blood extends AbstractImage{

	private static TextureRegion bloodRegion;
	
	public Blood(float x, float y, float rotation) {
		super(bloodRegion);
		//humanAnimDrawables = getHumanAnimDrawable();
		this.setOrigin(getWidth()/2, getHeight()/2);
		this.setX(x);
		this.setY(y);
		this.setRotation(rotation);
		this.addAction( sequence( delay( 0.1f ), fadeOut( 0.75f ),
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
	
	public static Blood create(float x, float y, float rotation )
	{
	        
	        return new Blood(x, y, rotation);
	}
	
	public static void loadAssets()
	{
		//if (bloodRegion == null) {
			bloodRegion = getZombieAtlas().findRegion( "blood");
		//}
	}

	private void destroy()
	{
		this.remove();
	}
}