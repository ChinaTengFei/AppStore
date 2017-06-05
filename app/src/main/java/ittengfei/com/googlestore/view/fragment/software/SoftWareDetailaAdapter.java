package ittengfei.com.googlestore.view.fragment.software;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import ittengfei.com.googlestore.R;
import ittengfei.com.googlestore.model.SoftWareBean;

/**
 * Created by Administrator on 2017-05-30.
 */

public class SoftWareDetailaAdapter extends RecyclerView.Adapter<SoftWareDetailaAdapter.Holder> {
    private final ArrayList<SoftWareBean> softWareBeenList;

    public SoftWareDetailaAdapter(ArrayList<SoftWareBean> softWareBeenList) {
        this.softWareBeenList = softWareBeenList;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        Holder holder = new Holder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_soft_ware_detail, parent,false));

        return holder;
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
        holder.tvAppName.setText(softWareBeenList.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return softWareBeenList.size();
    }

    class Holder extends RecyclerView.ViewHolder{
        @BindView(R.id.tv_app_name)
        TextView tvAppName;
        public Holder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
