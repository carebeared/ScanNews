package com.example.eight.scannews.contract;

import com.example.eight.scannews.beans.NewsBean;
import com.example.eight.scannews.beans.NewsDetailBean;

import java.util.List;

/**
 * Created by eight on 2017/6/6.
 */

public interface Contract {
    interface NewsModel {
        void loadNews(String url, String key, int num, int page, int type, OnLoadNewsListListener listener);
        void loadNewsDetail(String id, OnLoadNewsDetailListener listener);
    }

    interface NewsView {
        void showProgress();
        void addNews(List<NewsBean.NewslistBean> newsBeanList);
        void hideProgress();
        void showLoadingFail();
    }

    interface NewsPresenter {
        void loadNews(int type, int page);
    }

    interface OnLoadNewsListListener {
        void onSuccess(List<NewsBean.NewslistBean> list);
        void onFailure(String msg, Exception e);
    }

    interface OnLoadNewsDetailListener {
        void onSuccess(NewsDetailBean newsDetailBean);
        void onFailure(String msg, Exception e);
    }
}
