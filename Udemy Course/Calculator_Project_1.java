/* 
Description
Create a simple command-line calculator that takes two numbers as inputs and performs arithmetic operations on them. The calculator should support the following operations:

Addition (+)

Subtraction (-)

Multiplication (*)

Division (/)

Modulo (%)

Exponentiation (^)

The calculator should also handle any type casting and display the result as accurately as possible.

Instructions:

Create a Java project in Eclipse or any IDE of your choice.

Create a class called "Calculator" that has a main method.

Within the main method, prompt the user to enter two numbers and the operation they want to perform.

Use the appropriate Java operators and data types to perform the arithmetic operation.

Display the result to the user.

 */

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

