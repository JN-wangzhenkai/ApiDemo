package com.example.apidemo.utils;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.apidemo.Bean.DataBean;
import com.example.apidemo.Bean.ResultBean;
import com.example.apidemo.adapter.MyAdapter;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONObject;

import java.util.List;

/**
 * Created by wangzhenkai on 2016/6/19.
 */
public class DateParse {

    private ImageLoader mImageLoader;
    Context context;

    String url="http://gank.io/api/data/"+java.net.URLEncoder.encode("福利")+"/10/1";
    private RequestQueue mQueue;

    public DateParse(Context context) {
        this.context = context;
    }

    //获取数据
    public void getjson (final RecyclerView re) {

        mQueue = Volley.newRequestQueue(context);

        StringRequest objectRequest = new StringRequest(url,  new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                //获取到的数据解析出来
            List<ResultBean>data=  parseJson(response);

                //创建一个 ImageLoader 对象  第二个参数传入BitmapUtils的实例
                mImageLoader = new ImageLoader(mQueue, new BitmapUtils());
                //获取并解析数据

                MyAdapter adapter=new MyAdapter(mImageLoader);

                adapter.addData(data);

               re.setAdapter(adapter);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Log.d("错误", "onErrorResponse: ");
            }
        });

        mQueue.add(objectRequest);


    }

    //解析数据的方法
    public List<ResultBean> parseJson(String json){

       // Log.d("2222222222222222222", "parseJson: "+json);

        Gson gson=new Gson();

        DataBean<List<ResultBean>>  data=gson.fromJson(json,new TypeToken<DataBean<List<ResultBean>>>(){}.getType());

        return data.getResults();
    }

}
