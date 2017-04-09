package com.example.administrator.myapplication.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.administrator.myapplication.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/4/8 0008.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

//    List<Map> list = new ArrayList<>();
    private  boolean isDelete = false;

    private Context context;
    List<String> list  =  new ArrayList<>();
    public MyAdapter(Context context){
        this.context = context;
        list.add("数据1");
        list.add("数据2");
        list.add("数据3");
        list.add("数据4");
        list.add("数据5");
        list.add("数据6");
        list.add("数据1");
        list.add("数据2");
        list.add("数据3");
        list.add("数据4");
        list.add("数据5");
        list.add("数据6");
        list.add("数据1");
        list.add("数据2");
        list.add("数据3");
        list.add("数据4");
        list.add("数据5");
        list.add("数据6");
        list.add("数据1");
        list.add("数据2");
        list.add("数据3");
        list.add("数据4");
        list.add("数据5");
        list.add("数据6");
        list.add("数据1");
        list.add("数据2");
        list.add("数据3");
        list.add("数据4");
        list.add("数据5");
        list.add("数据6");

    }
    public void setDelete(boolean isDelete){
        this.isDelete = isDelete;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.listitem_hehe,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.tv_content.setText(list.get(position));
        if (isDelete){
            holder.cb_delete.setVisibility(View.VISIBLE);
        }else{
            holder.cb_delete.setVisibility(View.GONE);
        }

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        private TextView tv_content;
        private CheckBox cb_delete;
        public MyViewHolder(View itemView) {
            super(itemView);
            tv_content = (TextView) itemView.findViewById(R.id.tv_content);
            cb_delete = (CheckBox) itemView.findViewById(R.id.cb_delet);
        }
    }


}

