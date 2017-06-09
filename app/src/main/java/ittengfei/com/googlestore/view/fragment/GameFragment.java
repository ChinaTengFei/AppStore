package ittengfei.com.googlestore.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import ittengfei.com.googlestore.presenter.GamePresenter;

/**
 * Created by Administrator on 2017-05-28.
 */

public class GameFragment extends BaseFragment<GamePresenter> {


    public static GameFragment newInstance() {
        return new GameFragment();
    }

    @Override
    protected GamePresenter createPresenter() {
        return null;
    }

    @Override
    protected View getContentView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        TextView textView = new TextView(context);
        textView.setText(getClass().getSimpleName());
        return textView;
    }

    @Override
    protected void initView() {

    }
}
