package com.LD33.Helpers;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class AnimatedSprite implements ApplicationListener {
    private static final int FRAME_COLS = 6;
    private static final int FRAME_ROWS = 5;

    private float stateTime;
    private Animation walkAnimation;
    private Texture walkSheet;
    private TextureRegion currentFrame;
    private TextureRegion[] walkFrames;

    //additional fields
    private String imagePath;


    protected SpriteBatch SpriteBatch;

    public AnimatedSprite(String imagePath){
        this.imagePath = imagePath;
    }

    @Override
    public void create() {
        walkSheet = new Texture(Gdx.files.internal(imagePath)); // #9
        TextureRegion[][] tmp = TextureRegion.split(walkSheet, walkSheet.getWidth()/FRAME_COLS, walkSheet.getHeight()/FRAME_ROWS);
        walkFrames = new TextureRegion[FRAME_COLS * FRAME_ROWS];
        int index = 0;
        for (int i = 0; i < FRAME_ROWS; i++) {
            for (int j = 0; j < FRAME_COLS; j++) {
                walkFrames[index++] = tmp[i][j];
            }
        }
        walkAnimation = new Animation(0.25f, walkFrames);
        SpriteBatch = new SpriteBatch();
        stateTime = 0f;
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void render() {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);
        stateTime += Gdx.graphics.getDeltaTime();
        currentFrame = walkAnimation.getKeyFrame(stateTime, true);
        SpriteBatch.begin();
        SpriteBatch.draw(currentFrame, 50, 50);
        SpriteBatch.end();
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void dispose() {

    }
}
