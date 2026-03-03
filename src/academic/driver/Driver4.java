package academic.driver;

/**
 * @author 12S24057-LAURA AWISE
 */
import academic.model.Course;
import academic.model.Student;
import academic.model.Enrollment;
import java.util.ArrayList;
import java.util.List; // Menggunakan List interface untuk deklarasi
import java.util.Scanner;

public class Driver4 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // List untuk menyimpan semua entitas
        List<Course> courses = new ArrayList<>();
        List<Student> students = new ArrayList<>();
        List<Enrollment> enrollments = new ArrayList<>();

        System.out.println("--- Masukkan Data Entitas (Course, Student, Enrollment) ---");
        System.out.println("Format:");
        System.out.println("  course-add#KODE_MATKUL#NAMA_MATKUL#SKS#GRADE");
        System.out.println("  student-add#NIM#NAMA_MHS#TAHUN_MASUK#PRODI");
        System.out.println("  enrollment-add#KODE_MATKUL#NIM#TAHUN_AJARAN#SEMESTER");
        System.out.println("Ketik '---' untuk berhenti memasukkan data.");

        while (true) {
            String line = scanner.nextLine();
            if (line.equals("---")) {
                break;
            }

            try {
                String[] parts = line.split("#");
                String command = parts[0]; // Bagian pertama adalah perintah (course-add, student-add, enrollment-add)

                switch (command) {
                    case "course-add":
                        if (parts.length == 5) {
                            String code = parts[1];
                            String name = parts[2];
                            int credits = Integer.parseInt(parts[3]);
                            String grade = parts[4]; // Grade nilai akhir
                            Course course = new Course(code, name, credits, grade);
                            courses.add(course);
                        } else {
                            System.err.println("Peringatan: Format 'course-add' tidak sesuai. Baris ini diabaikan: " + line);
                        }
                        break;
                    case "student-add":
                        if (parts.length == 5) {
                            String nim = parts[1];
                            String name = parts[2];
                            int entranceYear = Integer.parseInt(parts[3]);
                            String major = parts[4];
                            Student student = new Student(nim, name, entranceYear, major);
                            students.add(student);
                        } else {
                            System.err.println("Peringatan: Format 'student-add' tidak sesuai. Baris ini diabaikan: " + line);
                        }
                        break;
                    case "enrollment-add":
                        if (parts.length == 5) {
                            String courseCode = parts[1];
                            String nim = parts[2];
                            String academicYear = parts[3];
                            String semester = parts[4];
                            Enrollment enrollment = new Enrollment(courseCode, nim, academicYear, semester);
                            // Sesuai contoh output, grade di enrollment selalu "None" untuk kasus ini
                            enrollment.setGrade("None");
                            enrollments.add(enrollment);
                        } else {
                            System.err.println("Peringatan: Format 'enrollment-add' tidak sesuai. Baris ini diabaikan: " + line);
                        }
                        break;
                    default:
                        System.err.println("Peringatan: Perintah tidak dikenal. Baris ini diabaikan: " + line);
                        break;
                }
            } catch (NumberFormatException e) {
                System.err.println("Peringatan: Kesalahan format angka di baris '" + line + "'. Baris ini diabaikan.");
            } catch (ArrayIndexOutOfBoundsException e) {
                System.err.println("Peringatan: Format input tidak lengkap di baris '" + line + "'. Baris ini diabaikan.");
            } catch (Exception e) {
                System.err.println("Peringatan: Terjadi kesalahan tidak terduga di baris '" + line + "'. Baris ini diabaikan. Error: " + e.getMessage());
            }
        }

        scanner.close(); // Tutup scanner

        System.out.println("\n--- Output Entitas ---");
        // Tampilkan Course
        for (Course course : courses) {
            System.out.println(course);
        }

        // Tampilkan Student
        for (Student student : students) {
            System.out.println(student);
        }

        // Tampilkan Enrollment
        for (Enrollment enrollment : enrollments) {
            System.out.println(enrollment);
        }

        System.out.println("\nProgram selesai.");
    }
}