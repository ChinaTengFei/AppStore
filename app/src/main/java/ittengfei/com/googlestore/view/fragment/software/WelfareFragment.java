package ittengfei.com.googlestore.view.fragment.software;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.Observable;
import ittengfei.com.googlestore.R;
import ittengfei.com.googlestore.StoreApplition;
import ittengfei.com.googlestore.model.SoftWareBean;
import ittengfei.com.googlestore.net.SoftWareApiService;

/**
 * Created by Administrator on 2017-05-30.
 */

public class WelfareFragment extends SoftWareDetailaBaseFragment<ArrayList<SoftWareBean>> {

    private static final String TYPE = "WELFAREFRAGMENT_TYPE";
    private String mType;
    @BindView(R.id.rv_main)
    public RecyclerView rvMain;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        mType = arguments.getString(TYPE);
    }

    @Override
    protected View initView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState, ArrayList<SoftWareBean> softWareBeen) {
        View inflate = inflater.inflate(R.layout.fragment_software_detaila,container,false);
        ButterKnife.bind(this,inflate);
        rvMain.setLayoutManager(new LinearLayoutManager(context));
        rvMain.setAdapter(new SoftWareDetailaAdapter(softWareBeen));
        TextView textView = new TextView(context);
        textView.setText("asdsd");
        return textView ;
    }

    @Override
    protected Observable<ArrayList<SoftWareBean>> loadData() {
        return StoreApplition.getInstance().getBuild().create(SoftWareApiService.class).getSoftWareItemByType(mType);
    }


    public static WelfareFragment newInstance(String type) {

        Bundle args = new Bundle();
        args.putString(TYPE,type);
        WelfareFragment fragment = new WelfareFragment();
        fragment.setArguments(args);
        return fragment;

    }
}
