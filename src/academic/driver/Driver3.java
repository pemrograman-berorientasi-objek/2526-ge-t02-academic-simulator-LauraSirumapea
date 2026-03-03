package academic.driver;

/**
 * @author 12S24057-LAURA AWISE
 */

import academic.model.Enrollment;
import java.util.ArrayList;
import java.util.Scanner;

public class Driver3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Enrollment> enrollments = new ArrayList<>();

        // Loop untuk menerima input data enrollment
        // Menggunakan hasNextLine untuk mencegah error 'No line found' di GitHub
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            
            // Berhenti jika menemukan tanda ---
            if (line.equals("---")) {
                break;
            }

            String[] segments = line.split("#");
            if (segments.length == 4) {
                String courseCode = segments[0];
                String nim = segments[1];
                String academicYear = segments[2];
                String semester = segments[3];

                // Buat objek Enrollment
                Enrollment enrollment = new Enrollment(courseCode, nim, academicYear, semester);
                
                // Set grade ke "None" sesuai permintaan output
                enrollment.setGrade("None");
                
                // Simpan ke list
                enrollments.add(enrollment);
            }
        }

        // Cetak semua enrollment yang sudah dimasukkan
        for (Enrollment e : enrollments) {
            System.out.println(e.toString());
        }

        scanner.close();
    }
}