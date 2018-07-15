package com.example.anurag.retrofit_task0;


import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiInterface {


    @GET("characters")
    Call<List<CharacterDetail>> getAllCharacters();

    @GET("characters/{name}")
    Call<SearchedCharacter> getCharacterByName(@Path(value = "name", encoded = true) String name);


}

