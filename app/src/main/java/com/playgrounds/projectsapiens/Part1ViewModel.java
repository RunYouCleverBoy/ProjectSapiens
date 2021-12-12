package com.playgrounds.projectsapiens;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.playgrounds.projectsapiens.listitems.FeedListItem;
import com.playgrounds.projectsapiens.listitems.ListItem;
import com.taboola.android.PublisherInfo;
import com.taboola.android.Taboola;

import io.reactivex.rxjava3.schedulers.Schedulers;

public class Part1ViewModel extends AndroidViewModel {
    private final PublisherInfo publisherInfo = new PublisherInfo(getApplication().getString(R.string.taboola_id));
    private final Part1Repository part1Repository = new Part1Repository();
    private final MutableLiveData<ListItem[]> dataLiveData = new MutableLiveData<>();

    public Part1ViewModel(@NonNull Application application) {
        super(application);
        Taboola.init(publisherInfo);
    }

    public LiveData<ListItem[]> getDataLiveData() {
        return dataLiveData;
    }

    public void FetchData() {
        part1Repository.fetchData(getApplication().getString(R.string.json_uri))
                .subscribeOn(Schedulers.io())
                .doOnSuccess(listOfItems -> {
                    FeedListItem[] items = listOfItems.stream().map(this::convertFrom).toArray(FeedListItem[]::new);
                    dataLiveData.postValue(items);
                }).subscribe();
    }

    private FeedListItem convertFrom(Part1ServerItem item) {
        return new FeedListItem(item.title, item.description, item.thumbnailUrl);
    }
}
