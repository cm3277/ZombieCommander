package com.JustMoser.ZombieCommander.Screens.Levels.CtF.Pack1;

import com.JustMoser.ZombieCommander.Tyrian;
import com.JustMoser.ZombieCommander.Helper.LevelManager;
import com.JustMoser.ZombieCommander.Screens.AbstractScreen;
import com.JustMoser.ZombieCommander.Screens.MenuScreen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class CtFPack1LevelSelect extends AbstractScreen
{
	//private static Image backgroundImage;
	private int gameTypeId;
	private int packId;
	
    public CtFPack1LevelSelect(Tyrian game )
    {
        super( game );
        gameTypeId = LevelManager.getCaptureTheFlag();
        packId = LevelManager.getPackId(gameTypeId, 1);
    }
    
    @Override
    public void show()
    {
        super.show();

        // let's make sure the stage is clear
        //stage.clear();

        // and finally we add the actor to the stage
        stage.addActor( getMenuBackgroundImage() );
        
        //do table 
        getMenuTable();
        

    }
    
    private Table getMenuTable()
    {
    	//Make the Menu table
        Table table = super.getTable();
        table.clear();
        //table.setPosition(480/2, 800 * 0.8f);
        Label lblWelcome = new Label("CtF Level Selection", super.getSkin());
        lblWelcome.setWrap(true);
        lblWelcome.setAlignment(1);
        lblWelcome.setPosition(480*0.1f, 800 * 0.9f);
        //lblWelcome.setWidth(Gdx.app.getGraphics().getWidth());
        //table.add( lblWelcome ).expandX().fill().spaceBottom(50);
        //table.row();
        stage.addActor(lblWelcome);
        
        for (int i = 1; i < 6; i++){
        	//level buttons
            if (LevelManager.getLevel(gameTypeId, packId, LevelManager.getLevelId(i))){
            	if (i == 1)
            		table.add(getLevelButton(i)).padRight(25).padTop(100).padLeft(25).expand().fill().row().space(50);
            	else
            	table.add(getLevelButton(i)).padRight(25).padLeft(25).expand().fill().row().space(50);
            }
            else{
            	table.add(getNotUnlockedLabel(i)).row().space(50);
            }
        }
    	
    	final Button menuButton = new Button(super.getSkin());
    	menuButton.add("Exit to Menu");
    	table.add(menuButton).padRight(25).padLeft(25).padBottom(50).expand().fill();
    	
    	menuButton.addListener(new ClickListener() {
    		@Override
    		public void touchUp(InputEvent event,float x,float y,int pointer,int button)
            {
                super.touchUp( event, x, y, pointer, button );
                game.setScreen( new MenuScreen( game ) );
            }
    	});
    	return table;
    }
    
    private Label getNotUnlockedLabel(int level)
    {
    	Label lblUnlock = new Label("Level " + level + " Not Unlocked", super.getSkin());
    	lblUnlock.setColor(Color.RED);
    	lblUnlock.setWrap(true);
    	lblUnlock.setAlignment(1);
    	return lblUnlock;
    }
    
    private Button getLevelButton(int button)
    {
    	if (button == 1){
    		return getLevel1Button();
    	}
    	else if (button == 2){
    		return getLevel2Button();
    	}
    	else if (button == 3){
    		return getLevel3Button();
    	}
    	else if (button == 4){
    		return getLevel4Button();
    	}
    	else {
    		return getLevel5Button();
    	}
    }
    
    private Button getLevel1Button()
    {
    	final Button levelButton = new Button(super.getSkin());
    	levelButton.add("Level 1");
    	levelButton.setColor(Color.GREEN);
    	levelButton.addListener(new ClickListener() {
    		@Override
    		public void touchUp(InputEvent event,float x,float y,int pointer,int button)
            {
                super.touchUp( event, x, y, pointer, button );
                game.setScreen( new CtFPack1Level1( game ) );
            }
    	});
    	return levelButton;
    }
    
    private Button getLevel2Button()
    {
    	final Button levelButton = new Button(super.getSkin());
    	levelButton.add("Level 2");
    	levelButton.setColor(Color.BLUE);
    	levelButton.addListener(new ClickListener() {
    		@Override
    		public void touchUp(InputEvent event,float x,float y,int pointer,int button)
            {
                super.touchUp( event, x, y, pointer, button );
                game.setScreen( new CtFPack1Level2( game ) );
            }
    	});
    	return levelButton;
    }
    
    private Button getLevel3Button()
    {
    	final Button levelButton = new Button(super.getSkin());
    	levelButton.add("Level 3");
    	levelButton.setColor(Color.GREEN);
    	levelButton.addListener(new ClickListener() {
    		@Override
    		public void touchUp(InputEvent event,float x,float y,int pointer,int button)
            {
                super.touchUp( event, x, y, pointer, button );
                game.setScreen( new CtFPack1Level3( game ) );
            }
    	});
    	return levelButton;
    }
    
    private Button getLevel4Button()
    {
    	final Button levelButton = new Button(super.getSkin());
    	levelButton.add("Level 4");
    	levelButton.setColor(Color.BLUE);
    	levelButton.addListener(new ClickListener() {
    		@Override
    		public void touchUp(InputEvent event,float x,float y,int pointer,int button)
            {
                super.touchUp( event, x, y, pointer, button );
                game.setScreen( new CtFPack1Level4( game ) );
            }
    	});
    	return levelButton;
    }
    
    private Button getLevel5Button()
    {
    	final Button levelButton = new Button(super.getSkin());
    	levelButton.add("Level 5");
    	levelButton.setColor(Color.GREEN);
    	levelButton.addListener(new ClickListener() {
    		@Override
    		public void touchUp(InputEvent event,float x,float y,int pointer,int button)
            {
                super.touchUp( event, x, y, pointer, button );
                game.setScreen( new CtfPack1Level5( game ) );
            }
    	});
    	return levelButton;
    }
}