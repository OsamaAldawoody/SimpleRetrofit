package com.nerd.simpleretrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView textView = findViewById(R.id.text);
        Button button = findViewById(R.id.button);


        HashMap<Object,Object> hashMap = new HashMap<Object, Object>();
        hashMap.put("title","osama");
        hashMap.put("body","this is my first retrofit app");
        hashMap.put("userId",5);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        final ApiRetrofit apiRetrofit = retrofit.create(ApiRetrofit.class);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Call<Post> call = apiRetrofit.postHashMap(hashMap);
                call.enqueue(new Callback<Post>() {
                    @Override
                    public void onResponse(Call<Post> call, Response<Post> response) {
                        Toast.makeText(MainActivity.this, response.body().getTitle(), Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Call<Post> call, Throwable t) {
                        Toast.makeText(MainActivity.this, "post failed", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
}
