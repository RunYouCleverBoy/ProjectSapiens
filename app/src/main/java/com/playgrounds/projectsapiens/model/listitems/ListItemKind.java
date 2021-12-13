package com.playgrounds.projectsapiens.model.listitems;

import com.playgrounds.projectsapiens.R;

public enum ListItemKind {
    FEED_ITEM(1, R.layout.feed_recycler_cell),
    TABOOLA_WIDGET(2, R.layout.taboola_widget_cell),
    TABOOLA_FEED(3, R.layout.taboola_feed_cell);

    public final int id;
    public final int feed_recycler_cell;

    ListItemKind(int id, int feed_recycler_cell) {
        this.id = id;
        this.feed_recycler_cell = feed_recycler_cell;
    }

    public static ListItemKind valueOf(int id) {
        for (ListItemKind item : values()) {
            if (item.id == id) return item;
        }
        throw new IllegalArgumentException("Cannot find an item with id=" + id);
    }
}
