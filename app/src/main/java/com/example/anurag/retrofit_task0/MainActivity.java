package com.example.anurag.retrofit_task0;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private SearchView searchView;
    private RecyclerView searchList;
    private ArrayList<SearchedCharacter> searchedCharacters;
    private ApiInterface apiService;
    private SearchAdapter searchAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Realm.init(this);

        apiService = ApiClient.getClient().create(ApiInterface.class);
        searchView = findViewById(R.id.searchView);
        searchedCharacters = new ArrayList<>();
        searchedCharacters.addAll(RealmHelper.GetSavedCharacters());

        searchAdapter = new SearchAdapter(this, searchedCharacters);
        searchList = findViewById(R.id.searchList);
        searchList.setLayoutManager(new LinearLayoutManager(this));
        searchList.setAdapter(searchAdapter);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                searchCharacter(newText);
                return false;
            }
        });

        Log.d("SAVED_CHARACTERS", RealmHelper.GetSavedCharacters().size() + "");

    }

    private void searchCharacter(String name){
        Log.d("HERE", "HERE");
        Call<SearchedCharacter> searchCharacterCall = apiService.getCharacterByName(name);
        searchCharacterCall.enqueue(new Callback<SearchedCharacter>() {
            @Override
            public void onResponse(Call<SearchedCharacter> call, Response<SearchedCharacter> response) {
                if(response.body() == null){
                    searchedCharacters.clear();
                    searchedCharacters.addAll(RealmHelper.GetSavedCharacters());
                    searchAdapter.notifyDataSetChanged();
                    return;
                }
                SearchedCharacter character = response.body();
                Log.d("SEARCH_RESULT", character.getData().getName());
                searchedCharacters.clear();
                searchedCharacters.add(character);
                searchedCharacters.addAll(RealmHelper.GetSavedCharacters());
                searchAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<SearchedCharacter> call, Throwable t) {
                Log.d("HERE", t.getMessage());

            }
        });
    }
}
