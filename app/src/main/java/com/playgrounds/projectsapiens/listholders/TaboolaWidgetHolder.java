package com.playgrounds.projectsapiens.listholders;

import com.playgrounds.projectsapiens.databinding.TaboolaWidgetCellBinding;
import com.playgrounds.projectsapiens.listitems.TaboolaListItem;
import com.taboola.android.TaboolaWidget;

public class TaboolaWidgetHolder extends ListItemHolder<TaboolaListItem> {
    public final TaboolaWidget widget;

    public TaboolaWidgetHolder(TaboolaWidgetCellBinding binding) {
        super(binding.getRoot());
        this.widget = binding.taboolaView;
    }

    @Override
    public void bind(TaboolaListItem data) {

    }
}
