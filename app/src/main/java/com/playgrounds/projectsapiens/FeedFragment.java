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
import com.playgrounds.projectsapiens.model.PositionResolver;
import com.playgrounds.projectsapiens.model.PositionResolverImpl;

public class FeedFragment extends Fragment {
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
        FragmentViewModel viewModel = new ViewModelProvider(this,
                new ViewModelProvider.AndroidViewModelFactory(requireActivity().getApplication())).get(FragmentViewModel.class);
        RecyclerView recycler = binding.feedRecycler;
        LinearLayoutManager layoutManager = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
        PositionResolver resolver = new PositionResolverImpl();
        FeedAdapter adapter = new FeedAdapter(resolver);
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
