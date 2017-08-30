package com.example.cmm.viewpagerdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.cmm.viewpagerdemo.activity.FragmentPagerAct;
import com.example.cmm.viewpagerdemo.activity.PagerTabAct;
import com.example.cmm.viewpagerdemo.activity.PagerTitleAct;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void goPager_title(View view) {
        startActivity(new Intent(this, PagerTitleAct.class));
    }

    public void goPager_tab(View view) {
        startActivity(new Intent(this, PagerTabAct.class));
    }

    public void goFragmentPager(View view) {
        startActivity(new Intent(this, FragmentPagerAct.class));
    }


}
