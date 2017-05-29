package ittengfei.com.googlestore;

import android.app.Application;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Administrator on 2017-05-28.
 */

public class StoreApplition extends Application {

    private Retrofit build;
    private static StoreApplition instance;
    @Override
    public void onCreate() {
        super.onCreate();
        build = new Retrofit.Builder().addCallAdapterFactory(RxJava2CallAdapterFactory.create()).addConverterFactory(GsonConverterFactory.create()).baseUrl("http://netaa.oss-cn-shanghai.aliyuncs.com/").build();

        instance = this;
    }

    public Retrofit getBuild() {
        return build;
    }

    public static StoreApplition getInstance() {
        return instance;
    }
}
