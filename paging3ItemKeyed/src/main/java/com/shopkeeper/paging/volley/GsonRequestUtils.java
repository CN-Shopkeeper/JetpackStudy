package com.shopkeeper.paging.volley;

import com.android.volley.Response;
import com.shopkeeper.paging.model.Movie;

import java.util.ArrayList;

public class GsonRequestUtils {

    //  不能写localhost（模拟器解析localhost就是模拟器本身），得写服务器的ip（就是电脑的）
//    查询自己ip的方法：右键电脑的网络，“打开网络和Internet设置”，找到自己连接的网络，点击属性，往下翻
    private static final String BASE_URL = "http://192.168.0.103:8088/";

    public static GsonArrayRequest<Movie> getPdsRequest(int since, int pagesize, Response.Listener<ArrayList<Movie>> listener, Response.ErrorListener errorListener) {
        return new GsonArrayRequest<>(
                BASE_URL + "ikds?since=" + since + "&pagesize=" + pagesize,
                Movie.class,
                null,
                listener,
                errorListener);
    }
}
