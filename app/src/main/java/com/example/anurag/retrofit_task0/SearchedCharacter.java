package com.example.anurag.retrofit_task0;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class SearchedCharacter extends RealmObject{

    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("data")
    @Expose
    private Data data;

    @PrimaryKey
    private long timestamp = System.currentTimeMillis();

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public long getTimestamp() {
        return timestamp;
    }
}
