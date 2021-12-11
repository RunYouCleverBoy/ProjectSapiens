package com.playgrounds.projectsapiens.listholders;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;

import com.playgrounds.projectsapiens.databinding.FeedRecyclerCellBinding;
import com.playgrounds.projectsapiens.listitems.FeedListItem;
import com.squareup.picasso.Picasso;

final class FeedItemHolder extends ListItemHolder<FeedListItem> {
    private static final Drawable placeholder = new ColorDrawable(Color.LTGRAY);
    private final FeedRecyclerCellBinding viewBinding;

    public FeedItemHolder(FeedRecyclerCellBinding viewBinding) {
        super(viewBinding.getRoot());
        this.viewBinding = viewBinding;
    }

    public void bind(FeedListItem item) {
        String title = item.title != null ? item.title : "";
        String description = item.description != null ? item.description : "";
        viewBinding.part1CellTitle.setText(title);
        viewBinding.part1CellDescription.setText(description);
        Picasso.with(viewBinding.getRoot().getContext()).load(item.thumbnailUri)
                .placeholder(placeholder)
                .into(viewBinding.part1CellThumbnail);
    }
}
