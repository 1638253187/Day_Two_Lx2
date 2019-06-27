package com.example.day_two_lx.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.day_two_lx.R;
import com.example.day_two_lx.Wz;
import com.example.day_two_lx.adapter.RecyXxAdapter;
import com.example.day_two_lx.bean.NewBean;
import com.example.day_two_lx.model.ImpXxModel;
import com.example.day_two_lx.presenter.ImpXxPresenter;
import com.example.day_two_lx.view.XxView;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class TwoFragment extends Fragment implements XxView, OnRefreshLoadMoreListener {


    private View view;
    private RecyclerView mRecy;
    private ArrayList<NewBean.DataBean> list;
    private RecyXxAdapter adapter;
    private SmartRefreshLayout mSmart;

    public TwoFragment() {
        // Required empty public constructor
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (getUserVisibleHint()) {
            initData();
        } else {
            if (list != null && list.size() > 0) {
                list.clear();
                adapter.notifyDataSetChanged();
            }
        }
    }

    private void initData() {
        ImpXxPresenter impXxPresenter = new ImpXxPresenter(new ImpXxModel(), this);
        impXxPresenter.getXx();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_two, container, false);
        initView(inflate);
        return inflate;
    }

    private void initView(View inflate) {
        mRecy = (RecyclerView) inflate.findViewById(R.id.recy);
        mSmart = (SmartRefreshLayout) inflate.findViewById(R.id.smart);
        mRecy.addItemDecoration(new DividerItemDecoration(getActivity(), 1));
        mRecy.setLayoutManager(new LinearLayoutManager(getActivity()));
        list = new ArrayList<>();
        adapter = new RecyXxAdapter(getActivity(), list);
        mRecy.setAdapter(adapter);
        adapter.setOnItemCliclListener(new RecyXxAdapter.OnItemCliclListener() {
            @Override
            public void onItemClick(int position) {
                Intent intent = new Intent(getActivity(), Wz.class);
                startActivity(intent);
            }
        });
        mSmart.setOnRefreshLoadMoreListener(this);
    }


    @Override
    public void onSuccess(List<NewBean.DataBean> dataBeans) {
        list.addAll(dataBeans);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onFail(String error) {
        Toast.makeText(getActivity(), error, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
        initData();
        refreshLayout.finishLoadMore();
        mSmart.finishLoadMore();
    }

    @Override
    public void onRefresh(@NonNull RefreshLayout refreshLayout) {
        list.clear();
        initData();
        refreshLayout.finishRefresh();
        mSmart.finishRefresh();
    }
}
