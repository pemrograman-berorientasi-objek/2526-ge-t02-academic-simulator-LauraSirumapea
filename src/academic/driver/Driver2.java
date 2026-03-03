package academic.driver;

/**
 * @author 12S24057- Laura Awise
 */
import academic.model.Student;
import java.util.ArrayList;
import java.util.Scanner;

public class Driver2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        System.out.println("Masukkan data mahasiswa (setiap baris 4 segmen dipisahkan '#').");
        System.out.println("Segmen: NIM#NAMA#TAHUN_MASUK#PROGRAM_STUDI");
        System.out.println("Ketik '---' untuk berhenti.");

        while (true) {
            String line = scanner.nextLine();
            if (line.equals("---")) {
                break;
            }

            String[] segments = line.split("#");
            if (segments.length == 4) {
                try {
                    String nim = segments[0];
                    String name = segments[1];
                    int entranceYear = Integer.parseInt(segments[2]);
                    String studyProgram = segments[3];

                    Student student = new Student(nim, name, entranceYear, studyProgram);
                    students.add(student);
                } catch (NumberFormatException e) {
                    System.err.println("Peringatan: Tahun Masuk tidak valid di baris '" + line + "'. Baris ini diabaikan.");
                }
            } else {
                System.err.println("Peringatan: Format input tidak sesuai (harus 4 segmen dipisahkan '#'). Baris ini diabaikan.");
            }
        }

        scanner.close();

        System.out.println("\n--- Daftar Mahasiswa yang Tersimpan ---");
        for (Student student : students) {
            System.out.println(student);
        }
    }
}