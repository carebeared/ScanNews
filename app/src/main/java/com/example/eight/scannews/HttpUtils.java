package com.example.eight.scannews;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.eight.scannews.beans.NewsBean;
import com.example.eight.scannews.beans.NewsDetailBean;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by eight on 2017/6/10.
 */

public class HttpUtils {
    private static String BASE_URL;
    private static final int DEFAULT_TIMEOUT = 10;
    private Retrofit retrofit;
    private ApiService apiService;

    public static String getBaseUrl() {
        return BASE_URL;
    }

    public static void setBaseUrl(String baseUrl) {
        BASE_URL = baseUrl;
    }

    /**
     * 私有化构造函数
     */
    private HttpUtils() {
        OkHttpClient client = new OkHttpClient();
        client.newBuilder().connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);

        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        apiService = retrofit.create(ApiService.class);
    }

    /**
     * 创建单例
     */
    private static class SingleInstance {
        private static final HttpUtils INSTANCE = new HttpUtils();
    }

    /**
     * 获取单例
     * @return
     */
    public static HttpUtils getInstance() {
        return SingleInstance.INSTANCE;
    }

    /**
     *
     * @param
     * @param
     * @param observer 观察值对象
     */

    public void getNewsFromHttp(String key, int num, int page, Observer<NewsBean> observer) {
        apiService.getNews(key, num, page)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    public static void showPicture(Context context, ImageView imageView, String url) {
        if (imageView == null) {
            throw new IllegalArgumentException("argument error");
        }
        Glide.with(context).load(url).placeholder(R.drawable.ic_action_home)
                .error(R.drawable.ic_menu_camera)
                .crossFade().into(imageView);
    }
}
