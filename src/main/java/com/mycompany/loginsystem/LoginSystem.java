/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.loginsystem;

import java.util.Scanner;
import javax.swing.JOptionPane;


public class LoginSystem {

  

    public static void main(String[] args) {
       int option = 0;
        int sum = 0;
       // Object creation for the login class
        userRegistration log = new userRegistration();
        Scanner scanner = new Scanner(System.in);
        
        // Display a welcoming message
        System.out.println("Welcome to Easy Kanban");

        // Prompt for user details during registration
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        
        System.out.print("Enter your surname: ");
        String surname = scanner.nextLine();

        // Ask for username with validation
        String username;
        do {
            System.out.print("Enter your username (must have up to 5 characters and contain an underscore): ");
            username = scanner.nextLine();
        } while (!log.CHECKusername(username));
        
        // Ask for password with validation
        String password;
        do {
            System.out.print("Enter your password (must be 8 characters or more, contain special characters, numbers, and an uppercase letter): ");
            password = scanner.nextLine();
        } while (!log.CheckPassword(password));
        
        // Register the user with the captured information
        log.registerUser(name, surname, username, password);

        // Login process
        boolean loginSuccess = false;
        while (!loginSuccess) {
            System.out.print("Enter your username for login: ");
            String loginUsername = scanner.nextLine();
            
            System.out.print("Enter your password for login: ");
            String loginPassword = scanner.nextLine();
            
            loginSuccess = log.loginUser(loginUsername, loginPassword);
        }

        // Display login status
        log.returnLoginStatus(name, surname);
        
    
        while (option != 3) {
            option = Integer.parseInt(JOptionPane.showInputDialog("Select an option to continue.:\n1: Add tasks\n2: Show report\n3: Quit"));

            switch (option) {
                case 1:
                    int size = Integer.parseInt(JOptionPane.showInputDialog("How many tasks do you wish to capture?"));

                    // Arrays to hold task data for each task
                    String[] taskName = new String[size];
                    String[] taskDescription = new String[size];
                    String[] developerDetails = new String[size];
                    String[] taskID = new String[size];
                    int[] taskDuration = new int[size];
                    String[] taskStatus = new String[size];
                    Task task = new Task(size);  // Create a Task object to manage arrays

                    for (int i = 0; i < size; i++) {
                        // Prompt for task name and assign to array
                        taskName[i] = JOptionPane.showInputDialog("Enter Task name for task " + (i + 1) + ":");

                        // Task description input with validation (less than 50 characters)
                        do {
                            taskDescription[i] = JOptionPane.showInputDialog("Enter Task Description for task " + (i + 1) + " (max 50 characters):");
                        } while (!task.checkDescription(taskDescription[i]));  // Check length validation

                        // Developer details input and assign to array
                        developerDetails[i] = JOptionPane.showInputDialog("Enter Developer Details (First and Last name) for task " + (i + 1) + ":");

                        // Task duration input and assign to array
                        taskDuration[i] = Integer.parseInt(JOptionPane.showInputDialog("Enter Task Duration (in hours) for task " + (i + 1) + ":"));

                        // Create and assign Task ID for each task in array
                        taskID[i] = task.CreateTaskID(taskName[i], i, developerDetails[i]);
                        JOptionPane.showMessageDialog(null, "Task ID for task " + (i + 1) + ": " + taskID[i]);

                        // Prompt for task status (To Do, Doing, Done) and assign to array
                        int statusOption = Integer.parseInt(JOptionPane.showInputDialog("Choose a status for task " + (i + 1) + ":\n1: To Do\n2: Doing\n3: Done"));
                        switch (statusOption) {
                            case 1:
                                taskStatus[i] = "To Do";
                                break;
                            case 2:
                                taskStatus[i] = "Doing";
                                break;
                            case 3:
                                taskStatus[i] = "Done";
                                break;
                        }

                        // Print task details for each task
                        task.printTaskDetails(taskStatus[i], developerDetails[i], i, taskName[i], taskDescription[i], taskID[i], taskDuration[i]);

                        // Accumulate total hours for all tasks
                        sum += task.returnHours(taskDuration[i]);
                    }

                    // Display total hours of all tasks performed
                    JOptionPane.showMessageDialog(null, "The total hours of all the tasks performed: " + sum + " hrs");
                    break;

                case 2:
                    // Placeholder for future report feature
                    JOptionPane.showMessageDialog(null, "Report Coming Soon");
                    break;

                case 3:
                    // Exit the program
                    JOptionPane.showMessageDialog(null, "GOODBYE!!!");
                    System.exit(0);
                    break;

                default:
                    // Handle invalid options
                    JOptionPane.showMessageDialog(null, "Invalid option, please choose the correct option.");
                    break;
            }
        }
}
}


