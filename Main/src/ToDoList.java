import java.util.Scanner;

import java.util.ArrayList;

public class ToDoList {
    private Scanner scanner;
    private ArrayList<String> tasks;
    public ToDoList() {
        scanner = new Scanner(System.in);
        tasks = new ArrayList<>();
    }

    private void printMenu() {
        System.out.println("\n=== MENU ===");
        System.out.println("1. Add Task");
        System.out.println("2. View Tasks");
        System.out.println("3. Mark Task Complete");
        System.out.println("4. Remove Task");
        System.out.println("5. Exit");
        System.out.print("Choose an option: ");
    }

    public void start() {
        while (true) {
            printMenu();
            int choice = getValidInput();
            switch (choice) {
                case 1 -> AddTask();
                case 2 -> ViewTasks();
                case 3 -> MarkComplete();
                case 4 -> DeleteTask();
                case 5 -> {
                    System.out.println("Goodbye!");
                    return;
                }
                default -> System.out.println("Wrong input.");

            }
        }
    }

    private int getValidInput() {
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Must be a number.");
            scanner.next();
        }
        return scanner.nextInt();
    }

    private void AddTask() {
        System.out.println("Enter task description: ");
        scanner.nextLine();
        String task = scanner.nextLine();
        tasks.add(task);
        System.out.println("Task added! Total tasks: " + tasks.size());
    }

    private void DeleteTask() {
        if (tasks.isEmpty()) {
            System.out.println("Nothing to delete yet. Add a task first.");
            return;
        }
        ViewTasks();
        System.out.print("Enter task number to remove: ");
        int index = getValidInput();
        if(isValidTaskNumber(index)) {
            String removedTask = tasks.remove(index-1);
            System.out.println("Task \"" + removedTask + "\" had been deleted.");
        }
        else System.out.println("Invalid task number.");
    }

    private void ViewTasks() {
        if (tasks.isEmpty()){
            System.out.println("Nothing to view yet. Add a task first.");
            return;
        }
        System.out.println("-----YOUR TASKS-----");
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println(i+1 + ". " + tasks.get(i));
        }
    }
    private void MarkComplete() {
        if (tasks.isEmpty()) {
            System.out.println("Nothing to mark completed yet. Add a task first");
            return;
        }
        ViewTasks();
        System.out.print("Enter a task number to mark complete: ");
        int task_num = getValidInput();
        if (isValidTaskNumber(task_num)) {
            int index = task_num -1;
            String current = tasks.get(index);
            tasks.set(index, "[✓] " + current);
            System.out.println("Task marked complete.");
        }
        else {
            System.out.println("Invalid input");
        }
    }

    private boolean isValidTaskNumber(int taskNum) {

        return (taskNum >= 1 && taskNum <= tasks.size());
    }

    public static void main(String[] args) {
        ToDoList list = new ToDoList();
        list.start();
    }


}
