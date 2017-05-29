package ittengfei.com.googlestore.view.fragment.software;

import android.content.Context;
import android.support.annotation.AttrRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

import ittengfei.com.googlestore.R;

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
            pageLoading.setVisibility(VISIBLE);
            pageFailed.setVisibility(INVISIBLE);
        }

        syncRequest();
    }

    private void syncRequest() {
        
    }

    protected void show(){

    };
    abstract protected String getUrl();
    abstract protected void loadDate();
}
