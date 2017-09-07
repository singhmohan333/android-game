package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.math.Vector2;


public class MyGdxGame extends ApplicationAdapter implements GestureDetector.GestureListener{
	SpriteBatch batch;
	private OrthographicCamera camera;
	private Texture texture;
	private Sprite sprite;


	@Override
	public void create() {
		batch = new SpriteBatch();
		camera = new OrthographicCamera(Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
		texture = new Texture(Gdx.files.internal("img.png"));
		sprite = new Sprite(texture);

		sprite.setPosition(-sprite.getWidth()/2,-sprite.getHeight()/2);
		Gdx.input.setInputProcessor(new GestureDetector(this));


	}
	@Override
	public void render() {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.setProjectionMatrix(camera.combined);


		batch.begin();
		sprite.draw(batch);
		batch.end();
	}

	@Override
	public void dispose() {

		batch.dispose();
 		texture.dispose();

	}

	@Override
	public boolean pan(float x, float y, float deltaX, float deltaY) {
		camera.translate(-deltaX,deltaY);
		camera.update();
		return false;
	}

	@Override
	public boolean touchDown(float x, float y, int pointer, int button) {
	return false;
	}

	@Override
	public boolean tap(float x, float y, int count, int button) {
		return false;
	}

	@Override
	public boolean longPress(float x, float y) {
		return false;
	}

	@Override
	public boolean fling(float velocityX, float velocityY, int button) {
		return false;
	}



	@Override
	public boolean panStop(float x, float y, int pointer, int button) {
		return false;
	}

	@Override
	public boolean zoom(float initialDistance, float distance) {
		return false;
	}

	@Override
	public boolean pinch(Vector2 initialPointer1, Vector2 initialPointer2, Vector2 pointer1, Vector2 pointer2) {
		return false;
	}

	@Override
	public void pinchStop() {

	}
}
