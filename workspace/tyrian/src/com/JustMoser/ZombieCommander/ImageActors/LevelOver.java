package com.JustMoser.ZombieCommander.ImageActors;

import com.JustMoser.ZombieCommander.Helper.LevelManager;
import com.JustMoser.ZombieCommander.Helper.ProfileManager;
import com.JustMoser.ZombieCommander.Helper.RoundHelper;
import com.JustMoser.ZombieCommander.Helper.Audio.MusicManager;
import com.JustMoser.ZombieCommander.Helper.Audio.MusicManager.CustomMusic;
import com.JustMoser.ZombieCommander.Screens.AbstractScreen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class LevelOver extends AbstractImage{
	
	private static Image background;
	private static Table statTable;
	private static Label lblRounds;
	private static Label lblBrains;
	private static Label lblBonusBrains;
	private static Label lblTotalBrains;
	private static Label lblNewUnlock;
	
	public static void enable()
	{
		getBackgroundImage().setVisible(true);
		getBackgroundImage().toFront();
		getStatTable().setVisible(true);
		getStatTable().toFront();
		setPaused(true);
		MusicManager.play(CustomMusic.MENUMUSIC);
	}
	
	/*private static void disable()
	{
		getBackgroundImage().setVisible(false);
		getStatTable().setVisible(false);
	}*/
	
	private static Image getBackgroundImage()
    {
    	if (background == null) {
    		background = new Image(getMenuBackgroundRegion());
    		background.setVisible(true);
    		//background.setColor(Color.BLACK);
    		background.setFillParent(true);
    	}
    	if (!getStaticStage().getActors().contains(background, true)){
			getStaticStage().addActor(background);
		}
    	return background;
    }
	
	private static Table getStatTable()
    {
        if( statTable == null ) {
        	statTable = new Table(getSkin());
        	statTable.setVisible(false);
        	statTable.setFillParent(true);
        	statTable.add("").row();
        	statTable.add("Level Completed!").padTop(50).space(100).row(); //okay button to return to level select screen, maybe more stats later
        	//Rounds Label
        	//statTable.add("Humans Killed in " + RoundHelper.getCurrentRound() + " rounds!").space(100);
        	lblRounds = new Label("Kills!", getSkin()); // is set farther down
        	lblRounds.setFontScale(RoundHelper.getFontScale(25));
        	lblRounds.setWrap(true);
        	lblRounds.setAlignment(1);
        	statTable.add(lblRounds).expandX().fill().row();
        	//label for brains earned
        	lblBrains = new Label("Brains!", getSkin()); //is set farther down
        	lblBrains.setFontScale(RoundHelper.getFontScale(25));
        	lblBrains.setWrap(true);
        	lblBrains.setAlignment(1);
        	statTable.add(lblBrains).expandX().fill().row();
        	//label for Bonus brains earned
	        lblBonusBrains = new Label("Bonus Brains!", getSkin()); //is set farther down
	        lblBonusBrains.setFontScale(RoundHelper.getFontScale(25));
	        lblBonusBrains.setWrap(true);
	        lblBonusBrains.setAlignment(1);
	        statTable.add(lblBonusBrains).expandX().fill().row();
        	//Total brains
        	lblTotalBrains = new Label("Brains!", getSkin()); //is set farther down
        	lblTotalBrains.setFontScale(RoundHelper.getFontScale(25));
        	lblTotalBrains.setWrap(true);
        	lblTotalBrains.setAlignment(1);
        	statTable.add(lblTotalBrains).expandX().fill().row();
        	//New Unlocked level?
	        lblNewUnlock = new Label("NEW! Next Level Unlocked!", getSkin()); //is set farther down
	        lblNewUnlock.setFontScale(RoundHelper.getFontScale(25));
	        lblNewUnlock.setWrap(true);
	        lblNewUnlock.setAlignment(1);
	        statTable.add(lblNewUnlock).expandX().fill().row();
	        Button leaderBoardsButton = new Button(AbstractImage.getSkin());
	        leaderBoardsButton.add("View Level " + RoundHelper.getLevel() + "'s LeaderBoard");
	        leaderBoardsButton.setColor(Color.GREEN);
	        statTable.add(leaderBoardsButton).padRight(25).padLeft(25).space(20).expand().fill().row();
	        leaderBoardsButton.addListener(new ClickListener() {
	    		@Override
	    		public void touchUp(InputEvent event,float x,float y,int pointer,int button)
	            {
	                super.touchUp( event, x, y, pointer, button );
	                RoundHelper.doLeaderBoards(false);
	            }
	    	});
	        
        	statTable.add(AbstractScreen.getNextLevelButton()).padRight(25).padLeft(25).space(20).expand().fill().row();
        }
        if (!getStaticStage().getActors().contains(statTable, true)){
			getStaticStage().addActor(statTable);
		}
        if (RoundHelper.getGameTypeId() == LevelManager.getSlayer()){
        	lblRounds.setText("Humans Killed in " + RoundHelper.getCurrentRound() + " rounds!");
        }
        else if (RoundHelper.getGameTypeId() == LevelManager.getCaptureTheFlag()){
        	lblRounds.setText("Flag Captured in " + RoundHelper.getCurrentRound() + " rounds!");
        }
        else{
        	lblRounds.setText("Chests Destroyed in " + RoundHelper.getCurrentRound() + " rounds!");
        }
        lblBonusBrains.setText("Bonus Brains for completing level: " + RoundHelper.calcBonusBrains() + "!");
        lblBrains.setText("Brains net change this Level " + (ProfileManager.getProfile().getNumBrains() - RoundHelper.getStartLevelBrains()) + "!");
        lblTotalBrains.setText("Total brains earned this level " + RoundHelper.getBrainsEarned() + "!");
        if (RoundHelper.getNewUnlock()){
        	lblNewUnlock.setText("NEW! Next Level Unlocked!");
        }
        else{
        	lblNewUnlock.setText("");
        }
            return statTable;
    }

}
