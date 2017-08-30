package com.example.cmm.viewpagerdemo.activity;

import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;

import com.example.cmm.viewpagerdemo.R;

import java.util.ArrayList;
import java.util.List;

public class PagerTabAct extends AppCompatActivity {
    private ViewPager mViewPager;
    private PagerTabStrip mTabStrip;

    private List<View> mViewList;
    private List<String> mTitleList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pager_tab);
        mViewPager = (ViewPager) findViewById(R.id.viewPager);
        mTabStrip = (PagerTabStrip) findViewById(R.id.pager_strip);

        //初始化数据
        initData();

        //PagerAdapter的下面四个函数必须被重写
        PagerAdapter mPagerAdapter = new PagerAdapter() {
            @Override
            public int getCount() {
                //View的count
                return mViewList.size();
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                //object为instantiateItem  return的Object对象

                return view == object;

//                return view==mViewList.get(Integer.valueOf(String.valueOf(object)));
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {

                container.addView(mViewList.get(position));
                return mViewList.get(position);

                //TODO 如果return的是position，那么 isViewFromObject return 被注释掉的代码
//                return position;
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {

                container.removeView(mViewList.get(position));

            }

            @Override
            public CharSequence getPageTitle(int position) {  //只是显示标题，非必须实现方法
                return mTitleList.get(position);
            }

        };


        mViewPager.setAdapter(mPagerAdapter);
    }

    private void initData() {
        mViewList = new ArrayList<>();

        View view1 = View.inflate(this, R.layout.item_view1, null);
        View view2 = View.inflate(this, R.layout.item_view2, null);
        View view3 = View.inflate(this, R.layout.item_view3, null);
        mViewList.add(view1);
        mViewList.add(view2);
        mViewList.add(view3);

        mTitleList = new ArrayList<>();
        mTitleList.add("界面一");
        mTitleList.add("界面二");
        mTitleList.add("界面三");
    }

    //只显示当前界面的title
    public void oneTitle(View v) {
        mTabStrip.getChildAt(0).setVisibility(View.GONE);
        mTabStrip.getChildAt(2).setVisibility(View.GONE);
    }

    public void changeColor(View v) {
        mTabStrip.setTabIndicatorColorResource(R.color.green);  //改变标题下划线颜色
    }
}
