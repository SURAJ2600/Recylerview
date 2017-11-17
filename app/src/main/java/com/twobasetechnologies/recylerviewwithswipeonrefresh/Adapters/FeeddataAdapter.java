package com.twobasetechnologies.recylerviewwithswipeonrefresh.Adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.twobasetechnologies.recylerviewwithswipeonrefresh.DataModel.Developer;
import com.twobasetechnologies.recylerviewwithswipeonrefresh.Interface.OnLoadMoreListener;
import com.twobasetechnologies.recylerviewwithswipeonrefresh.MainActivity;
import com.twobasetechnologies.recylerviewwithswipeonrefresh.R;

import java.util.ArrayList;

/**
 * Created by suraj on 27/10/17.
 */

public class FeeddataAdapter extends RecyclerView.Adapter<FeeddataAdapter.MyViewHolder> {


    private OnLoadMoreListener mOnLoadMoreListener;

    private ArrayList<Developer> counts;
    private String type = "";

    private Context mContext;

    public FeeddataAdapter(Activity mainActivity, final ArrayList<Developer> counts, String mrecylerviewtype) {

        this.mContext = mainActivity;

        this.counts = counts;
        this.type = mrecylerviewtype;

    }

    public void setmOnLoadMoreListener(OnLoadMoreListener loads) {
        this.mOnLoadMoreListener = loads;

    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = null;
        if (type.equals("linear")) {
            itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.feedata_listitem, parent, false);
        } else if (type.equals("grid")) {
            itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.gridview, parent, false);
        } else {
            itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.staggeredgridviews, parent, false);
        }


        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        Log.e("siz------e", "" + counts.size());

        if (position > counts.size() - 2) {
            holder.name.setText("" + counts.get(position).getName());

            holder.language.setText("" + counts.get(position).getLanguage());

            holder.rating.setText("" + counts.get(position).getRating());
            // holder.imreceive_progressbars.setVisibility(View.VISIBLE);
            mOnLoadMoreListener.onLoadMore(position);

        } else {
            // holder.imreceive_progressbars.setVisibility(View.GONE);
            // holder.imreceive_progressbars.setVisibility(View.VISIBLE);


            holder.name.setText("" + counts.get(position).getName());

            holder.language.setText("" + counts.get(position).getLanguage());

            holder.rating.setText("" + counts.get(position).getRating());


        }

    }

    @Override
    public int getItemCount() {
        return counts.size();
    }

    /*public void setOnLoadMoreListener(Activity activity) {

        this.mOnLoadMoreListener=activity;
    }*/


    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name, language, rating;

        // ProgressBar imreceive_progressbars;
        public MyViewHolder(View itemView) {
            super(itemView);

            name = (TextView) itemView.findViewById(R.id.name);
            language = (TextView) itemView.findViewById(R.id.language);

            rating = (TextView) itemView.findViewById(R.id.time);


        }
    }


    @Override
    public long getItemId(int position) {
        return (position);
    }


}
