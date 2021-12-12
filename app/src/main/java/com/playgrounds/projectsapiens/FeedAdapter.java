package com.playgrounds.projectsapiens;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.playgrounds.projectsapiens.listholders.ListItemHolder;
import com.playgrounds.projectsapiens.listitems.ListItem;
import com.playgrounds.projectsapiens.listitems.ListItemKind;

public class FeedAdapter extends RecyclerView.Adapter<ListItemHolder<? extends ListItem>> {
    private ListItem[] data = new ListItem[]{};
    private final PositionResolver resolver;

    public FeedAdapter(PositionResolver resolver) {
        this.resolver = resolver;
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
    }

    @Override
    public int getItemCount() {
        return data.length;
    }
}
