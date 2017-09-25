package com.asus.leo.weekview.fragment;


import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.asus.leo.weekview.R;
import com.asus.leo.weekview.activity.EditContentActivity;
import com.asus.leo.weekview.adapter.ContetAdapter;
import com.asus.leo.weekview.common.WeekViewData;

import java.util.ArrayList;


public class MomoFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private ContetAdapter mContetAdapter;
    private EditContentActivity mEditContentActivity;
    private ArrayList<WeekViewData> mMomoData;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mEditContentActivity = (EditContentActivity)activity;
        mMomoData = mEditContentActivity.getMomoData();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_momo, container, false);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.RecyclerView);

        mContetAdapter = new ContetAdapter(getActivity(),mMomoData);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.addItemDecoration(new DividerItemDecoration(getActivity(),DividerItemDecoration.VERTICAL));
        mRecyclerView.setAdapter(mContetAdapter);

        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
    }

}
