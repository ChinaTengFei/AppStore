package ittengfei.com.googlestore.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import butterknife.BindView;
import interface_vc.SoftWare;
import ittengfei.com.googlestore.R;
import ittengfei.com.googlestore.model.TitleValueBean;
import ittengfei.com.googlestore.presenter.SoftWarePreSenter;
import ittengfei.com.googlestore.view.MainActivity;
import ittengfei.com.googlestore.view.fragment.software.SoftWareDetailaBaseFragment;

/**
 * Created by Administrator on 2017-05-28.
 */

public class SoftWareFragment extends BaseFragment<SoftWarePreSenter> implements SoftWare.View {

    @BindView(R.id.vp_software)
    ViewPager vpSoftWare;

    @BindView(R.id.tabv_software)
    TabLayout tabVTitle;

    @Override
    protected SoftWarePreSenter createPresenter() {
        return new SoftWarePreSenter(this);
    }

    @Override
    protected View getContentView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_software,null);
        return inflate;
    }

    @Override
    protected void initView() {
    }

    @Override
    protected void initData() {
        presenter.loadData();
    }

    @Override
    public void showData(ArrayList<TitleValueBean> titleValueList) {
        FragmentManager supportFragmentManager = ((MainActivity) context).getSupportFragmentManager();
        SoftWarePagerAdapter softWarePagerAdapter = new SoftWarePagerAdapter(supportFragmentManager, titleValueList);
        vpSoftWare.setAdapter(softWarePagerAdapter);
        tabVTitle.setupWithViewPager(vpSoftWare);
    }

    @Override
    public void refreshList() {

    }


    public static SoftWareFragment newInstance() {
        return new SoftWareFragment();
    }

    private class SoftWarePagerAdapter extends FragmentPagerAdapter{

        private final ArrayList<TitleValueBean> titleValueList;

        public SoftWarePagerAdapter(FragmentManager fm,ArrayList<TitleValueBean> titleValueList) {
            super(fm);
            this.titleValueList = titleValueList;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return titleValueList.get(position).getTitle();
        }

        @Override
        public Fragment getItem(int position) {
            SoftWareDetailaBaseFragment softWareDetailaBaseFragment = SoftWareDetailaBaseFragment.newInstance(titleValueList.get(position));
            return softWareDetailaBaseFragment;
        }

        @Override
        public int getCount() {
            return titleValueList.size();
        }
    }
}
