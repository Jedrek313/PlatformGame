package com.example.jedre.simpleandroidgame;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Game extends AppCompatActivity implements View.OnClickListener {

    private GameView gameView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        FrameLayout game = new FrameLayout(this);
        LinearLayout gameWidgets = new LinearLayout (this);
        Button leftButton = new Button(this);
        leftButton.setWidth(200);
        leftButton.setHeight(200);
        leftButton.setX(100);
        leftButton.setY(850);
        leftButton.setText("LEFT");
        Button rightButton = new Button(this);
        rightButton.setWidth(200);
        rightButton.setHeight(200);
        rightButton.setX(150);
        rightButton.setY(850);
        rightButton.setText("RIGHT");
        gameWidgets.addView(leftButton);
        gameWidgets.addView(rightButton);
        gameView = new GameView(this);
        leftButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                gameView.getPlayer().moveLeft();
            }
        });
        //leftButton.setON
        rightButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                gameView.getPlayer().moveRight();
            }
        });

        game.addView(gameView);
        game.addView(gameWidgets);

        setContentView(game);
    }

    @Override
    protected void onPause() {
        super.onPause();
        gameView.pause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        gameView.resume();
    }

    @Override
    public void onClick(View view) {

    }
}
