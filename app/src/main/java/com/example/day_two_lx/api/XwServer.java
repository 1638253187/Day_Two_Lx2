package com.example.day_two_lx.api;

import com.example.day_two_lx.bean.NewBean;
import com.example.day_two_lx.bean.XwBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface XwServer {
    String baseurl = "http://api.tianapi.com/wxnew/";
    String baseurlxx = "https://www.apiopen.top/";

    @GET()
    Observable<XwBean> getXw(@Url String url);

    @GET()
    Observable<NewBean>getXX(@Url String url);
}
