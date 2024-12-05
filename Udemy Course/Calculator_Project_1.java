/* Project Description
Create a student management system that uses arrays and regular expressions to manage student records. The system should allow the user to add, view, and search for student records.

Instructions:

Create a Java project in Eclipse or any IDE of your choice.

Create a class called "Student" that has the following properties: name, ID, email, and GPA.

Create an array of Student objects to store the student records.

Create a method called "addStudent" that takes the name, ID, email, and GPA as parameters and adds a new Student object to the array.

Create a method called "viewStudents" that displays all the student records in the array.

Create a method called "searchStudents" searches for a student with a given name.

Use regular expressions to validate the email address format when adding a new student record. */

package Course;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.print("Enter first number: ");
        double num1 = input.nextDouble();

        System.out.print("Enter second number: ");
        double num2 = input.nextDouble();

        System.out.print("Enter operation (+, -, *, /, %, ^): ");
        String operation = input.next();

        double result = 0;

        switch (operation) {
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "*":
                result = num1 * num2;
                break;
            case "/":
                if (num2 != 0) {
                    result = num1 / num2;
                } else {
                    System.out.println("Error: Cannot divide by zero.");
                    validOperation = false;
                }
                break;
            case "%":
                result = num1 % num2;
                break;
            case "^":
                result = Math.pow(num1, num2);
                break;
            default:
                System.out.println("Invalid operation. Please choose from (+, -, *, /, %, ^).");
                validOperation = false;
                break;
        }

        if (true) {
            System.out.printf("Result: %.2f\n", result);
        }

    }
}

