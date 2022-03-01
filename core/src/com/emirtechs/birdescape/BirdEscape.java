package com.emirtechs.birdescape;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

import java.util.Random;

public class BirdEscape extends ApplicationAdapter {


    SpriteBatch batch;
    Texture bg;
    Texture bird;
    Texture enemy;
    Texture enemy2;
    Texture enemy3;
    float birdX = 0;
    float birdY = 0;
    float enemyVelocity=2;
    Random random;


    int gameState = 0;
    float velocity=0f;
    float gravity=0.5f;

    int numberOfEnemies=4;
    float[] enemyX=new float[numberOfEnemies];
    float[] enemyOffset=new float[numberOfEnemies];
    float[] enemyOffset2=new float[numberOfEnemies];
    float[] enemyOffset3=new float[numberOfEnemies];

    float distance=0;

    @Override
    public void create() {
        batch = new SpriteBatch();
        bg = new Texture("background.png");
        bird = new Texture("bird.png");
        enemy=new Texture("enemy.png");
        enemy2=new Texture("enemy.png");
        enemy3=new Texture("enemy.png");

        distance = Gdx.graphics.getWidth()/2;
        random=new Random();




        birdX = Gdx.graphics.getWidth() / 4;
        birdY = Gdx.graphics.getHeight() / 2;

        for (int i=0; i<numberOfEnemies;i++){


            enemyOffset[i]=(random.nextFloat()-0.5f) * (Gdx.graphics.getHeight()-200);
            enemyOffset2[i]=(random.nextFloat()-0.5f) * (Gdx.graphics.getHeight()-200);
            enemyOffset3[i]=(random.nextFloat()-0.5f) * (Gdx.graphics.getHeight()-200);

            enemyX[i]= Gdx.graphics.getWidth()- enemy.getWidth()/2+i*distance;
        }

    }

    @Override
    public void render() {

        batch.begin();
        batch.draw(bg, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

        if (gameState == 1) {

            if (Gdx.input.justTouched()) {
                velocity=-12;
            }

            for(int i=0; i < numberOfEnemies; i++){

                if(enemyX[i]< Gdx.graphics.getWidth() / 15){
                    enemyX[i]=enemyX[i] +numberOfEnemies*distance;

                    enemyOffset[i]=(random.nextFloat()-0.5f) * (Gdx.graphics.getHeight()-200);
                    enemyOffset2[i]=(random.nextFloat()-0.5f) * (Gdx.graphics.getHeight()-200);
                    enemyOffset3[i]=(random.nextFloat()-0.5f) * (Gdx.graphics.getHeight()-200);


                }else{
                    enemyX[i]=enemyX[i]-enemyVelocity;
                }




                batch.draw(enemy,enemyX[i],Gdx.graphics.getHeight()/2+enemyOffset[i],Gdx.graphics.getWidth() / 15, Gdx.graphics.getHeight() / 10);
                batch.draw(enemy2,enemyX[i],Gdx.graphics.getHeight()/2+enemyOffset2[i],Gdx.graphics.getWidth() / 15, Gdx.graphics.getHeight() / 10);
                batch.draw(enemy3,enemyX[i],Gdx.graphics.getHeight()/2+enemyOffset3[i],Gdx.graphics.getWidth() / 15, Gdx.graphics.getHeight() / 10);

            }





            if(birdY>0 || velocity<0){


                velocity=velocity+gravity;
                birdY=birdY-velocity;
            }

        } else {
            if (Gdx.input.justTouched()) {
                gameState = 1;
            }
        }

        batch.draw(bird, birdX, birdY, Gdx.graphics.getWidth() / 15, Gdx.graphics.getHeight() / 10);

        batch.end();

    }

    @Override
    public void dispose() {

    }
}
