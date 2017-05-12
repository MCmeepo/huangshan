package com.meepo.huangshan.bean;

import android.graphics.Bitmap;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by meepo on 2017/5/1.
 */

public class Movie {

    String mId;
    String mTitle;
    String mType;
    String mYear;
    String mPosterUrl;
    Bitmap mPosterBitmap;
    Bitmap mPosterBitmapL;

    public static Movie makeMovie(JSONObject json) {

        //has（"")方法：针对字符串判断，是否有“”
        if (json.has("imdbID")) {
            Movie movie = new Movie();
            movie.setImdbId(json.optString("imdbID"));
            if (json.has("Title")) {
                movie.setTitle(json.optString("Title"));
            }
            if (json.has("Type")) {
                movie.setType(json.optString("Type"));
            }
            if (json.has("Year")) {
                movie.setYear(json.optString("Year"));
            }
            if (json.has("Poster")) {
                movie.setPosterUrl(json.optString("Poster"));
            }
            return movie;
        }

        return null;
    }

    public Bitmap getBitmap() {
        return mPosterBitmap;
    }

    public static List<Movie> movieList(JSONArray jsons) {
        List<Movie> movies = new ArrayList<>();
        for (int i = 0; i < jsons.length(); i++) {
            movies.add(makeMovie(jsons.optJSONObject(i)));
        }
        return movies;
    }

    public String getImdbId() {
        return mId;
    }

    public Movie setImdbId(String imdbId) {
        this.mId = imdbId;
        return this;
    }

    public String getTitle() {
        return mTitle;
    }

    public Movie setTitle(String title) {
        this.mTitle = title;
        return this;
    }

    public String getType() {
        return mType;
    }

    public Movie setType(String type) {
        this.mType = type;
        return this;
    }

    public String getYear() {
        return mYear;
    }

    public Movie setYear(String year) {
        this.mYear = year;
        return this;
    }

    public String getPosterUrl() {
        return mPosterUrl;
    }

    public Movie setPosterUrl(String posterUrl) {
        this.mPosterUrl = posterUrl;
        return this;
    }

    public Bitmap getPosterBitmap() {
        return mPosterBitmap;
    }

    public Movie setPosterBitmap(Bitmap posterBitmap) {
        mPosterBitmap = posterBitmap;
        return this;
    }
}



