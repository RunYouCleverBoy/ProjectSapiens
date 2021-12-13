package com.playgrounds.projectsapiens;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.playgrounds.projectsapiens.model.FeedRepository;
import com.playgrounds.projectsapiens.model.listitems.ListItem;
import com.taboola.android.PublisherInfo;
import com.taboola.android.Taboola;

import io.reactivex.rxjava3.schedulers.Schedulers;

public class FragmentViewModel extends AndroidViewModel {
    @SuppressWarnings("FieldCanBeLocal")
    private final PublisherInfo publisherInfo = new PublisherInfo(getApplication().getString(R.string.taboola_id));
    private final FeedRepository feedRepository = new FeedRepository();
    private final MutableLiveData<ListItem[]> dataLiveData = new MutableLiveData<>();

    public FragmentViewModel(@NonNull Application application) {
        super(application);
        Taboola.init(publisherInfo);
    }

    public LiveData<ListItem[]> getDataLiveData() {
        return dataLiveData;
    }

    public void FetchData() {
        feedRepository.fetchData(getApplication().getString(R.string.json_uri))
                .subscribeOn(Schedulers.io())
                .doOnSuccess(listOfItems -> {
                    ListItem[] items = FeedRepository.mapPostsToArray(listOfItems);
                    dataLiveData.postValue(items);
                }).subscribe();
    }
}
