package com.example.day_two_lx.callback;

import com.example.day_two_lx.bean.XwBean;

import java.util.List;

public interface XwCallBack {
    void onSuccess(List<XwBean.NewslistBean> xwbean);

    void onFail(String error);

}
