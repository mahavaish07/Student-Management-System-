import java.util.ArrayList;
import java.util.Scanner;

class Student {
    int rollNumber;
    String name;
    double marks;

    Student(int rollNumber, String name, double marks) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.marks = marks;
    }

    void display() {
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Name: " + name);
        System.out.println("Marks: " + marks);
        System.out.println("----------------------");
    }
}

public class StudentManagementSystem {

    static ArrayList<Student> students = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    static Student findStudent(int rollNumber) {
        for (Student s : students) {
            if (s.rollNumber == rollNumber) {
                return s;
            }
        }
        return null;
    }

    static void addStudent() {
        System.out.print("Enter Roll Number: ");
        int roll = sc.nextInt();
        sc.nextLine();

        if (findStudent(roll) != null) {
            System.out.println("Roll number already exists!");
            return;
        }

        System.out.print("Enter Student Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Marks: ");
        double marks = sc.nextDouble();
        sc.nextLine();

        if (marks < 0 || marks > 100) {
            System.out.println("Marks must be between 0 and 100.");
            return;
        }

        students.add(new Student(roll, name, marks));
        System.out.println("Student added successfully!");
    }

    static void viewStudents() {
        if (students.isEmpty()) {
            System.out.println("No student records found.");
            return;
        }

        for (Student s : students) {
            s.display();
        }
    }

    static void updateStudent() {
        System.out.print("Enter Roll Number to update: ");
        int roll = sc.nextInt();
        sc.nextLine();

        Student s = findStudent(roll);

        if (s == null) {
            System.out.println("Student not found!");
            return;
        }

        System.out.print("Enter New Name: ");
        String name = sc.nextLine();

        System.out.print("Enter New Marks: ");
        double marks = sc.nextDouble();
        sc.nextLine();

        if (marks < 0 || marks > 100) {
            System.out.println("Marks must be between 0 and 100.");
            return;
        }

        s.name = name;
        s.marks = marks;

        System.out.println("Student updated successfully!");
    }

    static void deleteStudent() {
        System.out.print("Enter Roll Number to delete: ");
        int roll = sc.nextInt();
        sc.nextLine();

        Student s = findStudent(roll);

        if (s == null) {
            System.out.println("Student not found!");
            return;
        }

        students.remove(s);
        System.out.println("Student deleted successfully!");
    }

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\n===== STUDENT MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    addStudent();
                    break;

                case 2:
                    viewStudents();
                    break;

                case 3:
                    updateStudent();
                    break;

                case 4:
                    deleteStudent();
                    break;

                case 5:
                    System.out.println("Thank you for using the system!");
                    break;

                default:
                    System.out.println("Invalid choice! Try again.");
            }

        } while (choice != 5);

        sc.close();
    }
}