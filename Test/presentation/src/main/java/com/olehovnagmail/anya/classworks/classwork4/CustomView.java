package com.olehovnagmail.anya.classworks.classwork4;


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class CustomView extends View {

    private Paint paint;
    private float radius;
    private float cx;
    private float cy;
    private RectF rect;

    public CustomView(Context context) {
        super(context);
        init();
    }

    public CustomView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public CustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }


    private void init() {
        paint = new Paint();
        paint.setColor(Color.BLUE);
        paint.setAntiAlias(true);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        cx = w / 2;
        cy = h / 2;
        radius = w > h ? h / 4 : w / 4;

        rect = new RectF();
        rect.left = w / 8;
        rect.top = h / 4;
        rect.right = 7 * w / 8;
        rect.bottom = 3 * h / 4;
    }

    //когда дотрагиваются пальцем до View
    @Override
    public boolean onTouchEvent(MotionEvent event) {

        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:{
                //опустили палец на экран
               // rect.contains(event.getX(),event.getY());
                break;
            }

            case MotionEvent.ACTION_UP:{
                //Подняли палец от экрана
                break;
            }

            case MotionEvent.ACTION_MOVE:{
                cx=event.getX();
                cy = event.getY();
                invalidate();
                return false;
            }
        }
        return true;
    }

    //нужно переписать если заданы wrap_content в xml для нашего элемента CustomView
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        paint.setColor(Color.BLACK);
        canvas.drawRect(rect, paint);
        paint.setColor(Color.MAGENTA);
        canvas.drawLine(getWidth(), 0, 0, getHeight(), paint);
        paint.setColor(Color.BLUE);
        canvas.drawCircle(cx, cy, radius, paint);
    }
}
