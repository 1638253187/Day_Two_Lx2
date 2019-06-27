package com.example.day_two_lx.callback;

import com.example.day_two_lx.bean.NewBean;

import java.util.List;

public interface XxCallBack {
    void onSuccess(List<NewBean.DataBean> newbean);
    void onFail(String error);
}
