package com.example.eight.scannews.model;

import com.example.eight.scannews.HttpUtils;
import com.example.eight.scannews.beans.NewsBean;
import com.example.eight.scannews.contract.Contract;

import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

/**
 * Created by eight on 2017/6/6.
 */

public class NewsModelImpl implements Contract.NewsModel {
    @Override
    public void loadNews(String url, String key, int num, int page, int type, Contract.OnLoadNewsListListener listener) {
        HttpUtils.getInstance().getNewsFromHttp(key, num, page, new Observer<NewsBean>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull NewsBean newsBean) {

            }

            @Override
            public void onError(@NonNull Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
    }

    @Override
    public void loadNewsDetail(String id, Contract.OnLoadNewsDetailListener listener) {

    }
}
