package academic.driver;

import academic.model.Course;
import java.util.ArrayList;
import java.util.Scanner;

public class Driver1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Course> courses = new ArrayList<>();

        while (true) {
            String line = scanner.nextLine();
            if (line.equals("---")) {
                break;
            }

            String[] segments = line.split("#");
            if (segments.length == 4) {
                String courseCode = segments[0];
                String courseName = segments[1];
                int credits = Integer.parseInt(segments[2]);
                String grade = segments[3];

                Course course = new Course(courseCode, courseName, credits, grade);
                courses.add(course);
            }
        }

        for (Course course : courses) {
            System.out.println(course);
        }

        scanner.close();
    }
} 