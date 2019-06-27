package com.example.day_two_lx.adapter;

import android.content.Context;
import android.media.Image;
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
import com.example.day_two_lx.bean.XwBean;

import java.util.ArrayList;


public class RecyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private ArrayList<XwBean.NewslistBean> list;
    private OnItemCliclListener onItemCliclListener;

    public void setOnItemCliclListener(OnItemCliclListener onItemCliclListener) {
        this.onItemCliclListener = onItemCliclListener;
    }

    public RecyAdapter(Context context, ArrayList<XwBean.NewslistBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        switch (i) {
            case 0:
                View inflate = LayoutInflater.from(context).inflate(R.layout.item, null);
                return new ViewHolder(inflate);
            case 1:
                View inflate1 = LayoutInflater.from(context).inflate(R.layout.item1, null);
                return new ViewHolder1(inflate1);
            case 2:
                View inflate2 = LayoutInflater.from(context).inflate(R.layout.item2, null);
                return new ViewHolder2(inflate2);
            case 3:
                View inflate3 = LayoutInflater.from(context).inflate(R.layout.item3, null);
                return new ViewHolder3(inflate3);

        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, final int i) {
        int type = getItemViewType(i);
        if (type == 0) {
            ViewHolder viewHolder1 = (ViewHolder) viewHolder;
            XwBean.NewslistBean newslistBean = list.get(i);
            viewHolder1.tv_title.setText(newslistBean.getTitle());
            RequestOptions requestOptions = new RequestOptions();
            RequestOptions transform = requestOptions.transform(new RoundedCorners(12));
            Glide.with(context).load(newslistBean.getPicUrl()).apply(transform).into(viewHolder1.iv_picUrl);
            viewHolder1.view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (onItemCliclListener!=null){
                        onItemCliclListener.onItemClick(i);
                    }
                }
            });
        }
        if (type == 1) {
            ViewHolder1 viewHolder1 = (ViewHolder1) viewHolder;
            XwBean.NewslistBean newslistBean = list.get(i);
            viewHolder1.tv_title.setText(newslistBean.getTitle());
            viewHolder1.tv_titles.setText(newslistBean.getTitle());
            RequestOptions requestOptions = new RequestOptions();
            RequestOptions transform = requestOptions.transform(new RoundedCorners(12));
            Glide.with(context).load(newslistBean.getPicUrl()).apply(transform).into(viewHolder1.iv_picUrl);
            Glide.with(context).load(newslistBean.getPicUrl()).apply(transform).into(viewHolder1.iv_picUrls);
            viewHolder1.view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (onItemCliclListener!=null){
                        onItemCliclListener.onItemClick(i);
                    }
                }
            });

        }
        if (type == 2) {
            ViewHolder2 viewHolder1 = (ViewHolder2) viewHolder;
            XwBean.NewslistBean newslistBean = list.get(i);
            viewHolder1.tv_title.setText(newslistBean.getTitle());
            RequestOptions requestOptions = new RequestOptions();
            RequestOptions transform = requestOptions.transform(new RoundedCorners(12));
            Glide.with(context).load(newslistBean.getPicUrl()).apply(transform).into(viewHolder1.iv_picUrl);
            viewHolder1.view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (onItemCliclListener!=null){
                        onItemCliclListener.onItemClick(i);
                    }
                }
            });
        }
        if (type == 3) {
            ViewHolder3 viewHolder1 = (ViewHolder3) viewHolder;
            XwBean.NewslistBean newslistBean = list.get(i);
            viewHolder1.tv_title.setText(newslistBean.getTitle());
            RequestOptions requestOptions = new RequestOptions();
            RequestOptions transform = requestOptions.transform(new RoundedCorners(12));
            Glide.with(context).load(newslistBean.getPicUrl()).apply(transform).into(viewHolder1.iv_picUrl);
            viewHolder1.view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (onItemCliclListener!=null){
                        onItemCliclListener.onItemClick(i);
                    }
                }
            });
        }

    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return 0;
        } else if (position == 1) {
            return 1;
        } else if (position % 2 == 0) {
            return 2;
        }
        return 3;
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tv_title;
        private ImageView iv_picUrl;
        private View view;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            iv_picUrl = itemView.findViewById(R.id.iv_picUrl);
            tv_title = itemView.findViewById(R.id.tv_title);
            view = itemView;
        }
    }

    class ViewHolder1 extends RecyclerView.ViewHolder {
        private TextView tv_title,tv_titles;
        private ImageView iv_picUrl;
        private ImageView iv_picUrls;
        private View view;

        public ViewHolder1(@NonNull View itemView) {
            super(itemView);
            iv_picUrl = itemView.findViewById(R.id.iv_picUrl);
            tv_title = itemView.findViewById(R.id.tv_title);
            iv_picUrls = itemView.findViewById(R.id.iv_picUrls);
            tv_titles = itemView.findViewById(R.id.tv_titles);
            view = itemView;
        }
    }

    class ViewHolder2 extends RecyclerView.ViewHolder {
        private TextView tv_title;
        private ImageView iv_picUrl;
        private View view;

        public ViewHolder2(@NonNull View itemView) {
            super(itemView);
            iv_picUrl = itemView.findViewById(R.id.iv_picUrl);
            tv_title = itemView.findViewById(R.id.tv_title);
            view = itemView;
        }
    }

    class ViewHolder3 extends RecyclerView.ViewHolder {
        private TextView tv_title;
        private ImageView iv_picUrl;
        private View view;

        public ViewHolder3(@NonNull View itemView) {
            super(itemView);
            iv_picUrl = itemView.findViewById(R.id.iv_picUrl);
            tv_title = itemView.findViewById(R.id.tv_title);
            view = itemView;
        }
    }
    public interface OnItemCliclListener {
       void onItemClick(int position);
    }
}
