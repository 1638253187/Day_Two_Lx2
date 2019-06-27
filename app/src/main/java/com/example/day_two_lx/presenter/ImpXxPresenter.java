package com.example.day_two_lx.presenter;

import com.example.day_two_lx.bean.NewBean;
import com.example.day_two_lx.callback.XxCallBack;
import com.example.day_two_lx.model.XxModel;
import com.example.day_two_lx.view.XxView;

import java.util.List;

public class ImpXxPresenter implements XxPresenter, XxCallBack {
   private XxModel xxModel;
   private XxView xxView;

    public ImpXxPresenter(XxModel xxModel, XxView xxView) {
        this.xxModel = xxModel;
        this.xxView = xxView;
    }

    @Override
    public void getXx() {
        if (xxModel!=null){
            xxModel.getXX(this);
        }
    }

    @Override
    public void onSuccess(List<NewBean.DataBean> newbean) {
    if (xxView!=null){
        xxView.onSuccess(newbean);
    }
    }

    @Override
    public void onFail(String error) {
        if (xxView!=null){
            xxView.onFail(error);
        }
    }
}
