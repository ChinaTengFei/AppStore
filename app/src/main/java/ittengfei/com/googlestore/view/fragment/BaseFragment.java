package ittengfei.com.googlestore.view.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import ittengfei.com.googlestore.presenter.BasePresenter;

/**
 * Created by Administrator on 2017-05-28.
 */

public abstract class BaseFragment<T extends BasePresenter> extends Fragment{

    protected Context context;
    protected T presenter;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }

    protected abstract T createPresenter();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = getContentView(inflater, container, savedInstanceState);
        ButterKnife.bind(this,view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        presenter = createPresenter();
        initData();
    }


    protected abstract View getContentView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState);

    protected abstract void initView();

    protected void initData(){};
}
