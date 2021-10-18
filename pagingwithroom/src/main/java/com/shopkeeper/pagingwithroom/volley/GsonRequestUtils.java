package com.shopkeeper.pagingwithroom.volley;

import com.android.volley.Response;
import com.shopkeeper.pagingwithroom.model.Movies;

public class GsonRequestUtils {

    //  不能写localhost（模拟器解析localhost就是模拟器本身），得写服务器的ip（就是电脑的）
//    查询自己ip的方法：右键电脑的网络，“打开网络和Internet设置”，找到自己连接的网络，点击属性，往下翻
    private static final String BASE_URL = "http://192.168.0.103:8088/";

//    public static GsonRequest<Movies> getPdsRequest(int page, Response.Listener<Movies> listener, Response.ErrorListener errorListener) {
//        return new GsonRequest<>(
//                BASE_URL + "pkds?page=" + page,
//                Movies.class,
//                null,
//                listener,
//                errorListener
//        );
//    }

    public static GsonRequest<Movies> getAllMovies(Response.Listener<Movies> listener, Response.ErrorListener errorListener) {
        return new GsonRequest<>(
                BASE_URL + "allMovies",
                Movies.class,
                null,
                listener,
                errorListener
        );
    }
}
