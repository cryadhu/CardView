package com.card;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.view.View;

/**
 * Created by cry13 on 11/19/15.
 */
public class Line extends View {
    Paint paint = new Paint();


    int x1,x2,x3,y1,y2,y3;
    public Line(Context context,int x1,int x2,int x3,int y1,int y2,int y3,int h,int w) {
        super(context);
        paint.setColor(Color.GRAY);
        paint.setStrokeWidth(2);
        this.x1=x1*35;
        this.x2=x2*35;
        this.x3=w-x3*35;
        this.y1=h-y1*35;
        this.y2=h-y2*35;
        this.y3=h-y3*35;
        Log.e("d",""+w);
    }
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        /*canvas.drawLine(x1, y1, x2, y2, paint);
        canvas.drawLine(x1, y1, x3, y3, paint);*/
        canvas.drawLine(x1, y1,x2 , y2, paint);
        canvas.drawLine(x3, y2, x1, y2, paint);

    }



}
