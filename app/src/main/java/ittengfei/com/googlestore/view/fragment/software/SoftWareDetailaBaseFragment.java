package ittengfei.com.googlestore.view.fragment.software;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import ittengfei.com.googlestore.model.TitleValueBean;
import ittengfei.com.googlestore.presenter.SoftWarePreSenter;
import ittengfei.com.googlestore.view.fragment.BaseFragment;

/**
 * Created by Administrator on 2017-05-28.
 */

public class SoftWareDetailaBaseFragment extends BaseFragment<SoftWarePreSenter> {
    public static final String TITLE = "TITLE";

    public TextView textView;
    private TitleValueBean content;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        content = arguments.getParcelable(TITLE);

    }

    @Override
    protected SoftWarePreSenter createPresenter() {
        return null;
    }

    @Override
    protected View getContentView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        TextView textView = new TextView(context);
        textView.setText(content.toString());
        return textView;
    }

    @Override
    protected void initView() {
    }

    public static SoftWareDetailaBaseFragment newInstance(TitleValueBean content) {
        Bundle args = new Bundle();
        args.putParcelable(TITLE,content);
        SoftWareDetailaBaseFragment fragment = new SoftWareDetailaBaseFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
