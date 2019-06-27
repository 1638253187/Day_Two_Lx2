package com.example.day_two_lx.presenter;

import com.example.day_two_lx.bean.XwBean;
import com.example.day_two_lx.callback.XwCallBack;
import com.example.day_two_lx.model.XwModel;
import com.example.day_two_lx.view.XwView;

import java.util.List;

public class ImpXwPresenter implements XwPresenter, XwCallBack {
   private XwModel xwModel;
   private XwView xwView;

    public ImpXwPresenter(XwModel xwModel, XwView xwView) {
        this.xwModel = xwModel;
        this.xwView = xwView;
    }

    @Override
    public void getXw() {
        if (xwModel!=null){
            xwModel.GetXw(this);
        }
    }

    @Override
    public void onSuccess(List<XwBean.NewslistBean> xwbean) {
        if (xwView!=null){
            xwView.onSuccess(xwbean);
        }
    }

    @Override
    public void onFail(String error) {
        if (xwView!=null){
            xwView.onFail(error);
        }
    }
}
