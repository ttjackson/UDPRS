package com.lenovo.health.urdrs;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.viewpagerindicator.TabPageIndicator;

import java.util.ArrayList;
import java.util.List;


public class TestActivity extends ActionBarActivity implements Fragment1.OnFragmentInteractionListener, Fragment2.OnFragmentInteractionListener {

    ViewPager viewPager;
    TestPagerAdapter testPagerAdapter;
    Fragment1 fragment1;
    Fragment2 fragment2;
    List<Fragment> list = new ArrayList<Fragment>();
    List<String> titlelist = new ArrayList<String>();
    boolean isStarted = false;
    TabPageIndicator tabPageIndicator;
    @Override
    protected void onStart() {
        super.onStart();
        if (!isStarted) {
            Intent intent = getIntent();
            String temp = intent.getStringExtra("string");
            Toast.makeText(getApplicationContext(), temp, Toast.LENGTH_LONG).show();
            isStarted = true;
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
        //isStarted = false;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        fragment1 = new Fragment1();
        fragment2 = new Fragment2();
        initView();
        testPagerAdapter = new TestPagerAdapter(getSupportFragmentManager(), list, titlelist);
        viewPager = (ViewPager) findViewById(R.id.test_viewpager);
        viewPager.setAdapter(testPagerAdapter);
        tabPageIndicator = (TabPageIndicator) findViewById(R.id.tabpagerindicator);
        tabPageIndicator.setViewPager(viewPager);
    }

    public void initView() {
        list.add(fragment1);
        list.add(fragment2);
        titlelist.add("test1");
        titlelist.add("test2");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_test, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    public class TestPagerAdapter extends FragmentPagerAdapter {

        List<Fragment> mfragmentList = null;
        List<String> mtitleList = null;

        public TestPagerAdapter(FragmentManager fm, List<Fragment> fragmentList, List<String> titleList) {
            super(fm);
            mfragmentList = fragmentList;
            mtitleList = titleList;
        }

        @Override
        public int getCount() {
            return mfragmentList.size();
        }

        @Override
        public Fragment getItem(int i) {
            return mfragmentList.get(i);
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return super.isViewFromObject(view, object);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mtitleList.get(position);
        }
    }
}
