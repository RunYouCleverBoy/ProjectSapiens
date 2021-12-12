package com.playgrounds.projectsapiens.listholders;

import com.playgrounds.projectsapiens.databinding.TaboolaFeedCellBinding;
import com.playgrounds.projectsapiens.listitems.TaboolaListItem;
import com.taboola.android.TaboolaWidget;

public class TaboolaFeedHolder extends ListItemHolder<TaboolaListItem> {
    public final TaboolaWidget widget;

    public TaboolaFeedHolder(TaboolaFeedCellBinding binding) {
        super(binding.getRoot());
        this.widget = binding.taboolaView;
        widget.setInterceptScroll(true);
    }

    @Override
    public void bind(TaboolaListItem data) {

    }
}
