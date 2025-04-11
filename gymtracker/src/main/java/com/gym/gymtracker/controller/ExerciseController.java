package com.gym.gymtracker.controller;

import com.gym.gymtracker.model.Exercise;
import com.gym.gymtracker.model.MuscleGroup;
import com.gym.gymtracker.service.ExerciseService;

import org.springframework.web.bind.annotation.*;


import java.util.List;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class ExerciseController {

    private final ExerciseService exerciseService;

    public ExerciseController(ExerciseService exerciseService) {
        this.exerciseService = exerciseService;
    }

    @GetMapping("/exercises")
    public List<Exercise> getAllExercises() {
        return exerciseService.getAllExercises();
    }

    @GetMapping("/exercises/{id}")
    public Exercise getExerciseById(@PathVariable Long id) {
        return exerciseService.getExerciseById(id);
    }

    @GetMapping("/exercises/muscleGroup/{muscleGroup}")
    public List<Exercise> getExercisesByMuscleGroup(@PathVariable MuscleGroup muscleGroup) {
        return exerciseService.getExercisesByMuscleGroup(muscleGroup);
    }

    @GetMapping("/exercises/primaryGroup/{primaryGroup}")
    public List<Exercise> getExercisesByPrimaryGroup(@PathVariable String primaryGroup) {
        return exerciseService.getExercisesByPrimaryGroup(primaryGroup);
    }
}
