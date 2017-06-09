package ittengfei.com.googlestore.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import butterknife.BindView;
import ittengfei.com.googlestore.R;
import ittengfei.com.googlestore.interface_vc.SoftWare;
import ittengfei.com.googlestore.model.TitleValueBean;
import ittengfei.com.googlestore.presenter.SoftWarePresenter;
import ittengfei.com.googlestore.view.MainActivity;
import ittengfei.com.googlestore.view.fragment.software.SoftWareDetailaBaseFragment;
import ittengfei.com.googlestore.view.fragment.software.WelfareFragment;

/**
 * Created by Administrator on 2017-05-28.
 */

public class SoftWareFragment extends BaseFragment<SoftWarePresenter> implements SoftWare.View, ViewPager.OnPageChangeListener {
    private static final String TAG = "SoftWareFragment";
    @BindView(R.id.vp_software)
    ViewPager vpSoftWare;

    @BindView(R.id.tabv_software)
    TabLayout tabVTitle;

    @Override
    protected SoftWarePresenter createPresenter() {
        return new SoftWarePresenter(this);
    }

    @Override
    protected View getContentView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_software,null);
        return inflate;
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
        onPageSelected(0);

        vpSoftWare.addOnPageChangeListener(this);
        vpSoftWare.setCurrentItem(0);
        tabVTitle.setupWithViewPager(vpSoftWare);
    }

    @Override
    public void refreshList() {

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        Log.d(TAG, "onPageScrolled() called with: position = [" + position + "], positionOffset = [" + positionOffset + "], positionOffsetPixels = [" + positionOffsetPixels + "]");
    }

    @Override
    public void onPageSelected(int position) {
        SoftWarePagerAdapter adapter = (SoftWarePagerAdapter) vpSoftWare.getAdapter();

        ((SoftWareDetailaBaseFragment) adapter.getItem(position)).show();
    }

    @Override
    public void onPageScrollStateChanged(int state) {
        Log.d(TAG, "onPageScrollStateChanged() called with: state = [" + state + "]");
    }


    private class SoftWarePagerAdapter extends FragmentPagerAdapter{

        private final ArrayList<TitleValueBean> titleValueList;
        private ArrayList<SoftWareDetailaBaseFragment> softWareDetailaBaseFragments=new ArrayList<SoftWareDetailaBaseFragment>();

        public SoftWarePagerAdapter(FragmentManager fm,ArrayList<TitleValueBean> titleValueList) {
            super(fm);
            this.titleValueList = titleValueList;
            for (int i = 0; i < titleValueList.size(); i++) {
                softWareDetailaBaseFragments.add(WelfareFragment.newInstance(titleValueList.get(i).getUrl()));
            }
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return titleValueList.get(position).getTitle();
        }

        @Override
        public Fragment getItem(int position) {
            return softWareDetailaBaseFragments.get(position);
        }



        @Override
        public int getCount() {
            return titleValueList.size();
        }
    }


    public static SoftWareFragment newInstance() {
        return new SoftWareFragment();
    }
}
