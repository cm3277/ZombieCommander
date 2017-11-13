package com.JustMoser.ZombieCommander.ImageActors;

import com.JustMoser.ZombieCommander.Helper.ClassType;
import com.JustMoser.ZombieCommander.Helper.ProfileManager;
import com.JustMoser.ZombieCommander.Helper.RoundHelper;
import com.JustMoser.ZombieCommander.Helper.ZombieStats;
import com.JustMoser.ZombieCommander.Helper.Audio.SoundManager;
import com.JustMoser.ZombieCommander.Helper.Audio.SoundManager.SoundEffects;
import com.JustMoser.ZombieCommander.Screens.AbstractScreen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.Align;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class SpawnMenu extends AbstractImage{

	 public SpawnMenu() {
		 super();
		// TODO Auto-generated constructor stub
	}

	private static Table table;
	//private static Table bottomTable;
	private static Table warningTable;
	private static Image warningBackground;
	//private static Image brainImage;
	private static int lblNumZombiesToSpawn;
    private static Label numToSpawn;
    private static Label totalPrice;
    private static Label lblTypeToSpawn;
    private static int iTypeToSpawn;
    private static Image menuImage;//need to do zombieSpawn for spider to be finished!
    private static ZombieSpawn zombieSpawn;
	
	public static void enable(ZombieSpawn zSpawn)
	{
		//get zombie spawn location that enabled us
		zombieSpawn = zSpawn;
		iTypeToSpawn = 1;
		getMenuImage().setVisible(true);
		getMenuImage().toFront();
		getTable().setVisible(true);
		getTable().toFront();
		//getBottomTable().setVisible(true);
		//getBottomTable().toFront();
		changeSpawnType(iTypeToSpawn);
		if (lblNumZombiesToSpawn != 0){
			lblNumZombiesToSpawn = 0;
			numToSpawn.setText("To Spawn: " + lblNumZombiesToSpawn);
		}
		totalPrice.setText("Price: " + updateTotalPrice());
	}
	
	public static void disable(boolean resume)
	{
		getMenuImage().setVisible(false);
		getTable().setVisible(false);
		//getBottomTable().setVisible(false);
		if (resume)
			setPaused(false);
	}
	
	public static void changeSpawnType(int zombieType)
	{
		if (ClassType.isBanger(zombieType)){
			lblTypeToSpawn.setText("Banger");
			iTypeToSpawn = ClassType.getBanger();
		}
		else if (ClassType.isAssassin(zombieType)){
			lblTypeToSpawn.setText("Assassin");
			iTypeToSpawn = ClassType.getAssassin();
		}
		else if (ClassType.isSpider(zombieType)){
			lblTypeToSpawn.setText("Spider Queen");
			iTypeToSpawn = ClassType.getSpider();
		}
		else if (ClassType.isBat(zombieType)){
			lblTypeToSpawn.setText("Hell Bats");
			iTypeToSpawn = ClassType.getBat();
		}
		else if (ClassType.isRider(zombieType)){
			lblTypeToSpawn.setText("Wolf Rider");
			iTypeToSpawn = ClassType.getRider();
		}
		else if (ClassType.isHunter(zombieType)){
			lblTypeToSpawn.setText("Hunter");
			iTypeToSpawn = ClassType.getHunter();
		}
		else if (ClassType.isHealWitch(zombieType)){
			lblTypeToSpawn.setText("Healing Witch");
			iTypeToSpawn = ClassType.getHealWitch();
		}
		else if (ClassType.isMeatHead(zombieType)){
			lblTypeToSpawn.setText("Meathead");
			iTypeToSpawn = ClassType.getMeatHead();
		}
		else{
			lblTypeToSpawn.setText("Walker");
			iTypeToSpawn = ClassType.getZombie();
		}
		
	}
	
	public static int getTypeToSpawn()
	{
		return iTypeToSpawn;
	}
	
	private static Table getTable()
	{
		if (!getStaticStage().getActors().contains(table, true)){
			getStaticStage().addActor(table);
		}
        return table;
	}
	
	private static void loadTable()
    {
        //if( table == null ) {
            table = new Table(getSkin());
            table.setPosition(getMenuImage().getX(), getMenuImage().getY());
            table.setWidth(getMenuImage().getWidth());
            table.setHeight(getMenuImage().getHeight());
            table.add("").row();
            //Table Title
            Label title = new Label("Zombie Spawner", getSkin());
            title.setColor(Color.BLACK);
            table.add(title).padTop(20).spaceBottom(20).colspan(2).row();
            //Zombie type button
            Button zombieTypeButton = new Button(getSkin());
            zombieTypeButton.add("Choose Zombies");
            zombieTypeButton.setColor(Color.GREEN);
            table.add(zombieTypeButton).padRight(25).padLeft(25).expand().fill().spaceBottom(20).colspan(2).row();
            //create label that gets set to the different types
            lblTypeToSpawn = new Label("Walker", getSkin());
            lblTypeToSpawn.setColor(Color.BLACK);
            table.add(lblTypeToSpawn).spaceBottom(10).colspan(2).row();
            //Num of zombies to spawn label
            numToSpawn = new Label("To Spawn: " + lblNumZombiesToSpawn, getSkin());
            numToSpawn.setColor(Color.BLACK);
            table.add(numToSpawn).spaceBottom(10).colspan(2).row();
            //Calculated Price of Zombies
            totalPrice = new Label("Total: " + updateTotalPrice(), getSkin());
            totalPrice.setColor(Color.BLACK);
            table.add(totalPrice).spaceBottom(10).align(Align.right);
            
            table.add(getBrainImage()).spaceBottom(10).align(Align.left).row();
            //- num to spawn button
            Button decNumToSpawn = new Button(getSkin());
            decNumToSpawn.add(" - ");
            decNumToSpawn.setColor(Color.PINK);
            table.add(decNumToSpawn).padRight(25).padLeft(25).expand().fill().spaceBottom(20);
            //+ num to spawn button
            Button incNumToSpawn = new Button(getSkin());
            incNumToSpawn.add(" + ");
            incNumToSpawn.setColor(Color.RED);
            table.add(incNumToSpawn).padLeft(25).expand().fill().spaceBottom(20).padRight(20).row();//colspan is key
            //spawn zombies button
            Button spawnZombieButton = new Button(getSkin());
            spawnZombieButton.add("Spawn Zombies");
            spawnZombieButton.setColor(Color.BLUE);
            table.add(spawnZombieButton).padRight(25).padLeft(25).expand().fill().spaceBottom(20).colspan(2).row();
            //Exit button
            Button exitButton = new Button(getSkin());
            exitButton.add("Exit Spawner");
            exitButton.setColor(Color.MAGENTA);
            table.add(exitButton).padRight(25).padLeft(25).expand().fill().colspan(2).spaceBottom(20).row();
            Button menuButton = new Button(getSkin());
        	menuButton.add("Exit to Menu");
        	table.add(menuButton).padBottom(20).padRight(25).padLeft(25).expand().fill().colspan(2);
        	
        	menuButton.addListener(new ClickListener() {
        		@Override
        		public void touchUp(InputEvent event,float x,float y,int pointer,int button)
                {
                    super.touchUp( event, x, y, pointer, button );
                    enableExitWarning();
                }
        	});
            table.setVisible(false);
            
            //button listener
            spawnZombieButton.addListener(new ClickListener() {
        		@Override
        		public void touchUp(InputEvent event,float x,float y,int pointer,int button)
                {
                    super.touchUp( event, x, y, pointer, button );
                    if (lblNumZombiesToSpawn > 0 && ProfileManager.getProfile().getNumBrains() >= (ZombieStats.getZombiePrice(iTypeToSpawn)*lblNumZombiesToSpawn)){
	                    if (zombieSpawn != null)
	                    	if (ZombieStats.getZombiePrice(iTypeToSpawn)*lblNumZombiesToSpawn > 0)
	                    		SoundManager.play(SoundEffects.PURCHASE, 1f);
	                    	zombieSpawn.onSpawnZombieClicked(lblNumZombiesToSpawn);
	                    	RoundHelper.minusNumZombiesCanSpawn(lblNumZombiesToSpawn);
	                    	RoundHelper.resetRoundDelay();
                    }
                }
        	});
            zombieTypeButton.addListener(new ClickListener() {
        		@Override
        		public void touchUp(InputEvent event,float x,float y,int pointer,int button)
                {
                    super.touchUp( event, x, y, pointer, button );
                    ZTypeMiniScreen.enable();
                }
        	});
            exitButton.addListener(new ClickListener() {
        		@Override
        		public void touchUp(InputEvent event,float x,float y,int pointer,int button)
                {
                    super.touchUp( event, x, y, pointer, button );
                    disable(true);
                }
        	});
            incNumToSpawn.addListener(new ClickListener() {
        		@Override
        		public void touchUp(InputEvent event,float x,float y,int pointer,int button)
                {
                    super.touchUp( event, x, y, pointer, button );
                    if (lblNumZombiesToSpawn < RoundHelper.getNumZombiesCanSpawn())
                    	lblNumZombiesToSpawn++;
                    numToSpawn.setText("To Spawn: " + lblNumZombiesToSpawn);
                    totalPrice.setText("Price: " + updateTotalPrice());
                }
        	});
            decNumToSpawn.addListener(new ClickListener() {
        		@Override
        		public void touchUp(InputEvent event,float x,float y,int pointer,int button)
                {
                    super.touchUp( event, x, y, pointer, button );
                    if (lblNumZombiesToSpawn > 0)
                    	lblNumZombiesToSpawn--;
                    numToSpawn.setText("To Spawn: " + lblNumZombiesToSpawn);
                    totalPrice.setText("Price: " + updateTotalPrice());
                }
        	});
        //}
        
    }
	
	private static int updateTotalPrice()
	{
		return (ZombieStats.getZombiePrice(iTypeToSpawn) * lblNumZombiesToSpawn);
	}
	
	private static Image getMenuImage()
    {
    	
    	if (!getStaticStage().getActors().contains(menuImage, true)){
			getStaticStage().addActor(menuImage);
		}
    	return menuImage;
    }
	
	private static Image getBrainImage()
	{
		return new Image(Brain.getBrainRegion());
	}
	
	public static void loadAssets()
	{
		//if (menuImage == null) {
    		menuImage = new Image(getZombieAtlas().findRegion( "MenuBack"));
    		menuImage.setVisible(false);
    		menuImage.setPosition(480/2 - menuImage.getWidth()/2, 800/2 - menuImage.getHeight()/2);
    	//}
    		//if (warningBackground == null) {
        		warningBackground = new Image(getMenuBackgroundRegion());
        		warningBackground.setVisible(true);
        		//warningBackground.setColor(Color.BLACK);
        		warningBackground.setFillParent(true);
        		loadTable();
        		loadWarningTable();
        		//brainImage = new Image(Brain.getBrainRegion());
        
	}
	
	/*private static Table getBottomTable()
    {
        if( bottomTable == null ) {
        	bottomTable = new Table(AbstractImage.getSkin());
        	bottomTable.setFillParent(true);
        	bottomTable.align(Align.bottom);
        	Button menuButton = new Button(getSkin());
        	menuButton.add("Exit to Menu");
        	bottomTable.add(menuButton).center();
        	
        	menuButton.addListener(new ClickListener() {
        		@Override
        		public void touchUp(InputEvent event,float x,float y,int pointer,int button)
                {
                    super.touchUp( event, x, y, pointer, button );
                    enableExitWarning();
                }
        	});
        }
        if (!getStaticStage().getActors().contains(bottomTable, true)){
			getStaticStage().addActor(bottomTable);
		}
            return bottomTable;
    }*/
	
	private static void enableExitWarning()
	{
		getWarningBackgroundImage().setVisible(true);
		getWarningBackgroundImage().toFront();
		getWarningTable().setVisible(true);
		getWarningTable().toFront();
	}
	
	private static void disableExitWarning()
	{
		getWarningBackgroundImage().setVisible(false);
		getWarningTable().setVisible(false);
	}
	
	private static Table getWarningTable()
	{
		if (!getStaticStage().getActors().contains(warningTable, true)){
			getStaticStage().addActor(warningTable);
		}
            return warningTable;
	}
	
	private static void loadWarningTable()
	{
		//if( warningTable == null ) {
			warningTable = new Table(AbstractImage.getSkin());
			warningTable.setVisible(false);
			warningTable.setFillParent(true);
			Label warningLabel = new Label("Exiting to the main menu will lose all current progress for this level. Continue?", getSkin());
			warningLabel.setWrap(true);
			warningLabel.setAlignment(1);
			warningTable.add( warningLabel ).expandX().fill().spaceBottom(50).colspan(2).row();
			warningTable.add(AbstractScreen.getMainMenuButton()).padRight(25).padLeft(25).expand().fill().spaceBottom(50).row();
            Button cancelButton = new Button(AbstractImage.getSkin());
            cancelButton.add("Cancel");
            cancelButton.setColor(Color.GREEN);
	    	warningTable.add(cancelButton).padRight(25).padLeft(25).padBottom(50).expand().fill();
	    	
	    	cancelButton.addListener(new ClickListener() {
	    		@Override
	    		public void touchUp(InputEvent event,float x,float y,int pointer,int button)
	            {
	                super.touchUp( event, x, y, pointer, button );
	                disableExitWarning();
	            }
	    	});
		//}
		
	}
	
	private static Image getWarningBackgroundImage()
    {
    	
    	if (!getStaticStage().getActors().contains(warningBackground, true)){
			getStaticStage().addActor(warningBackground);
		}
    	return warningBackground;
    }
	
	public static int getLabelNumZombiesToSpawn()
	{
		return lblNumZombiesToSpawn;
	}
}
