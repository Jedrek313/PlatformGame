package com.example.jedre.simpleandroidgame;

/**
 * Created by jedre on 29.05.2017.
 */

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;

public class GButton
{
    public Matrix btn_matrix = new Matrix();

    private RectF rect;

    float width;
    float height;
    Bitmap bg;

    public GButton(float width, float height, Bitmap bg)
    {
        this.width = width;
        this.height = height;
        this.bg = bg;

        rect = new RectF(0, 0, width, height);
    }

    public void setPosition(float x, float y)
    {
        btn_matrix.setTranslate(x, y);
        btn_matrix.mapRect(rect);
    }

    public void draw(Canvas canvas)
    {
        canvas.drawBitmap(bg, btn_matrix, null);
    }

    public RectF getRect() {
        return rect;
    }
}