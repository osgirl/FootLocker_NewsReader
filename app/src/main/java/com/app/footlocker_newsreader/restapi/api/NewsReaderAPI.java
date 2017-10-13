package com.app.footlocker_newsreader.restapi.api;

import com.app.footlocker_newsreader.restapi.model.RootResponse;


import retrofit2.Call;
import retrofit2.http.GET;

public interface NewsReaderAPI {

    @GET("/jvanaria/jvanaria.github.io/master/business.json")
    Call<RootResponse> loadBusinessNews();

    @GET("/jvanaria/jvanaria.github.io/master/top-stories.json")
    Call<RootResponse> loadTopStories();

    @GET("/jvanaria/jvanaria.github.io/master/entertainment.json")
    Call<RootResponse> loadEntertainmentNews();
}
