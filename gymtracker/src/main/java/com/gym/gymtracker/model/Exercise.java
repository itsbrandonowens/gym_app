package com.gym.gymtracker.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor  // Add this annotation for a default constructor
@Builder
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Exercise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private PrimaryGroup primaryGroup;

    @Enumerated(EnumType.STRING)
    private MuscleGroup muscleGroup;

    private double defaultWeight;

    public PrimaryGroup getPrimaryGroup() {
        return muscleGroup.getPrimaryGroup();
    }

    @Override
    public String toString() {
        return "Exercise{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", muscleGroup='" + muscleGroup + '\'' +
                ", primaryGroup='" + primaryGroup + '\'' +
                ", defaultWeight=" + defaultWeight + " kg" +
                '}';
    }
}
