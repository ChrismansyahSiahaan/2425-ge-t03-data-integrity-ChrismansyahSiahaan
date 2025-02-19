package academic.driver;
import academic.model.Course;
import academic.model.Enrollment;
import academic.model.Student;
import java.util.Scanner;

/**
 * @author 12S23003_Chrismansyah Tolhas Siahaan
 * @author 12S23015_Kevin Kristoforus Samosir
 */

public class Driver2 {
    public static void main(String[] args) {
        Course[] courses = new Course[100];
        Student[] students = new Student[100];
        Enrollment[] enrollments = new Enrollment[100];
        int courseCount = 0, studentCount = 0, enrollmentCount = 0;
        StringBuilder invalidEntries = new StringBuilder();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String input = scanner.nextLine();
            if (input.equals("---")) {
                break;
            }
            String[] parts = input.split("#");
            switch (parts[0]) {
                case "course-add":
                    if (parts.length == 5) {
                        String code = parts[1];
                        String name = parts[2];
                        int credits = Integer.parseInt(parts[3]);
                        String grade = parts[4];
                        courses[courseCount++] = new Course(code, name, credits, grade);
                    }
                    break;
                case "student-add":
                    if (parts.length == 5) {
                        String id = parts[1];
                        String name = parts[2];
                        int year = Integer.parseInt(parts[3]);
                        String major = parts[4];
                        students[studentCount++] = new Student(id, name, year, major);
                    }
                    break;
                case "enrollment-add":
                    if (parts.length == 5) {
                        String courseCode = parts[1];
                        String studentId = parts[2];
                        String year = parts[3];
                        String semester = parts[4];
                        String grade = "none";

                        boolean courseExists = false;
                        boolean studentExists = false;

                        for (int i = 0; i < courseCount; i++) {
                            if (courses[i].getCode().equals(courseCode)) {
                                courseExists = true;
                                break;
                            }
                        }

                        for (int i = 0; i < studentCount; i++) {
                            if (students[i].getId().equals(studentId)) {
                                studentExists = true;
                                break;
                            }
                        }

                        if (!courseExists) {
                            invalidEntries.append("invalid course|").append(courseCode).append("\n");
                        }
                       else if (!studentExists) {
                            invalidEntries.append("invalid student|").append(studentId).append("\n");
                        }
                        if (courseExists && studentExists) {
                            enrollments[enrollmentCount++] = new Enrollment(courseCode, studentId, year, semester);
                        }
                    }
                    break;
                default:
                    System.out.println("Error: Perintah tidak dikenali.");
            }
        }
        scanner.close();

        // Cetak invalid entries
        System.out.print(invalidEntries.toString());
        
        // Cetak daftar courses dalam urutan terakhir ke awal
        for (int i = courseCount - 1; i >= 0; i--) {
            System.out.println(courses[i].toString());
        }

        // Cetak daftar students dalam urutan awal ke akhir
        for (int i = 0 ; i < studentCount ; i++) {
            System.out.println(students[i].toString());
        }

        // Cetak daftar enrollments dalam urutan awal ke akhir
        for (int i = 0; i < enrollmentCount; i++) {
            System.out.println(enrollments[i].toString());
        }
    }
}
