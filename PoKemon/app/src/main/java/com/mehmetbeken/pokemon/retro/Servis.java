package com.mehmetbeken.kerim.retro;

import com.mehmetbeken.kerim.retro.Model;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Servis {

    @GET("DavidCorrado/8912aa29d7c4a5fbf03993b32916d601/raw/681ef0b793ab444f2d81f04f605037fb44814125/pokemon.json")
    Call<List<Model>> getData();
}
