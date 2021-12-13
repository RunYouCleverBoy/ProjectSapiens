package com.playgrounds.projectsapiens.listholders;

import android.graphics.Color;
import android.view.ViewGroup;

import com.playgrounds.projectsapiens.databinding.TaboolaFeedCellBinding;
import com.playgrounds.projectsapiens.model.listitems.TaboolaListItem;
import com.taboola.android.TaboolaWidget;
import com.taboola.android.utils.SdkDetailsHelper;

public class TaboolaFeedHolder extends ListItemHolder<TaboolaListItem> {
    public final TaboolaWidget widget;

    public TaboolaFeedHolder(TaboolaFeedCellBinding binding) {
        super(binding.getRoot());
        widget = binding.taboolaView;
        ViewGroup.LayoutParams layoutParams = widget.getLayoutParams();
        layoutParams.height = SdkDetailsHelper.getDisplayHeight(widget.getContext()) * 2;
        widget.setLayoutParams(layoutParams);
        widget.setInterceptScroll(true);
        widget.setProgressBarEnabled(true);
        widget.setProgressBarDuration(1); //Sets progressbar duration to 1 second
        widget.setProgressBarColor(Color.MAGENTA); //Sets progressbar color to Magenta
        widget.fetchContent();
    }

    @Override
    public void bind(TaboolaListItem data) {

    }
}
