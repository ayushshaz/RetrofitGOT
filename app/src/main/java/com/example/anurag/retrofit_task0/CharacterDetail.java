package com.example.anurag.retrofit_task0;

import java.util.List;



public class CharacterDetail {
    String _id;
    String male;
    String house;
    String slug;
    String name;
    String _v;
    Float pageRank;
    List<String> books;
    String updatedAt;
    String createdAt;
    List<String> titles;

    public CharacterDetail(String _id, String male, String house, String slug, String name, String _v, Float pageRank, List<String> books, String updatedAt, String createdAt, List<String> titles) {
        this._id = _id;
        this.male = male;
        this.house = house;
        this.slug = slug;
        this.name = name;
        this._v = _v;
        this.pageRank = pageRank;
        this.books = books;
        this.updatedAt = updatedAt;
        this.createdAt = createdAt;
        this.titles = titles;
    }

    public String get_id() {
        return _id;
    }

    public String getMale() {
        return male;
    }

    public String getHouse() {
        return house;
    }

    public String getSlug() {
        return slug;
    }

    public String getName() {
        return name;
    }

    public String get_v() {
        return _v;
    }

    public Float getPageRank() {
        return pageRank;
    }

    public List<String> getBooks() {
        return books;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public List<String> getTitles() {
        return titles;
    }
}
