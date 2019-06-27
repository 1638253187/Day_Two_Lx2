package com.example.day_two_lx.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.day_two_lx.Main3Activity;
import com.example.day_two_lx.R;
import com.example.day_two_lx.adapter.RecyAdapter;
import com.example.day_two_lx.bean.XwBean;
import com.example.day_two_lx.model.ImpXwModel;
import com.example.day_two_lx.presenter.ImpXwPresenter;
import com.example.day_two_lx.view.XwView;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class OneFragment extends Fragment implements XwView {


    private View view;
    private RecyclerView mRecy;
    private ArrayList<XwBean.NewslistBean> list;
    private RecyAdapter adapter;

    public OneFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_one, container, false);
        initView(inflate);
        return inflate;
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
        ImpXwPresenter impXwPresenter = new ImpXwPresenter(new ImpXwModel(), this);
        impXwPresenter.getXw();
    }

    private void initView(View inflate) {
        mRecy = (RecyclerView) inflate.findViewById(R.id.recy);
        mRecy.addItemDecoration(new DividerItemDecoration(getActivity(), 1));
        mRecy.setLayoutManager(new LinearLayoutManager(getActivity()));
        list = new ArrayList<>();
        adapter = new RecyAdapter(getActivity(), list);
        mRecy.setAdapter(adapter);
        adapter.setOnItemCliclListener(new RecyAdapter.OnItemCliclListener() {
            @Override
            public void onItemClick(int position) {
                XwBean.NewslistBean newslistBean = list.get(position);
                String url = newslistBean.getUrl();
                Intent intent = new Intent(getActivity(), Main3Activity.class);
                intent.putExtra("web",url);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onSuccess(List<XwBean.NewslistBean> xwbean) {
        list.addAll(xwbean);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onFail(String error) {
        Toast.makeText(getActivity(), error, Toast.LENGTH_SHORT).show();
    }
}
