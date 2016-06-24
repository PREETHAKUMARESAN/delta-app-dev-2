package com.example.preethakumaresan.myapplication;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.view.View;

/**
 * Created by PREETHA KUMARESAN on 15-06-2016.
 */
public class MyView extends View {

    Bitmap draw;
    int x,y,dx,dy;
    public MyView(Context context)
    {
        super(context);
        draw= BitmapFactory.decodeResource(getResources(),R.mipmap.circle);
        x=0;
        y=0;
    }

    @Override
    public void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        //Go down
        if(dy>0)
        {
            if(y<y+dy)
            {
                y++;
                dy--;
            } else
            {
                dy=0;
            }
            //Wrap around
            if(y+draw.getHeight()>canvas.getHeight())
            {
                y=0;
            }
        }
        //Go right
        if(dx>0)
        {
            if(x<x+dx)
            {
                x++;
                dx--;
            }
            else
            {
                dx=0;
            }
            //Wrap around
            if(x+draw.getWidth()>canvas.getWidth())
            {
                x=0;
            }
        }
        //Go left
        else
        if(dx<0)
        {
            if(x>x+dx)
            {
                x--;
                dx++;
            } else
            {
                dx=0;
            }
            //Wrap around
            if(x<0)
            {
                x=canvas.getWidth()-draw.getWidth();
            }
        }

        //GO up
        else
        if (dy<0)
        {
            if(y>y+dy)
            {
                y--;
                dy++;
            } else
            {
                dy=0;
            }
            //Wrap around
            if(y<0)
            {
                y = canvas.getHeight() - draw.getHeight();
            }
        }

        Paint p = new Paint();
        canvas.drawBitmap(draw,x,y,p);
        invalidate();
    }
    public void changeposition(int a,int b)
    {
        dx = a;
        dy = b;
    }
    public void changesize(String shape,String size){
        //Default circle shape
        if(shape.equals("circle"))
        {
            draw = BitmapFactory.decodeResource(getResources(), R.mipmap.circle);

            //Small size
            if(size.equals("small")){
                int width = draw.getWidth();
                int height = draw.getHeight();
                float scaleWidth = ((float) 125) / width;
                float scaleHeight = ((float) 125) / height;

                // CREATE A MATRIX FOR THE MANIPULATION
                Matrix matrix = new Matrix();
                matrix.postScale(scaleWidth, scaleHeight);
                Bitmap changedsize = Bitmap.createBitmap(draw, 0, 0, width, height, matrix, false);
                draw.recycle();
                draw = changedsize;
            }
            //Medium default circle
            else if(size.equals("medium"))
            {
                int width = draw.getWidth();
                int height = draw.getHeight();
                float scaleWidth = ((float) 175) / width;
                float scaleHeight = ((float) 175) / height;
                // CREATE A MATRIX FOR THE MANIPULATION
                Matrix matrix = new Matrix();
                matrix.postScale(scaleWidth, scaleHeight);
                Bitmap changedsize = Bitmap.createBitmap(draw, 0, 0, width, height, matrix, false);
                draw.recycle();
               draw= changedsize;
            }
            //Large default circle
            else if(size.equals("large"))
            {
                int width = draw.getWidth();
                int height = draw.getHeight();
                float scaleWidth = ((float) 250) / width;
                float scaleHeight = ((float)250 ) / height;
                // CREATE A MATRIX FOR THE MANIPULATION
                Matrix matrix = new Matrix();
                matrix.postScale(scaleWidth, scaleHeight);
                Bitmap changedsize = Bitmap.createBitmap(draw, 0, 0, width, height, matrix, false);
                draw.recycle();
                draw = changedsize;
            }
        }
        //square diagram
        else if(shape.equals("square"))
        {
            draw = BitmapFactory.decodeResource(getResources(), R.mipmap.square);
            //Small square
            if(size.equals("small")){
                int width = draw.getWidth();
                int height = draw.getHeight();
                float scaleWidth = ((float) 125) / width;
                float scaleHeight = ((float) 125) / height;
                // CREATE A MATRIX FOR THE MANIPULATION
                Matrix matrix = new Matrix();
                matrix.postScale(scaleWidth, scaleHeight);
                Bitmap changedsize = Bitmap.createBitmap(draw, 0, 0, width, height, matrix, false);
                draw.recycle();
                draw = changedsize;
            }
            //Medium square
            else if(size.equals("medium"))
            {
                int width = draw.getWidth();
                int height = draw.getHeight();
                float scaleWidth = ((float) 175) / width;
                float scaleHeight = ((float) 175) / height;
                // CREATE A MATRIX FOR THE MANIPULATION
                Matrix matrix = new Matrix();
                matrix.postScale(scaleWidth, scaleHeight);
                Bitmap changedsize = Bitmap.createBitmap(draw, 0, 0, width, height, matrix, false);
                draw.recycle();
                draw = changedsize;
            }
            //large siquare
            else if(size.equals("large"))
            {
                int width = draw.getWidth();
                int height = draw.getHeight();
                float scaleWidth = ((float) 250) / width;
                float scaleHeight = ((float) 250) / height;
                // CREATE A MATRIX FOR THE MANIPULATION
                Matrix matrix = new Matrix();
                matrix.postScale(scaleWidth, scaleHeight);
                Bitmap changedsize = Bitmap.createBitmap(draw, 0, 0, width, height, matrix, false);
                draw.recycle();
                draw = changedsize;
            }

        }

    }

}
