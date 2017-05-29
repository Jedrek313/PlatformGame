package com.example.jedre.simpleandroidgame;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.widget.Button;
import android.widget.ImageView;

/**
 * Created by jedre on 29.05.2017.
 */

public class GameView extends SurfaceView implements SurfaceHolder.Callback, Runnable{

    volatile boolean playing;
    private Thread gameThread = null;

    private Player player;
    private  GButton leftButton;
    private  GButton rightButton;

    private Paint paint;
    private Canvas canvas;
    private SurfaceHolder surfaceHolder;

    public GameView(Context context) {
        super(context);
        leftButton = new GButton(200,200, BitmapFactory.decodeResource(context.getResources(), R.drawable.boom));
        leftButton.setPosition(100,850);
        rightButton = new GButton(200,200, BitmapFactory.decodeResource(context.getResources(), R.drawable.boom));
        rightButton.setPosition(200,850);
        player = new Player(75, 50, context);
        surfaceHolder = getHolder();
        paint = new Paint();
    }

    @Override
    public void run() {
        while (playing) {
            update();
            draw();
            //control();
        }
    }

    private void update() {
        player.update();
    }

    private void draw() {
        if (surfaceHolder.getSurface().isValid()) {
            //locking the canvas
            canvas = surfaceHolder.lockCanvas();
            Bitmap background = BitmapFactory.decodeResource(getResources(), R.drawable.background);
            /*
            float scale = (float)background.getHeight()/(float)getHeight();
            int newWidth = Math.round(background.getWidth()/scale);
            int newHeight = Math.round(background.getHeight()/scale);
            Bitmap scaled = Bitmap.createScaledBitmap(background, newWidth, newHeight, true);
            */
            canvas.drawBitmap(background, 0, 0, null);
            //drawing a background color for canvas

            //Drawing the player
            canvas.drawBitmap(
                    player.getBitmap(),
                    player.getX(),
                    player.getY(),
                    paint);

            /*canvas.drawBitmap(
                    rightButton.getBitmap(),
                    rightButton.getX(),
                    rightButton.getY(),
                    paint);

            canvas.drawBitmap(
                    leftButton.getBitmap(),
                    leftButton.getX(),
                    leftButton.getY(),
                    paint);
                    */
            //Unlocking the canvas
            surfaceHolder.unlockCanvasAndPost(canvas);
        }
    }
    public Player getPlayer(){
        return player;
    }
    private void control() {
        try {
            gameThread.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void pause() {
        playing = false;
        try {
            gameThread.join();
        } catch (InterruptedException e) {
        }
    }

    public void resume() {
        playing = true;
        gameThread = new Thread(this);
        gameThread.start();
    }


    @Override
    public void surfaceCreated(SurfaceHolder surfaceHolder) {

    }

    @Override
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i1, int i2) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {

    }
}