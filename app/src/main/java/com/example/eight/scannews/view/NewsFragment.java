package com.example.eight.scannews.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.eight.scannews.beans.NewsBean;
import com.example.eight.scannews.contract.Contract;

import java.util.List;

/**
 * Created by eight on 2017/6/9.
 */

public class NewsFragment extends Fragment implements Contract.NewsView {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void addNews(List<NewsBean> newsBeanList) {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void showLoadingFail() {

    }
}
