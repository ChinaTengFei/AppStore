package ittengfei.com.googlestore.view.fragment.software;

import android.content.Context;
import android.support.annotation.AttrRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import ittengfei.com.googlestore.R;

import static ittengfei.com.googlestore.view.fragment.software.BaseContent.Load_State.STATE_Loading;
import static ittengfei.com.googlestore.view.fragment.software.BaseContent.Load_State.State_Failed;
import static ittengfei.com.googlestore.view.fragment.software.BaseContent.Load_State.State_Succes;

/**
 * Created by Administrator on 2017-05-28.
 */

public abstract class BaseContent<T> extends FrameLayout {
    private Context context;
    private T softWareBeen;
    private View pageLoading;
    private View pageFailed;

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

        pageLoading = View.inflate(context, R.layout.page_loading, null);
        addView(pageLoading);
        pageFailed = View.inflate(context, R.layout.page_failed, null);
        addView(pageFailed);

        checkShow();
    }

    public void syncRequest() {

        loadData().observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io()).subscribe(new Observer<T>() {


            @Override
            public void onSubscribe(@io.reactivex.annotations.NonNull Disposable d) {

            }

            @Override
            public void onNext(@io.reactivex.annotations.NonNull T softWareBeen) {
                BaseContent.this.softWareBeen = softWareBeen;
                load_state = Load_State.State_Succes;
            }

            @Override
            public void onError(@io.reactivex.annotations.NonNull Throwable e) {
                load_state= State_Failed;
                checkShow();
            }

            @Override
            public void onComplete() {
                checkShow();
            }

        });
    }

    protected abstract View createSuccesView(T softWareBeen);

    protected void checkShow(){
        pageLoading.setVisibility(load_state==STATE_Loading?VISIBLE:INVISIBLE);
        pageFailed.setVisibility(load_state==State_Failed?VISIBLE:INVISIBLE);
        if(State_Succes==load_state){
            addView(createSuccesView(softWareBeen));
        }
    };
    abstract protected Observable<T> loadData();
}