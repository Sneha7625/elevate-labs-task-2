import java.util.ArrayList;
import java.util.Scanner;

// Student class with fields and constructor
class Student 
{
    private int id;
    private String name;
    private double marks;

    // Constructor
    public Student(int id, String name, double marks) 
    {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }

    // Getters and Setters
    public int getId() 
    { 
        return id; 
    }
    public String getName() 
    { 
        return name; 
    }
    public double getMarks() 
    { 
        return marks; 
    }
    public void setName(String name) 
    { 
        this.name = name; 
    }
    public void setMarks(double marks) 
    { 
        this.marks = marks; 
    }

    // Display student details
    public void display() 
    {
        System.out.println("ID: " + id + ", Name: " + name + ", Marks: " + marks);
    }
}

public class StudentRecordManager 
{
    public static void main(String[] args) 
    {
        ArrayList<Student> students = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n=== Student Record Management ===");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            switch (choice)
            {
                case 1:  // Add
                    System.out.print("Enter ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Marks: ");
                    double marks = scanner.nextDouble();
                    students.add(new Student(id, name, marks));
                    System.out.println("Student added!");
                    break;

                case 2:  // View
                    if (students.isEmpty()) 
                    {
                        System.out.println("No student records found.");
                    } 
                    else 
                    {
                        System.out.println("Student Records:");
                        for (Student s : students) 
                        
                        {
                            s.display();
                        }
                    }
                    break;

                case 3:  // Update
                    System.out.print("Enter ID to update: ");
                    int updateId = scanner.nextInt();
                    boolean foundUpdate = false;
                    for (Student s : students) 
                    {
                        if (s.getId() == updateId) 
                        {
                            scanner.nextLine(); // consume newline
                            System.out.print("Enter new name: ");
                            String newName = scanner.nextLine();
                            System.out.print("Enter new marks: ");
                            double newMarks = scanner.nextDouble();
                            s.setName(newName);
                            s.setMarks(newMarks);
                            System.out.println("Student updated.");
                            foundUpdate = true;
                            break;
                        }
                    }
                    if (!foundUpdate) 
                    System.out.println("Student not found.");
                    break;

                case 4:  // Delete
                    System.out.print("Enter ID to delete: ");
                    int deleteId = scanner.nextInt();
                    boolean removed = students.removeIf(s -> s.getId() == deleteId);
                    if (removed) 
                    {
                        System.out.println("Student deleted.");
                    } 
                    else 
                    {
                        System.out.println("Student not found.");
                    }
                    break;

                case 5:  // Exit
                    running = false;
                    System.out.println("Exiting system. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        scanner.close();
    }
}
