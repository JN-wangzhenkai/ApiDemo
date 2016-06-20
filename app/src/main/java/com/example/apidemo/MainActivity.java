package com.example.apidemo;

import android.graphics.Rect;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;
import com.example.apidemo.adapter.MyAdapter;
import com.example.apidemo.utils.BitmapUtils;
import com.example.apidemo.utils.DateParse;

public class MainActivity extends AppCompatActivity {

    public RecyclerView mRecyclerView;

    private ImageLoader mImageLoader;

    private RequestQueue mQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DateParse dateParse=new DateParse(getApplicationContext());


        //关联recycleview id
        mRecyclerView = (RecyclerView) findViewById(R.id.recycleview_show);

        //优化 提高性能
        if(mRecyclerView!=null){
            mRecyclerView.setHasFixedSize(true);
        }
        //线性  垂直或水平滚动
      //  mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        //2就是2列，第二个参数是垂直方向
        mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));


        ////设置item之间的间隔
        SpacesItemDecoration decoration=new SpacesItemDecoration(16);
       mRecyclerView.addItemDecoration(decoration);


        dateParse.getjson(mRecyclerView);
    }



    //自定义了一个SpacesItemDecoration
    public class SpacesItemDecoration extends RecyclerView.ItemDecoration {

        private int space;

        public SpacesItemDecoration(int space) {
            this.space=space;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            outRect.left=space;
            outRect.right=space;
            outRect.bottom=space;
            if(parent.getChildAdapterPosition(view)==0){
                outRect.top=space;
            }
        }
    }
}
