package com.JustMoser.ZombieCommander.ImageActors;

import static com.badlogic.gdx.scenes.scene2d.actions.Actions.delay;
import static com.badlogic.gdx.scenes.scene2d.actions.Actions.fadeIn;
import static com.badlogic.gdx.scenes.scene2d.actions.Actions.fadeOut;
import static com.badlogic.gdx.scenes.scene2d.actions.Actions.sequence;

import com.JustMoser.ZombieCommander.Helper.ClassType;
import com.JustMoser.ZombieCommander.Helper.UpgradeManager;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.actions.RepeatAction;
import com.badlogic.gdx.utils.Array;

public class WitchHealCircle extends AbstractImage{
	
	private static TextureRegion cirlceRegion;
	private Rectangle healRect;
	private static int FOREVER = -1;
	private Array<Zombie> healedZombies;
	private boolean isAlive;
	private float scale = 1;
	private boolean setIndex = false; //add green fade in and out for zombies being healed + 2 second delay to unheal
	
	public WitchHealCircle(TextureRegion animationRegion, float x, float y) {
		super(animationRegion);
		this.scale = UpgradeManager.getUpgradedCustom(ClassType.getHealWitch(), this.scale);
		this.setScale(this.scale);
		setPosition(x, y);
		this.setOrigin(this.getWidth()/2, this.getHeight()/2);
		this.setColor(Color.GREEN);
		healedZombies = new Array<Zombie>();
		RepeatAction fade = new RepeatAction();
		fade.setCount(FOREVER);
		fade.setAction(sequence( fadeIn( 0.5f ), delay( 0.5f ), fadeOut( 0.5f )));
		this.addAction(fade);
		isAlive = true;
	}
	
	public static WitchHealCircle create(float x, float y)
    {
		
        // create the ship
		return new WitchHealCircle(cirlceRegion, x, y);
    }
	
	public static void loadAssets()
	{
		//if (cirlceRegion == null) {
			cirlceRegion = getZombieAtlas().findRegion( "WitchCircle");
		//}
	}
	
	public Rectangle getRect()
	{
		if (healRect == null){
			healRect = new Rectangle(this.getX(), this.getY(), this.getWidth()*1.2f, this.getHeight()*1.2f);
		}
		return healRect;
	}
	
	@Override
    public void publicAct(float delta )
    {
		if (isAlive){
			if (this.getStage() != null && !setIndex){
				this.setZIndex(5);
				setIndex = true;
			}
			this.getRect().setX(this.getX());
			this.getRect().setY(this.getY());
			for (Zombie zombie: getZombieArray()){
				if (zombie.getAlive()){
					if (getRect().overlaps(zombie.getRect())){
						if (!healedZombies.contains(zombie, true)){
							healedZombies.add(zombie);
							zombie.addHealCircle();
						}
					}
					else if (zombie.isHealing()){
						if (healedZombies.contains(zombie, true)){
							healedZombies.removeValue(zombie, true);
							zombie.minusHealCircle();
						}
					}
				}
			}
		}
    }
	
	public void destroy()
	{
		for (Zombie zombie: healedZombies){
			healedZombies.removeValue(zombie, true);
			zombie.minusHealCircle();
		}
		isAlive = false;
		this.remove();
	}

}
