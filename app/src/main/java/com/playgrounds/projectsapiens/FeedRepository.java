package com.playgrounds.projectsapiens;

import androidx.annotation.NonNull;

import com.playgrounds.projectsapiens.listitems.FeedListItem;
import com.playgrounds.projectsapiens.listitems.ListItem;
import com.playgrounds.projectsapiens.listitems.ListItemKind;

import java.util.List;

import io.reactivex.rxjava3.core.Single;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public class FeedRepository {
    @NonNull
    static ListItem[] mapPostsToArray(java.util.List<FeedItemsFromServer> listOfItems) {
        final ListItem[] result = new ListItem[PositionResolverImpl.OVERALL_POSITIONS];
        int index = 0;
        PositionResolverImpl positionResolver = new PositionResolverImpl();
        for (FeedItemsFromServer item : listOfItems) {
            // For the unlikely event that there are more items than cells the put them.
            if (index >= result.length) {
                return result;
            }

            if (positionResolver.get(index) == ListItemKind.FEED_ITEM.id) {
                result[index] = convertFrom(item);
            }
            index++;
        }
        return result;
    }

    @NonNull
    static FeedListItem convertFrom(FeedItemsFromServer item) {
        return new FeedListItem(item.title, item.description, item.thumbnailUrl);
    }

    public Single<List<FeedItemsFromServer>> fetchData(String uriStr) {
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
        Single<List<FeedItemsFromServer>> load();
    }
}
