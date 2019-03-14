package com.lazday.tugaskeduaolshop.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


import com.lazday.tugaskeduaolshop.R;
import com.lazday.tugaskeduaolshop.adapter.ProductTugasAdapter;
import com.lazday.tugaskeduaolshop.data.Model.productTugas;
import com.lazday.tugaskeduaolshop.data.Retrofit.Api;
import com.lazday.tugaskeduaolshop.data.Retrofit.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class JavaFragment extends Fragment {

    SwipeRefreshLayout swipeRefreshLayout;
    RecyclerView recyclerView;

    private void getProductsTugas() {

        swipeRefreshLayout.setRefreshing(true);
        ApiInterface apiInterface = Api.getUrlTugas().create(ApiInterface.class);

        Call<productTugas> call =apiInterface.getResultsJava();
        call.enqueue(new Callback<productTugas>() {
            @Override
            public void onResponse(Call<productTugas> call, Response<productTugas> response) {
                productTugas productTugas = response.body();
                List<productTugas.Result> results = productTugas.getResults();
                recyclerView.setAdapter(new ProductTugasAdapter(getActivity(), results));
                swipeRefreshLayout.setRefreshing(false);
            }

            @Override
            public void onFailure(Call<productTugas> call, Throwable t) {
                Log.e("_logError", String.valueOf( t.toString() ) );
                swipeRefreshLayout.setRefreshing(false);
            }
        });

    }

    public JavaFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
    */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_java, container, false);
        recyclerView = view.findViewById(R.id.recyclerViewJava);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getContext(), 2);
        recyclerView.setLayoutManager(layoutManager);

        swipeRefreshLayout = view.findViewById(R.id.swipeRefresh);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                recyclerView.setAdapter(null);
//                Toast.makeText(getActivity(),"lagi mengambil",Toast.LENGTH_SHORT).show();
                getProductsTugas();
            }
        });
        getProductsTugas();
        return view;
    }
}
