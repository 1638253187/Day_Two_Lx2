package com.example.day_two_lx.view;

import com.example.day_two_lx.bean.NewBean;

import java.util.List;

public interface XxView {
    void onSuccess(List<NewBean.DataBean> dataBeans);
    void onFail(String error);
}
