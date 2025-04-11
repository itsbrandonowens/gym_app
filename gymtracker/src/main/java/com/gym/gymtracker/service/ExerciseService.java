package com.gym.gymtracker.service;

import com.gym.gymtracker.model.Exercise;
import com.gym.gymtracker.model.MuscleGroup;
import com.gym.gymtracker.repository.ExerciseRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ExerciseService {

    private final ExerciseRepository exerciseRepository;


    public ExerciseService(ExerciseRepository exerciseRepository) {
        this.exerciseRepository = exerciseRepository;
    }

    public List<Exercise> getAllExercises() {
        return exerciseRepository.findAll();
    }

    public Exercise getExerciseById(Long id) {
        return exerciseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Exercise not found with id: " + id)); 
    }
    

    public List<Exercise> getExercisesByMuscleGroup(MuscleGroup muscleGroup){
        return exerciseRepository.findByMuscleGroup(muscleGroup);
    }

    public List<Exercise> getExercisesByPrimaryGroup(String primaryGroup) {
        return exerciseRepository.findByPrimaryGroup(primaryGroup);
    }

}
