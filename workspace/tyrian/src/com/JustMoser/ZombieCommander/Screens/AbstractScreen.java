package com.JustMoser.ZombieCommander.Screens;

import com.JustMoser.ZombieCommander.Tyrian;
import com.JustMoser.ZombieCommander.ImageActors.AbstractImage;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

/**
 * The base class for all game screens.
 */
public abstract class AbstractScreen implements Screen
{
    protected final Tyrian game;
    private static Tyrian staticGame;
    protected final Stage stage;
    private BitmapFont font;
    private SpriteBatch batch;
    private Skin skin;
    private Table table;
    private static Button nextLevel;
    private static Button mainMenu;
    private TextureRegion splashRegion;
    private TextureRegion menuRegion;
    private Image menuBackgroundImage;
    
    private TextureAtlas atlas;


    public AbstractScreen(Tyrian game )
    {
        this.game = game;
        staticGame = game;
        this.stage = new Stage( 480, 800, true );
        //this.resize(Gdx.app.getGraphics().getWidth(), Gdx.app.getGraphics().getHeight());
        //this.stage.setCamera(new OrthographicCamera(480, 800));
        //this.stage.getCamera().position.set(480/2, 800/2, 0f);
        //this.stage.getCamera().update();
        //this.stage.getCamera().unproject(new Vector3(0,0,0));
        AbstractImage.setStaticstage(this.stage);
        
    }

    protected String getName()
    {
        return getClass().getSimpleName();
    }
    
    public BitmapFont getFont()
    {
        if( font == null ) {
            font = new BitmapFont();
        }
        return font;
    }
    
    protected Skin getSkin()
    {
        if( skin == null ) {
            FileHandle skinFile = Gdx.files.internal( "uiskin.json" );
            skin = new Skin( skinFile );
            AbstractImage.setSkin(skinFile);
        }
        return skin;
    }


    public SpriteBatch getBatch()
    {
        if( batch == null ) {
            batch = new SpriteBatch();
        }
        return batch;
    }
    
    public static Button getNextLevelButton()
    {
    	return nextLevel;
    }
    
    public static void loadNextLevelButton()
    {
    	//if (nextLevel == null) {
    		nextLevel = new Button(AbstractImage.getSkin());
    		nextLevel.add("Exit");
            
    		nextLevel.addListener(new ClickListener() {
        		@Override
        		public void touchUp(InputEvent event,float x,float y,int pointer,int button)
                {
                    super.touchUp( event, x, y, pointer, button );
                    AbstractImage.resetArrays();
                    staticGame.setScreen(new WorldSelectScreen(staticGame));
                }
        	});
    	//}
    	
    }
    
    public static Button getMainMenuButton()
    {
    	return mainMenu;
    }
    
    public static void loadMainMenuButton()
    {
    	//if (mainMenu == null) {
    		mainMenu = new Button(AbstractImage.getSkin());
    		mainMenu.add("Exit To Menu");
            
    		mainMenu.addListener(new ClickListener() {
        		@Override
        		public void touchUp(InputEvent event,float x,float y,int pointer,int button)
                {
                    super.touchUp( event, x, y, pointer, button );
                    AbstractImage.resetArrays();
                    staticGame.setScreen(new MenuScreen(staticGame));
                }
        	});
    	//}
    	
    }
    
    public static void loadAssets()
    {
    	loadMainMenuButton();
    	loadNextLevelButton();
    }

    // Screen implementation

    @Override
    public void show()
    {
        Gdx.app.log( Tyrian.LOG, "Showing screen: " + getName() );
        // set the input processor
        Gdx.input.setInputProcessor( stage );
        stage.clear();
    }

    @Override
    public void resize( int width, int height )
    {
    	//this.resize(width, height);
        Gdx.app.log( Tyrian.LOG, "Resizing screen: " + getName() + " to: " + width + " x " + height );

        // resize the stage
        stage.setViewport( 480, 800, true );
        
        /*Vector2 size = Scaling.fit.apply(800, 480, width, height);
        int viewportX = (int)(width - size.x) / 2;
        int viewportY = (int)(height - size.y) / 2;
        int viewportWidth = (int)size.x;
        int viewportHeight = (int)size.y;
        Gdx.gl.glViewport(viewportX, viewportY, viewportWidth, viewportHeight);*/
        
        //stage.setViewport(800, 480, true, 0, 0, width, height);
        
        //stage.clear();
    }

    @Override
    public void render(float delta )
    {
        // the following code clears the screen with the given RGB color (black)
        Gdx.gl.glClearColor( 0f, 0f, 0f, 1f );
        Gdx.gl.glClear( GL20.GL_COLOR_BUFFER_BIT );
        
        //update touches
        if (Gdx.input.isTouched()){
        	Vector3 touch = new Vector3(0,0,0);
        	stage.getCamera().unproject(touch.set(Gdx.input.getX(), Gdx.input.getY(), 0));
        	
        }

        // update and draw the stage actors
        stage.act( delta );
        stage.draw();
    }
    
    public TextureAtlas getAtlas()
    {
        if( atlas == null ) {
            atlas = new TextureAtlas( Gdx.files.internal( "gameTextures.pack" ) );
        }
        return atlas;
    }
    
    protected Table getTable()
    {
        if( table == null ) {
            table = new Table(getSkin());
            table.setFillParent( true );
            //table.debug();
            stage.addActor( table );
        }
        return table;
    }
    
    public TextureRegion getSplashRegion()
    {
    	if (splashRegion == null){
    		splashRegion = getAtlas().findRegion( "splash" );
    	}
    	return splashRegion;
    }
    
    public TextureRegion getMenuRegion()
    {
    	if (menuRegion == null){
    		return getAtlas().findRegion( "MenuBackground" );
    	}
    	return menuRegion;
    }
    
    public Image getMenuBackgroundImage()
    {
 		if (menuBackgroundImage == null) {
 			menuBackgroundImage = new Image(getMenuRegion());
 			menuBackgroundImage.setFillParent(true);
 		}
    	return menuBackgroundImage;
    }

    @Override
    public void hide()
    {
        Gdx.app.log( Tyrian.LOG, "Hiding screen: " + getName() );
        dispose();
    }

    @Override
    public void pause()
    {
        Gdx.app.log( Tyrian.LOG, "Pausing screen: " + getName() );
    }

    @Override
    public void resume()
    {
        Gdx.app.log( Tyrian.LOG, "Resuming screen: " + getName() );
    }

    @Override
    public void dispose()
    {
        Gdx.app.log( Tyrian.LOG, "Disposing screen: " + getName() );

        // dispose the collaborators
        if( font != null ) font.dispose();
        if( batch != null ) batch.dispose();
        if( skin != null ) skin.dispose();
        if( atlas != null ) atlas.dispose();
        this.stage.clear();
        this.stage.dispose();
    }
}
