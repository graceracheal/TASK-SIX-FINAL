package com.example.tasksix2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class TrackFitnessBottomSheet extends BottomSheetDialogFragment {

    public static TrackFitnessBottomSheet newInstance() {
        return new TrackFitnessBottomSheet();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.bottom_sheet_dashboard, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setupClickHandlers(view);
    }

    private void setupClickHandlers(@NonNull View view) {
        setupOption(view, R.id.option_log_food, "Log Food selected");
        setupOption(view, R.id.option_track_sleep, "Track Sleep selected");
        setupOption(view, R.id.option_track_weight, "Track Weight selected");
        setupOption(view, R.id.option_track_water, "Track Water Intake selected");
    }

    private void setupOption(View view, int optionId, String message) {
        LinearLayout option = view.findViewById(optionId);
        if (option != null) {
            option.setOnClickListener(v -> {
                Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show();
                dismiss();
            });
        }
    }

    @Override
    public int getTheme() {
        return R.style.BottomSheetDialogTheme;
    }
}