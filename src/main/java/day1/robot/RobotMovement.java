package day1.robot;

public enum RobotMovement {
    LEFT_STEP (07),
    RIGHT_STEP (07),
    LEFT_READ_MOVE(15),
    RIGHT_READ_MOVE (15),
    JUMP (20);
    private double energyConsumption;

    RobotMovement (double energyConsumption){
        this.energyConsumption = energyConsumption;
    }

    public double getEnergyConsumption() {
        return energyConsumption;
    }
}
