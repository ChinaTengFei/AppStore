package ittengfei.com.googlestore.view.fragment.software;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import io.reactivex.Observable;
import ittengfei.com.googlestore.model.TitleValueBean;

/**
 * Created by Administrator on 2017-05-28.
 */

public abstract class SoftWareDetailaBaseFragment<T> extends Fragment{
    public static final String TITLE = "TITLE";
    public TextView textView;
    private TitleValueBean content;
    protected Context context;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        content = arguments.getParcelable(TITLE);

    }

    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable final Bundle savedInstanceState) {
        return new BaseContent<T>(context) {
            @Override
            protected View createSuccesView(T softWareBeen) {

                return initView(inflater, container, savedInstanceState,softWareBeen);
            }

            @Override
            protected Observable<T> loadData() {

                return SoftWareDetailaBaseFragment.this.loadData();
            }
        };
    }

    protected abstract View initView(final LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState,T softWareBeen);
    protected abstract Observable<T> loadData();

}
