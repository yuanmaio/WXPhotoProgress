package photo.wx.com.wxphotoprogress;

import android.animation.ObjectAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.animation.LinearInterpolator;


import photo.wx.com.wxphotoprogress.view.CircleBackgroundTextView;
import photo.wx.com.wxphotoprogress.view.LineView;

public class MainActivity extends AppCompatActivity implements View.OnTouchListener {
    private CircleBackgroundTextView mCircleBackgroundTextView;
    private LineView mLineView;
    private ObjectAnimator animator;
    private int width;
    private ViewTreeObserver observer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        mCircleBackgroundTextView.setOnTouchListener(this);
    }
//初始化view
    private void initView() {
        mCircleBackgroundTextView= (CircleBackgroundTextView) findViewById(R.id.button_start);
        mLineView= (LineView) findViewById(R.id.lineView);
        observer=mLineView.getViewTreeObserver();
        observer.addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
            @Override
            public boolean onPreDraw() {
                width = mLineView.getMeasuredWidth();
                return true;
            }
        });
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        switch (motionEvent.getAction()){
            case MotionEvent.ACTION_DOWN:
                startAnimator();
                break;
            case MotionEvent.ACTION_UP:
                if(animator!=null && animator.isRunning()){
                    animator.cancel();
                }
                break;

        }
        return true;
    }
    /**
     * 启动线的动画
     */
    private void startAnimator(){
        animator = ObjectAnimator.ofInt(mLineView, "layoutWidth", width, 0);
        animator.setDuration(10000);
        animator.setInterpolator(new LinearInterpolator());
        animator.start();
    }
}
