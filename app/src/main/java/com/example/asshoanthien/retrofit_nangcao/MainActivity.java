package com.example.asshoanthien.retrofit_nangcao;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.asshoanthien.retrofit_nangcao.adapter.CateAdapter;
import com.example.asshoanthien.retrofit_nangcao.model.Example;
import com.example.asshoanthien.retrofit_nangcao.retrofit.PolyRetrofit;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    int page = 1;
    int per_page = 5;
    private RecyclerView lvList;
    SwipeRefreshLayout f5;
    List<Example>   categories;
    CateAdapter cateAdapter;
    LinearLayoutManager linearLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        categories=new ArrayList<>();
        cateAdapter=new CateAdapter(this,categories);
        linearLayoutManager=new LinearLayoutManager(this);
        lvList.setAdapter(cateAdapter);
        lvList.setLayoutManager(linearLayoutManager);


        f5.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                //lay du lieu
                page=1;
                categories.clear();
                getData(page,per_page);
            }
        });

        lvList.addOnScrollListener(new EndlessRecyclerViewScrollListener(linearLayoutManager) {
            @Override
            public void onLoadMore(int page, int totalItemsCount, RecyclerView view) {
                page=page+1;
                getData(page,per_page);
            }
        });


    }
    public void getData(int page, int per_page){
        PolyRetrofit.getInstance().getCategpries(page, per_page)
                .enqueue(new Callback<List<Example>>() {
            @Override
            public void onResponse(Call<List<Example>> call, Response<List<Example>> response) {
                Toast.makeText(MainActivity.this, response.body().size() + "", Toast.LENGTH_SHORT).show();

                categories.addAll(response.body());
                cateAdapter.notifyDataSetChanged();
                f5.setRefreshing(false);
            }

            @Override
            public void onFailure(Call<List<Example>> call, Throwable t) {

            }
        });

    }
    private void initView() {
        f5 = (SwipeRefreshLayout) findViewById(R.id.f5);
        lvList = (RecyclerView) findViewById(R.id.lvList);
    }
}
