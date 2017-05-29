package ittengfei.com.googlestore;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import ittengfei.com.googlestore.presenter.BasePresenter;

/**
 * Created by Administrator on 2017-05-28.
 */

public abstract class BaseActivity<T extends BasePresenter> extends AppCompatActivity {

    private T mPresenter;

    @Override
    protected final void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(getContentView());

        if (isBindView()) {
            Unbinder bind = ButterKnife.bind(this);
        }

        initView();

        initListener();
        initData();
        mPresenter = createPresenter();
    }

    protected T createPresenter(){
        return null;
    };
    protected void initListener(){};

    boolean isBindView(){
        return true;
    }
    protected void initData(){}

    abstract protected void initView();
    @LayoutRes
    abstract public int getContentView();


}
