package com.example.horang.minesweeper;


import android.graphics.Color;
import android.widget.Button;

/**
 * Created by horang on 06/04/16.
 */
public class Case{
    private Button button;
    private boolean mine;

    Case(Button b){
        button = b;
        button.setBackgroundColor(Color.BLACK);
        button.setTextSize(12);
        mine = false;
    }

    public Button getButton(){
        return button;
    }

    public void setMine(boolean bool){
        mine = bool;
    }

    public boolean getMine(){
        return mine;
    }
}
