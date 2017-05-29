package ittengfei.com.googlestore.net;

import java.util.ArrayList;

import io.reactivex.Observable;
import ittengfei.com.googlestore.model.AppAndBean;
import ittengfei.com.googlestore.model.TitleValueBean;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Administrator on 2017-05-28.
 */

public interface MainApiService {
    @GET("app/{address}")
    Observable<AppAndBean> getAppList(@Path("address") String fileName);


    @GET("software/software")
    Observable<ArrayList<TitleValueBean>> getSoftWareContent();
}
