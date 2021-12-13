package com.playgrounds.projectsapiens;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.playgrounds.projectsapiens.listholders.HolderFactory;
import com.playgrounds.projectsapiens.listholders.ListItemHolder;
import com.playgrounds.projectsapiens.model.PositionResolver;
import com.playgrounds.projectsapiens.model.listitems.FeedListItem;
import com.playgrounds.projectsapiens.model.listitems.ListItem;
import com.playgrounds.projectsapiens.model.listitems.ListItemKind;

public class FeedAdapter extends RecyclerView.Adapter<ListItemHolder<? extends ListItem>> {
    private ListItem[] data = new ListItem[]{};
    private final PositionResolver resolver;
    private OnItemClickListener onItemClickListener = (title, text, thumbnailUri) -> {
    };

    public FeedAdapter(PositionResolver resolver) {
        this.resolver = resolver;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @SuppressLint("NotifyDataSetChanged")
    public <T extends ListItem> void setData(T[] data) {
        this.data = data;
        notifyDataSetChanged();
    }

    @Override
    public int getItemViewType(int position) {
        return resolver.get(position);
    }

    @NonNull
    @Override
    public ListItemHolder<? extends ListItem> onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = ((Activity) parent.getContext()).getLayoutInflater();
        return HolderFactory.create(ListItemKind.valueOf(viewType), inflater, parent);
    }

    @Override
    public void onBindViewHolder(@NonNull ListItemHolder holder, int position) {
        //noinspection unchecked
        holder.bind(data[position]);
        ListItem datum = data[position];
        if (datum instanceof FeedListItem) {
            FeedListItem feedListItem = ((FeedListItem) datum);
            holder.itemView.setOnClickListener(ignored ->
                    onItemClickListener.onClick(
                            feedListItem.title,
                            feedListItem.description,
                            feedListItem.thumbnailUri));
        }
    }

    @Override
    public int getItemCount() {
        return data.length;
    }

    public interface OnItemClickListener {
        void onClick(String title, String text, String thumbnailUri);
    }
}
