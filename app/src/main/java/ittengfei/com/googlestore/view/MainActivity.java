package ittengfei.com.googlestore.view;

import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.widget.RadioGroup;

import java.util.ArrayList;

import butterknife.BindView;
import ittengfei.com.googlestore.BaseActivity;
import ittengfei.com.googlestore.R;
import ittengfei.com.googlestore.presenter.MainPresenter;
import ittengfei.com.googlestore.view.fragment.BaseFragment;
import ittengfei.com.googlestore.view.fragment.GameFragment;
import ittengfei.com.googlestore.view.fragment.IndexFragment;
import ittengfei.com.googlestore.view.fragment.PersonalFragment;
import ittengfei.com.googlestore.view.fragment.SoftWareFragment;
import ittengfei.com.googlestore.weiget.NoScrollViewPager;

public class MainActivity extends BaseActivity<MainPresenter> implements RadioGroup.OnCheckedChangeListener {

    @BindView(R.id.rg_tab)
    RadioGroup rgTab;
    @BindView(R.id.vp_main)
    NoScrollViewPager vpMain;


    @Override
    public int getContentView() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {


        vpMain.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            ArrayList<BaseFragment> fragments = new ArrayList<BaseFragment>(){
                {
                    add(IndexFragment.newInstance());
                    add(SoftWareFragment.newInstance());
                    add(GameFragment.newInstance());
                    add(PersonalFragment.newInstance());
                }
            };
            @Override
            public Fragment getItem(int position) {
                return fragments.get(position);
            }

            @Override
            public int getCount() {
                return fragments.size();
            }
        });
    }


    @Override
    protected void initListener() {
        rgTab.setOnCheckedChangeListener(this);

    }

    @Override
    protected MainPresenter createPresenter()
    {
        MainPresenter mainPresenter = new MainPresenter();
        return mainPresenter;
    }
    @Override
    public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
        switch (i){
            case R.id.rb_index:
                setCurrentPager(0);
                break;
            case R.id.rb_software:
                setCurrentPager(1);break;
            case R.id.rb_game:
                setCurrentPager(2);break;
            case R.id.rb_personal:
                setCurrentPager(3);break;

        }
    }
    private void setCurrentPager(int index){
        vpMain.setCurrentItem(index);
    }
}
