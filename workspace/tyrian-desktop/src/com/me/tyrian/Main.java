package com.me.tyrian;

import com.JustMoser.ZombieCommander.Tyrian;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.ApplicationListener;

public class Main {
	public static void main(String[] args )
	    {
	        // create the listener that will receive the application events
	        ApplicationListener listener = new Tyrian();
	 
	        // define the window's title
	        String title = "Tyrian";
	 
	        // define the window's size
	        //int width = 480, height = 800;
	        int width = 1200, height = 1920;
	 
	        // whether to use OpenGL ES 2.0
	        boolean useOpenGLES2 = true;
	 
	        // create the game
	        new LwjglApplication( listener, title, width, height, useOpenGLES2 );
	    }
}
