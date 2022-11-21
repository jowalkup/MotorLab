package com.stuypulse.robot.commands;

import com.stuypulse.robot.util.Motor;

public class DriveFunctions {
    
    public static void driveForwards(Motor left, Motor right) {
        left.set(1.0);
        right.set(1.0);
    }

    public static void driveBackwards(Motor left, Motor right) {
        left.set(-1.0);
        right.set(-1.0);
    }

    public static void turnRight(Motor left, Motor right) {
        left.set(1.0);
        right.set(-1.0);
    }

    public static void turnLeft(Motor left, Motor right) {
        left.set(-1.0);
        right.set(1.0);
    }

    public static void arcRight(Motor left, Motor right) {
        left.set(1.0);
        right.set(0.5);
    }

    public static void arcLeft(Motor left, Motor right) {
        left.set(0.5);
        right.set(1.0);
    }

    public static void stopDistance(Motor left, Motor right) {
        left.set(1.0);
        right.set(1.0);
        if((left.getDistance() > 23.0 && left.getDistance() < 25.0) || (right.getDistance() > 23.0 && right.getDistance() < 25.0)){
            left.set(0.0);
            right.set(0.0);
        }
        // or >= 24
    }

    public static void bangBang(Motor left, Motor right) {
        if(left.getDistance() > 24.0 || right.getDistance() > 24.0){
            left.set(-1.0);
            right.set(-1.0);
        }
        else if(left.getDistance() < 24.0 || right.getDistance() < 24.0){
            left.set(1.0);
            right.set(1.0);
        }
        
    }

    public static void lessBang(Motor left, Motor right) {
        if(left.getDistance() > 24.0 || right.getDistance() > 24.0){
            left.set(-0.25);
            right.set(-0.25);
        }
        else if(left.getDistance() < 24.0 || right.getDistance() < 24.0){
            left.set(0.25);
            right.set(0.25);
        }
        
    }

    // public static void betterControl(Motor left, Motor right) {
    //     if((left.getDistance() >= 25.0 && left.getDistance() <= 30.0) || (right.getDistance() >= 25.0 && right.getDistance() <= 30.0)){
    //         left.set(-0.25);
    //         right.set(-0.25);
    //     }
    //     if((left.getDistance() > 30.0 && left.getDistance() <= 36.0) || (right.getDistance() > 30.0 && right.getDistance() <= 36.0)){
    //         left.set(-0.5);
    //         right.set(-0.5);
    //     }
    //     if((left.getDistance() <= 23.0 && left.getDistance() >= 18.0) || (right.getDistance() >= 18.0 && right.getDistance() <= 23.0)){
    //         left.set(0.25);
    //         right.set(0.25);
    //     }
    //     if((left.getDistance() >= 12.0 && left.getDistance() < 18.0) || (right.getDistance() >= 12.0 && right.getDistance() < 18.0)){
    //         left.set(0.5);
    //         right.set(0.5);
    //     }
    // }

    // or, using the kP(r-x) thing (?)

    public static void betterControl(Motor left, Motor right) {
        // left.set((24.0 - left.getDistance()) / 24.0);
        // right.set((24.0 - right.getDistance()) / 24.0);
        double kP = 1.0 / 120.0; // any number < 1 but for this 1/target distance
        double error = 120 - left.getDistance;
        left.set(kP * error);
        right.set(kP * error);
    }

}
