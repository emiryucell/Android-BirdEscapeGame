package com.emirtechs.birdescape;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class BirdEscape extends ApplicationAdapter {


    SpriteBatch batch;
    Texture bg;
    Texture bird;
    float birdX = 0;
    float birdY = 0;
    int gameState = 0;
    float velocity=0f;
    float gravity=0.5f;

    @Override
    public void create() {
        batch = new SpriteBatch();
        bg = new Texture("background.png");
        bird = new Texture("bird.png");

        birdX = Gdx.graphics.getWidth() / 4;
        birdY = Gdx.graphics.getHeight() / 2;

    }

    @Override
    public void render() {

        if (Gdx.input.justTouched()) {
            gameState = 1;
        }
        if (gameState == 1) {

            if(birdY>0 || velocity<0){


                velocity=velocity+gravity;
                birdY=birdY-velocity;
            }

        } else {
            if (Gdx.input.justTouched()) {
                gameState = 1;
            }
        }
        batch.begin();
        batch.draw(bg, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        batch.draw(bird, birdX, birdY, Gdx.graphics.getWidth() / 15, Gdx.graphics.getHeight() / 10);

        batch.end();

    }

    @Override
    public void dispose() {

    }
}
