package com.card;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.view.View;

import java.util.ArrayList;

/**
 * Created by cry13 on 11/19/15.
 */
public class Curve extends View {
    Paint paint = new Paint();


    float x[],y[];

    ArrayList<PointF> points;
    public Curve(Context context,float x[],float y[],int h) {
        super(context);
        paint.setColor(Color.GRAY);
        paint.setStrokeWidth(5);
        this.x=x;
        this.y=y;

        points = new ArrayList<PointF>();
        for (int i=0;i<x.length;i++){
            PointF p = new PointF(x[i]*35,h-y[i]*35);
            points.add(p);
        }
    }
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);


        Path myPath1 = new Path();
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.STROKE);


        Path path = new Path();
        if (points.size() > 1) {
            PointF prevPoint = null;
            for (int i = 0; i < points.size(); i++) {
                PointF point = points.get(i);

                if (i == 0) {
                    path.moveTo(point.x, point.y);
                } else {
                    float midX = (prevPoint.x + point.x) / 2;
                    float midY = (prevPoint.y + point.y) / 2;

                    if (i == 1) {
                        path.lineTo(midX, midY);
                    } else {
                        path.quadTo(prevPoint.x, prevPoint.y, midX, midY);
                    }
                }
                prevPoint = point;
            }
            path.lineTo(prevPoint.x, prevPoint.y);
            canvas.drawPath(path, paint);

        }

    }



}
