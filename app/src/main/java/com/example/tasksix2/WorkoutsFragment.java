package com.example.tasksix2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class WorkoutsFragment extends Fragment {

    private RecyclerView workoutRecyclerView;
    private List<Workout> workouts;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View fragmentView = inflater.inflate(R.layout.fragment_workouts, container, false);

        workoutRecyclerView = fragmentView.findViewById(R.id.recycler_workouts);
        workoutRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        createWorkoutList();

        WorkoutAdapter workoutAdapter = new WorkoutAdapter(workouts);
        workoutRecyclerView.setAdapter(workoutAdapter);

        return fragmentView;
    }

    private void createWorkoutList() {
        workouts = new ArrayList<>();
        workouts.add(new Workout("Full Body HIIT", "High-intensity interval training for total body fitness", "30 min", "Intermediate"));
        workouts.add(new Workout("Upper Body Strength", "Focus on chest, shoulders, and arms", "45 min", "Advanced"));
        workouts.add(new Workout("Core Crusher", "Strengthen your abdominal and lower back muscles", "20 min", "Beginner"));
        workouts.add(new Workout("Leg Day Essentials", "Build stronger lower body muscles", "40 min", "Intermediate"));
        workouts.add(new Workout("Cardio Blast", "Increase your heart rate and burn calories", "25 min", "Beginner"));
        workouts.add(new Workout("Yoga Flow", "Improve flexibility and reduce stress", "35 min", "All Levels"));
        workouts.add(new Workout("Back & Biceps", "Strengthen your back and bicep muscles", "40 min", "Intermediate"));
        workouts.add(new Workout("Chest & Triceps", "Build upper body strength focus", "35 min", "Advanced"));
    }

    private static class Workout {
        private final String title;
        private final String description;
        private final String duration;
        private final String level;

        public Workout(String title, String description, String duration, String level) {
            this.title = title;
            this.description = description;
            this.duration = duration;
            this.level = level;
        }

        public String getTitle() { return title; }
        public String getDescription() { return description; }
        public String getDuration() { return duration; }
        public String getLevel() { return level; }
    }

    private static class WorkoutAdapter extends RecyclerView.Adapter<WorkoutAdapter.WorkoutViewHolder> {
        private final List<Workout> workoutList;

        public WorkoutAdapter(List<Workout> workoutList) {
            this.workoutList = workoutList;
        }

        @NonNull
        @Override
        public WorkoutViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_workout, parent, false);
            return new WorkoutViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(@NonNull WorkoutViewHolder holder, int position) {
            Workout currentWorkout = workoutList.get(position);

            holder.titleText.setText(currentWorkout.getTitle());
            holder.descriptionText.setText(currentWorkout.getDescription());
            holder.durationText.setText(currentWorkout.getDuration());
            holder.levelText.setText(currentWorkout.getLevel());

            holder.startWorkoutButton.setOnClickListener(v -> {
                Toast.makeText(v.getContext(), "Starting " + currentWorkout.getTitle() + " workout", Toast.LENGTH_SHORT).show();
            });
        }

        @Override
        public int getItemCount() {
            return workoutList.size();
        }

        static class WorkoutViewHolder extends RecyclerView.ViewHolder {
            ImageView workoutImage;
            TextView titleText, descriptionText, durationText, levelText;
            ImageButton startWorkoutButton;

            public WorkoutViewHolder(@NonNull View itemView) {
                super(itemView);
                workoutImage = itemView.findViewById(R.id.workout_image);
                titleText = itemView.findViewById(R.id.workout_title);
                descriptionText = itemView.findViewById(R.id.workout_description);
                durationText = itemView.findViewById(R.id.workout_duration);
                levelText = itemView.findViewById(R.id.workout_level);
                startWorkoutButton = itemView.findViewById(R.id.btn_start_workout);
            }
        }
    }
}