package com.xjp.androidtoolbardemo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TableLayout;
import android.widget.Toast;

import com.xjp.androidtoolbardemo.Fragment.GameFragment;
import com.xjp.androidtoolbardemo.Fragment.homeFragment;
import com.xjp.androidtoolbardemo.Fragment.topFragment;
import com.xjp.androidtoolbardemo.R;
import com.xjp.androidtoolbardemo.adapter.TabFragmentAdapter;
import com.xjp.androidtoolbardemo.tools.UiUtils;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends BaseActivity implements Toolbar.OnMenuItemClickListener {

    private Toolbar toolbar;
    //    private FloatingActionButton fab;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private String[] tab_names;  // 标签的名字
    private DrawerLayout drawerLayout;

    private NavigationView navigationView;
    private ViewPager mViewPager;
    private PagerTabStrip pager_tab_strip;

    @Override
    protected int getContentView() {
        return R.layout.activity_main;
    }

    protected void init() {
//        tab_names = UiUtils.getStringArray(R.array.tab_names);
//        tab_names = new String[]{"a", "d", "c", "d"};

         tab_names = this.getResources().getStringArray(R.array.tab_names);
    }


    @Override
    protected void initView() {
//        final TextInputLayout inputLayout = findView(R.id.textInput);
//        inputLayout.setHint("请输入姓名:");
//
//        EditText editText = inputLayout.getEditText();
//        editText.setHintTextColor(getResources().getColor(android.R.color.holo_blue_bright));
//        editText.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//            }
//
//            @Override
//            public void onTextChanged(CharSequence s, int start, int before, int count) {
//                if (s.length() > 4) {
//                    inputLayout.setErrorEnabled(true);
//                    inputLayout.setError("姓名长度不能超过4个");
//                } else {
//                    inputLayout.setErrorEnabled(false);
//                }
//            }
//
//            @Override
//            public void afterTextChanged(Editable s) {
//            }
//        });
        drawerLayout = findView(R.id.drawer_layout);
        navigationView = findView(R.id.navigationView);
        mViewPager = (ViewPager) findViewById(R.id.viewPager);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.sub_exit:
                        finish();
                        break;
                    case R.id.sub_switch:
                        break;
                    case R.id.nav_blog:
                        startActivity(new Intent(MainActivity.this, BlogActivity.class));
                        break;
                    case R.id.nav_ver:
                        break;
                    case R.id.nav_about:
                        break;
                }
                menuItem.setChecked(true);
                drawerLayout.closeDrawers();
                return true;
            }
        });

        pager_tab_strip = (PagerTabStrip) findViewById(R.id.pager_tab_strip);

        initToolbar();
//        initTabLayout();

        mViewPager.setAdapter(new MainAdpater(getSupportFragmentManager()));
    }


    //    public void initTabLayout() {
    private class MainAdpater extends FragmentStatePagerAdapter {
        public MainAdpater(FragmentManager fm) {
            super(fm);
        }

        // 每个条目返回的fragment
        //  0
        @Override
        public Fragment getItem(int position) {
//              通过Fragment工厂  生产Fragment
            if (position == 0) {
                return new GameFragment();
            } else {
                return new topFragment();
//            return new GameFragment();

            }
        }

        // 一共有几个条目
        @Override
        public int getCount() {
            return tab_names.length;
        }

        // 返回每个条目的标题
        @Override
        public CharSequence getPageTitle(int position) {
            return tab_names[position];
        }
//        viewPager = findView(R.id.viewPager);
//
//        tabLayout = findView(R.id.tabs);
//        List<String> tabList = new ArrayList<>();
//        tabList.add("哈哈哈");
//        tabList.add("额");
//        tabList.add("你有病吧");
//        tabList.add("停好玩");
//        tabList.add("Tab5");
//        tabList.add("Tab6");
//        tabList.add("Tab7");
//        tabLayout.setTabMode(TabLayout.MODE_FIXED);//设置tab模式，当前为系统默认模式 TabLayout.MODE_SCROLLABLE
////        tabLayout.setTabMode(tabLayout.MODE_SCROLLABLE);
//        //此处代码设置无效，不知道为啥？？？xml属性是可以的
////        tabLayout.setTabTextColors(android.R.color.white, android.R.color.holo_red_dark);//设置TabLayout两种状态
////        tabLayout.addTab(tabLayout.newTab().setText(tabList.get(0)));//添加tab选项卡
////        tabLayout.addTab(tabLayout.newTab().setText(tabList.get(1)));
////        tabLayout.addTab(tabLayout.newTab().setText(tabList.get(2)));
////        tabLayout.addTab(tabLayout.newTab().setText("Tab4"));
////        tabLayout.addTab(tabLayout.newTab().setText("Tab5"));
////        tabLayout.addTab(tabLayout.newTab().setText("Tab6"));
////        tabLayout.addTab(tabLayout.newTab().setText("Tab7"));
////
//
//        List<Fragment> fragmentList = new ArrayList<>();
////        for (int i = 0; i < tabList.size(); i++) {
////            Fragment f1 = new TabFragment();
//            Bundle bundle = new Bundle();
//////            bundle.putString("content", "http://blog.csdn.net/feiduclear_up \n CSDN 废墟的树");
//            bundle.putString("Data", "data from TestBundle");
////            f1.setArguments(bundle);
////            fragmentList.add(f1);
////    }
//
//        Fragment f1 = new GameFragment();
//        Fragment f2 = new homeFragment();
//        Fragment f3 = new topFragment();
//        fragmentList.add(f1);
//        fragmentList.add(f2);
//        f2.setArguments(bundle);
//        fragmentList.add(f3);
//
//
//        TabFragmentAdapter fragmentAdapter = new TabFragmentAdapter(getSupportFragmentManager(), fragmentList, tabList);
//        viewPager.setAdapter(fragmentAdapter);//给ViewPager设置适配器
//        tabLayout.setupWithViewPager(viewPager);//将TabLayout和ViewPager关联起来。
//        tabLayout.setTabsFromPagerAdapter(fragmentAdapter);//给Tabs设置适配器
    }
//    }

    private void initToolbar() {
        toolbar = findView(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        toolbar.setTitle("小黄人");
//        toolbar.setSubtitle("CSDN");
//        toolbar.setLogo(R.drawable.ic_launcher22);
        toolbar.setNavigationIcon(R.drawable.ic_list_black_24dp);
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setOnMenuItemClickListener(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
        if (id == android.R.id.home) {
            drawerLayout.openDrawer(GravityCompat.START);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    public boolean onMenuItemClick(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.action_edit:
                Toast.makeText(this, "查找按钮", Toast.LENGTH_SHORT).show();
//                Snackbar.make(view, "请输入6位数的密码", Snackbar.LENGTH_SHORT).show();
                break;
            case R.id.action_share:
                Toast.makeText(this, "分享按钮", Toast.LENGTH_SHORT).show();
                break;
        }

        return true;
    }
}
