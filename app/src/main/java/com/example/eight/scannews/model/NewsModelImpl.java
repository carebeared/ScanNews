package com.example.eight.scannews.model;

import com.example.eight.scannews.contract.Contract;

/**
 * Created by eight on 2017/6/6.
 */

public class NewsModelImpl implements Contract.NewsModel {
    @Override
    public void loadNews(String url, int type, Contract.OnLoadNewsListListener listener) {

    }

    @Override
    public void loadNewsDetail(String id, Contract.OnLoadNewsDetailListener listener) {

    }
}
