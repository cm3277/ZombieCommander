package com.JustMoser.ZombieCommander.ImageActors;

import com.JustMoser.ZombieCommander.Helper.ClassType;
import com.JustMoser.ZombieCommander.Helper.RoundHelper;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class ZombieSpawn extends AbstractImage{
	
	private static TextureRegion spawnRegion;
	
	//spawning
    private int numSpawnedZombies = 0;
    private int numZombiesToSpawn = 0;
    private static float zombieSpawnDelay = 0.8f;
    private static float meatHeadSpawnDelay = 1.5f;
    private static float batSpawnDelay = 0.25f;
    private float zombieSpawnCounter = 3f;
    private Zombie localZombie;
    private Vector2 spawnLocation = new Vector2();
    private int amountToAdd;
    private Rectangle body;
    	//zombie Types
    private int TOSPAWN = 0;
    private int SPAWNED = 1;
    private int numWalkers[] = new int[] {0, 0};
    private int numMeatheads[] = new int[] {0, 0};
    private int numBangers[] = new int[] {0, 0};
    private int numAssassins[] = new int[] {0, 0};
    private int numSpiders[] = new int[] {0, 0};
    private int numBats[] = new int[] {0, 0};
    private int numRiders[] = new int[] {0, 0};
    private int numHunters[] = new int[] {0, 0};
    private int numHealWitches[] = new int[] {0, 0};

	public ZombieSpawn(Vector2 pos) {
		super(spawnRegion);
		amountToAdd = 0;
		//position = pos;
		setPosition(pos.x, pos.y);
		getZombieSpawnArray().add(this);
		body = new Rectangle(pos.x, pos.y, getWidth(),getHeight());
		//set listeners
		this.addListener(new ClickListener(){
			@Override
			public void touchUp(InputEvent event,float x,float y,int pointer,int button){
				super.touchUp( event, x, y, pointer, button );
				isTouched();
			}
		});
        
	}
	
	public static ZombieSpawn create(Vector2 pos)
	    {
			
	        return new ZombieSpawn(pos);
	    }
	
	public static void loadAssets()
	{
		//if (spawnRegion == null) {
			spawnRegion = getZombieAtlas().findRegion( "zSpawn");
		//}
	}
	
	private void isTouched()
	{
		if (!getPaused()){
			setPaused(true);
			//setColor(Color.BLUE);
			spawnLocation.set(this.getX() + this.getWidth()/2, this.getY() + this.getHeight()/2);
			SpawnMenu.enable(this);
		}
	}
	
	@Override
    public void publicAct(float delta )
    {
		if (numZombiesToSpawn != 0){
    		intervalZombieSpawn(delta);
    	}
		//this.toFront();
    }
	
	private void intervalZombieSpawn(float delta)
    {
    	zombieSpawnCounter += delta;
    	if (numAssassins[TOSPAWN] > numAssassins[SPAWNED]){
    		if (zombieSpawnCounter >= zombieSpawnDelay){
    			zombieSpawnCounter = 0f;
    			spawnZombies();
    		}
    	}
    	else if (numBats[TOSPAWN] > numBats[SPAWNED]){
    		if (zombieSpawnCounter >= batSpawnDelay){
    			zombieSpawnCounter = 0f;
    			spawnZombies();
    		}
    	}
    	else if (numHunters[TOSPAWN] > numHunters[SPAWNED]){
    		if (zombieSpawnCounter >= zombieSpawnDelay){
    			zombieSpawnCounter = 0f;
    			spawnZombies();
    		}
    	}
    	else if (numHealWitches[TOSPAWN] > numHealWitches[SPAWNED]){
    		if (zombieSpawnCounter >= zombieSpawnDelay){
    			zombieSpawnCounter = 0f;
    			spawnZombies();
    		}
    	}
    	else if (numRiders[TOSPAWN] > numRiders[SPAWNED]){
    		if (zombieSpawnCounter >= zombieSpawnDelay){
    			zombieSpawnCounter = 0f;
    			spawnZombies();
    		}
    	}
    	else if (numSpiders[TOSPAWN] > numSpiders[SPAWNED]){
    		if (zombieSpawnCounter >= zombieSpawnDelay){
    			zombieSpawnCounter = 0f;
    			spawnZombies();
    		}
    	}
    	else if (numBangers[TOSPAWN] > numBangers[SPAWNED]){
    		if (zombieSpawnCounter >= zombieSpawnDelay){
    			zombieSpawnCounter = 0f;
    			spawnZombies();
    		}
    	}
    	else if (numMeatheads[TOSPAWN] > numMeatheads[SPAWNED]){
    		if (zombieSpawnCounter >= meatHeadSpawnDelay){
    			zombieSpawnCounter = 0f;
    			spawnZombies();
    		}
    	}
    	else if (zombieSpawnCounter >= zombieSpawnDelay){
			zombieSpawnCounter = 0f;
			spawnZombies();
		}
    }
	
	private void spawnZombies()
    {
    	if (numZombiesToSpawn > numSpawnedZombies){
    		int spawnType = 1;
    		if (numHealWitches[TOSPAWN] > numHealWitches[SPAWNED]){
    			spawnType = ClassType.getHealWitch();
    			numHealWitches[SPAWNED]++;
    		}
    		else if (numHunters[TOSPAWN] > numHunters[SPAWNED]){
    			spawnType = ClassType.getHunter();
    			numHunters[SPAWNED]++;
    		}
    		else if (numRiders[TOSPAWN] > numRiders[SPAWNED]){
    			spawnType = ClassType.getRider();
    			numRiders[SPAWNED]++;
    		}
    		else if (numSpiders[TOSPAWN] > numSpiders[SPAWNED]){
    			spawnType = ClassType.getSpider();
    			numSpiders[SPAWNED]++;
    		}
    		else if (numBats[TOSPAWN] > numBats[SPAWNED]){
    			spawnType = ClassType.getBat();
    			numBats[SPAWNED]++;
    		}
    		else if (numAssassins[TOSPAWN] > numAssassins[SPAWNED]){
    			spawnType = ClassType.getAssassin();
    			numAssassins[SPAWNED]++;
    		}
    		else if (numBangers[TOSPAWN] > numBangers[SPAWNED]){
    			spawnType = ClassType.getBanger();
    			numBangers[SPAWNED]++;
    		}
    		else if (numMeatheads[TOSPAWN] > numMeatheads[SPAWNED]){
    			spawnType = ClassType.getMeatHead();
    			numMeatheads[SPAWNED]++;
    		}
    		else if (numWalkers[TOSPAWN] > numWalkers[SPAWNED]){
    			spawnType = ClassType.getZombie();
    			numWalkers[SPAWNED]++;
    		}
    		localZombie = Zombie.create(spawnType, spawnLocation.x + MathUtils.random(-this.getWidth()/2, this.getWidth()/2 - 20), spawnLocation.y + MathUtils.random(-this.getHeight()/2, this.getHeight()/2 - 20));
    		localZombie.setTargetArray(ZombieTarget.getSpawnTargets());
        	getZombieArray().add(localZombie);
        	getStage().addActor(localZombie);
        	numSpawnedZombies++;
        	//delay for switching rounds between zombie spawns if zombies died
        	RoundHelper.resetRoundDelay();
    	}
    	if (numZombiesToSpawn == numSpawnedZombies){
    		numZombiesToSpawn = 0;
    		numSpawnedZombies = 0;
    		resetSpawnArrays();
    	}
    }
	
	private void resetSpawnArrays()
    {
    	if (numMeatheads[TOSPAWN] != 0){
			numMeatheads[TOSPAWN] = 0;
			numMeatheads[SPAWNED] = 0;
		}
    	if (numSpiders[TOSPAWN] != 0){
    		numSpiders[TOSPAWN] = 0;
    		numSpiders[SPAWNED] = 0;
		}
    	if (numHunters[TOSPAWN] != 0){
    		numHunters[TOSPAWN] = 0;
    		numHunters[SPAWNED] = 0;
		}
    	if (numHealWitches[TOSPAWN] != 0){
    		numHealWitches[TOSPAWN] = 0;
    		numHealWitches[SPAWNED] = 0;
		}
    	if (numRiders[TOSPAWN] != 0){
    		numRiders[TOSPAWN] = 0;
    		numRiders[SPAWNED] = 0;
		}
    	if (numBats[TOSPAWN] != 0){
    		numBats[TOSPAWN] = 0;
    		numBats[SPAWNED] = 0;
		}
    	if (numBangers[TOSPAWN] != 0){
    		numBangers[TOSPAWN] = 0;
    		numBangers[SPAWNED] = 0;
		}
    	if (numAssassins[TOSPAWN] != 0){
    		numAssassins[TOSPAWN] = 0;
    		numAssassins[SPAWNED] = 0;
		}
		if (numWalkers[TOSPAWN] != 0){
			numWalkers[TOSPAWN] = 0;
			numWalkers[SPAWNED] = 0;
		}
    }
	
	public void onSpawnZombieClicked(int amount)
    {
    	SpawnMenu.disable(false);
    	ZombieTarget.onSpawnZombie(this);
    	amountToAdd = amount;
    }
	
	public void onTargetsSet()
	{
		numZombiesToSpawn += amountToAdd;
    	if (ClassType.isSpider(SpawnMenu.getTypeToSpawn())){
    		numSpiders[TOSPAWN] += amountToAdd;
    	}
    	else if (ClassType.isRider(SpawnMenu.getTypeToSpawn())){
    		numRiders[TOSPAWN] += amountToAdd;
    	}
    	else if (ClassType.isHunter(SpawnMenu.getTypeToSpawn())){
    		numHunters[TOSPAWN] += amountToAdd;
    	}
    	else if (ClassType.isHealWitch(SpawnMenu.getTypeToSpawn())){
    		numHealWitches[TOSPAWN] += amountToAdd;
    	}
    	else if (ClassType.isBat(SpawnMenu.getTypeToSpawn())){
    		numBats[TOSPAWN] += (amountToAdd*2); //two bats for every spawn
    		numZombiesToSpawn += amountToAdd;
    	}
    	else if (ClassType.isAssassin(SpawnMenu.getTypeToSpawn())){
    		numAssassins[TOSPAWN] += amountToAdd;
    	}
    	else if (ClassType.isBanger(SpawnMenu.getTypeToSpawn())){
    		numBangers[TOSPAWN] += amountToAdd;
    	}
    	else if (ClassType.isMeatHead(SpawnMenu.getTypeToSpawn())){
    		numMeatheads[TOSPAWN] += amountToAdd;
    	}
    	else
    		numWalkers[TOSPAWN] += amountToAdd;
	}
	
	public Rectangle getRect()
	{
		if (body.getX() != this.getX())
			body.setX(this.getX());
		if (body.getY() != this.getY())
			body.setY(this.getY());
		return body;
	}
	
}