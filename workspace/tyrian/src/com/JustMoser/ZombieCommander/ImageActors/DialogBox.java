package com.JustMoser.ZombieCommander.ImageActors;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class DialogBox extends AbstractImage{
	
	private Table textTable;
	private String dialogString;
	private boolean isActive;
	private Label lblText;
	
	public DialogBox(float f, float g, String dialogString)
	{
		super(HealthBar.getHealthBarRegion());
		this.setColor(Color.WHITE);
		this.setSize(450, 400);
		this.setPosition(f, g);
		this.dialogString = dialogString;
		setPaused(true);
		isActive = true;
		this.toFront();
	}
	
	@Override
	public void act(float delta)
	{
		if (isActive){
			if (textTable == null){
				this.getStage().addActor(getTextTable());
			}
		}
	}
	
	private Table getTextTable()
    {
    	if (textTable == null){
    		textTable = new Table(getSkin());
    		textTable.setPosition(this.getX(), this.getY());
    		textTable.setWidth(this.getWidth());
    		textTable.setHeight(this.getHeight());
    		lblText = new Label(dialogString, super.getSkin());
    		//lblText.setFontScale(RoundHelper.getFontScale(35));
    		lblText.setColor(Color.BLACK);
    		lblText.setWrap(true);
    		lblText.setAlignment(1);
	    	textTable.add( lblText ).expandX().fill().space(10).row();
	    	
	    	Button okayButton = new Button(super.getSkin());
	    	Label lblOk = new Label("OK", super.getSkin());
	    	//lblOk.setFontScale(RoundHelper.getFontScale(35));
	    	okayButton.add(lblOk);
	    	okayButton.setColor(Color.GREEN);
	    	textTable.add(okayButton).padRight(25).padLeft(25).padBottom(10).expand().fill().row();
	    	
	    	okayButton.addListener(new ClickListener() {
	    		@Override
	    		public void touchUp(InputEvent event,float x,float y,int pointer,int button)
	            {
	                super.touchUp( event, x, y, pointer, button );
	                destroy();
	            }
	    	});
	    	textTable.toFront();
	    	
    	}
    	return textTable;
    }
	
	private void destroy()
	{
		isActive = false;
		setPaused(false);
		getTextTable().remove();
		textTable = null;
		this.remove();
	}
	
	public boolean getActive()
	{
		return isActive;
	}
	
	public void setText(String dialog)
	{
		dialogString = dialog;
		setPaused(true);
		isActive = true;
	}
	
	@Override
	public void setPosition(float x, float y)
	{
		this.setX(x - 450/2);
		this.setY(y - 400/2);
	}

	
}
