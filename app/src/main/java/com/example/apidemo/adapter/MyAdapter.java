package com.example.apidemo.adapter;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.example.apidemo.Bean.ResultBean;
import com.example.apidemo.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangzhenkai on 2016/6/19.
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private List<ResultBean> resultData = new ArrayList<>();

    private ImageLoader mImageLoader;

    public MyAdapter(ImageLoader imageLoader) {

        mImageLoader=imageLoader;
    }

    public void addData( List<ResultBean> bean) {
        resultData.addAll(bean);
    }

    //拿到数据放置的 item
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cardview, null);

        ViewHolder viewHolder = new ViewHolder(v);

        //找到ID
        viewHolder.img = (NetworkImageView) v.findViewById(R.id.img_card);
        viewHolder.create = (TextView) v.findViewById(R.id.tv_create);
        viewHolder.publish = (TextView) v.findViewById(R.id.tv_publish);
        viewHolder.desc = (TextView) v.findViewById(R.id.tv_desc);
        viewHolder.type = (TextView) v.findViewById(R.id.tv_type);
        viewHolder.who = (TextView) v.findViewById(R.id.tv_who);

        return viewHolder;
    }

    //传入封装起来的数据
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        ResultBean bean = resultData.get(position);

        holder.create.setText(bean.getCreatedA());
        holder.publish.setText(bean.getPublishedAt());
        holder.who.setText(bean.getWho());
        holder.type.setText(bean.getType());
        holder.desc.setText(bean.getDesc());
        holder.img.setImageUrl(bean.getUrl(),mImageLoader);
    }

    //数据个数
    @Override
    public int getItemCount() {
        return resultData.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView create;
        public TextView publish;
        public TextView desc;
        public TextView type;
        public NetworkImageView img;
        public TextView who;


        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
