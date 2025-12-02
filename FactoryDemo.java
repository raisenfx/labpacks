// Lab 8 icin

import java.util.Scanner;

class Robot {
    private String modelName;
    private int batteryLevel;
    private String status;


    public Robot(String modelName, int batteryLevel, String status) {
        this.modelName = modelName;
        this.batteryLevel = batteryLevel;
        this.status = status;
    }


    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public int getBatteryLevel() {
        return batteryLevel;
    }

    public void setBatteryLevel(int batteryLevel) {
        this.batteryLevel = batteryLevel;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    public void displayRobotInfo() {
        System.out.println("Robot Information:");
        System.out.println("  Model: " + modelName);
        System.out.println("  Battery Level: " + batteryLevel + "%");
        System.out.println("  Status: " + status);
        System.out.println();
    }


    public boolean isBatteryEnough(int requiredAmount) {
        return batteryLevel >= requiredAmount;
    }

    public void consumeBattery(int amount) {
        batteryLevel -= amount;
        if (batteryLevel < 0) {
            batteryLevel = 0;
        }
    }

    public void chargeBattery(int amount) {
        batteryLevel += amount;
        if (batteryLevel >= 100) {
            batteryLevel = 100;
            status = "Active";
        } else {
            status = "Charging";
        }
    }


    public void performTask(Task t) {
        System.out.println("\nRobot " + modelName + " attempting task: " + t.getTaskName());


        if ("Charging".equalsIgnoreCase(status)) {
            System.out.println("  Failed: Robot is currently charging!");
            return;
        }


        if (isBatteryEnough(t.getEnergyCost())) {
            consumeBattery(t.getEnergyCost());
            System.out.println("  Success: Task '" + t.getTaskName() + "' completed!");


            if (batteryLevel < 10) {
                status = "Low Battery";
            }
        } else {
            System.out.println("  Failed: Not enough battery for task!");
        }
    }


    public void performTaskBatch(TaskBatch batch) {
        System.out.println("\nRobot " + modelName + " attempting to process task batch...");


        Task[] tasks = batch.getTasks();
        if (tasks == null || tasks.length == 0) {
            return;
        }


        int totalEnergyCost = batch.getTotalEnergyCost();


        if (!isBatteryEnough(totalEnergyCost)) {
            System.out.println("  Failed: Not enough battery for the entire batch!");
            System.out.println("  Required: " + totalEnergyCost + "%, Available: " + batteryLevel + "%");
            return;
        }

        System.out.println("  Starting batch processing...");


        for (Task task : tasks) {
            performTask(task);
        }

        System.out.println("  Batch processing complete!");
    }
}


class Task {
    private String taskName;
    private int energyCost;


    public Task(String taskName, int energyCost) {
        this.taskName = taskName;
        this.energyCost = energyCost;
    }


    public String getTaskName() {
        return taskName;
    }

    public int getEnergyCost() {
        return energyCost;
    }


    public void describeTask() {
        System.out.println("Task: " + taskName + " | Energy Cost: " + energyCost + "%");
    }
}


class TaskBatch {
    private Task[] tasks;
    private int taskCount;


    public TaskBatch() {
        tasks = new Task[5];
        taskCount = 0;
    }


    public void addTask(Task t) {
        if (taskCount < 5) {
            tasks[taskCount] = t;
            taskCount++;
            System.out.println("Task '" + t.getTaskName() + "' added to batch.");
        } else {
            System.out.println("Error: Batch is full (max 5 tasks). Cannot add: " + t.getTaskName());
        }
    }


    public int getTotalEnergyCost() {
        if (taskCount == 0) {
            System.out.println("Error: Batch contains no tasks.");
            return 0;
        }

        int total = 0;
        for (int i = 0; i < taskCount; i++) {
            total += tasks[i].getEnergyCost();
        }
        return total;
    }


    public Task[] getTasks() {
        if (taskCount == 0) {
            System.out.println("Error: Batch contains no tasks.");
            return new Task[0];
        }


        Task[] result = new Task[taskCount];
        for (int i = 0; i < taskCount; i++) {
            result[i] = tasks[i];
        }
        return result;
    }


    public void printBatchInfo() {
        if (taskCount == 0) {
            System.out.println("Batch is empty.");
            return;
        }

        System.out.println("\n=== Task Batch Information ===");
        System.out.println("Number of tasks: " + taskCount);
        System.out.println("Tasks:");
        for (int i = 0; i < taskCount; i++) {
            System.out.print("  " + (i+1) + ". ");
            tasks[i].describeTask();
        }
        System.out.println("Total energy cost: " + getTotalEnergyCost() + "%");
        System.out.println("============================\n");
    }
}


public class FactoryDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== ROBOT FACTORY MANAGEMENT SYSTEM ===\n");


        Robot robot1 = new Robot("RX-100", 85, "Active");
        Robot robot2 = new Robot("T-800", 45, "Active");

        System.out.println("Initial Robot Information:");
        robot1.displayRobotInfo();
        robot2.displayRobotInfo();


        System.out.println("\n--- Testing Battery Operations ---");
        System.out.print("Enter battery amount to consume for Robot 1: ");
        int consumeAmount = scanner.nextInt();

        System.out.println("\nBefore consumption:");
        robot1.displayRobotInfo();

        if (robot1.isBatteryEnough(consumeAmount)) {
            robot1.consumeBattery(consumeAmount);
            System.out.println("Battery consumed successfully!");
        } else {
            System.out.println("Failed: Not enough battery!");
        }

        System.out.println("\nAfter consumption:");
        robot1.displayRobotInfo();


        System.out.println("Charging Robot 1 by 30%...");
        robot1.chargeBattery(30);
        robot1.displayRobotInfo();


        System.out.println("\n--- Creating Tasks ---");
        Task task1 = new Task("Welding", 25);
        Task task2 = new Task("Assembly", 15);
        Task task3 = new Task("Painting", 10);
        Task task4 = new Task("Quality Check", 5);
        Task task5 = new Task("Packaging", 8);

        System.out.println("Created tasks:");
        task1.describeTask();
        task2.describeTask();
        task3.describeTask();
        task4.describeTask();
        task5.describeTask();


        System.out.println("\n--- Testing Task Processing ---");
        System.out.println("Robot 2 before task:");
        robot2.displayRobotInfo();

        robot2.performTask(task1);

        System.out.println("\nRobot 2 after task:");
        robot2.displayRobotInfo();


        System.out.println("\nTesting with low battery...");
        robot2.performTask(task1);
        robot2.displayRobotInfo();


        System.out.println("\n--- Testing Task Batch ---");
        TaskBatch batch = new TaskBatch();


        batch.addTask(task1);
        batch.addTask(task2);
        batch.addTask(task3);
        batch.addTask(task4);


        batch.printBatchInfo();


        System.out.println("Trying to add a 6th task...");
        Task task6 = new Task("Shipping", 12);
        batch.addTask(task5);
        batch.addTask(task6);


        System.out.println("\n--- Testing Batch Processing ---");


        robot2.chargeBattery(100);
        robot2.setStatus("Active");

        System.out.println("Robot 2 before batch processing:");
        robot2.displayRobotInfo();


        robot2.performTaskBatch(batch);

        System.out.println("\nRobot 2 after batch processing:");
        robot2.displayRobotInfo();


        System.out.println("\nTesting batch with insufficient battery...");
        Robot robot3 = new Robot("LowPower-1", 20, "Active");
        robot3.displayRobotInfo();


        TaskBatch smallBatch = new TaskBatch();
        smallBatch.addTask(task1);
        smallBatch.addTask(task2);

        robot3.performTaskBatch(smallBatch);

        scanner.close();
        System.out.println("\n=== SYSTEM SHUTDOWN ===");
    }
}
