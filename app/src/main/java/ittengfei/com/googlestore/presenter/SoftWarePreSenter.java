package ittengfei.com.googlestore.presenter;

import android.util.Log;

import java.util.ArrayList;

import interface_vc.SoftWare;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import ittengfei.com.googlestore.StoreApplition;
import ittengfei.com.googlestore.model.TitleValueBean;
import ittengfei.com.googlestore.net.MainApiService;

import static android.content.ContentValues.TAG;

/**
 * Created by Administrator on 2017-05-28.
 */

public class SoftWarePreSenter extends BasePresenter implements SoftWare.Presenter {

    private final SoftWare.View mSoftWareView;

    public SoftWarePreSenter(SoftWare.View softWareView) {
        this.mSoftWareView = softWareView;
    }

    public void loadData(){
        MainApiService mainApiService = StoreApplition.getInstance().getBuild().create(MainApiService.class);
        mainApiService.getSoftWareContent().observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io()).subscribe(new Consumer<ArrayList<TitleValueBean>>() {
            @Override
            public void accept(@NonNull ArrayList<TitleValueBean> titleValueBean) throws Exception {
                Log.d(TAG, "accept() called with: titleValueBean = [" + titleValueBean + "]");
                Thread.currentThread().getName();
                mSoftWareView.showData(titleValueBean);
            }
        });
    }
}
