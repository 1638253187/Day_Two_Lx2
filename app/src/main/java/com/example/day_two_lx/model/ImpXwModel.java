package com.example.day_two_lx.model;

import com.example.day_two_lx.api.XwServer;
import com.example.day_two_lx.bean.XwBean;
import com.example.day_two_lx.callback.XwCallBack;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ImpXwModel implements XwModel {
    @Override
    public void GetXw(final XwCallBack xwCallBack) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(XwServer.baseurl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        XwServer xwServer = retrofit.create(XwServer.class);

        Observable<XwBean> observable = xwServer.getXw("?key=52b7ec3471ac3bec6846577e79f20e4c&num=20&page=20");

        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<XwBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(XwBean xwBean) {
                    xwCallBack.onSuccess(xwBean.getNewslist());
                    }

                    @Override
                    public void onError(Throwable e) {
                    xwCallBack.onFail("网络错误："+e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
