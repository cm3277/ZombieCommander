package com.JustMoser.ZombieCommander.Screens;

import static com.badlogic.gdx.scenes.scene2d.actions.Actions.delay;
import static com.badlogic.gdx.scenes.scene2d.actions.Actions.fadeIn;
import static com.badlogic.gdx.scenes.scene2d.actions.Actions.fadeOut;
import static com.badlogic.gdx.scenes.scene2d.actions.Actions.sequence;

import com.JustMoser.ZombieCommander.Tyrian;
import com.JustMoser.ZombieCommander.ImageActors.AbstractImage;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.Scaling;

/**
 * Shows a splash image and moves on to the next screen.
 */
public class SplashScreen extends AbstractScreen
{
    //private Texture splashTexture;
    private Image splashImage;
    //private static TextureRegion splashRegion;

    public SplashScreen( Tyrian game )
    {
        super( game );
    }

    @Override
    public void show()
    {
        super.show();
        
        //stage.clear();
        
        //AtlasRegion splashRegion = getSplashRegion();
        //Drawable splashDrawable = new TextureRegionDrawable( splashRegion );

        // here we create the splash image actor; its size is set when the
        // resize() method gets called
        splashImage = new Image( getSplashRegion() );
        splashImage.setScaling(Scaling.stretch);
        splashImage.setFillParent( true );

        // this is needed for the fade-in effect to work correctly; we're just
        // making the image completely transparent
        splashImage.getColor().a = 0f;
        
        //splashImage.addAction(fadeIn(0.75f));
        
        

        // configure the fade-in/out effect on the splash image
        splashImage.addAction( sequence( fadeIn(0.75f), delay( 0.75f ),
            new Action() {
                @Override
                public boolean act(
                    float delta )
                {
                	//load crazy amount of assets
                    AbstractImage.loadAssets();
                    // the last action will move to the next screen
                    //game.setScreen( new MenuScreen( game ) );
                    return true;
                }
            }, fadeOut(0.75f),
            new Action() {
                @Override
                public boolean act(
                    float delta )
                {
                	//load crazy amount of assets
                    //AbstractImage.loadAssets();
                    // the last action will move to the next screen
                    game.setScreen( new MenuScreen( game ) );
                    return true;
                }
            }) );

        // and finally we add the actor to the stage
        stage.addActor( splashImage );
    }
}