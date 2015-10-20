package com.spizer.mizer2.animations;

import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.widget.GridLayout;

public class BasicsSwitchAnimation extends Animation implements
        Animation.AnimationListener {

    private View view;
    private int currentLeft;
    private int currentTop;
    private int currentRight;
    private int currentBottom;

    GridLayout.LayoutParams GridLayout = new GridLayout.LayoutParams();

    //The steps to skip between size values
    private static int STEP_SIZE=5;
    private static int ANIMATION_DURATION=50;

    public void TransAnim(View view) {
        this.view=view;
        setDuration(ANIMATION_DURATION);
        setRepeatCount(255 / STEP_SIZE);
        setFillAfter(true);
        setInterpolator(new AccelerateDecelerateInterpolator());

        //setAnimationListener(new ThisAnimationListener());
    }

    @Override
    public void onAnimationEnd(Animation animation) {

    }

    @Override
    public void onAnimationRepeat(Animation animation) {
        int i;
        //change depth of the view
        for (i = 1, i<10, i++) {
            GridLayout.setMargins(currentLeft += STEP_SIZE, currentTop += STEP_SIZE,
                    currentRight += STEP_SIZE, currentBottom += STEP_SIZE);
            view.setLayoutParams(GridLayout);
        }
    }

    @Override
    public void onAnimationStart(Animation animation) {
        GridLayout.setMargins(0, 0, 0, 0);
        view.setLayoutParams(GridLayout);
        currentLeft=0;
        currentTop=0;
        currentRight=0;
        currentBottom=0;
    }
}
