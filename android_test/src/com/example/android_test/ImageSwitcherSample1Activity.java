package com.example.android_test;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Gallery.LayoutParams;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ViewSwitcher.ViewFactory;

public class ImageSwitcherSample1Activity extends FragmentActivity implements ViewFactory {

    private final static String TAG = "PhotoView";

    private ImageSwitcher mSwitcher;
    // 画像を20枚準備
    private int[] images = { R.drawable.photo_01, R.drawable.photo_02, R.drawable.photo_03, R.drawable.photo_04,
            R.drawable.photo_05, R.drawable.photo_06, R.drawable.photo_07, R.drawable.photo_08, R.drawable.photo_09,
            R.drawable.photo_10 };
    // 現在表示中の画像の位置
    private int position = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imageswitchersample1);

        mSwitcher = (ImageSwitcher) findViewById(R.id.imageswitcher);
        mSwitcher.setFactory(this); // この処理を行わないと例外で落ちた
        position = getIntent().getIntExtra("position", 0);
        mSwitcher.setImageResource(images[position]);

        // 今日はフリック実装する時間なかったので、
        // クリックされたら次の画像へスライドという形
        mSwitcher.setOnClickListener(new OnClickListener() {

            public void onClick(View v) {
                showNext();
                // showPrevious();
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
