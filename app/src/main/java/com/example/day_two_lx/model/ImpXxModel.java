package com.example.day_two_lx.model;

import com.example.day_two_lx.api.XwServer;
import com.example.day_two_lx.bean.NewBean;
import com.example.day_two_lx.callback.XxCallBack;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ImpXxModel implements XxModel {
    private int page = 1;

    @Override
    public void getXX(final XxCallBack xxCallBack) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(XwServer.baseurlxx)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        XwServer xwServer = retrofit.create(XwServer.class);

        Observable<NewBean> observable = xwServer.getXX("satinGodApi?type=1&page=" + page++ + "");
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<NewBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(NewBean newBean) {
                        xxCallBack.onSuccess(newBean.getData());
                    }

                    @Override
                    public void onError(Throwable e) {
                        xxCallBack.onFail("网络错误:" + e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
