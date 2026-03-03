package academic.driver;

import academic.model.Student;
import java.util.ArrayList;
import java.util.Scanner;

public class Driver2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        while (true) {
            String line = scanner.nextLine();
            if (line.equals("---")) {
                break;
            }

            String[] segments = line.split("#");
            if (segments.length == 4) {
                String nim = segments[0];
                String name = segments[1];
                int entranceYear = Integer.parseInt(segments[2]);
                String studyProgram = segments[3];

                Student student = new Student(nim, name, entranceYear, studyProgram);
                students.add(student);
            }
        }

        for (Student student : students) {
            System.out.println(student);
        }

        scanner.close();
    }
}