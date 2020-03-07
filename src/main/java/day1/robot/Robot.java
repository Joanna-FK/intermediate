package day1.robot;

import lombok.*;

import javax.sound.midi.Soundbank;

@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class Robot {
    private int batteryLevel = 100;
    private String robotName;
    private boolean isActivated = false;

    public Robot(String robotName) {
        this.robotName = robotName;
    }

    public void moveTheRobot(RobotMovement robotMovement) {
        if ( !isActivated) {
            System.err.println("Robot jest wyłączony");
            return;
        }
        if (batteryLevel>= robotMovement.getEnergyConsumption()){
            System.out.println("wykonuję ruch robota: "+ robotMovement);
            batteryLevel-=robotMovement.getEnergyConsumption();
        }else {
            System.err.println("Niewtystarczająca ilość energii");
        }
    }

        public void chargeRobot (){
            if (isActivated) {
                System.err.println("Nie można ładować robota");
            } else {
                batteryLevel = 100;
                System.out.println("Robot naładowany");
            }
        }

        public void turnOn (){
        if (isActivated){
            System.err.println("Robot jest już włączony");
        }else {
            isActivated=true;
            System.out.println("Robot naładowany");
        }
        }

        public void turnOff(){
        if (!isActivated){
            System.err.println("Robot jest już wyłączony");
        }else {
            isActivated=false;
            System.out.println("Robot naładowany");
        }
        }

    }

