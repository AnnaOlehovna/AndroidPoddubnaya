package com.olehovnagmail.anya.presentation.screens.homework4;


import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Picture;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;

import com.olehovnagmail.anya.R;

import java.util.Calendar;

public class MyAnalogClock extends View {

    private Paint paint;


    private float widthForPaint;
    private float radius;
    private float cx;
    private float cy;

    private float lineStartX;
    private float lineStartY;
    private float lineEndX;
    private float lineEndY;

    private float lengthSecondHand;
    private float lengthMinuteHand;
    private float lengthHourHand;

    private float stopXHour;
    private float stopYHour;
    private float stopXMinutes;
    private float stopYMinutes;
    private float stopXSeconds;
    private float stopYSeconds;


    public MyAnalogClock(Context context) {
        super(context);
    }

    public MyAnalogClock(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyAnalogClock(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public MyAnalogClock(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);


        cx = w / 2f;
        cy = h / 2f;
        radius = w > h ? h / 3f : w / 3f;

        widthForPaint = 0.02f * radius;

        lineStartX = cx;
        lineStartY = cy - radius;
        lineEndX = cx;
        lineEndY = lineStartY + 0.05f * radius;

        lengthSecondHand = 3f * radius / 4f;
        lengthMinuteHand = lengthSecondHand;
        lengthHourHand = radius / 2f;

    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(getResources().getColor(R.color.clockBackground));
        paint.setStyle(Paint.Style.FILL);
        canvas.drawCircle(cx, cy, radius, paint);



        paint.reset();
        paint.setAntiAlias(true);
        paint.setStrokeWidth(widthForPaint);
        paint.setColor(getResources().getColor(R.color.clockBounds));
        paint.setStyle(Paint.Style.STROKE);
        canvas.drawCircle(cx, cy, radius, paint);


        canvas.save();
        for (int i = 0; i < 12; i++) {
            canvas.drawLine(lineStartX, lineStartY, lineEndX, lineEndY, paint);
            canvas.rotate(30, cx, cy);

        }
        canvas.restore();

        paint.setTextSize(radius / 5f);

        paint.setTextAlign(Paint.Align.CENTER);
        canvas.drawText("12", cx, cy - 5.8f * radius / 8f, paint);
        canvas.drawText("6", cx, cy + 7f * radius / 8f, paint);

        paint.setTextAlign(Paint.Align.RIGHT);
        canvas.drawText("3", cx + 7f * radius / 8f, cy + radius / 10f, paint);

        paint.setTextAlign(Paint.Align.LEFT);
        canvas.drawText("9", cx - 7f * radius / 8f, cy + radius / 10f, paint);

        Calendar calendar = Calendar.getInstance();
        float hour = calendar.get(Calendar.HOUR);
        float minutes = calendar.get(Calendar.MINUTE);
        float seconds = calendar.get(Calendar.SECOND);

        stopXHour = cx + (float) (lengthHourHand * Math.sin(hour * Math.PI / 6 + minutes * Math.PI / 360));
        stopYHour = cy - (float) (lengthHourHand * Math.cos(hour * Math.PI / 6 + minutes * Math.PI / 360));

        stopXMinutes = cx + (float) (lengthMinuteHand * Math.sin(minutes * Math.PI / 30));
        stopYMinutes = cy - (float) (lengthMinuteHand * Math.cos(minutes * Math.PI / 30));

        stopXSeconds = cx + (float) (lengthSecondHand * Math.sin(seconds * Math.PI / 30));
        stopYSeconds = cy - (float) (lengthSecondHand * Math.cos(seconds * Math.PI / 30));

        paint.setColor(getResources().getColor(R.color.hourHand));
        canvas.drawLine(cx, cy, stopXHour,stopYHour, paint);

        paint.setColor(getResources().getColor(R.color.minuteHand));
        canvas.drawLine(cx, cy, stopXMinutes,stopYMinutes, paint);

        paint.setColor(getResources().getColor(R.color.secondHand));
        canvas.drawLine(cx, cy, stopXSeconds,stopYSeconds, paint);

        paint.setStyle(Paint.Style.FILL);
        canvas.drawCircle(cx, cy, widthForPaint, paint);

        invalidate();


    }


}
