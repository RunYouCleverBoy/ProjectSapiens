package com.playgrounds.projectsapiens.listitems;

/**
 * A struct for list item
 * <p>
 * It's a data class, so it's all too much to use getters and setters.
 */
public class FeedListItem implements ListItem {
    public String title;
    public String description;
    public String thumbnailUri;

    public FeedListItem(String title, String description, String thumbnailUri) {
        this.title = title;
        this.description = description;
        this.thumbnailUri = thumbnailUri;
    }
}
