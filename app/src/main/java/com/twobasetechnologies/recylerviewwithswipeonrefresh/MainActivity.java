package com.twobasetechnologies.recylerviewwithswipeonrefresh;

import android.os.Handler;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.ListFragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.twobasetechnologies.recylerviewwithswipeonrefresh.Adapters.FeeddataAdapter;
import com.twobasetechnologies.recylerviewwithswipeonrefresh.Adapters.ViewPagerAdapter;
import com.twobasetechnologies.recylerviewwithswipeonrefresh.DataModel.Developer;
import com.twobasetechnologies.recylerviewwithswipeonrefresh.Fragments.GridList;
import com.twobasetechnologies.recylerviewwithswipeonrefresh.Fragments.LInearList;
import com.twobasetechnologies.recylerviewwithswipeonrefresh.Fragments.StaggeredList;
import com.twobasetechnologies.recylerviewwithswipeonrefresh.Interface.OnLoadMoreListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private FeeddataAdapter mAdapter;
    ProgressBar imreceive_progressbars;
    private SwipeRefreshLayout swipeRefreshLayout;
    Developer developer;
    ViewPager viewPager;

    private   TabLayout tabLayout;
    ArrayList<Developer> counts = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        ViewPager viewPager = (ViewPager) findViewById(R.id.pager);
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());

        // Add Fragments to adapter one by one
        adapter.addFragment(new LInearList(), "Linear");
        adapter.addFragment(new GridList(), "Grid");
        adapter.addFragment(new StaggeredList(), "Staggered");
        viewPager.setAdapter(adapter);

         tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

    }




}

