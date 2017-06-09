package com.example.eight.scannews.presenter;

import com.example.eight.scannews.beans.NewsBean;
import com.example.eight.scannews.contract.Contract;
import com.example.eight.scannews.model.NewsModelImpl;

import java.util.List;

/**
 * Created by eight on 2017/6/6.
 */

public class NewsPresenterImpl implements Contract.NewsPresenter, Contract.OnLoadNewsListListener{

    private Contract.NewsModel newsModel;
    private Contract.NewsView newsView;

    public NewsPresenterImpl(Contract.NewsView newsView) {
        this.newsModel = new NewsModelImpl();
        this.newsView = newsView;
    }

    @Override
    public void loadNews(int type, int page) {

    }

    @Override
    public void onSuccess(List<NewsBean> list) {
        newsView.hideProgress();
        newsView.addNews(list);
    }

    @Override
    public void onFailure(String msg, Exception e) {
        newsView.hideProgress();
        newsView.showLoadingFail();
    }
}
