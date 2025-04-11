import React, { useState } from 'react';
import '../styles/WorkoutGenerator.css';
const WorkoutGenerator = () => {
  const [workout, setWorkout] = useState(null);
  const [loading, setLoading] = useState(false);

  const generateWorkout = async () => {
    setLoading(true);
    try {
      const response = await fetch('http://localhost:8080/workouts/generate-weekly-plan');
      if (!response.ok) {
        throw new Error('Network response was not ok');
      }
      const data = await response.json();
      setWorkout(data);
    } catch (error) {
      console.error('Error fetching workout:', error);
    } finally {
      setLoading(false);
    }
  };

  return (
    <div className='workout_generator_container'>
      <h1 className='workout_title'>Workout Generator</h1>
      <button className= "generate_ppl_workout" onClick={generateWorkout} disabled={loading}>
        {loading ? 'Generating...' : 'Generate PPL'}
      </button>

      {workout && (
        <div className='generated_workout_container'>
          {Object.entries(workout).map(([day, muscles]) => (
            <div className='day_container' key={day}>
              <h2 className='day_text'>{day}</h2>
              {Object.entries(muscles).map(([muscle, exercises]) => (
                
                  <ul className='exercise_list'>
                    {exercises.map((exercise) => (
                      <li className='exercist_list_item' key={exercise.id}>
                        <span className='exercise_name'>{exercise.name}</span> - <span className='exercise_weight'> {exercise.defaultWeight}kg </span>
                      </li>
                    ))}
                  </ul>
                
              ))}
            </div>
          ))}
        </div>
      )}
    </div>
  );
};

export default WorkoutGenerator;
