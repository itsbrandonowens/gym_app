package com.gym.gymtracker.repository;

import com.gym.gymtracker.model.Exercise;
import com.gym.gymtracker.model.MuscleGroup;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExerciseRepository extends JpaRepository<Exercise, Long> {

    List<Exercise> findAll();
    
    Exercise findExerciseById(Long Id);

    List<Exercise> findByMuscleGroup(MuscleGroup muscleGroup);

    List<Exercise> findByPrimaryGroup(String primaryGroup);
}
