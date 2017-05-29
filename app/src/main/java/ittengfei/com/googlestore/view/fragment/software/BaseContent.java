package ittengfei.com.googlestore.view.fragment.software;

import android.content.Context;
import android.support.annotation.AttrRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;

import java.util.ArrayList;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import ittengfei.com.googlestore.R;
import ittengfei.com.googlestore.StoreApplition;
import ittengfei.com.googlestore.model.SoftWareBean;
import ittengfei.com.googlestore.net.SoftWareApiService;

import static android.content.ContentValues.TAG;

/**
 * Created by Administrator on 2017-05-28.
 */

public abstract class BaseContent extends FrameLayout {
    private Context context;

    public enum Load_State {
        STATE_Loading, State_Succes, State_Failed
    }

    Load_State load_state = Load_State.STATE_Loading;

    public BaseContent(@NonNull Context context) {
        this(context, null);
    }

    public BaseContent(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public BaseContent(@NonNull Context context, @Nullable AttributeSet attrs, @AttrRes int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        initView();
    }

    private void initView() {

        View pageLoading = View.inflate(context, R.layout.page_loading, null);
        addView(pageLoading);
        View pageFailed = View.inflate(context, R.layout.page_failed, null);
        addView(pageFailed);

        if(load_state== Load_State.STATE_Loading){
            pageLoading.setVisibility(INVISIBLE);
            pageFailed.setVisibility(VISIBLE);
        }

        syncRequest();
    }

    private void syncRequest() {
        SoftWareApiService softWareApiService = StoreApplition.getInstance().getBuild().create(SoftWareApiService.class);
        softWareApiService.getSoftWareItemByType("applist3").observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io()).subscribe(new Consumer<ArrayList<SoftWareBean>>() {
            @Override
            public void accept(@io.reactivex.annotations.NonNull ArrayList<SoftWareBean> titleValueBean) throws Exception {
                Log.d(TAG, "accept() called with: titleValueBean = [" + titleValueBean + "]");
            }
        });
    }

    protected void show(){

    };
    abstract protected String getUrl();
    abstract protected void loadDate();
}
