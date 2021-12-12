package com.playgrounds.projectsapiens;

import java.util.List;

import io.reactivex.rxjava3.core.Single;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public class FeedRepository {
    public Single<List<Part1ServerItem>> fetchData(String uriStr) {
        RxJava3CallAdapterFactory rxAdapter = RxJava3CallAdapterFactory.create();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(uriStr)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(rxAdapter)
                .build();
        FeedDataApi api = retrofit.create(FeedDataApi.class);
        return api.load();
    }

    public interface FeedDataApi {
        @GET("data.json")
        Single<List<Part1ServerItem>> load();
    }
}
