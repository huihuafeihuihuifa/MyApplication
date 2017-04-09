package com.example.administrator.myapplication;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.example.administrator.myapplication.adapter.MyAdapter;

public class MainActivity extends AppCompatActivity {

    private boolean isDelete = false;
    private RecyclerView recycler;
    private MyAdapter adapter;
    private TextView tv_menu,tv_sort1,tv_sort2,tv_tab1,tv_tab2,tv_tab3;
    private RecyclerView recyeler;
    private SwipeRefreshLayout refresh;//下拉刷新

    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);//去掉标题栏
        setContentView(R.layout.activity_list);
        tv_menu = (TextView) findViewById(R.id.tv_menu);
        recycler = (RecyclerView) findViewById(R.id.recycler);
        refresh = (SwipeRefreshLayout) findViewById(R.id.refresh);
        //refresh.setRefreshing(true);
        init();
        initRecycler();
        Log.i("nihao","d");
    }

    private void initRecycler() {
        adapter = new MyAdapter(this);
        recycler.setFocusable(false);// 设置不抢夺主页面焦点
        recycler.setHasFixedSize(true);
        recycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recycler.setAdapter(adapter);
    }

    private void init() {
        refresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {

                refresh.setRefreshing(false);
            }
        });
        tv_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showMenu();
            }
        });
    }

    private void showMenu(){
        final View pop_menu = MainActivity.this.getLayoutInflater().inflate(R.layout.pop_menu, null);
        TextView menu_delete = (TextView) pop_menu.findViewById(R.id.menu_delete);

        final PopupWindow window = new PopupWindow(pop_menu, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        //  2016/5/17 设置动画
//        window.setAnimationStyle(R.style.popup_window_anim);
        //  2016/5/17 设置背景颜色
        window.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#F8F8F8")));
        // T 2016/5/17 设置可以获取焦点
        window.setFocusable(true);
        // 2016/5/17 设置可以触摸弹出框以外的区域
        window.setOutsideTouchable(true);
        // 更新popupwindow的状态
        window.update();
        // 以下拉的方式显示，并且可以设置显示的位置
        window.showAsDropDown(tv_menu, 0, 0);

        //点击批量删除
        menu_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                window.dismiss();
                isDelete = true;
                adapter.setDelete(isDelete);
                adapter.notifyDataSetChanged();
            }
        });

    }



    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK){
            if (isDelete){
                isDelete = false;
                adapter.setDelete(false);
                adapter.notifyDataSetChanged();
                return false;
            }
        }
        return super.onKeyDown(keyCode, event);
    }
}
