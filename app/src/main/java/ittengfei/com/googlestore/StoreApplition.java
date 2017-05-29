package ittengfei.com.googlestore;

import android.app.Application;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Response;
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
        build = new Retrofit.Builder().addCallAdapterFactory(RxJava2CallAdapterFactory.create()).client(getOkHttpClient())
                .addConverterFactory(GsonConverterFactory.create()).baseUrl("http://netaa.oss-cn-shanghai.aliyuncs.com/").build();

        instance = this;
    }

    public Retrofit getBuild() {
        return build;
    }
    private OkHttpClient getOkHttpClient() {
        //定制OkHttp
        OkHttpClient.Builder httpClientBuilder = new OkHttpClient
                .Builder();
        //OkHttp进行添加拦截器loggingInterceptor
        httpClientBuilder.addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                return chain.proceed(chain.request());
            }
        });
        return httpClientBuilder.build();
    }
    public static StoreApplition getInstance() {
        return instance;
    }
}
