package com.mehmetbeken.kerim.Fragment;

import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mehmetbeken.kerim.Adapter.RecyclerviewAdapter;
import com.mehmetbeken.kerim.R;
import com.mehmetbeken.kerim.retro.Model;
import com.mehmetbeken.kerim.retro.Servis;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class PokemonFragment extends Fragment {


    Retrofit retrofit;
    String BASE_URL;
    ArrayList<Model> models;
    Gson gson;
    RecyclerView recyclerView;
    RecyclerviewAdapter recyclerviewAdapter;


    public PokemonFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_pokemon, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        recyclerView=view.findViewById(R.id.recyclerView);




















        //Retrofit islemleri

        BASE_URL = "https://gist.githubusercontent.com/";
        gson = new GsonBuilder().setLenient().create();

        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();


        Servis servis = retrofit.create(Servis.class);
        Call<List<Model>> call = servis.getData();

        call.enqueue(new Callback<List<Model>>() {
            @Override
            public void onResponse(Call<List<Model>> call, Response<List<Model>> response) {
                if (response.isSuccessful()) {

                    List<Model> pokemonList = response.body();
                    models = new ArrayList<>(pokemonList);









                    RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(getContext());
                    recyclerView.setLayoutManager(layoutManager);
                    recyclerviewAdapter=new RecyclerviewAdapter(models);
                    recyclerView.setAdapter(recyclerviewAdapter);




                }

            }

            @Override
            public void onFailure(Call<List<Model>> call, Throwable t) {
                t.printStackTrace();

            }
        });


    }


}





