import { Route, Routes } from 'react-router-dom';
import WorkoutGenerator from './components/WorkoutGenerator';
import ExercisesByMuscleGroup from './components/ExercisesByMuscleGroup';
import Homepage from './components/Homepage';
import './App.css'; 
function App() {
  return (
    <div>
      <Routes>
        <Route path='/' element={<Homepage />} />
        <Route path='/workout_generator' element={<WorkoutGenerator />} />
        <Route path='/view_exercises' element={<ExercisesByMuscleGroup />} />
      </Routes>
    </div>
  );
}


export default App;
