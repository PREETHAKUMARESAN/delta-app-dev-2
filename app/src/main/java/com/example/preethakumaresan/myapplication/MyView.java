package com.example.preethakumaresan.myapplication;


import android.view.View;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Paint;



/**
 * Created by PREETHA KUMARESAN on 09-06-2016.
 */
public class MyView extends View
{
    Bitmap draw;
    int x,y,dx,dy;

    Canvas canv;


    public MyView(Context context)
    {
        super(context);
        draw= BitmapFactory.decodeResource(getResources(),R.drawable.circle);
        x=0;
        y=0;
    }

    @Override
    public void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        canv = canvas;


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
    public void setPosition(int a,int b)
    {
        dx = a;
        dy = b;
    }


    }


