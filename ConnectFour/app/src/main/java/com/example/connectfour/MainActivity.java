package com.example.connectfour;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.graphics.Bitmap;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;


public class MainActivity extends AppCompatActivity {


    private ImageView imageView;

    private Bitmap bitmap;

    int player = 2;

    int[][] array = new int[][]{
            { 0, 0, 0, 0, 0, 0, 0},
            { 0, 0, 0, 0, 0, 0, 0},
            { 0, 0, 0, 0, 0, 0, 0},
            { 0, 0, 0, 0, 0, 0, 0},
            { 0, 0, 0, 0, 0, 0, 0},
            { 0, 0, 0, 0, 0, 0, 0}
    };



    private Connect4 gridFormation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridFormation = findViewById(R.id.Connect4);

        gridFormation.draw();



        imageView = findViewById(R.id.imageView1);

        imageView.setDrawingCacheEnabled(true);
        imageView.buildDrawingCache(true);

        imageView.setOnTouchListener(new View.OnTouchListener()
        {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {


                player = player == 1 ? 2 : 1 ;

                gridFormation.player(player);

                int x = (int) motionEvent.getRawX();
                gridFormation.checkColumn(x);

                if(motionEvent.getAction() == MotionEvent.ACTION_DOWN)
                {
                    view.performClick();
                    bitmap = Bitmap.createBitmap(imageView.getWidth(), imageView.getHeight(), Bitmap.Config.ARGB_8888);
                    bitmap = imageView.getDrawingCache();
                    gridFormation.colouredBlock(bitmap);
                    gridFormation.getWinner(array);
                }
                return true;
            }
        });
    }
}