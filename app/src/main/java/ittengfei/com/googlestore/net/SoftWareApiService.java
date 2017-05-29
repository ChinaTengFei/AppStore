package ittengfei.com.googlestore.net;


import java.util.ArrayList;

import io.reactivex.Observable;
import ittengfei.com.googlestore.model.TitleValueBean;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Administrator on 2017-05-29.
 */

public interface SoftWareApiService {
    @GET("software/software")
    Observable<ArrayList<TitleValueBean>> getSoftWareContent();

    @GET("software/{softwareType}")
    Observable<TitleValueBean> getSoftWareItemByType(@Path("softwareType")String Type);
}
