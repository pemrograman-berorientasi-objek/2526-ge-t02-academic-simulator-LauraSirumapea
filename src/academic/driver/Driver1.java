package academic.driver;

/**
 * 
 * @laura 12S24057 - Laura Awise
 */

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
                try {
                    String courseCode = segments[0];
                    String courseName = segments[1];
                    int credits = Integer.parseInt(segments[2]);
                    String grade = segments[3];

                    Course course = new Course(courseCode, courseName, credits, grade);
                    courses.add(course);
                } catch (NumberFormatException e) {
                    System.err.println("Peringatan: Jumlah SKS tidak valid di baris '" + line + "'. Baris ini diabaikan.");
                }
            } else {
                System.err.println("Peringatan: Format input tidak sesuai (harus 4 segmen dipisahkan '#'). Baris ini diabaikan.");
            }
        }

        scanner.close();

        System.out.println("\n--- Daftar Mata Kuliah yang Tersimpan ---");
        for (Course course : courses) {
            System.out.println(course);
        }
    }
}