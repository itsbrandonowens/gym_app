import React, { useEffect, useState } from 'react';
import '../styles/ExercisesByMuscleGroup.css';

const ExercisesByMuscleGroup = () => {
    const [exercises, setExercises] = useState({});

    useEffect(() => {
        // Fetch exercises from the backend or an API using fetch
        fetch('http://localhost:8080/exercises')
            .then(response => response.json())
            .then(data => {
                const groupedExercises = groupExercisesByMuscleGroup(data);
                setExercises(groupedExercises);
            })
            .catch(error => {
                console.error("There was an error fetching the exercises!", error);
            });
    }, []);

    // Helper function to group exercises by muscle group
    const groupExercisesByMuscleGroup = (exercises) => {
        return exercises.reduce((grouped, exercise) => {
            const { muscleGroup } = exercise;
            if (!grouped[muscleGroup]) {
                grouped[muscleGroup] = [];
            }
            grouped[muscleGroup].push(exercise);
            return grouped;
        }, {});
    };

    return (
        <div>
            <a href= "/"> <button className='home_button' >🏠</button></a>
            <h1 className='muscle-group-title-main'> All Exercises By Muscle Group </h1>
            <div className="exercises-container">
                {Object.entries(exercises).map(([muscleGroup, exercisesList]) => (
                    <div className="muscle-group-container" key={muscleGroup}>
                        <h2 className="muscle-group-title">{muscleGroup}</h2>
                        <ul className="exercise-list">
                            {exercisesList.map((exercise) => (
                                <li key={exercise.id} className="exercise-item">
                                    <span className="exercise-name">{exercise.name}</span>
                                    <span className="exercise-weight">{exercise.defaultWeight}kg</span>
                                </li>
                            ))}
                        </ul>
                    </div>
                ))}
            </div>
        </div>
    );
};

export default ExercisesByMuscleGroup;
