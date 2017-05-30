package ittengfei.com.googlestore.view.fragment.software;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import ittengfei.com.googlestore.model.SoftWareBean;
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
        return new BaseContent(context) {
            @Override
            protected View createSuccesView(ArrayList<SoftWareBean> softWareBeen) {
                TextView textView1 = new TextView(context);
                textView1.setText(softWareBeen.toString());
                textView1.setMovementMethod(new ScrollingMovementMethod());
                return textView1;
            }

            @Override
            protected String getUrl() {
                return content.getUrl();
            }

            @Override
            protected void loadDate() {

            }
        };
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
