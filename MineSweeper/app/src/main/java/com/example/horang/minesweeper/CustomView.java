package com.example.horang.minesweeper;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by horang on 30/03/16.
 */
public class CustomView extends View{
    private Button reset;
    private Button modebutton;
    private TextView nbmines;
    private TextView nbmarked;

    public CustomView(Context context){
        super(context);
        init();
    }

    public CustomView(Context context, AttributeSet as){
        super(context, as);
        init();
    }

    public CustomView(Context context, AttributeSet as, int default_style) {
        super(context, as, default_style);
        init();
    }

    public void init(){
        reset = (Button) findViewById(R.id.reset);
        modebutton = (Button) findViewById(R.id.modebutton);
        nbmines = (TextView) findViewById(R.id.nbmines);
        nbmarked = (TextView) findViewById(R.id.nbmarked);
    }
}
