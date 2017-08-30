package com.example.cmm.viewpagerdemo.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.example.cmm.viewpagerdemo.R;
import com.example.cmm.viewpagerdemo.adapter.FragmentAdapter;
import com.example.cmm.viewpagerdemo.fragment.Fragment1;
import com.example.cmm.viewpagerdemo.fragment.Fragment2;
import com.example.cmm.viewpagerdemo.fragment.Fragment3;

import java.util.ArrayList;
import java.util.List;

public class FragmentPagerAct extends AppCompatActivity {
    private ViewPager mViewPager;
    List<Fragment> mFragmentList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_pager);

        mViewPager = (ViewPager) findViewById(R.id.viewPager);

        mFragmentList = new ArrayList<>();
        Fragment1 fragment1 = new Fragment1();
        Fragment2 fragment2 = new Fragment2();
        Fragment3 fragment3 = new Fragment3();
        mFragmentList.add(fragment1);
        mFragmentList.add(fragment2);
        mFragmentList.add(fragment3);

        mViewPager.setAdapter(new FragmentAdapter(getSupportFragmentManager(), mFragmentList));

        //监听viewPager页面滑动事件
        mViewPager.addOnPageChangeListener(new MyPageChangeListener());
    }

    /**
     * viewPager 翻页有两种方式，一种是手动滑，一种是代码直接设置setCurrentItem
     * <p>
     * 以下监听，主要用于手动翻页监听
     */
    public class MyPageChangeListener implements ViewPager.OnPageChangeListener {

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            /**
             * 这个方法会在屏幕滚动过程中不断被调用。
             */
        }

        @Override
        public void onPageSelected(int position) {
            /**
             * 当用手指滑动翻页的时候，如果翻动成功了（滑动的距离够长），
             *
             * 手指抬起来就会立即执行这个方法，position就是当前滑动到的页面。
             */

            Toast.makeText(FragmentPagerAct.this, "翻到了第" + (position + 1) + "页", Toast.LENGTH_SHORT).show();

        }

        @Override
        public void onPageScrollStateChanged(int state) {
            /**
             * 这个方法在手指操作屏幕的时候发生变化。有三个值：0（END）,1(PRESS) , 2(UP)
             *
             * 当用手指滑动翻页时，手指按下去的时候会触发这个方法，state值为1
             *
             * 手指抬起时，如果发生了滑动（即使很小），这个值会变为2，然后最后变为0
             */

        }
    }
}
