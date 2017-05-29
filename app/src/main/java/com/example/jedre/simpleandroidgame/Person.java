package com.example.jedre.simpleandroidgame;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

/**
 * Created by jedre on 29.05.2017.
 */

public abstract class Person {


    protected Bitmap bitmap;
    private int x;
    private int y;
    private int speed = 0;
    private int directionH = 0;

    public Person(int x, int y, Context context){
        this.x=x;
        this.y=y;
        this.speed = 15;
    }
    public void update(){
        moveHorizontal();
        x++;
    }

    public Bitmap getBitmap(){
        return bitmap;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void moveLeft(){
        this.directionH = -speed;
    }

    public void moveRight(){
        this.directionH = speed;
    }

    public void moveHorizontal(){
        this.x+=this.directionH;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getSpeed() {
        return speed;
    }
}
