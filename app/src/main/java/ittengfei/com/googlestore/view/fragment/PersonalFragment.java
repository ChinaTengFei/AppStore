package ittengfei.com.googlestore.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import ittengfei.com.googlestore.presenter.PersonalPresenter;

/**
 * Created by Administrator on 2017-05-28.
 */

public class PersonalFragment extends BaseFragment<PersonalPresenter> {
    public static PersonalFragment newInstance() {
        return new PersonalFragment();
    }

    @Override
    protected PersonalPresenter createPresenter() {
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
