package com.example.horang.minesweeper;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;

import java.util.Random;

public class MainActivity extends AppCompatActivity{
    Case[][] grid;
    GridLayout greed;
    int i, j;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        greed = (GridLayout) findViewById(R.id.greed);

        grid = new Case[10][10];
        for(i = 0; i < 10; i++){
            for (j = 0; j < 10; j++){
                grid[i][j] = new Case((Button)greed.getChildAt(i*10 + j));
                Button button = grid[i][j].getButton();
                button.setOnClickListener(new View.OnClickListener() {
                    int a = i;
                    int b = j;
                    @Override
                    public void onClick(View v) {
                        if(grid[a][b].getMine()) {
                            v.setBackgroundColor(Color.RED);
                            grid[a][b].getButton().setText("M");
                        }
                        else
                            v.setBackgroundColor(Color.GRAY);

                    }
                });
            }
        }

        int n = 20;
        while(n > 0){
            Random rnd = new Random();
            int a = rnd.nextInt(10);
            int b = rnd.nextInt(10);
            if(!grid[a][b].getMine()){
                grid[a][b].setMine(true);
                n--;
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
