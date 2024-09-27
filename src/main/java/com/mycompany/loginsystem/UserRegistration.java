/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.loginsystem;
import java.util.Scanner;
/**
 *
 * @author RC_Student_lab
 */
public class UserRegistration {
    String usernameInput;  // Stores the entered username
    String passwordInput;  // Stores the entered password
    String firstName;      // Stores the user's first name
    String lastName;       // Stores the user's last name
    Scanner scanner = new Scanner(System.in);  // Scanner for user input

    // Method to check if the username is valid (must contain an underscore and be no more than 5 characters)
    public boolean checkUsername() {
        boolean validUsername = false;
        for (int i = 0; i < usernameInput.length(); i++) {
            if (usernameInput.length() <= 5 && usernameInput.contains("_")) {
                validUsername = true;
            }
        }
        return validUsername;
    }

    // Method to check if the password meets complexity requirements
    // The password must contain at least one uppercase letter, one number, and one special character
    public boolean checkPasswordComplexity() {
        boolean hasNumber = false;
        boolean hasSpecial = false;
        boolean hasLetter = false;

        for (int i = 0; i < passwordInput.length(); i++) {
            if (passwordInput.length() >= 8) {
                char ch = passwordInput.charAt(i);
                if (Character.isUpperCase(ch)) {
                    hasLetter = true;
                }
                if (Character.isDigit(ch)) {
                    hasNumber = true;
                }
                if (!Character.isLetterOrDigit(ch)) {
                    hasSpecial = true;
                }
            }
        }
        return hasLetter && hasNumber && hasSpecial;
    }

    // Method to handle the user registration process
    public String registerUser() {
        boolean validUsername = false;
        boolean validPassword = false;

        // Prompt for username and password until valid inputs are received
        while (!validUsername || !validPassword) {
            if (checkUsername()) {
                System.out.println("Username successfully captured");
                validUsername = true;
            } else {
                System.out.println("Invalid username. Ensure it contains an underscore and is no more than 5 characters.");
                System.out.println("Enter your username again:");
                usernameInput = scanner.next();
            }

            if (checkPasswordComplexity()) {
                System.out.println("Password successfully captured");
                validPassword = true;
            } else {
                System.out.println("Invalid password. Ensure it has at least 8 characters, a capital letter, a number, and a special character.");
                System.out.println("Enter your password again:");
                passwordInput = scanner.next();
            }
        }

        System.out.println("The username and password meet the complexity requirements. User registered successfully.");
        return "User registered successfully.";
    }
}