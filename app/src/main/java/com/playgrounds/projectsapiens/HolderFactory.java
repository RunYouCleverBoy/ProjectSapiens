package com.playgrounds.projectsapiens;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import com.playgrounds.projectsapiens.listholders.ListItemHolder;
import com.playgrounds.projectsapiens.listitems.ListItem;

public class HolderFactory {
    @NonNull
    public static <T extends ListItem> ListItemHolder<T> create(int viewType, LayoutInflater inflater, ViewGroup parent) {
        throw new RuntimeException("TODO");
    }
}
