package com.birds.flappy;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.birds.flappy.States.GameStateManager;
import com.birds.flappy.States.MenuState;

public class FlappyDemo extends ApplicationAdapter {
	public static final int WIDTH = 480;
    public static final int HEIGHT = 800;
    public static final String TITLE = "FlappyBird";
    private GameStateManager gsm;

    private SpriteBatch batch; // should only have one PASS AROUND TO DIFF STATES


	@Override
	public void create () {

		batch = new SpriteBatch();
        gsm = new GameStateManager();
        Gdx.gl.glClearColor(1, 0, 0, 1);
        gsm.push(new MenuState(gsm));
	}

	@Override
	public void render () {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT); // wipes screen clean
        gsm.render(batch); // give it our spritebatch file
		gsm.update(Gdx.graphics.getDeltaTime());
	}

//	@Override
//	public void dispose () {
//		batch.dispose();
//		img.dispose();
//	}
}
