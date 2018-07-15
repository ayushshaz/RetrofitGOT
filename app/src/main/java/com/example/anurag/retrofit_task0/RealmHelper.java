package com.example.anurag.retrofit_task0;

import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmResults;

public class RealmHelper {

    public static void SaveCharacter(SearchedCharacter searchedCharacter){
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        realm.insertOrUpdate(searchedCharacter);
        realm.commitTransaction();
    }

    public static ArrayList<SearchedCharacter> GetSavedCharacters(){
        Realm realm = Realm.getDefaultInstance();
        RealmResults<SearchedCharacter> realmResults = realm.where(SearchedCharacter.class).findAll();
        ArrayList<SearchedCharacter> result = new ArrayList<>(realmResults);
        return result;
    }

    public static void DeleteAllCharacters(){
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        realm.delete(SearchedCharacter.class);
        realm.commitTransaction();
    }

    public static SearchedCharacter GetCharacterById(long id){
        Realm realm = Realm.getDefaultInstance();
        RealmResults<SearchedCharacter> result = realm.where(SearchedCharacter.class).equalTo("timestamp", id).findAll();
        if(result.size() == 0){
            return null;
        }

        return result.get(0);
    }

}
