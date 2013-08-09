package com.example.android_test;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ViewSwitcher.ViewFactory;

public class ImageSwitcherSample2Activity extends Activity implements ViewFactory {

    private final static String TAG = "PhotoView";

    private ImageSwitcher mSwitcher;
    // 画像を20枚準備
    private int[] images = { R.drawable.photo_01, R.drawable.photo_02, R.drawable.photo_03, R.drawable.photo_04,
            R.drawable.photo_05, R.drawable.photo_06, R.drawable.photo_07, R.drawable.photo_08, R.drawable.photo_09,
            R.drawable.photo_10 };
    // 現在表示中の画像の位置
    private int position = 0;
    private GestureDetector myGestureDetector;
    public static final int THRESHOLD = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imageswitchersample2);

        mSwitcher = (ImageSwitcher) findViewById(R.id.imageswitcher);
        mSwitcher.setFactory(this); // この処理を行わないと例外で落ちた
        position = getIntent().getIntExtra("position", 0);
        mSwitcher.setImageResource(images[position]);
        myGestureDetector = new GestureDetector(this, new OnGestureListener() {
            private boolean event = true;

            @Override
            public boolean onSingleTapUp(MotionEvent e) {
                Log.d(TAG, "onSingletapUp");
                event = true;
                return false;
            }

            @Override
            public void onShowPress(MotionEvent e) {
                Log.d(TAG, "onShowPress");
            }

            @Override
            public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
                Log.d(TAG, "onScroll");
                event = true;
                return false;
            }

            @Override
            public void onLongPress(MotionEvent e) {
                // do nothing
                Log.d(TAG, "onLongPress");
            }

            @Override
            public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
                Log.d(TAG, "onFling");
                if (Math.abs(e2.getX() - e1.getX()) > THRESHOLD) {
                    if (velocityX < 0) {
                        showNext();
                    } else {
                        showPrevious();
                    }
                    event = true;
                    return true;
                }
                return false;
            }

            @Override
            public boolean onDown(MotionEvent e) {
                Log.d(TAG, "onDown");
                if (event) {
                    event = false;
                    return true;
                } else {
                    return false;
                }
            }

        });
        mSwitcher.setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return myGestureDetector.onTouchEvent(event);
            }
        });
    }

    private void showNext() {
        position += 1;
        if (position >= images.length) {
            position = 0;
        }
        // AnimationHelperは個人のライブラリです。あしからず。
        mSwitcher.setInAnimation(AnimationHelper.inFromRightAnimation());
        mSwitcher.setOutAnimation(AnimationHelper.outToLeftAnimation());
        mSwitcher.setImageResource(images[position]);
    }

    private void showPrevious() {
        position -= 1;
        if (position < 0) {
            position = images.length - 1;
        }
        // AnimationHelperは個人のライブラリです。あしからず。
        mSwitcher.setInAnimation(AnimationHelper.inFromLeftAnimation());
        mSwitcher.setOutAnimation(AnimationHelper.outToRightAnimation());
        mSwitcher.setImageResource(images[position]);
    }

    public View makeView() {
        // ApiDemos->Views->ImageSwitcherのソースからメソッドを丸々コピー
        ImageView i = new ImageView(this);
        //        i.setBackgroundColor(0xFF000000);
        i.setScaleType(ImageView.ScaleType.FIT_CENTER);
        i.setLayoutParams(new ImageSwitcher.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
        return i;
    }

}
