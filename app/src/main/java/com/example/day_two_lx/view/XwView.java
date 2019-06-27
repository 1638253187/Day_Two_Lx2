package com.example.day_two_lx.view;

import com.example.day_two_lx.bean.XwBean;

import java.util.List;

public interface XwView {
    void onSuccess(List<XwBean.NewslistBean> xwbean);

    void onFail(String error);
}
