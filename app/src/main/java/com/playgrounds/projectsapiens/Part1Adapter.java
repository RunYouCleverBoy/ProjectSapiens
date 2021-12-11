package com.playgrounds.projectsapiens;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.playgrounds.projectsapiens.listholders.ListItemHolder;
import com.playgrounds.projectsapiens.listitems.ListItem;

public class Part1Adapter extends RecyclerView.Adapter<ListItemHolder<ListItem>> {
    private ListItem[] data = new ListItem[]{};

    @SuppressLint("NotifyDataSetChanged")
    public <T extends ListItem> void setData(T[] data) {
        this.data = data;
        notifyDataSetChanged();
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @NonNull
    @Override
    public ListItemHolder<ListItem> onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = ((Activity) parent.getContext()).getLayoutInflater();
        return HolderFactory.create(viewType, inflater, parent);
    }

    @Override
    public void onBindViewHolder(@NonNull ListItemHolder<ListItem> holder, int position) {
        holder.bind(data[position]);
    }


    @Override
    public int getItemCount() {
        return data.length;
    }
}
