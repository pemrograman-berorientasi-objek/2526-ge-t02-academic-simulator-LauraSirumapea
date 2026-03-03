package academic.driver;

/**
 * @author 12S24057-LAURA AWISE
 */
import academic.model.Course;
import academic.model.Student;
import academic.model.Enrollment;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Driver4 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Course> courses = new ArrayList<>();
        List<Student> students = new ArrayList<>();
        List<Enrollment> enrollments = new ArrayList<>();

        // Gunakan hasNextLine() untuk menghindari NoSuchElementException
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.equals("---")) {
                break;
            }

            String[] parts = line.split("#");
            if (parts.length < 1) continue;
            
            String command = parts[0];

            switch (command) {
                case "course-add":
                    if (parts.length == 5) {
                        String code = parts[1];
                        String name = parts[2];
                        int credits = Integer.parseInt(parts[3]);
                        String grade = parts[4];
                        courses.add(new Course(code, name, credits, grade));
                    }
                    break;
                case "student-add":
                    if (parts.length == 5) {
                        String nim = parts[1];
                        String name = parts[2];
                        int entranceYear = Integer.parseInt(parts[3]);
                        String major = parts[4];
                        students.add(new Student(nim, name, entranceYear, major));
                    }
                    break;
                case "enrollment-add":
                    if (parts.length == 5) {
                        String courseCode = parts[1];
                        String nim = parts[2];
                        String academicYear = parts[3];
                        String semester = parts[4];
                        Enrollment enrollment = new Enrollment(courseCode, nim, academicYear, semester);
                        enrollment.setGrade("None");
                        enrollments.add(enrollment);
                    }
                    break;
            }
        }

        // TAMPILKAN OUTPUT (Hanya data, tanpa teks dekorasi apa pun)
        for (Course c : courses) {
            System.out.println(c);
        }
        for (Student s : students) {
            System.out.println(s);
        }
        for (Enrollment e : enrollments) {
            System.out.println(e);
        }

        scanner.close();
    }
}