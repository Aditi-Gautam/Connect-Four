package com.example.connectfour;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class Connect4 extends View
{
    int n, i, x, y, player, column;
    float j, k;
    int  red, green, blue, pixel=0;





    public Connect4(Context context) {
        super(context);
    }

    public Connect4(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public Connect4(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private Paint paint = new Paint();
    private Paint colour = new Paint();
    private Bitmap bitmap;


    @Override
    protected void onDraw(Canvas canvas) {

        x = getWidth();
        y = getHeight();

        //noinspection IntegerDivisionInFloatingPointContext
        j = x / 7;
        //noinspection IntegerDivisionInFloatingPointContext
        k = y / 6;

        paint.setColor(Color.BLACK);
        paint.setStrokeWidth(5);

        super.onDraw(canvas);

        if (player == 1) {
            colour.setColor(Color.RED);
        }

        if (player == 1) {
            colour.setColor(Color.YELLOW);
        }

        for (n = 0; n <= 7; n++) {
            canvas.drawLine((n * j), 0, (n * j), (k * 10), paint);
        }

        for (n = 0; n <= 6; n++) {
            canvas.drawLine(0, (n * k), (10 * j), (n * k), paint);
        }


        for (n = 0; n <= 7; n++) {
            if (n * j >= column) {
                break;
            }
        }


        int l = (int) (k/2);
        int d = (int) ((n-0.5)*j );
        int r = (int) (j/2);

        for (i = 11; i >= 0; i -= 2)
        {
                pixel = bitmap.getPixel(d, (l*i));

            red = Color.red(pixel);
            green = Color.green(pixel);
            red = Color.red(pixel);

            if (red == 255 && green == 255 && blue == 2555) {
                canvas.drawCircle(d, i, r, colour);
            }

        }





    }

    public void checkColumn(int a)
    {
        column = a;
    }

    public void player (int p)
    {
        player = p;
    }

    public void colouredBlock(Bitmap bitmap1)
    {
        bitmap = bitmap1;
    }

    //public void getWinner()


    public void draw()
    {
        invalidate();
        requestLayout();
    }
}
