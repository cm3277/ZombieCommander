package com.JustMoser.ZombieCommander.Tutorial;

import static com.badlogic.gdx.scenes.scene2d.actions.Actions.delay;
import static com.badlogic.gdx.scenes.scene2d.actions.Actions.fadeIn;
import static com.badlogic.gdx.scenes.scene2d.actions.Actions.fadeOut;
import static com.badlogic.gdx.scenes.scene2d.actions.Actions.sequence;

import com.JustMoser.ZombieCommander.Helper.LevelManager;
import com.JustMoser.ZombieCommander.ImageActors.AbstractImage;
import com.JustMoser.ZombieCommander.ImageActors.DialogBox;
import com.JustMoser.ZombieCommander.Screens.Levels.CtF.Pack1.CtFPack1Level1;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.actions.RepeatAction;
import com.badlogic.gdx.scenes.scene2d.ui.Label;

public class CtFTutorial extends Actor{
	
	private int tutorialLevel;
	private DialogBox dialogBox;
	private Label lblFlagHint;
	private Label lblReturnHint;
	private boolean nextTutStep;
	
	public CtFTutorial()
	{
		tutorialLevel = 0;
	}
	
	@Override
	public void act(float delta)
	{
		if (!AbstractImage.getPaused()){
			if (tutorialLevel == 0){
				doTut0();
			}
			else if (tutorialLevel == 1){
				doTut1();
			}
			else {
				doEndTut();
			}
		}
	}
	
	private void nextStep()
	{
		tutorialLevel++;
		nextTutStep = false;
	}
	
	private void doTut0()
	{
		if (dialogBox == null){
			dialogBox = new DialogBox(getStage().getWidth()/2,getStage().getHeight()/2,"Welcome! In Capture the Flag the objective is to" +
					" return the humans' flag to your base in the least amount of rounds!");
			this.getStage().addActor(dialogBox);
			//flag hint
			lblFlagHint = new Label("Flag", AbstractImage.getSkin());
			lblFlagHint.setColor(Color.RED);
			lblFlagHint.setPosition(CtFPack1Level1.getHumanFlagStand().getX() - lblFlagHint.getWidth()/2, CtFPack1Level1.getHumanFlagStand().getY() - lblFlagHint.getHeight()/2);
			lblFlagHint.addAction(getRepeatFade());
			this.getStage().addActor(lblFlagHint);
			
			//return hint
			lblReturnHint = new Label("Return", AbstractImage.getSkin());
			lblReturnHint.setColor(Color.RED);
			lblReturnHint.setPosition(CtFPack1Level1.getZombieFlagStand().getX() - lblReturnHint.getWidth()/2, CtFPack1Level1.getZombieFlagStand().getY() - lblReturnHint.getHeight()/2);
			lblReturnHint.addAction(getRepeatFade());
			this.getStage().addActor(lblReturnHint);
		}
		else if (!dialogBox.getActive()){
			//lblHint.remove();
			nextStep();
		}
	}
	
	private void doTut1()
	{
		if (nextTutStep == false){
			dialogBox.setText("Hint: Walk zombies into the flag and they will carry it! Then direct them back to the base to win! Watch out Humans will chase after the flag!");
			this.getStage().addActor(dialogBox);
			
			nextTutStep = true;
		}
		else if (!dialogBox.getActive()){
			//lblHint.remove();
			LevelManager.setTutorialFinished(LevelManager.getCaptureTheFlag());
			nextStep();
		}
	}
	
	private void doEndTut()
	{
		if (nextTutStep == false){
			if (AbstractImage.getZombieArray().size > 0){
				lblFlagHint.remove();
				lblReturnHint.remove();
			}	
		}
	}
	
	private Action getRepeatFade()
	{
		RepeatAction fade = new RepeatAction();
		fade.setCount(-1);
		fade.setAction(sequence( fadeIn( 0.5f ), delay( 1f ), fadeOut( 0.5f )));
		return fade;
	}

}
