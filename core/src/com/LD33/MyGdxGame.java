package com.LD33;

import com.LD33.Helpers.AnimatedSprite;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;

public class MyGdxGame extends ApplicationAdapter {
	private Array<ApplicationListener> _gameObjects;

	public MyGdxGame(){
		_gameObjects = new Array<ApplicationListener>();
	}

	@Override
	public void create () {
		CreateGameObjects();
	}

	@Override
	public void render () {
		for(int i=0;i<_gameObjects.size;i++){
			_gameObjects.get(i).render();
		}
	}

	private void CreateGameObjects() {
		AnimatedSprite animatedSprite = new AnimatedSprite("badlogic.jpg");
		animatedSprite.create();
		_gameObjects.add(animatedSprite);
	}
}
