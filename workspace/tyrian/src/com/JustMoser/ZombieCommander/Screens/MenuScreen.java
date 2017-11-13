package com.JustMoser.ZombieCommander.Screens;

import com.JustMoser.ZombieCommander.Tyrian;
import com.JustMoser.ZombieCommander.Helper.ProfileManager;
import com.JustMoser.ZombieCommander.Helper.Audio.MusicManager;
import com.JustMoser.ZombieCommander.Helper.Audio.MusicManager.CustomMusic;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.swarmconnect.Swarm;

public class MenuScreen extends AbstractScreen
{
	private Image backgroundImage;
	//private Image warningBackground;
	private Table menuTable;
	private Table warningTable;
	private boolean profileCreated;
	private boolean extraWarning;
	private Label lblWarning;
	
    public MenuScreen(Tyrian game )
    {
        super( game );
    }
    
    @Override
    public void show()
    {
        super.show();

        // let's make sure the stage is clear
        stage.clear();

        //black background
        stage.addActor( getBackgroundImage() );
        
        
        //Make the Menu table
        menuTable = super.getTable();
        menuTable.clear();
        //Label lblWelcome = new Label("Welcome to Zombie Commander for Android!", super.getSkin());
        //lblWelcome.setWrap(true);
        //lblWelcome.setAlignment(1);
        //lblWelcome.setWidth(Gdx.app.getGraphics().getWidth());
        //menuTable.add( lblWelcome ).padTop(50).expandX().fill().spaceBottom(50);
        menuTable.row();
    	final Button b1 = new Button(super.getSkin());
    	b1.add("Select Gametype");
    	b1.setColor(Color.GREEN);
    	menuTable.add(b1).padRight(25).padLeft(25).padTop(stage.getHeight()*0.3f).expand().fill().row();
    	
    	b1.addListener(new ClickListener() {
    		@Override
    		public void touchUp(InputEvent event,float x,float y,int pointer,int button)
            {
                super.touchUp( event, x, y, pointer, button );
                game.setScreen( new WorldSelectScreen( game ) );
            }
    	});
    	
    	//swarm buttons!
    	Button achievementsButton = new Button(super.getSkin());
    	achievementsButton.add("View Achievements");
    	achievementsButton.setColor(Color.BLUE);
    	menuTable.add(achievementsButton).padRight(25).padLeft(25).space(20).expand().fill().row();
    	
    	achievementsButton.addListener(new ClickListener() {
    		@Override
    		public void touchUp(InputEvent event,float x,float y,int pointer,int button)
            {
                super.touchUp( event, x, y, pointer, button );
                Swarm.showAchievements();
            }
    	});
    	
    	Button leaderBoardsButton = new Button(super.getSkin());
        leaderBoardsButton.add("View Leaderboards");
        leaderBoardsButton.setColor(Color.RED);
        menuTable.add(leaderBoardsButton).padRight(25).padLeft(25).space(20).expand().fill().row();
        leaderBoardsButton.addListener(new ClickListener() {
    		@Override
    		public void touchUp(InputEvent event,float x,float y,int pointer,int button)
            {
                super.touchUp( event, x, y, pointer, button );
                Swarm.showLeaderboards();
            }
    	});
    	
    	Button profileButton = new Button(super.getSkin());
    	Label lblDelete = new Label("Delete Saved Progress", super.getSkin());
    	lblDelete.setWrap(true);
    	lblDelete.setAlignment(1);
    	profileButton.add(lblDelete).expandX().fill();
    	menuTable.add(profileButton).padRight(25).padLeft(25).padBottom(50).space(20).expand().fill();
    	
    	profileButton.addListener(new ClickListener() {
    		@Override
    		public void touchUp(InputEvent event,float x,float y,int pointer,int button)
            {
                super.touchUp( event, x, y, pointer, button );
                enableWarningTable();
            }
    	});
    	
    	//stage.addActor(menuTable);
    	//getBackgroundImage().toFront();
    	
    	//Menu Music!
    	MusicManager.play(CustomMusic.MENUMUSIC);
    	
    	//Google Play game services login
    	//GameServices.enableSignIOTable(stage);
    	//Tyrian.getIActivityRequestHandler().enableSignIOTableHandle();

    }
    
    private void enableWarningTable()
    {
    	profileCreated = false;
    	extraWarning = false;
    	menuTable.setVisible(false);
    	//backgroundImage.setColor(Color.RED);
    	if (lblWarning != null)
    		lblWarning.setText("This will delete any previously saved game progress. Are you sure you want to continue?");
    	stage.addActor( getMenuBackgroundImage() );
    	getWarningTable().setVisible(true);
    	getWarningTable().toFront();
    }
    
    private void disableWarningTable()
    {
    	//backgroundImage.setColor(Color.BLACK);
    	getMenuBackgroundImage().remove();
    	getWarningTable().setVisible(false);
    	menuTable.setVisible(true);
    }
    
    private Table getWarningTable()
    {
    	if (warningTable == null){
	    	warningTable = new Table(getSkin());
	    	warningTable.setFillParent( true );
	    	lblWarning = new Label("This will delete any previously saved game progress. Are you sure you want to continue?", super.getSkin());
	    	lblWarning.setWrap(true);
	    	lblWarning.setAlignment(1);
	    	warningTable.add( lblWarning ).padTop(100).expandX().fill().space(50).row();
	    	
	    	Button okayButton = new Button(super.getSkin());
	    	okayButton.add("OK");
	    	okayButton.setColor(Color.RED);
	    	warningTable.add(okayButton).padRight(25).padLeft(25).expand().fill().row().space(50);
	    	
	    	okayButton.addListener(new ClickListener() {
	    		@Override
	    		public void touchUp(InputEvent event,float x,float y,int pointer,int button)
	            {
	                super.touchUp( event, x, y, pointer, button );
	                if (!extraWarning){
	                	lblWarning.setText("Click OK to continue and delete all saved game data.");
	                	extraWarning = true;
	                }
	                else if (!profileCreated){
	                	ProfileManager.newProfile();
	                	lblWarning.setText("Data has been deleted.");
	                	profileCreated = true;
	                }
	                else
	                {
	                	disableWarningTable();
	                }
	                
	            }
	    	});
	    	
	    	Button cancelButton = new Button(super.getSkin());
	    	cancelButton.add("Cancel");
	    	cancelButton.setColor(Color.GREEN);
	    	warningTable.add(cancelButton).padRight(25).padLeft(25).padBottom(50).expand().fill();
	    	
	    	cancelButton.addListener(new ClickListener() {
	    		@Override
	    		public void touchUp(InputEvent event,float x,float y,int pointer,int button)
	            {
	                super.touchUp( event, x, y, pointer, button );
	                disableWarningTable();
	            }
	    	});
	    	warningTable.setVisible(false);
	    	stage.addActor(warningTable);
    	}
    	return warningTable;
    }
    
    private Image getBackgroundImage()
    {
 		if (backgroundImage == null) {
 			backgroundImage = new Image(getSplashRegion());
 			//backgroundImage.setVisible(true);
 			//backgroundImage.setColor(Color.BLACK);
 			backgroundImage.setFillParent(true);
 		}
    	return backgroundImage;
    }
}
