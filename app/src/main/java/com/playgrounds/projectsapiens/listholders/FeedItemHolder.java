package com.playgrounds.projectsapiens.listholders;

import android.view.View;

import com.playgrounds.projectsapiens.databinding.FeedRecyclerCellBinding;
import com.playgrounds.projectsapiens.listitems.FeedListItem;
import com.squareup.picasso.Picasso;

public final class FeedItemHolder extends ListItemHolder<FeedListItem> {
    private final FeedRecyclerCellBinding viewBinding;

    public FeedItemHolder(FeedRecyclerCellBinding viewBinding) {
        super(viewBinding.getRoot());
        this.viewBinding = viewBinding;
    }

    @Override
    public void bind(FeedListItem item) {
        String title = item != null && item.title != null ? item.title : "";
        String description = item != null && item.description != null ? item.description : "";
        viewBinding.feedCellTitle.setText(title);
        viewBinding.feedCellDescription.setText(description);
        if (item != null) {
            viewBinding.feedCellThumbnail.setVisibility(View.VISIBLE);
            Picasso.with(viewBinding.getRoot().getContext()).load(item.thumbnailUri)
                    .into(viewBinding.feedCellThumbnail);
        } else {
            viewBinding.feedCellThumbnail.setVisibility(View.GONE);
        }
    }
}
