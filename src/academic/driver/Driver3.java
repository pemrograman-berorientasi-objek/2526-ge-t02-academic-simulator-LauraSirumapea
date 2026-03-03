package academic.driver;

/**
 * @author 12S24057-Laura Awise
 */

import academic.model.Enrollment;
import java.util.ArrayList;
import java.util.Scanner;

public class Driver3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Enrollment> existingEnrollments = new ArrayList<>();

        // Tahap 1: Input Data Enrollment
        // Gunakan hasNextLine() untuk mencegah NoSuchElementException
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.equals("---")) {
                break;
            }

            String[] segments = line.split("#");
            if (segments.length == 4) {
                String nim = segments[0];
                String courseCode = segments[1];
                String academicYear = segments[2];
                String semester = segments[3];

                Enrollment enrollment = new Enrollment(nim, courseCode, academicYear, semester);
                existingEnrollments.add(enrollment);
            }
        }

        // Tahap 2: Query Pencarian
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.equals("---")) {
                break;
            }

            String[] querySegments = line.split("#");
            if (querySegments.length == 4) {
                String queryNim = querySegments[0];
                String queryCourseCode = querySegments[1];
                String queryAcademicYear = querySegments[2];
                String querySemester = querySegments[3];
                
                // Gunakan default sesuai format soal, biasanya "None"
                String status = "None"; 

                for (Enrollment existing : existingEnrollments) {
                    if (existing.getNim().equals(queryNim) &&
                        existing.getCourseCode().equals(queryCourseCode) &&
                        existing.getAcademicYear().equals(queryAcademicYear) &&
                        existing.getSemester().equals(querySemester)) {
                        status = "Aktif"; // Sesuaikan jika di soal statusnya bukan "Aktif"
                        break;
                    }
                }
                // Format output: NIM|KODE|TAHUN|SEMESTER|STATUS
                System.out.println(queryNim + "|" + queryCourseCode + "|" + queryAcademicYear + "|" + querySemester + "|" + status);
            }
        }

        scanner.close();
    }
}