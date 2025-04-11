package com.gym.gymtracker.controller;

import com.gym.gymtracker.model.Exercise;
import com.gym.gymtracker.service.WorkoutService;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/workouts")
public class WorkoutController {

    @Autowired
    private WorkoutService workoutService;

    // Get method for retrieving the weekly workout plan
    @GetMapping("/generate-weekly-plan")
    public ResponseEntity<?> generateWeeklyPlan() {
        try {
            // Call the service to generate the weekly plan and retrieve it
            Map<String, Map<String, List<Exercise>>> weeklyPlan = workoutService.generateWeeklyWorkoutPlan();
            return ResponseEntity.ok(weeklyPlan);  // Return the generated weekly plan
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error generating weekly plan: " + e.getMessage());
        }
    }

    @GetMapping("/generate-pull-day")
    public ResponseEntity<?> generatePullDay(){
        try{
             Map<String, List<Exercise>> pullPlan = workoutService.generatePullDay();
             return ResponseEntity.ok(pullPlan);
            } catch (Exception e) {
                e.printStackTrace();
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error generating plan: " + e.getMessage());
            }
    }

    @GetMapping("/generate-push-day")
    public ResponseEntity<?> generatePushDay(){
        try{
             Map<String, List<Exercise>> pushPlan = workoutService.generatePushDay();
             return ResponseEntity.ok(pushPlan);
            } catch (Exception e) {
                e.printStackTrace();
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error generating plan: " + e.getMessage());
            }
    }

    @GetMapping("/generate-leg-day")
    public ResponseEntity<?> generateLegDay(){
        try{
             Map<String, List<Exercise>> legPlan = workoutService.generateLegDay();
             return ResponseEntity.ok(legPlan);
            } catch (Exception e) {
                e.printStackTrace();
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error generating plan: " + e.getMessage());
            }
    }

    @GetMapping("/generate-arm-day")
    public ResponseEntity<?> generateArmDay(){
        try{
             Map<String, List<Exercise>> armPlan = workoutService.generateArmDay();
             return ResponseEntity.ok(armPlan);
            } catch (Exception e) {
                e.printStackTrace();
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error generating plan: " + e.getMessage());
            }
    }

}
