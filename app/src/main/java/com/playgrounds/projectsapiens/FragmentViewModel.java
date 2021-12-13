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
    private final MutableLiveData<NewDataResponse> dataLiveData = new MutableLiveData<>();

    public FragmentViewModel(@NonNull Application application) {
        super(application);
        Taboola.init(publisherInfo);
    }

    public LiveData<NewDataResponse> getDataLiveData() {
        return dataLiveData;
    }

    public void FetchData() {
        feedRepository.fetchData(getApplication().getString(R.string.json_uri))
                .subscribeOn(Schedulers.io())
                .doOnSuccess(value -> dataLiveData.postValue(new NewDataResponse.SuccessResponse(value)))
                .doOnError(value -> new NewDataResponse.FailureResponse("Failed to load data"))
                .subscribe();
    }

    // This is a substitute for sealed classes
    public abstract static class NewDataResponse {
        public static class SuccessResponse extends NewDataResponse {
            public final ListItem[] items;

            public SuccessResponse(ListItem[] items) {
                super();
                this.items = items;
            }
        }

        public static class FailureResponse extends NewDataResponse {
            public final String reason;

            public FailureResponse(String reason) {
                super();
                this.reason = reason;
            }
        }
    }
}
