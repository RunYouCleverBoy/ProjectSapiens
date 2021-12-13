package com.playgrounds.projectsapiens;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
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
import com.playgrounds.projectsapiens.model.listitems.ListItem;

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

        adapter.setOnItemClickListener(this::sendMail);

        viewModel.getDataLiveData().observe(getViewLifecycleOwner(), newDataResponse -> {
            if (newDataResponse instanceof FragmentViewModel.NewDataResponse.SuccessResponse) {
                ListItem[] data = ((FragmentViewModel.NewDataResponse.SuccessResponse) newDataResponse).items;
                adapter.setData(data);
            } else if (newDataResponse instanceof FragmentViewModel.NewDataResponse.FailureResponse) {
                showError(((FragmentViewModel.NewDataResponse.FailureResponse) newDataResponse).reason);
            }
        });
        viewModel.FetchData();
    }

    private void sendMail(String subject, String message, String thumbnailUri) {
        Intent intent = new Intent(Intent.ACTION_SEND)
                .setType("text/html")
                .putExtra(Intent.EXTRA_SUBJECT, subject)
                .putExtra(Intent.EXTRA_TEXT, thumbnailUri + "\n" + message);
        startActivity(Intent.createChooser(intent, getString(R.string.chooser_text)));
    }

    private void showError(String reason) {
        new AlertDialog.Builder(requireActivity())
                .setTitle(R.string.error)
                .setMessage(reason)
                .setPositiveButton(android.R.string.ok, (dialogInterface, i) -> dialogInterface.dismiss())
                .show();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
