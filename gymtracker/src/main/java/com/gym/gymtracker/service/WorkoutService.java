package com.gym.gymtracker.service;

import com.gym.gymtracker.model.Exercise;
import com.gym.gymtracker.model.MuscleGroup;
import com.gym.gymtracker.repository.ExerciseRepository;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.LinkedHashMap;

@Service
public class WorkoutService {

    private final ExerciseRepository exerciseRepository;

    public WorkoutService(ExerciseRepository exerciseRepository) {
        this.exerciseRepository = exerciseRepository;
    }

    // Helper method to generate random exercises for a specific muscle group
    private List<Exercise> generateRandomExercisesForMuscleGroup(MuscleGroup muscleGroup, int count) {
        List<Exercise> exercises = exerciseRepository.findByMuscleGroup(muscleGroup);

        if (exercises.size() < count) {
            throw new IllegalArgumentException("Not enough exercises available for " + muscleGroup);
        }

        // Shuffle and pick random exercises
        Collections.shuffle(exercises);
        return exercises.subList(0, count);
    }

    // Generate Pull Day
    public Map<String, List<Exercise>> generatePullDay() {
        Map<String, List<Exercise>> pullDay = new LinkedHashMap<>();
        pullDay.put("Lat", generateRandomExercisesForMuscleGroup(MuscleGroup.LATS, 1));
        pullDay.put("Rhomboid", generateRandomExercisesForMuscleGroup(MuscleGroup.RHOMBOIDS, 1));
        pullDay.put("Rear Delt", generateRandomExercisesForMuscleGroup(MuscleGroup.REARDELTS, 1));
        pullDay.put("Bicep", generateRandomExercisesForMuscleGroup(MuscleGroup.BICEPS, 1));
        pullDay.put("Brachioradialis", generateRandomExercisesForMuscleGroup(MuscleGroup.BRACHIORADIALIS, 1));
        pullDay.put("Forearm", generateRandomExercisesForMuscleGroup(MuscleGroup.FOREARMS, 1));
        return pullDay;
    }

    // Generate Push Day
    public Map<String, List<Exercise>> generatePushDay() {
        Map<String, List<Exercise>> pushDay = new LinkedHashMap<>();
        pushDay.put("Chest", generateRandomExercisesForMuscleGroup(MuscleGroup.CHEST, 2)); // 2 exercises for chest
        pushDay.put("Front Delt", generateRandomExercisesForMuscleGroup(MuscleGroup.FRONTDELTS, 1));
        pushDay.put("Side Delt", generateRandomExercisesForMuscleGroup(MuscleGroup.SIDEDELTS, 1));
        pushDay.put("Traps", generateRandomExercisesForMuscleGroup(MuscleGroup.TRAPS, 1));
        pushDay.put("Triceps Lateral", generateRandomExercisesForMuscleGroup(MuscleGroup.TRICEPSLATERAL, 1));
        pushDay.put("Triceps Long", generateRandomExercisesForMuscleGroup(MuscleGroup.TRICEPSLONG, 1));
        return pushDay;
    }

    // Generate Leg Day
    public Map<String, List<Exercise>> generateLegDay() {
        Map<String, List<Exercise>> legDay = new LinkedHashMap<>();
        legDay.put("Quads", generateRandomExercisesForMuscleGroup(MuscleGroup.QUADS, 2));
        legDay.put("Hamstring", generateRandomExercisesForMuscleGroup(MuscleGroup.HAMSTRINGS, 1));
        legDay.put("Glutes", generateRandomExercisesForMuscleGroup(MuscleGroup.GLUTES, 1));
       
        return legDay;
    }

    //Generate Arm Day
    public Map<String, List<Exercise>> generateArmDay(){
        Map<String, List<Exercise>> armDay = new LinkedHashMap<>();
        armDay.put("Bicep", generateRandomExercisesForMuscleGroup(MuscleGroup.BICEPS, 1));
        armDay.put("Brachioradialis", generateRandomExercisesForMuscleGroup(MuscleGroup.BRACHIORADIALIS, 1));
        armDay.put("Tricep Lateral", generateRandomExercisesForMuscleGroup(MuscleGroup.TRICEPSLATERAL, 1));
        armDay.put("Tricep Long", generateRandomExercisesForMuscleGroup(MuscleGroup.TRICEPSLONG, 1));
        armDay.put("Forearm", generateRandomExercisesForMuscleGroup(MuscleGroup.FOREARMS, 2));
        return armDay;
    }

    // Generate a full weekly workout plan
    public Map<String, Map<String, List<Exercise>>> generateWeeklyWorkoutPlan() {
        Map<String, Map<String, List<Exercise>>> weeklyPlan = new LinkedHashMap<>();
        weeklyPlan.put("Pull Day", generatePullDay());
        weeklyPlan.put("Push Day", generatePushDay());
        weeklyPlan.put("Leg Day", generateLegDay());
        return weeklyPlan;
    }

    public Exercise updateExerciseWeight(Long exerciseId, double newWeight){
        Exercise exercise = exerciseRepository.findById(exerciseId).orElseThrow(()-> new IllegalArgumentException("Exercise not found with ID: " + exerciseId));
        exercise.setDefaultWeight(newWeight);
        return exerciseRepository.save(exercise); 
    }
}
