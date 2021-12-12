package com.playgrounds.projectsapiens;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import com.playgrounds.projectsapiens.databinding.FeedRecyclerCellBinding;
import com.playgrounds.projectsapiens.databinding.TaboolaFeedCellBinding;
import com.playgrounds.projectsapiens.databinding.TaboolaWidgetCellBinding;
import com.playgrounds.projectsapiens.listholders.FeedItemHolder;
import com.playgrounds.projectsapiens.listholders.ListItemHolder;
import com.playgrounds.projectsapiens.listholders.TaboolaFeedHolder;
import com.playgrounds.projectsapiens.listholders.TaboolaWidgetHolder;
import com.playgrounds.projectsapiens.listitems.ListItemKind;

public class HolderFactory {
    @NonNull
    public static ListItemHolder create(ListItemKind kind, LayoutInflater inflater, ViewGroup parent) {
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
