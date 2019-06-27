package com.example.day_two_lx.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.example.day_two_lx.R;
import com.example.day_two_lx.bean.NewBean;

import java.util.ArrayList;

public class RecyXxAdapter extends RecyclerView.Adapter<RecyXxAdapter.ViewHolder> {
    private Context context;
    private ArrayList<NewBean.DataBean> list;
    private OnItemCliclListener onItemCliclListener;

    public void setOnItemCliclListener(OnItemCliclListener onItemCliclListener) {
        this.onItemCliclListener = onItemCliclListener;
    }

    public RecyXxAdapter(Context context, ArrayList<NewBean.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.itemm, null);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        NewBean.DataBean dataBean = list.get(i);
        viewHolder.tv_text.setText(dataBean.getText());
        viewHolder.tv_top_commentsName.setText(dataBean.getTop_commentsName());
        RequestOptions requestOptions = new RequestOptions();
        requestOptions.circleCrop();
        Glide.with(context).load(dataBean.getHeader()).apply(requestOptions).into(viewHolder.iv_header);
        RequestOptions requestOptions1 = new RequestOptions();
        requestOptions1.transform(new RoundedCorners(5));
        Glide.with(context).load(dataBean.getThumbnail()).apply(requestOptions1).into(viewHolder.iv_thumbnail);
        viewHolder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onItemCliclListener!=null){
                    onItemCliclListener.onItemClick(i);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tv_top_commentsName, tv_text;
        private ImageView iv_thumbnail,iv_header;
        private View view;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
              iv_header = itemView.findViewById(R.id.iv_header);
            iv_thumbnail = itemView.findViewById(R.id.iv_thumbnail);
            tv_text = itemView.findViewById(R.id.tv_text);
            tv_top_commentsName = itemView.findViewById(R.id.tv_top_commentsName);
            view=itemView;
        }
    }

    public interface OnItemCliclListener {
        void onItemClick(int position);
    }
}
