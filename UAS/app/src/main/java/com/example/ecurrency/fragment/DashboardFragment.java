package com.example.ecurrency.fragment;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ecurrency.R;
import com.example.ecurrency.adapter.CardNews;
import com.example.ecurrency.model.News;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;


public class DashboardFragment extends Fragment {


    public DashboardFragment() {

    }

    private RecyclerView rvNews;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_dashboard, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);
        rvNews = view.findViewById(R.id.rv_news);
        getNews();
    }

    public void getNews(){
        final ArrayList<News> News = new ArrayList<>();
        AsyncHttpClient client = new AsyncHttpClient();
        String url = "http://newsapi.org/v2/top-headlines?category=business&apiKey=e692335ecadf4fa881abc2d91d9d83c1";

        client.get(url, new AsyncHttpResponseHandler() {

            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                try{
                    String result = new String (responseBody);
                    JSONObject responseObject = new JSONObject(result);
                    JSONArray list =  responseObject.getJSONArray("articles");
                    for (int i = 0; i < list.length(); i++){
                        JSONObject obj = list.getJSONObject(i);
                        News s = new News(obj.getString("title"),
                                obj.getString("description"),obj.getString("urlToImage"));
                        News.add(s);
                    }
                    showNews(News);
                }catch (Exception e){
                    Log.d("ExceptionStudent", "onSuccess: " + e.getMessage());
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                Log.d("OnFailureStudent", "onFailure: " + error.getMessage());
            }
        });
    }

    private void showNews(ArrayList<News> news) {
        rvNews.setLayoutManager(new LinearLayoutManager(getActivity()));
        CardNews cardNews = new CardNews(getContext());
        cardNews.setListNews(news);
        rvNews.setAdapter(cardNews);
    }
}
