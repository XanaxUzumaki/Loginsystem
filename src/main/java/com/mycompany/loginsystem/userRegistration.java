/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.loginsystem;


import java.util.Scanner;

public class userRegistration {
   

    // Instance variables to store the registered username and password
    private String registeredUsername;
    private String registeredPassword;

    // Method that checks for username requirements
    public boolean CHECKusername(String user) {
        if (user.length() <= 5 && user.contains("_")) {
            System.out.println("Username successfully captured.");
            this.registeredUsername = user; // Store registered username
            return true;
        } else {
            System.out.println("Username is not successfully captured. Ensure it contains an underscore and has up to 5 characters.");
            return false;
        }
    }

    // Method that checks for password complexity
    public boolean CheckPassword(String pass) {
        boolean containSpecial = false;
        boolean containUppercase = false;
        boolean containDigit = false;

        for (int i = 0; i < pass.length(); i++) {
            char c = pass.charAt(i);
            if (Character.isUpperCase(c)) {
                containUppercase = true;
            } else if (Character.isDigit(c)) {
                containDigit = true;
            } else if (!Character.isLetterOrDigit(c)) {
                containSpecial = true;
            }
        }

        if (pass.length() >= 8 && containSpecial && containUppercase && containDigit) {
            System.out.println("Password successfully captured.");
            this.registeredPassword = pass; // Store registered password
            return true;
        } else {
            System.out.println("Password not successfully captured. Ensure it meets the requirements.");
            return false;
        }
    }

    // Method to register the user
    public void registerUser(String name, String surname, String username, String password) {
        System.out.println("Congratulations, you have successfully registered!");
        System.out.println("***********************************************");
        // You can also store the name and surname here if needed.
    }

    // Method to verify login credentials
    public boolean loginUser(String enteredUsername, String enteredPassword) {
        // Compare entered credentials with registered ones
        if (enteredUsername.equals(this.registeredUsername) && enteredPassword.equals(this.registeredPassword)) {
            System.out.println("Login successful!");
            return true;
        } else {
            System.out.println("Incorrect username or password. Please try again.");
            return false;
        }
    }

    // Method to return login status
    public void returnLoginStatus(String name, String surname) {
        System.out.println("Welcome to Easy Kanban, " + name + " " + surname + "!");
    }
}
