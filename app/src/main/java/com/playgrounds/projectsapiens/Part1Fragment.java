package com.playgrounds.projectsapiens;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.playgrounds.projectsapiens.databinding.RecyclerLayoutBinding;

public class Part1Fragment extends Fragment {
    private RecyclerLayoutBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = RecyclerLayoutBinding.inflate(getLayoutInflater(), container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        Context context = requireContext();
        Part1ViewModel viewModel = new ViewModelProvider(this,
                new ViewModelProvider.AndroidViewModelFactory(requireActivity().getApplication())).get(Part1ViewModel.class);
        RecyclerView recycler = binding.part1Recycler;
        LinearLayoutManager layoutManager = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
        Part1Adapter adapter = new Part1Adapter();
        recycler.setLayoutManager(layoutManager);
        recycler.setAdapter(adapter);

        viewModel.getDataLiveData().observe(getViewLifecycleOwner(), adapter::setData);
        viewModel.FetchData();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
