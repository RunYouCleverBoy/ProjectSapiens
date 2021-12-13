package com.playgrounds.projectsapiens.listholders;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.playgrounds.projectsapiens.model.listitems.ListItem;

public abstract class ListItemHolder<T extends ListItem> extends RecyclerView.ViewHolder {
    public ListItemHolder(@NonNull View itemView) {
        super(itemView);
    }

    public abstract void bind(T data);
}
