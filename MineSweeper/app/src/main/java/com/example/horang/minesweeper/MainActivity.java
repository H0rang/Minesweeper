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
import android.widget.TextView;

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
        init();
        Button reset = (Button) findViewById(R.id.reset);
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                init();
            }
        });
    }

    public void init(){
        final TextView info = (TextView) findViewById(R.id.info);
        info.setText("Number of mines : 20");

        for(i = 0; i < 10; i++){
            for (j = 0; j < 10; j++){
                grid[i][j] = new Case((Button)greed.getChildAt(i*10 + j));
                Button button = grid[i][j].getButton();
                button.setEnabled(true);
                button.setOnClickListener(new View.OnClickListener() {
                    int a = i;
                    int b = j;
                    @Override
                    public void onClick(View v) {
                        if(grid[a][b].getMine()) {
                            v.setBackgroundColor(Color.RED);
                            grid[a][b].getButton().setText("M");
                            grid[a][b].getButton().setEnabled(false);
                            info.setText("You lost");

                            for(int k = 0; k < 10; k++){
                                for(int l = 0; l < 10; l++){
                                    grid[k][l].getButton().setEnabled(false);
                                }
                            }
                        }
                        else{
                            v.setBackgroundColor(Color.GRAY);
                            int n = grid[a][b].neighbours;
                            if(n == 0){
                                grid[a][b].getButton().setText("");
                            }
                            else{
                                switch(n){
                                    case 1 :
                                        grid[a][b].getButton().setTextColor(Color.BLUE);
                                        break;
                                    case 2 :
                                        grid[a][b].getButton().setTextColor(Color.GREEN);
                                        break;
                                    case 3 :
                                        grid[a][b].getButton().setTextColor(Color.YELLOW);
                                        break;
                                    default:
                                        grid[a][b].getButton().setTextColor(Color.RED);
                                        break;
                                }
                                grid[a][b].getButton().setText("" + n);
                                grid[a][b].getButton().setEnabled(false);
                            }
                        }
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

                if(a > 0 && b > 0)
                    grid[a - 1][b - 1].neighbours++;
                if(a > 0 && b < 9)
                    grid[a - 1][b + 1].neighbours++;
                if(a < 9 && b > 0)
                    grid[a + 1][b - 1].neighbours++;
                if(a < 9 && b < 9)
                    grid[a + 1][b + 1].neighbours++;
                if(a > 0)
                    grid[a - 1][b].neighbours++;
                if(a < 9)
                    grid[a + 1][b].neighbours++;
                if(b > 0)
                    grid[a][b - 1].neighbours++;
                if(b < 9)
                    grid[a][b + 1].neighbours++;
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
