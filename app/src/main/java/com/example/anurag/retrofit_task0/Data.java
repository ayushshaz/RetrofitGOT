package com.example.anurag.retrofit_task0;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import io.realm.RealmList;
import io.realm.RealmObject;


public class Data extends RealmObject{

    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("dateOfDeath")
    @Expose
    private Integer dateOfDeath;
    @SerializedName("dateOfBirth")
    @Expose
    private Integer dateOfBirth;
    @SerializedName("imageLink")
    @Expose
    private String imageLink;
    @SerializedName("male")
    @Expose
    private Boolean male;
    @SerializedName("culture")
    @Expose
    private String culture;
    @SerializedName("house")
    @Expose
    private String house;
    @SerializedName("slug")
    @Expose
    private String slug;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("__v")
    @Expose
    private Integer v;
    @SerializedName("pageRank")
    @Expose
    private Float pageRank;
    @SerializedName("books")
    @Expose
    private RealmList<String> books = null;
    @SerializedName("updatedAt")
    @Expose
    private String updatedAt;
    @SerializedName("createdAt")
    @Expose
    private String createdAt;
    @SerializedName("titles")
    @Expose
    private RealmList<String> titles = null;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getDateOfDeath() {
        return dateOfDeath;
    }

    public void setDateOfDeath(Integer dateOfDeath) {
        this.dateOfDeath = dateOfDeath;
    }

    public Integer getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Integer dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getImageLink() {
        return imageLink;
    }

    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }

    public Boolean getMale() {
        return male;
    }

    public void setMale(Boolean male) {
        this.male = male;
    }

    public String getCulture() {
        return culture;
    }

    public void setCulture(String culture) {
        this.culture = culture;
    }

    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getV() {
        return v;
    }

    public void setV(Integer v) {
        this.v = v;
    }

    public Float getPageRank() {
        return pageRank;
    }

    public void setPageRank(Float pageRank) {
        this.pageRank = pageRank;
    }

    public RealmList<String> getBooks() {
        return books;
    }

    public void setBooks(RealmList<String> books) {
        this.books = books;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public RealmList<String> getTitles() {
        return titles;
    }

    public void setTitles(RealmList<String> titles) {
        this.titles = titles;
    }

}
