package day1.robot;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Robot robot= new Robot("Zygmunt");
        Scanner scanner = new Scanner(System.in);

        String command;
        do{
            System.out.println("Get command:");
            System.out.println(" - movement [LEFT_ TEP, RIGHT_STEP, LEFT_READ_MOVE, RIGHT_READ_MOVE, JUMP]");
            System.out.println("charge");
            System.out.println("turnOn");
            System.out.println("turnOff");
            command = scanner.nextLine();
            if(command.equalsIgnoreCase("turnOn")) {
                robot.turnOn();
            } else if (command.equalsIgnoreCase("turnOff")){
                robot.turnOff();}
            else if (command.equalsIgnoreCase( "charge Robot")){
                robot.chargeRobot();
                }else if (command.startsWith("movement")) {
                String[] word = command.split(" "); //dzielę komendę na słowa
                String typeOfMovement = word[1];//wyciągam słowo w którym znajduje się rodzaj ruchu
                //string -> enum odpowiedniego typu
                RobotMovement movement = RobotMovement.valueOf(typeOfMovement.toUpperCase()); //konwersja, nieważne jaka wielkość lkiter wpisana
                robot.moveTheRobot(movement); //wykonanie ruchu
            }  else if (!command.equalsIgnoreCase("quit")){
                    System.err.print("nie rozpoznaję komendy");
                }
            }while (!command.equalsIgnoreCase("quit"));
        }
    }

