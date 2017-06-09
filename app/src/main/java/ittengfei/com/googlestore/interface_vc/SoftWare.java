package ittengfei.com.googlestore.interface_vc;

import java.util.ArrayList;

import ittengfei.com.googlestore.model.TitleValueBean;

/**
 * Created by Administrator on 2017-05-28.
 */

public class SoftWare {
    public interface View{
        void showData(ArrayList<TitleValueBean> titleValueBean);
        void refreshList();
    };
    public interface Presenter{
        void loadData();

    }
}
