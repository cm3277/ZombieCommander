package com.JustMoser.ZombieCommander;

//import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;

import com.JustMoser.ZombieCommander.Tyrian;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.android.AndroidApplication;
import com.swarmconnect.Swarm;

 
/**
 * This class simply defines an Android activity for our game.
 */
//@SuppressWarnings("unused")
@SuppressWarnings("unused")
public class MainActivity extends AndroidApplication//extends BaseGameActivity implements IActivityRequestHandler
{
	//private GameServices gameServices;
	private Tyrian tyrian;
	/*private static boolean firstSignIn = false;
	
	//ui stufff
		private static Table signIOTable;
		private static Table signResultTable;
		private static Label lblResult;
		private static Button signInButton;//
		private static Stage currentStage;
		//private static Skin skin;
		
	//nifty handler
		
		private final static int ENABLE_SIGNIO_TABLE = 1;
	    //private final int HIDE_ADS = 0;

	    public static Handler handler =  new Handler()
	    {
	        @Override
	        public void handleMessage(Message msg) {
	            switch(msg.what) {
	                case ENABLE_SIGNIO_TABLE://
	                {
	                    enableSignIOTable();
	                    break;
	                }
	                //case HIDE_ADS:
	                //{
	                //    adView.setVisibility(View.GONE);
	                //    break;
	                //}
	            }
	        }
	    };*/
	
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate( savedInstanceState );
        
        getWindow().addFlags( WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON );//
 
        // whether to use OpenGL ES 2.0
        boolean useOpenGLES2 = true;
        
        tyrian = new Tyrian();
 
        // create the game
        initialize( tyrian, useOpenGLES2 );
        //Gdx.input.setCatchBackKey(true);
        
        //swarm
        Swarm.setAllowGuests(true);
        Swarm.setActive(this);
        //Swarm.init(this, 6410, "61e662761e1c1c97d523a9e127640804");
    }
    
    /*@Override
    public void onBackPressed()
    {
    	//super.onPause();
        //Swarm.setInactive(this);
    	Gdx.app.log( Tyrian.LOG, "Back Button Pressed" );//
    }*/
    
    @Override
	public void onResume() {
        super.onResume();
        Swarm.setActive(this);
        
        // Replace MY_APP_ID with your App ID from the Swarm Admin Panel
        // Replace MY_APP_KEY with your string App Key from the Swarm Admin Panel
        Swarm.init(this, 6410, "61e662761e1c1c97d523a9e127640804");
    }

    @Override
	public void onPause() {
        super.onPause();
        Swarm.setInactive(this);
    }
    
    /*public static void enableSignIOTable()
	{
		if (!isSignedIn()){
			currentStage = AbstractImage.getStaticStage();
			currentStage.addActor(getBackgroundImage());
			getBackgroundImage().toFront();
			currentStage.addActor(getSignIOTable());
			getSignIOTable().setVisible(true);
			getSignIOTable().toFront();
			//signInFinished = false;
		}
	}
	
	private static Image getBackgroundImage()
    {
    		Image background = new Image(AbstractImage.getMenuBackgroundRegion());
    		background.setVisible(true);
    		//background.setColor(Color.BLACK);
    		background.setFillParent(true);
    	return background;
    }
	
	public static Table getSignIOTable()
	{
		if (signIOTable == null){
			signIOTable = new Table(AbstractImage.getSkin());
			signIOTable.setFillParent( true );
			signIOTable.add("").row();
	    	Label lblSignIn = new Label("Sign In with your Google Plus Account to access all the cool features like Achievements and LeaderBoards!", AbstractImage.getSkin());
	    	
	    	lblSignIn.setWrap(true);
	    	lblSignIn.setAlignment(1);
	    	signIOTable.add( lblSignIn ).padRight(25).padLeft(25).padTop(100).expandX().fill().space(50).row();
	    	
	    	signInButton = new Button(AbstractImage.getSkin());
	    	signInButton.add("Sign In");
	    	
	    	signIOTable.add(signInButton).padRight(25).padLeft(25).padBottom(50).expand().fill().row();
	    	
	    	signInButton.addListener(new ClickListener() {
	    		@Override
	    		public void touchUp(InputEvent event,float x,float y,int pointer,int button)
	            {
	                super.touchUp( event, x, y, pointer, button );
	                if (!isSignedIn()){
	                	disableSignIOTable();
	                	// start the asynchronous sign in flow
	                	beginUserInitiatedSignIn();
	                }
	                else
	                {
	                	disableSignIOTable();
	                	signOut();
	                }
	            }
	    	});
	    	
	    	Button cancelButton = new Button(AbstractImage.getSkin());
	    	cancelButton.add("Cancel");
	    	
	    	signIOTable.add(cancelButton).padRight(25).padLeft(25).padBottom(50).expand().fill();
	    	
	    	cancelButton.addListener(new ClickListener() {
	    		@Override
	    		public void touchUp(InputEvent event,float x,float y,int pointer,int button)
	            {
	                super.touchUp( event, x, y, pointer, button );
	                disableSignIOTable();
	            }
	    	});
    	}
		signInButton.clear();
		if (!isSignedIn()){
			signInButton.add("Sign In");
		}
		else
			signInButton.add("Sign Out");
		return signIOTable;
	}
	
	private static void disableSignIOTable()
	{
		getSignIOTable().setVisible(false);
		getSignIOTable().remove();
		getBackgroundImage().setVisible(false);
		getBackgroundImage().remove();
		//signInFinished = true;
	}
	
	/*private static Skin getSkin()
	{
		if (skin == null){
			skin = new Skin( new FileHandle("uiskin.json" ));
		}
		return skin;
	}
	
	public static Table getSignResultTable(boolean success)
	{
		if (signResultTable == null){
			signResultTable = new Table(AbstractImage.getSkin());
			signResultTable.setFillParent( true );
			signResultTable.add("").row();
	    	lblResult = new Label("", AbstractImage.getSkin());
	    	
	    	lblResult.setWrap(true);
	    	lblResult.setAlignment(1);
	    	signResultTable.add( lblResult ).padRight(25).padLeft(25).padTop(100).expandX().fill().space(50).row();
	    	
	    	Button signInButton = new Button(AbstractImage.getSkin());
	    	signInButton.add("OK");
	    	
	    	signResultTable.add(signInButton).padRight(25).padLeft(25).padBottom(50).expand().fill();
	    	
	    	signInButton.addListener(new ClickListener() {
	    		@Override
	    		public void touchUp(InputEvent event,float x,float y,int pointer,int button)
	            {
	                super.touchUp( event, x, y, pointer, button );
	                signResultTable.setVisible(false);
	                signResultTable.remove();
	                getBackgroundImage().setVisible(false);
	        		getBackgroundImage().remove();
	                //signInFinished = true;
	            }
	    	});
    	}
		if (success)
			lblResult.setText("Sign In Success!");
		else
			lblResult.setText("Sign In Failed!");
		return signResultTable;
	}
   
	@Override
	public void onSignInFailed() 
	{
		// TODO Auto-generated method stub
		if (firstSignIn){
			currentStage.addActor(getSignResultTable(false));
			getSignResultTable(false).setVisible(true);
			getSignResultTable(false).toFront();
		}
		else
			firstSignIn = true;
	}

	@Override
	public void onSignInSucceeded() 
	{
		// TODO Auto-generated method stub
		currentStage.addActor(getSignResultTable(true));
		getSignResultTable(true).setVisible(true);
		getSignResultTable(true).toFront();
	}

	@Override
	public void enableSignIOTableHandle() 
	{
		handler.sendEmptyMessage(ENABLE_SIGNIO_TABLE);
	}*/
}