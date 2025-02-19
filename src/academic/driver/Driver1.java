package academic.driver;
import academic.model.Course;
import academic.model.Enrollment;
import academic.model.Student;
import java.util.Scanner;

/**
 * @author 12S23003_Chrismansyah Siahaan
 * @author 12S23015_Kevin Kristoforus Samosir
 */

public class Driver1 {
    public static void main(String[] args) {
        Course[] courses = new Course[100];
        Student[] students = new Student[100];
        Enrollment[] enrollments = new Enrollment[100];
        int courseCount = 0, studentCount = 0, enrollmentCount = 0;
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String input = scanner.nextLine();
            if (input.equals("---")) {
            break;
            }
            String[] parts = input.split("#");
            switch (parts[0]) {
                case "course-add":
                    courses[courseCount++] = new Course(parts[1], parts[2], Integer.parseInt(parts[3]), parts[4]);
                    break;  
                case "student-add":
                    students[studentCount++] = new Student(parts[1], parts[2], Integer.parseInt(parts[3]), parts[4]);
                    break;
                case "enrollment-add":
                    enrollments[enrollmentCount++] = new Enrollment(parts[1], parts[2], parts[3], parts[4]);
                    break;
            }
        }

        for (int i = courseCount - 1; i >= 0; i--) {
            System.out.println(courses[i]);
        }
        for (int i = 0; i < studentCount; i++) {
            System.out.println(students[i]);
        }
        for (int i = 0; i < enrollmentCount; i++) {
            System.out.println(enrollments[i]);
        }

        scanner.close();
    }
}