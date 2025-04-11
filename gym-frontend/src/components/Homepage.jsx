import { Link } from 'react-router-dom';
import '../styles/Homepage.css';
import generate_workout from "./images/generate-workout.png";
import view_exercises from "./images/view-exercises.png";
import view_progress from "./images/view-progress.png";
const Homepage = () => {
  

    return (
        <div>
           <h1 className='homepage_title'> Brandon Atkinson's Gym App </h1>
           <div className='homepage_image_container'>
           <Link to="/workout_generator" > <img className="homepage_image" src={generate_workout} alt="generate-workout"/> </Link>
           <Link to="/view_exercises" > <img className="homepage_image" src={view_exercises} alt="view-exercises"/> </Link>
           <img className="homepage_image" src={view_progress} alt="view-progress"/>
           </div>
        </div>
    );
};

export default Homepage;
