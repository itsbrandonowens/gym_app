package com.gym.gymtracker.model;


public enum MuscleGroup {

    BICEPS(PrimaryGroup.PULL),
    BRACHIORADIALIS(PrimaryGroup.PULL),
    LATS(PrimaryGroup.PULL),
    RHOMBOIDS(PrimaryGroup.PULL),
    REARDELTS(PrimaryGroup.PULL),
    FOREARMS(PrimaryGroup.PULL),
    CHEST(PrimaryGroup.PUSH),
    TRICEPSLONG(PrimaryGroup.PUSH),
    TRICEPSLATERAL(PrimaryGroup.PUSH),
    FRONTDELTS(PrimaryGroup.PUSH),
    SIDEDELTS(PrimaryGroup.PUSH),
    TRAPS(PrimaryGroup.PUSH),
    HAMSTRINGS(PrimaryGroup.LEGS),
    QUADS(PrimaryGroup.LEGS),
    GLUTES(PrimaryGroup.LEGS),
    CALVES(PrimaryGroup.LEGS),

    ;

    

    private final PrimaryGroup primaryGroup;

    MuscleGroup(PrimaryGroup primaryGroup) {
        this.primaryGroup = primaryGroup;
    }

    public PrimaryGroup getPrimaryGroup() {
        return primaryGroup;
    }
}

