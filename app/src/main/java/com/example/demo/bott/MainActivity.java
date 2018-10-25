package com.example.demo.bott;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView mBv;
    private ViewPager mVp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView(){
        mBv = (BottomNavigationView)findViewById(R.id.bv);
        mVp = (ViewPager) findViewById(R.id.vp);

        BottomNavigationViewHelper.disableShiftMode(mBv);

        mBv.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.item_tab1:
                        mVp.setCurrentItem(0);
                        return true;

                    case R.id.item_tab2:
                        mVp.setCurrentItem(1);
                        return true;

                    case R.id.item_tab3:
                        mVp.setCurrentItem(2);
                        return true;

                    case R.id.item_tab4:
                        mVp.setCurrentItem(3);
                        return true;


                }

                return false;
            }
        });

        setupViewPage(mVp);

        mVp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                mBv.getMenu().getItem(position).setChecked(true);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void setupViewPage(ViewPager viewPager){
        BottomAdapter adapter = new BottomAdapter(getSupportFragmentManager());
        adapter.addFragment(new TabFragment());
        adapter.addFragment(new Tab1Fragment());
        adapter.addFragment(new Tab2Fragment());
        adapter.addFragment(new Tab3Fragment());
        viewPager.setAdapter(adapter);
    }

}
