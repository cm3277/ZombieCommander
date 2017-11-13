package com.JustMoser.ZombieCommander;

import com.JustMoser.ZombieCommander.Helper.ProfileManager;
import com.JustMoser.ZombieCommander.Helper.Audio.MusicManager;
import com.JustMoser.ZombieCommander.Helper.Audio.SoundManager;
import com.JustMoser.ZombieCommander.ImageActors.AbstractImage;
import com.JustMoser.ZombieCommander.Screens.SplashScreen;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.FPSLogger;
import com.badlogic.gdx.graphics.GL20;

/**
 * The game's main class, called as application events are fired.
 */
public class Tyrian extends Game //implements ApplicationListener, InputProcessor//implements ApplicationListener
{
    // constant useful for logging
    public static final String LOG = Tyrian.class.getSimpleName();

    // a libgdx helper class that logs the current FPS each second
    private FPSLogger fpsLogger;
    private ProfileManager profileManager;
    private SoundManager soundManager;
    private MusicManager musicManager;
    
    //Keep aspect ratio for all sizes
    //private static final int VIRTUAL_WIDTH = 480;
    //private static final int VIRTUAL_HEIGHT = 800;
    //private static final float ASPECT_RATIO = (float)VIRTUAL_WIDTH/(float)VIRTUAL_HEIGHT;

    //private OrthographicCamera camera;
   // private Rectangle viewport;
   // @SuppressWarnings("unused")
	//private SpriteBatch sb;
    //private GameServices gameServices;
    //private Activity androidActivity;
    //private static IActivityRequestHandler myRequestHandler;

    

    public Tyrian()
    {
    	
    }
    
    //public Tyrian(IActivityRequestHandler requestHandler)
    //{
    //	myRequestHandler = requestHandler;
    //}

    // Screen methods

    public SplashScreen getSplashScreen()
    {
        return new SplashScreen( this );
    }
    
    //public static IActivityRequestHandler getIActivityRequestHandler()
    //{
    //	return myRequestHandler;
    //}



    @Override
    public void create()
    {
    	//sb = new SpriteBatch();
        //camera = new OrthographicCamera(VIRTUAL_WIDTH, VIRTUAL_HEIGHT)
    	
    	
    	//Gdx.input.setInputProcessor(this);
        Gdx.app.log( Tyrian.LOG, "Creating game" );
        fpsLogger = new FPSLogger();
        
        // create the sound manager
        soundManager = new SoundManager();
        // create the sound manager
        musicManager = new MusicManager();

        // create the profile manager
        profileManager = new ProfileManager();
        profileManager.retrieveProfile();
        
        setScreen( getSplashScreen() );
    }

    @Override
    public void resize(
        int width,
        int height )
    {
    	super.resize(width, height);

        Gdx.app.log( Tyrian.LOG, "Resizing game to: " + width + " x " + height );
     // calculate new viewport
        
    }

    @Override
    public void render()
    {
        // clear previous frame
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        super.render();

        // output the current FPS
        fpsLogger.log();
    }

    @Override
    public void pause()
    {
        super.pause();
        Gdx.app.log( Tyrian.LOG, "Pausing game" );
        // persist the profile, because we don't know if the player will come
        // back to the game
        profileManager.persist();
    }

    @Override
    public void resume()
    {
        super.resume();
        Gdx.app.log( Tyrian.LOG, "Resuming game" );
      //load
        //AbstractImage.loadAssets();
    }

    @Override
    public void setScreen(Screen screen )
    {
        super.setScreen( screen );
        Gdx.app.log( Tyrian.LOG, "Setting screen: " + screen.getClass().getSimpleName() );
    }
    @Override
    public void dispose()
    {
        super.dispose();
        Gdx.app.log( Tyrian.LOG, "Disposing game" );
        
        // dipose some services
        musicManager.dispose();
        //AbstractImage.nullStatics();
        AbstractImage.getZombieAtlas().dispose();
        soundManager.dispose();
        musicManager.dispose();
    }
}
