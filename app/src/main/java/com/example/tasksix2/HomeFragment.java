package com.example.tasksix2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

public class HomeFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        setupButtons(view);
        setupCardListeners(view);

        return view;
    }

    private void setupButtons(View view) {
        Button btnOpenBottomSheet = view.findViewById(R.id.btn_open_bottom_sheet);

        btnOpenBottomSheet.setOnClickListener(v -> {
            TrackFitnessBottomSheet bottomSheet = TrackFitnessBottomSheet.newInstance();
            bottomSheet.show(getParentFragmentManager(), "TrackFitnessBottomSheet");
        });
    }
    private void setupCardListeners(View view) {
        setCardClickListener(view, R.id.card_start_workout, "Starting new workout...");
        setCardClickListener(view, R.id.card_track_sleep, "Track sleep...");
        setCardClickListener(view, R.id.card_log_water, "Log water intake...");
        setCardClickListener(view, R.id.card_nutrition, "Track nutrition...");
        setCardClickListener(view, R.id.card_heart_rate, "Heart rate monitoring...");
    }

    private void setCardClickListener(View view, int cardId, String message) {
        CardView cardView = view.findViewById(cardId);
        cardView.setOnClickListener(v -> showToast(message));
    }
    private void showToast(String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
    }
}
