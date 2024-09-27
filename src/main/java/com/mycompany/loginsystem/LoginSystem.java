/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.loginsystem;
import java.util.Scanner;
/**
 *
 * @author RC_Student_lab
 *
 */
public class LoginSystem {
    String loginUsername;  // Stores the username entered during login
    String loginPassword;  // Stores the password entered during login
    Scanner scanner = new Scanner(System.in);  // Scanner for user input
    UserRegistration userRegistration; // Reference to UserRegistration object

    public LoginSystem(UserRegistration userRegistration) {
        this.userRegistration = userRegistration;
    }

    // Method to verify login credentials
    public boolean loginUser() {
        return loginUsername.equals(userRegistration.usernameInput) && 
               loginPassword.equals(userRegistration.passwordInput);
    }

    // Method to display login status
    public String returnLoginStatus() {
        if (loginUser()) {
            System.out.println("Successful Login");
            System.out.println("Welcome " + userRegistration.firstName + " " + userRegistration.lastName + "! It is great to see you again.");
        } else {
            System.out.println("Failed Login. Username or Password incorrect.");
        }
        return "";
    }

    // Main method to run the registration and login processes
    public static void main(String[] args) {
        UserRegistration newUser = new UserRegistration(); // Create a new user registration object
        LoginSystem loginSystem = new LoginSystem(newUser); // Pass the user registration object to login system

        // Capture user registration details
        System.out.println("Enter your username:");
        newUser.usernameInput = newUser.scanner.next();
        System.out.println("Enter your password:");
        newUser.passwordInput = newUser.scanner.next();
        System.out.println("Enter your first name:");
        newUser.firstName = newUser.scanner.next();
        System.out.println("Enter your last name:");
        newUser.lastName = newUser.scanner.next();
        System.out.println(newUser.registerUser());

        // Handle login process
        if (newUser.checkUsername() && newUser.checkPasswordComplexity()) {
            boolean loggedIn = false;
            while (!loggedIn) {
                System.out.println("Enter your username for login:");
                loginSystem.loginUsername = loginSystem.scanner.next();
                System.out.println("Enter your password for login:");
                loginSystem.loginPassword = loginSystem.scanner.next();
                if (loginSystem.loginUser()) {
                    System.out.println(loginSystem.returnLoginStatus());
                    loggedIn = true;
                } else {
                    System.out.println("Failed Login. Username or Password incorrect.");
                }
            }
        }
    }
}