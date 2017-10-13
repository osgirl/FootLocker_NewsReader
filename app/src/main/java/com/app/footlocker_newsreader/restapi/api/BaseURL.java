package com.app.footlocker_newsreader.restapi.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class BaseURL {

    private static final String BASE_URL = "https://raw.githubusercontent.com";

    private static Retrofit getBaseUrl() {
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static NewsReaderAPI getAPI() {
        return BaseURL.getBaseUrl().create(NewsReaderAPI.class);
    }
}
