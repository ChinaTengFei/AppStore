package ittengfei.com.googlestore.net;


import java.util.ArrayList;

import io.reactivex.Observable;
import ittengfei.com.googlestore.model.SoftWareBean;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Administrator on 2017-05-29.
 */

public interface SoftWareApiService {

    @GET("{softwareType}")
    Observable<ArrayList<SoftWareBean>> getSoftWareItemByType(@Path("softwareType")String Type);
}
