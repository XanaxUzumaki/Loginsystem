/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.loginsystem;

import javax.swing.JOptionPane;

public class Task {

    private String[] taskName;
    private String[] taskDescription;
    private String[] developerDetails;
    private String[] taskID;
    private int[] taskDuration;
    private String[] taskStatus;

    // Constructor to initialize the arrays with the specified size
    public Task(int size) {
        taskName = new String[size];
        taskDescription = new String[size];
        developerDetails = new String[size];
        taskID = new String[size];
        taskDuration = new int[size];
        taskStatus = new String[size];
    }

    // Method to validate the task description (length less than 50 characters)
    public boolean checkDescription(String description) {
        if (description.length() <= 50) {
            JOptionPane.showMessageDialog(null, "Task description is successfully captured");
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Task description should not exceed 50 characters");
            return false;
        }
    }

    // Method to create the Task ID based on task name, task number, and developer details
    public String CreateTaskID(String taskname, int tasknumber, String developerDetails) {
        return taskname.substring(0, 2).toUpperCase() + ":" + tasknumber + ":" + developerDetails.substring(developerDetails.length() - 3).toUpperCase();
    }

    // Method to print task details using JOptionPane
    public String printTaskDetails(String taskStatus, String developerDetails, int taskNumber, String taskName, String taskDescription, String taskID, int taskDuration) {
        String details = "***** Task Details *****\n"
                + "Task Status: " + taskStatus + "\n"
                + "Developer Details: " + developerDetails + "\n"
                + "Task Number: " + taskNumber + "\n"
                + "Task Name: " + taskName + "\n"
                + "Task Description: " + taskDescription + "\n"
                + "Task ID: " + taskID + "\n"
                + "Task Duration: " + taskDuration + " hours\n"
                + "*************************\n";
        JOptionPane.showMessageDialog(null, details);
        return details;
    }

    // Method to return the task duration (used for summing total hours)
    public int returnHours(int hours) {
        return hours;
    }
}
