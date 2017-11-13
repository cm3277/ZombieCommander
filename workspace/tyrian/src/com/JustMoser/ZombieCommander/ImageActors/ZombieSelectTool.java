package com.JustMoser.ZombieCommander.ImageActors;

import static com.badlogic.gdx.scenes.scene2d.actions.Actions.fadeIn;
import static com.badlogic.gdx.scenes.scene2d.actions.Actions.fadeOut;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class ZombieSelectTool extends AbstractImage{
	
	private static Vector2 position;
	private static Vector2 draggedPos;
	private static boolean released = false;
	private static boolean bounds = false;
	private static Rectangle selectBox;
	private static int selectedZombiesNum = 0;
	private static TextureRegion selectToolRegion;
	private static float unPausedCounter = 0f;
	private static float unPausedDelay = 0.4f;

	public ZombieSelectTool(Vector2 pos) {
		super(selectToolRegion);
		this.setVisible(false);
		position = pos;
		draggedPos = new Vector2();
		setPosition(position.x, position.y);
		selectBox = new Rectangle();
	}
	
	public static ZombieSelectTool create(Vector2 pos)
	    {
			
	        return new ZombieSelectTool(pos);
	    }
	
	public static void loadAssets()
	{
		//if (selectToolRegion == null) {
			selectToolRegion = getZombieAtlas().findRegion( "SelectTool");
		//}
	}

	@Override
    public void publicAct(float delta )//finish with this, change y to screen cords? not sure...
    {
		if (unPausedCounter <= unPausedDelay){
			unPausedCounter += delta;
			if (bounds)
				bounds = false;
			if (released)
				released = false;
		}
		else if (bounds){
			if (position.x > draggedPos.x)
				setX(draggedPos.x);
			else
				setX(position.x);
			if (position.y > draggedPos.y)
				setY(draggedPos.y);
			else
				setY(position.y);
			//setPosition(position.x, position.y);
			this.setScaleX(Math.abs(draggedPos.x - position.x)/50);
			this.setScaleY(Math.abs(draggedPos.y - position.y)/50);
			setVisible(true);
			this.toFront();
			selectBox.set(this.getX(), this.getY(), this.getWidth()*getScaleX(), this.getHeight()*getScaleY());
			zombieSelect();
			bounds = false;
		}
		if (released){
			setVisible(false);
			if (selectedZombiesNum > 0){
				if (!ZombieTarget.getSelectTextImage().isVisible())
					ZombieTarget.getSelectTextImage().setVisible(true);
				ZombieTarget.getSelectTextImage().addAction(fadeIn(0.5f));
				ZombieTarget.getSelectTextImage().toFront();
				ZombieTarget.setQuickTargetEnabled();
			}
			else{
				ZombieTarget.getSelectTextImage().addAction(fadeOut(0.5f));
				getZombieNeedTargetArray().clear();
				if (selectedZombiesNum < 0)
					selectedZombiesNum = 0;
			}
			released = false;
		}
    }
	
	
	public static void isTouched(float x, float y)
	{
		if (!getPaused()){
			position.set(x, y);
		}
		//look for double tap and set Targets, get zombies selected int 
	}
	
	public static void isDragged(float x, float y)
	{
		if (!getPaused()){
			draggedPos.set(x, y);
			bounds = true;
		}
	}
	
	public static void isReleased()
	{
		released = true;
	}
	
	public static void resetSelectedZombiesNum()
	{
		selectedZombiesNum = 0;
	}
	
	public static void resetUnPausedCounter()
	{
		unPausedCounter = 0f;
		bounds = false;
	}
	
	private void zombieSelect()
	{
		for (Zombie z1 : getZombieArray()){
			if (this.isVisible()){
				if (selectBox.overlaps(z1.getRect())){
					if (!z1.getSelected()){
						z1.selectZombie();
						selectedZombiesNum++;
					}
				}
				else{
					if (z1.getSelected()){
						z1.deSelectZombie();
						selectedZombiesNum--;
					}
				}
			}
		}
	}
	
}