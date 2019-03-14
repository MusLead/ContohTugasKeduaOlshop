package com.lazday.tugaskeduaolshop;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.design.widget.TabLayout;

import com.lazday.tugaskeduaolshop.Fragment.JavaFragment;
import com.lazday.tugaskeduaolshop.Fragment.KotlinFragment;
import com.lazday.tugaskeduaolshop.adapter.TabAdapter;

public class MainActivity extends AppCompatActivity {

    public static TabLayout tabLayout;
    ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewPager);

        addTab(viewPager);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void addTab(ViewPager viewPager) {
        TabAdapter adapter = new TabAdapter(getSupportFragmentManager());
        adapter.addFragment(new KotlinFragment(),"Kotlin");
        adapter.addFragment(new JavaFragment(),"Java");
        viewPager.setAdapter(adapter);
    }
}
