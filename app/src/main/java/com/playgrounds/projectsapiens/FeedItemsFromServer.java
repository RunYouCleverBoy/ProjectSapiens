package com.playgrounds.projectsapiens;

import com.google.gson.annotations.SerializedName;

public class FeedItemsFromServer {
    @SerializedName("name")
    public String title;
    @SerializedName("thumbnail")
    public String thumbnailUrl;
    @SerializedName("description")
    public String description;
}
