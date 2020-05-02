package com.example.cobanavfragment.fragments;


import android.content.Intent;
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
import android.widget.Button;
import android.widget.Toast;

import com.example.cobanavfragment.R;
import com.example.cobanavfragment.activities.DetailActivity;
import com.example.cobanavfragment.adapter.CardView;
import com.example.cobanavfragment.adapter.Student;
import com.example.cobanavfragment.utils.ItemClickSupport;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

public class HomeFragment extends Fragment {


    public HomeFragment() {

    }

    private RecyclerView rvStudent;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rvStudent = view.findViewById(R.id.rv_student);


    }

    @Override
    public void onStart() {
        super.onStart();
        getStudent();
    }

    public void getStudent(){
        final ArrayList<Student> students = new ArrayList<>();
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
                        Student s = new Student(obj.getString("author"),obj.getString("title"),
                                obj.getString("description"),obj.getString("url"),obj.getString("content"),
                                obj.getString("publishedAt"));
                        students.add(s);
                    }
                    showStudent(students);
                }catch (Exception e){
                    Log.d("ExceptionStudent", "onSuccess: " + e.getMessage());
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                Log.d("OnFailureStudent", "onFAilure: " + error.getMessage());
            }
        });
    }

    private void showStudent(final ArrayList<Student>students){
        rvStudent.setLayoutManager(new LinearLayoutManager(getActivity()));
        CardView cardView = new CardView(getContext());
        cardView.setListStudent(students);
        rvStudent.setAdapter(cardView);
        ItemClickSupport.addTo(rvStudent).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                Intent intent = new Intent(getActivity(), DetailActivity.class);
                intent.putExtra(DetailActivity.EXTRA_STUDENT, students.get(position));
                startActivity(intent);
                Toast.makeText(getContext(), students.get(position).getName(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
