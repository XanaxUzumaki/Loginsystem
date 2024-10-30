/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.loginsystem;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TaskTest {
    
   
    @Test
    public void testCheckDescription() {
        System.out.println("checkDescription");
        String description = "Create Login to authenticate users";
        Task instance = null;
        boolean expResult = true;
        boolean result = instance.checkDescription(description);
        assertEquals(expResult, result);
       
    }

    /**
     * Test of CreateTaskID method, of class Task.
     */
    @Test
    public void testCreateTaskID() {
        System.out.println("CreateTaskID");
         String taskname = "Login Feature";
        int tasknumber = 0;
        String  developerDetails = "To Do";
        Task instance = null;
        String expResult = "";
        String result = instance.CreateTaskID(taskname, tasknumber, developerDetails);
        assertEquals(expResult, result);
       
    }

    /**
     * Test of printTaskDetails method, of class Task.
     */
    @Test
    public void testPrintTaskDetails() {
        System.out.println("printTaskDetails");
       String taskStatus = "To Do";
        String developerDetails = "Robyn Harrison";
        int taskNumber = 0;
        String taskName= "Login Feature";
        String taskDescription = "Create Login to authenticate users";
        String taskID = " ";
        int taskDuration = 8;

        Task instance = null;
        String expResult = "";
        String result = instance.printTaskDetails(taskStatus, developerDetails, taskNumber, taskName, taskDescription, taskID, taskDuration);
        assertEquals(expResult, result);
       
    }

    /**
     * Test of returnHours method, of class Task.
     */
    @Test
    public void testReturnHours() {
        System.out.println("returnHours");
        int hours = 0;
        Task instance = null;
        int expResult = 8;

        int result = instance.returnHours(hours);
        assertEquals(expResult, result);
     
    }
    
}
