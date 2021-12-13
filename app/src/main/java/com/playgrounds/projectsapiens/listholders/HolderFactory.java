package com.playgrounds.projectsapiens.listholders;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import com.playgrounds.projectsapiens.databinding.FeedRecyclerCellBinding;
import com.playgrounds.projectsapiens.databinding.TaboolaFeedCellBinding;
import com.playgrounds.projectsapiens.databinding.TaboolaWidgetCellBinding;
import com.playgrounds.projectsapiens.model.listitems.ListItem;
import com.playgrounds.projectsapiens.model.listitems.ListItemKind;

public class HolderFactory {
    @NonNull
    public static ListItemHolder<? extends ListItem> create(ListItemKind kind, LayoutInflater inflater, ViewGroup parent) {
        switch (kind) {
            case FEED_ITEM:
                return new FeedItemHolder(FeedRecyclerCellBinding.inflate(inflater, parent, false));
            case TABOOLA_WIDGET:
                return new TaboolaWidgetHolder(TaboolaWidgetCellBinding.inflate(inflater, parent, false));
            case TABOOLA_FEED:
                return new TaboolaFeedHolder(TaboolaFeedCellBinding.inflate(inflater, parent, false));
            default:
                throw new IllegalArgumentException("Holder factory: Cannot handle " + kind);
        }
    }
}
