package com.example.android_test.loopviewpager;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.ActionBar.Tab;
import com.actionbarsherlock.app.ActionBar.TabListener;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.example.android_test.R;

public class LoopViewPagerActivity extends SherlockFragmentActivity implements TabListener {

     LoopViewPager mPager;
//    ViewPager mPager;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loopviewpager);

        int pgaeNum = 3;

//        mPager = (ViewPager) findViewById(R.id.pager);
         mPager = (LoopViewPager) findViewById(R.id.pager);
//         mPager.setOffscreenPageLimit(3);
//        final MyFragmentStatePagerAdapter adapter = new MyFragmentStatePagerAdapter(getFragmentManager(), pgaeNum);
        final MyFragmentStatePagerAdapter adapter = new MyFragmentStatePagerAdapter(getSupportFragmentManager(), pgaeNum);
        mPager.setAdapter(adapter);
        // pager.setAdapter(new MyPagerAdapter());

        ActionBar actionBar = getSupportActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        for (int i = 0; i < pgaeNum; i++) {
            actionBar.addTab(actionBar.newTab().setText(i + "").setTabListener(this));
        }

        findViewById(R.id.button1).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                adapter.addPage();
                adapter.notifyDataSetChanged();
            }
        });

        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                adapter.removePage();
                adapter.notifyDataSetChanged();
            }
        });
    }

    class MyFragmentStatePagerAdapter extends FragmentStatePagerAdapter {

        public float getPageWidth(int position) {
            // TODO Auto-generated method stub
            super.getPageWidth(position);
            if (position == 1) {
                return 0.78f;
            } else
                return 1.0f;
        }

        int mPageNum = 0;

        public MyFragmentStatePagerAdapter(FragmentManager fm, int pageNum) {
            super(fm);
            mPageNum = pageNum;
        }

        @Override
        public Fragment getItem(int position) {
            return SimpleFragment.newInstance(position);
        }

        @Override
        public int getCount() {
            return mPageNum;
        }

        @Override
        public int getItemPosition(Object object) {
            return POSITION_NONE;
        }

        public void addPage() {
            mPageNum++;
        }

        public void removePage() {
            if (mPageNum > 1) {
                mPageNum--;
            }
        }
    }

    class MyPagerAdapter extends PagerAdapter {

        public MyPagerAdapter() {
            super();
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            TextView tv = new TextView(container.getContext());
            tv.setTextSize(100);
            tv.setText(position + "");
            container.addView(tv);
            return tv;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            View v = (View) object;
            container.removeView(v);
        }

        @Override
        public int getCount() {
            return 5;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == ((View) object);
        }
    }

    public static class SimpleFragment extends Fragment {

        public static SimpleFragment newInstance(int position) {
            Bundle args = new Bundle();
            args.putInt("position", position);
            SimpleFragment sf = new SimpleFragment();
            sf.setArguments(args);
            return sf;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

            int position = getArguments().getInt("position");

            TextView tv = new TextView(inflater.getContext());
            tv.setTextSize(100);
            tv.setText(position + "");
            return tv;
        }
    }

    @Override
    public void onTabReselected(Tab tab, FragmentTransaction ft) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onTabSelected(Tab tab, FragmentTransaction ft) {
        int position = getSupportActionBar().getSelectedNavigationIndex();
        mPager.setCurrentItem(position);
    }

    @Override
    public void onTabUnselected(Tab tab, FragmentTransaction ft) {
        // TODO Auto-generated method stub

    }
}
