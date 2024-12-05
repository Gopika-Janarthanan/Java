package Course;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
import java.util.regex.Pattern;

public class StudentManagementSystem {

    private final Scanner input = new Scanner(System.in);
    private final ArrayList<Student> students = new ArrayList<>();

    public static void main(String[] args) {
        StudentManagementSystem system = new StudentManagementSystem();
        system.run();
    }

    public void run() {
        while (true) {
            System.out.println("Enter a command (add, view, search, sort, exit):");
            String command = input.nextLine().toLowerCase();

            switch (command) {
                case "add":
                    addStudent();
                    break;

                case "view":
                    viewStudents();
                    break;

                case "search":
                    searchStudent();
                    break;

                case "sort":
                    sortStudents();
                    break;

                case "exit":
                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println("Invalid command. Try again.");
            }
        }
    }

    private void addStudent() {
        System.out.println("Adding a new student.");
        System.out.print("Enter Name: ");
        String name = input.nextLine();
        System.out.print("Enter ID: ");
        int id = Integer.parseInt(input.nextLine());
        System.out.print("Enter GPA: ");
        float gpa = Float.parseFloat(input.nextLine());
        System.out.print("Enter Email: ");
        String email = input.nextLine();

        if (!isValidEmail(email)) {
            System.out.println("Invalid email format. Try again.");
            return;
        }

        Student newStudent = new Student(name, id, email, gpa);
        students.add(newStudent);
        System.out.println("Student record added successfully.");
    }

    private void viewStudents() {
        if (students.isEmpty()) {
            System.out.println("No student records available.");
            return;
        }

        System.out.println("View all student records:");
        for (Student student : students) {
            System.out.println(student);
        }
    }

    private void searchStudent() {
        System.out.print("Enter keywords to search : ");
        String regex = input.nextLine();

        System.out.println("Search results:");
        for (Student student : students) {
            if (Pattern.matches(regex, student.getName())) {
                System.out.println(student);
            }
        }
    }

    private void sortStudents() {
        System.out.print("Enter a field to sort by (name, id, gpa, email): ");
        String field = input.nextLine().toLowerCase();

        Comparator<Student> comparator;

        switch (field) {
            case "name":
                comparator = Comparator.comparing(Student::getName);
                break;

            case "id":
                comparator = Comparator.comparingInt(Student::getId);
                break;

            case "gpa":
                comparator = Comparator.comparingDouble(Student::getGpa);
                break;

            case "email":
                comparator = Comparator.comparing(Student::getEmail);
                break;

            default:
                System.out.println("Invalid field. Sorting canceled.");
                return;
        }

        students.sort(comparator);
        System.out.println("Students sorted by " + field + ":");
        viewStudents();
    }

    private boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$";
        return Pattern.matches(emailRegex, email);
    }

    static class Student {
        private String name;
        private int id;
        private float gpa;
        private String email;

        public Student(String name, int id, String email, float gpa) {
            this.name = name;
            this.id = id;
            this.email = email;
            this.gpa = gpa;
        }

        public String getName() {
            return name;
        }

        public int getId() {
            return id;
        }

        public float getGpa() {
            return gpa;
        }

        public String getEmail() {
            return email;
        }

        @Override
        public String toString() {
            return "Name: " + name + ", ID: " + id + ", Email: " + email + ", GPA: " + gpa;
        }
    }
}
