package com.example.android_test;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.android_test.loopviewpager.LoopViewPagerActivity;

public class MainActivity extends Activity {

    /* (non-Javadoc)
     * @see android.app.Activity#onCreate(android.os.Bundle)
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.ImageSwitcherSample1ActivityButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), ImageSwitcherSample1Activity.class));
            }
        });
        findViewById(R.id.ImageSwitcherSample2ActivityButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), ImageSwitcherSample2Activity.class));
            }
        });
        findViewById(R.id.LoopViewPagerActivityButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), LoopViewPagerActivity.class));
            }
        });
    }
}
