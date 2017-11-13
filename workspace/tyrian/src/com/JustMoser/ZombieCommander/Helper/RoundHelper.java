package com.JustMoser.ZombieCommander.Helper;

import static com.badlogic.gdx.scenes.scene2d.actions.Actions.delay;
import static com.badlogic.gdx.scenes.scene2d.actions.Actions.fadeIn;
import static com.badlogic.gdx.scenes.scene2d.actions.Actions.fadeOut;
import static com.badlogic.gdx.scenes.scene2d.actions.Actions.sequence;

import com.JustMoser.ZombieCommander.Helper.SwarmConsts.Leaderboard;
import com.JustMoser.ZombieCommander.Helper.Audio.SoundManager;
import com.JustMoser.ZombieCommander.Helper.Audio.SoundManager.SoundEffects;
import com.JustMoser.ZombieCommander.ImageActors.AbstractImage;
import com.JustMoser.ZombieCommander.ImageActors.Brain;
import com.JustMoser.ZombieCommander.ImageActors.HealthBar;
import com.JustMoser.ZombieCommander.ImageActors.Human;
import com.JustMoser.ZombieCommander.ImageActors.LevelOver;
import com.JustMoser.ZombieCommander.ImageActors.ZTypeMiniScreen;
import com.JustMoser.ZombieCommander.ImageActors.Zombie;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.Align;
import com.swarmconnect.SwarmLeaderboard;

public class RoundHelper extends Actor{
	
	private static int currentRound;
	private static int numZombiesCanSpawn;
	private static int numZombieBase = 5;
	private static int numZombieMultiplier = 4;
	private static int topBarHeight = 30;
	private static Image topBar;
	private Image middleBar;
	private boolean topBarAdded;
	private Label lblRound;
	private static Label lblRoundTop;
	private static Label lblBrainsTop;
	private static Label lblNumZombies;
	private static Table topTable;
	private static float roundDelayTimer = 0f;
	private static float roundDelay = 3.1f;
	private static int startLevelBrains = 0;
	private static int brainsEarned = 0;
	private static int bonusBrains = 0;
	private static int numChests;
	private static int numChestsFinished;
	private static int numChestsStarted;
	private static int levelId = 0;
	private static int packId = 0;
	private static int gameTypeId;
	private static boolean newUnlock = false;
	
	public RoundHelper(int pack, int level, int gameType)
	{
		currentRound = 0;
		topBarAdded = false;
		roundDelayTimer = 0f;
		startLevelBrains = ProfileManager.getProfile().getNumBrains();
		brainsEarned = 0;
		packId = pack;
		levelId = level;
		gameTypeId = gameType;
		newUnlock = false;
		numChests = 0;
		numChestsFinished = 0;
		numChestsStarted = 0;
	}
	
	private void newRound()
	{
		//scary sound
		SoundManager.play(SoundEffects.NEWROUNDSCARY, 1f);
		currentRound++;
		calcNumZombiesCanSpawn();
		AbstractImage.getZombieArray().clear();
		//this.getStage().addActor(getMiddleBar());
		getMiddleBar().toFront();
		getMiddleBar().addAction( sequence( fadeIn( 2f ), delay( 2f ), fadeOut( 2f ), new Action() {
            @Override
            public boolean act(
                float delta )
            {
                getMiddleBar().toBack();
                return true;
            }
        }));
		//this.getStage().addActor(getRoundLabel());
		getRoundLabel().setText("Round: " + currentRound);
		getRoundLabel().toFront();
		getRoundLabel().addAction( sequence( fadeIn( 2f ), delay( 2f ), fadeOut( 2f ), new Action() {
            @Override
            public boolean act(
                float delta )
            {
                getRoundLabel().toBack();
                return true;
            }
        }));
		getRoundLabelTop().setText("Round: " + currentRound);
	}
	
	public static Table getTopTable()
	{
		return topTable;
	}
	
	public static void loadTopTable()
    {
       // if( topTable == null ) {
        	topTable = new Table(AbstractImage.getSkin());
        	topTable.setFillParent(true);
        	topTable.align(Align.top);
        	topTable.add(getRoundLabelTop()).space(20);
        	topTable.add(getNumZombiesLabel()).space(20);
        	topTable.add(getBrainsLabelTop()).space(5);
        	topTable.add(new Image(ZTypeMiniScreen.getSmallBrainRegion())).align(Align.left);
       // }
    }
	
	public static void loadAssets()
	{
		loadRoundLabelTop();
		loadNumZombiesLabel();
		loadBrainsLabelTop();
		loadTopTable();
	}
	
	private Label getRoundLabel()
	{
		if (lblRound == null){
			lblRound = new Label("Round: " + currentRound, AbstractImage.getSkin());
			lblRound.setWrap(true);
			lblRound.setAlignment(1);
			lblRound.setColor(Color.RED);
			lblRound.addAction( Actions.fadeOut( 0f ) );
			lblRound.setPosition(480*0.3f - lblRound.getWidth(), 800/2 - lblRound.getHeight()/2);
			lblRound.setWidth(Gdx.app.getGraphics().getWidth());
			this.getStage().addActor(lblRound);
		}
		return lblRound;
	}
	
	private static Label getRoundLabelTop()
	{
		return lblRoundTop;
	}
	
	private static void loadRoundLabelTop()
	{
		//if (lblRoundTop == null){
			lblRoundTop = new Label("Round: " + currentRound, AbstractImage.getSkin());//finish this shiz
			lblRoundTop.setFontScale(getFontScale(18));
			lblRoundTop.setColor(Color.WHITE);
			//lblRoundTop.setPosition(480*0.6f, 800 - topBarHeight);
		//}
		
	}
	
	private static Label getNumZombiesLabel()
	{
		return lblNumZombies;
	}
	
	private static void loadNumZombiesLabel()
	{
		//if (lblNumZombies == null){
			lblNumZombies = new Label("Zombies: " + numZombiesCanSpawn, AbstractImage.getSkin());
			lblNumZombies.setFontScale(getFontScale(18));
			lblNumZombies.setColor(Color.WHITE);
		//}
		
	}
	
	private static Label getBrainsLabelTop()
	{
		return lblBrainsTop;
	}
	
	private static void loadBrainsLabelTop()
	{
		//if (lblBrainsTop == null){
			lblBrainsTop = new Label("Brains: " + ProfileManager.getProfile().getNumBrains(), AbstractImage.getSkin());//finish this shiz
			lblBrainsTop.setFontScale(getFontScale(18));
			lblBrainsTop.setColor(Color.WHITE);
			//lblRoundTop.setPosition(480*0.6f, 800 - topBarHeight);
		//}
		
	}
	
	public static void updateBrainsLabel()
	{
		getBrainsLabelTop().setText("Brains: " + ProfileManager.getProfile().getNumBrains());
	}
	
	private static Image getTopBar()
	{
		//if (topBar == null){
			topBar = new Image(HealthBar.getHealthBarRegion());
			topBar.setSize(Gdx.app.getGraphics().getWidth(), topBarHeight);
			topBar.setPosition(0, 800 - topBar.getHeight());
			topBar.setColor(Color.BLACK);
		//}
		return topBar;
	}
	
	private Image getMiddleBar()
	{
		if (middleBar == null){
			middleBar = new Image(HealthBar.getHealthBarRegion());
			middleBar.addAction( Actions.fadeOut( 0f ) );
			middleBar.setSize(Gdx.app.getGraphics().getWidth(), getRoundLabel().getHeight()*1.3f);
			middleBar.setPosition(0, 800/2 - middleBar.getHeight()/2);
			middleBar.setColor(Color.BLACK);
			this.getStage().addActor(middleBar);
		}
		return middleBar;
	}
	
	private void calcNumZombiesCanSpawn()
	{
		numZombiesCanSpawn = numZombieBase + (numZombieMultiplier * (currentRound - 1)) + levelId;
		getNumZombiesLabel().setText("Zombies: " + numZombiesCanSpawn);
	}

	public static int getNumZombiesCanSpawn() 
	{
		return numZombiesCanSpawn;
	}

	public static void minusNumZombiesCanSpawn(int amount) 
	{
		RoundHelper.numZombiesCanSpawn -= amount;
		getNumZombiesLabel().setText("Zombies: " + numZombiesCanSpawn);
	}
	
	public static void addNumZombiesCanSpawn(int amount) 
	{
		RoundHelper.numZombiesCanSpawn += amount;
		getNumZombiesLabel().setText("Zombies: " + numZombiesCanSpawn);
	}
	
	@Override
	public void act(float delta)
	{
		if (topBarAdded == false){
			this.getStage().addActor(getTopBar());
			this.getStage().addActor(getTopTable());
			topBarAdded = true;
		}
		if (currentRound == 0){
			newRound();
		}
		if (!AbstractImage.getPaused()){
			//Check for end game for slayer
			if (gameTypeId == LevelManager.getSlayer())
				slayerEndCheck();
			else if (gameTypeId == LevelManager.getSearchAndDestroy())
				searchAndDestroyEndCheck();
			else if (gameTypeId == LevelManager.getCaptureTheFlag())
				captureTheFlagEndCheck();
			
			if (numZombiesCanSpawn == 0){
				if (roundDelayTimer <= roundDelay){
					roundDelayTimer += delta;
				}
				else{
					if (!zombiesAlive() && numChestsStarted == 0){
						newRound();
					}
				}
			}
		}
	}
	
	private void captureTheFlagEndCheck()
	{
		if (AbstractImage.getFlag().getRect().overlaps(AbstractImage.getZombieFlagStand().getRect())){
			if (!brainsLeft()){
				bonusBrains = calcBonusBrains();
				ProfileManager.getProfile().addBrains(bonusBrains);
				endLevel();
			}
		}
	}
	
	private void searchAndDestroyEndCheck()
	{
		if (numChests > 0 && numChests == numChestsFinished){
			if (!brainsLeft()){
				endLevel();
			}
		}
	}
	
	private void slayerEndCheck()
	{
		if (!humansAlive()){
			if (!brainsLeft()){
				bonusBrains = calcBonusBrains();
				ProfileManager.getProfile().addBrains(bonusBrains);
				endLevel();
			}
		}
	}
	
	public static int calcBonusBrains()
	{
		int bonusBrains = 1000;
		if (currentRound < 7){
			bonusBrains = MathUtils.roundPositive((float) (bonusBrains * Math.pow(0.8, currentRound) * ((levelId+1)/5f)));
		}
		else
			bonusBrains = 200;
		if (numChests != 0)
			bonusBrains = bonusBrains/numChests;
		return bonusBrains;
	}
	
	private void endLevel()
	{
		if (LevelManager.hasNextLevel(gameTypeId, packId, levelId)){
			if (!LevelManager.getLevel(gameTypeId, packId, levelId+1)){
				LevelManager.unlockLevel(gameTypeId, packId, levelId+1);
				newUnlock = true;
				if (!AchievementManager.getLevelPackNoob(packId)){
					if (levelId+1 == 3){
						AchievementManager.unlockLevelPackNoob(packId);
						if (gameTypeId == LevelManager.getSearchAndDestroy())
							AchievementManager.unlockZombie(ClassType.getHunter());
					}
				}
				if (gameTypeId == LevelManager.getSlayer())
					checkSlayerUnlocks();
			}
			else 
				newUnlock = false;
		}
		else{
			newUnlock = false;
			if (!AchievementManager.getLevelPackMaster(packId)){
				AchievementManager.unlockLevelPackMaster(packId);
			}
		}
		doLeaderBoards(true);
		LevelOver.enable();
	}
	
	public static void doLeaderBoards(boolean submit)
	{
		if (gameTypeId == LevelManager.getSlayer()){
			if (packId == LevelManager.getSlayerPackId(1)){
				if (levelId+1 == 1){
					if (submit)
						SwarmLeaderboard.submitScore(Leaderboard.SLAYER_BEGINNER_LEVEL_1_ROUNDS_ID, currentRound);
					else
						SwarmLeaderboard.showLeaderboard(Leaderboard.SLAYER_BEGINNER_LEVEL_1_ROUNDS_ID);
				}
				else if (levelId+1 == 2){
					if (submit)
						SwarmLeaderboard.submitScore(Leaderboard.SLAYER_BEGINNER_LEVEL_2_ROUNDS_ID, currentRound);
					else
						SwarmLeaderboard.showLeaderboard(Leaderboard.SLAYER_BEGINNER_LEVEL_2_ROUNDS_ID);
				}
				else if (levelId+1 == 3){
					if (submit)
						SwarmLeaderboard.submitScore(Leaderboard.SLAYER_BEGINNER_LEVEL_3_ROUNDS_ID, currentRound);
					else
						SwarmLeaderboard.showLeaderboard(Leaderboard.SLAYER_BEGINNER_LEVEL_3_ROUNDS_ID);
				}
				else if (levelId+1 == 4){
					if (submit)
						SwarmLeaderboard.submitScore(Leaderboard.SLAYER_BEGINNER_LEVEL_4_ROUNDS_ID, currentRound);
					else
						SwarmLeaderboard.showLeaderboard(Leaderboard.SLAYER_BEGINNER_LEVEL_4_ROUNDS_ID);
				}
				else if (levelId+1 == 5){
					if (submit)
						SwarmLeaderboard.submitScore(Leaderboard.SLAYER_BEGINNER_LEVEL_5_ROUNDS_ID, currentRound);
					else
						SwarmLeaderboard.showLeaderboard(Leaderboard.SLAYER_BEGINNER_LEVEL_5_ROUNDS_ID);
				}
			}
			//Slayer pack 2 
			else if (packId == LevelManager.getSlayerPackId(2)){
				if (levelId+1 == 1){
					if (submit)
						SwarmLeaderboard.submitScore(Leaderboard.SLAYER_ADVANCED_LEVEL_1_ROUNDS_ID, currentRound);
					else
						SwarmLeaderboard.showLeaderboard(Leaderboard.SLAYER_ADVANCED_LEVEL_1_ROUNDS_ID);
				}
				else if (levelId+1 == 2){
					if (submit)
						SwarmLeaderboard.submitScore(Leaderboard.SLAYER_ADVANCED_LEVEL_2_ROUNDS_ID, currentRound);
					else
						SwarmLeaderboard.showLeaderboard(Leaderboard.SLAYER_ADVANCED_LEVEL_2_ROUNDS_ID);
				}
				else if (levelId+1 == 3){
					if (submit)
						SwarmLeaderboard.submitScore(Leaderboard.SLAYER_ADVANCED_LEVEL_3_ROUNDS_ID, currentRound);
					else
						SwarmLeaderboard.showLeaderboard(Leaderboard.SLAYER_ADVANCED_LEVEL_3_ROUNDS_ID);
				}
				else if (levelId+1 == 4){
					if (submit)
						SwarmLeaderboard.submitScore(Leaderboard.SLAYER_ADVANCED_LEVEL_4_ROUNDS_ID, currentRound);
					else
						SwarmLeaderboard.showLeaderboard(Leaderboard.SLAYER_ADVANCED_LEVEL_4_ROUNDS_ID);
				}
				else if (levelId+1 == 5){
					if (submit)
						SwarmLeaderboard.submitScore(Leaderboard.SLAYER_ADVANCED_LEVEL_5_ROUNDS_ID, currentRound);
					else
						SwarmLeaderboard.showLeaderboard(Leaderboard.SLAYER_ADVANCED_LEVEL_5_ROUNDS_ID);
				}
			}
		}
		//Search and Destroy 
		else if (gameTypeId == LevelManager.getSearchAndDestroy()){
			if (packId == LevelManager.getSearchAndDestroyPackId(1)){
				if (levelId+1 == 1){
					if (submit)
						SwarmLeaderboard.submitScore(Leaderboard.SNDESTROY_BEGINNER_LEVEL_1_ROUNDS_ID, currentRound);
					else
						SwarmLeaderboard.showLeaderboard(Leaderboard.SNDESTROY_BEGINNER_LEVEL_1_ROUNDS_ID);
				}
				else if (levelId+1 == 2){
					if (submit)
						SwarmLeaderboard.submitScore(Leaderboard.SNDESTROY_BEGINNER_LEVEL_2_ROUNDS_ID, currentRound);
					else
						SwarmLeaderboard.showLeaderboard(Leaderboard.SNDESTROY_BEGINNER_LEVEL_2_ROUNDS_ID);
				}
				else if (levelId+1 == 3){
					if (submit)
						SwarmLeaderboard.submitScore(Leaderboard.SNDESTROY_BEGINNER_LEVEL_3_ROUNDS_ID, currentRound);
					else
						SwarmLeaderboard.showLeaderboard(Leaderboard.SNDESTROY_BEGINNER_LEVEL_3_ROUNDS_ID);
				}
				else if (levelId+1 == 4){
					if (submit)
						SwarmLeaderboard.submitScore(Leaderboard.SNDESTROY_BEGINNER_LEVEL_4_ROUNDS_ID, currentRound);
					else
						SwarmLeaderboard.showLeaderboard(Leaderboard.SNDESTROY_BEGINNER_LEVEL_4_ROUNDS_ID);
				}
				else if (levelId+1 == 5){
					if (submit)
						SwarmLeaderboard.submitScore(Leaderboard.SNDESTROY_BEGINNER_LEVEL_5_ROUNDS_ID, currentRound);
					else
						SwarmLeaderboard.showLeaderboard(Leaderboard.SNDESTROY_BEGINNER_LEVEL_5_ROUNDS_ID);
				}
			}
			//Search n destroy pack 2
			else if (packId == LevelManager.getSearchAndDestroyPackId(2)){
				if (levelId+1 == 1){
					if (submit)
						SwarmLeaderboard.submitScore(Leaderboard.SNDESTROY_ADVANCED_LEVEL_1_ROUNDS_ID, currentRound);
					else
						SwarmLeaderboard.showLeaderboard(Leaderboard.SNDESTROY_ADVANCED_LEVEL_1_ROUNDS_ID);
				}
				else if (levelId+1 == 2){
					if (submit)
						SwarmLeaderboard.submitScore(Leaderboard.SNDESTROY_ADVANCED_LEVEL_2_ROUNDS_ID, currentRound);
					else
						SwarmLeaderboard.showLeaderboard(Leaderboard.SNDESTROY_ADVANCED_LEVEL_2_ROUNDS_ID);
				}
				else if (levelId+1 == 3){
					if (submit)
						SwarmLeaderboard.submitScore(Leaderboard.SNDESTROY_ADVANCED_LEVEL_3_ROUNDS_ID, currentRound);
					else
						SwarmLeaderboard.showLeaderboard(Leaderboard.SNDESTROY_ADVANCED_LEVEL_3_ROUNDS_ID);
				}
				else if (levelId+1 == 4){
					if (submit)
						SwarmLeaderboard.submitScore(Leaderboard.SNDESTROY_ADVANCED_LEVEL_4_ROUNDS_ID, currentRound);
					else
						SwarmLeaderboard.showLeaderboard(Leaderboard.SNDESTROY_ADVANCED_LEVEL_4_ROUNDS_ID);
				}
				else if (levelId+1 == 5){
					if (submit)
						SwarmLeaderboard.submitScore(Leaderboard.SNDESTROY_ADVANCED_LEVEL_5_ROUNDS_ID, currentRound);
					else
						SwarmLeaderboard.showLeaderboard(Leaderboard.SNDESTROY_ADVANCED_LEVEL_5_ROUNDS_ID);
				}
			}
		}
		//Capture the Flag
		else if (gameTypeId == LevelManager.getCaptureTheFlag()){
			if (packId == LevelManager.getCaptureTheFlagPackId(1)){
				if (levelId+1 == 1){
					if (submit)
						SwarmLeaderboard.submitScore(Leaderboard.CTFLAG_BEGINNER_LEVEL_1_ROUNDS_ID, currentRound);
					else
						SwarmLeaderboard.showLeaderboard(Leaderboard.CTFLAG_BEGINNER_LEVEL_1_ROUNDS_ID);
				}
				else if (levelId+1 == 2){
					if (submit)
						SwarmLeaderboard.submitScore(Leaderboard.CTFLAG_BEGINNER_LEVEL_2_ROUNDS_ID, currentRound);
					else
						SwarmLeaderboard.showLeaderboard(Leaderboard.CTFLAG_BEGINNER_LEVEL_2_ROUNDS_ID);
				}
				else if (levelId+1 == 3){
					if (submit)
						SwarmLeaderboard.submitScore(Leaderboard.CTFLAG_BEGINNER_LEVEL_3_ROUNDS_ID, currentRound);
					else
						SwarmLeaderboard.showLeaderboard(Leaderboard.CTFLAG_BEGINNER_LEVEL_3_ROUNDS_ID);
				}
				else if (levelId+1 == 4){
					if (submit)
						SwarmLeaderboard.submitScore(Leaderboard.CTFLAG_BEGINNER_LEVEL_4_ROUNDS_ID, currentRound);
					else
						SwarmLeaderboard.showLeaderboard(Leaderboard.CTFLAG_BEGINNER_LEVEL_4_ROUNDS_ID);
				}
				else if (levelId+1 == 5){
					if (submit)
						SwarmLeaderboard.submitScore(Leaderboard.CTFLAG_BEGINNER_LEVEL_5_ROUNDS_ID, currentRound);
					else
						SwarmLeaderboard.showLeaderboard(Leaderboard.CTFLAG_BEGINNER_LEVEL_5_ROUNDS_ID);
				}
			}
			//Capture the flag pack 2
			else if (packId == LevelManager.getCaptureTheFlagPackId(2)){
				if (levelId+1 == 1){
					if (submit)
						SwarmLeaderboard.submitScore(Leaderboard.CTFLAG_ADVANCED_LEVEL_1_ROUNDS_ID, currentRound);
					else
						SwarmLeaderboard.showLeaderboard(Leaderboard.CTFLAG_ADVANCED_LEVEL_1_ROUNDS_ID);
				}
				else if (levelId+1 == 2){
					if (submit)
						SwarmLeaderboard.submitScore(Leaderboard.CTFLAG_ADVANCED_LEVEL_2_ROUNDS_ID, currentRound);
					else
						SwarmLeaderboard.showLeaderboard(Leaderboard.CTFLAG_ADVANCED_LEVEL_2_ROUNDS_ID);
				}
				else if (levelId+1 == 3){
					if (submit)
						SwarmLeaderboard.submitScore(Leaderboard.CTFLAG_ADVANCED_LEVEL_3_ROUNDS_ID, currentRound);
					else
						SwarmLeaderboard.showLeaderboard(Leaderboard.CTFLAG_ADVANCED_LEVEL_3_ROUNDS_ID);
				}
				else if (levelId+1 == 4){
					if (submit)
						SwarmLeaderboard.submitScore(Leaderboard.CTFLAG_ADVANCED_LEVEL_4_ROUNDS_ID, currentRound);
					else
						SwarmLeaderboard.showLeaderboard(Leaderboard.CTFLAG_ADVANCED_LEVEL_4_ROUNDS_ID);
				}
				else if (levelId+1 == 5){
					if (submit)
						SwarmLeaderboard.submitScore(Leaderboard.CTFLAG_ADVANCED_LEVEL_5_ROUNDS_ID, currentRound);
					else
						SwarmLeaderboard.showLeaderboard(Leaderboard.CTFLAG_ADVANCED_LEVEL_5_ROUNDS_ID);
				}
			}
		}
		
	}
	
	private void checkSlayerUnlocks()
	{
		if (levelId+1 == 1){
			if (!AchievementManager.getUnlockedZombie(ClassType.getMeatHead())){
				AchievementManager.unlockZombie(ClassType.getMeatHead());
			}
			if (!AchievementManager.getUnlockedZombie(ClassType.getHealWitch())){
				AchievementManager.unlockZombie(ClassType.getHealWitch());
			}
		}
		if (levelId+1 == 2){
			if (!AchievementManager.getUnlockedZombie(ClassType.getAssassin())){
				AchievementManager.unlockZombie(ClassType.getAssassin());
			}
			if (!AchievementManager.getUnlockedZombie(ClassType.getBanger())){
				AchievementManager.unlockZombie(ClassType.getBanger());
			}
		}
		if (levelId+1 == 3){
			if (!AchievementManager.getUnlockedZombie(ClassType.getBat())){
				AchievementManager.unlockZombie(ClassType.getBat());
			}
		}
		if (levelId+1 == 4){
			if (!AchievementManager.getUnlockedZombie(ClassType.getSpider())){
				AchievementManager.unlockZombie(ClassType.getSpider());
			}
			if (!AchievementManager.getUnlockedZombie(ClassType.getRider())){
				AchievementManager.unlockZombie(ClassType.getRider());
			}
		}
	}
	
	private boolean zombiesAlive()
	{
		boolean areAlive = false;
		for(Zombie zombie: AbstractImage.getZombieArray())
		{
			if (zombie.getAlive()){
					areAlive = true;
					break;
			}
		}
		return areAlive;
	}
	
	private boolean humansAlive()
	{
		boolean areAlive = false;
		for(Human human: AbstractImage.getHumanArray())
		{
			if (human.getAlive()){
				areAlive = true;
				break;
			}
		}
		return areAlive;
	}
	
	private boolean brainsLeft()
	{
		boolean left = false;
		for (Brain brain: AbstractImage.getBrainArray()){
			if (brain.getIsActive()){
				left = true;
				break;
			}
				
		}
		return left;
	}
	
	public static float getFontScale(float size)
	{
		return size/39f;
	}
	
	public static void resetRoundDelay()
	{
		roundDelayTimer = 0f;
	}
	
	public static int getCurrentRound()
	{
		return currentRound;
	}
	
	public static int getStartLevelBrains()
	{
		return startLevelBrains;
	}
	
	public static int getBrainsEarned()
	{
		return brainsEarned;
	}
	
	public static void addBrainsEarned(int amount)
	{
		brainsEarned += amount;
	}
	
	public static int getBonusBrains()
	{
		return bonusBrains;
	}
	
	public static boolean getNewUnlock()
	{
		return newUnlock;
	}
	
	public static void addChest()
	{
		numChests++;
	}
	
	public static void addFinishedChest()
	{
		numChestsFinished++;
		numChestsStarted--;
	}
	
	public static void addChestStarted()
	{
		numChestsStarted++;
	}
	
	public static int getGameTypeId()
	{
		return gameTypeId;
	}
	
	public static int getLevel()
	{
		return levelId+1;
	}
	
	public static int getPackId()
	{
		return packId;
	}

}