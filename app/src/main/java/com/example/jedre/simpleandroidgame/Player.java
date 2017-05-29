package com.example.jedre.simpleandroidgame;

import android.content.Context;
import android.graphics.BitmapFactory;

/**
 * Created by jedre on 29.05.2017.
 */

public class Player extends Person {

    public Player(int x, int y, Context context) {
        super(x, y, context);
        bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.player);
    }

}
