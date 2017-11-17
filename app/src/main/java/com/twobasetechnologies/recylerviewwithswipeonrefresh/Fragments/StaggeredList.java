package com.twobasetechnologies.recylerviewwithswipeonrefresh.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.twobasetechnologies.recylerviewwithswipeonrefresh.Adapters.FeeddataAdapter;
import com.twobasetechnologies.recylerviewwithswipeonrefresh.DataModel.Developer;
import com.twobasetechnologies.recylerviewwithswipeonrefresh.Interface.OnLoadMoreListener;
import com.twobasetechnologies.recylerviewwithswipeonrefresh.MainActivity;
import com.twobasetechnologies.recylerviewwithswipeonrefresh.R;

import java.util.ArrayList;

public class StaggeredList extends Fragment implements OnLoadMoreListener {

    private RecyclerView recyclerView;
    private FeeddataAdapter mAdapter;
    OnLoadMoreListener thiss;
    ProgressBar imreceive_progressbars;
    private SwipeRefreshLayout swipeRefreshLayout;
    Developer developer;

    ArrayList<Developer> counts = new ArrayList<>();

    public StaggeredList() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment.
        View v = inflater.inflate(R.layout.fragment_staggered_list, container, false);

        recyclerView = (RecyclerView) v.findViewById(R.id.recycler_view);

        imreceive_progressbars = (ProgressBar) v.findViewById(R.id.imreceive_progressbars);
        swipeRefreshLayout = (SwipeRefreshLayout) v.findViewById(R.id.swipeRefreshLayout);

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {

                counts = new ArrayList<Developer>();
                loaddata();

                mAdapter = new FeeddataAdapter((MainActivity) getActivity(), counts, "stag");

                swipeRefreshLayout.setRefreshing(false);
            }
        });


        //Method for  feeding the arralist

        loaddata();
        mAdapter = new FeeddataAdapter(getActivity(), counts, "stag");
        mAdapter.setmOnLoadMoreListener(this);
        //  mAdapter.setOnLoadMoreListener(getActivity());
        //  mAdapter.setOnLoadMoreListener(getActivity());
        recyclerView.setAdapter(mAdapter);

        // mAdapter = new FeeddataAdapter(recyclerView, this,counts);
        RecyclerView.LayoutManager mLayoutManager = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
        //  = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

        return v;
    }

    @Override
    public void onLoadMore(int Position) {
        Log.e("pos", "" + Position);
        Log.e("pos", "" + Position);
        Log.e("size", "" + counts.size());


        imreceive_progressbars.setVisibility(View.VISIBLE);
        loaddata();
        //  imreceive_progressbars.setVisibility(View.GONE);

        Handler h = new Handler();
        h.postDelayed(new Runnable() {
            @Override
            public void run() {
                mAdapter.notifyDataSetChanged();

                imreceive_progressbars.setVisibility(View.GONE);

                recyclerView.scrollToPosition(counts.size() - 3);

            }
        }, 3000);


    }


    private void loaddata() {
        for (int i = 0; i < 10; i++) {
            developer = new Developer("Tom Cruise", "Actor", "11.50am");
            counts.add(developer);
            Log.e("countsize========>", "" + counts.size());

        }
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
