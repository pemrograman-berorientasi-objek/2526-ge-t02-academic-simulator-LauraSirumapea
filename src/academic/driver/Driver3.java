package academic.driver;

/**
 * @author 12S24057-Laura Awise
 */

import academic.model.Enrollment; // Import kelas Enrollment dari package model
import java.util.ArrayList;        // Untuk menyimpan daftar enrollment
import java.util.Scanner;          // Untuk menerima input dari pengguna

public class Driver3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // List untuk menyimpan semua data enrollment yang sudah ada (aktif)
        ArrayList<Enrollment> existingEnrollments = new ArrayList<>();

        System.out.println("--- Tahap 1: Masukkan Data Enrollment yang Sudah Ada ---");
        System.out.println("Format: NIM#KODE_MATKUL#TAHUN_AJARAN#SEMESTER");
        System.out.println("Contoh: 12S2203#IF223#2023/2024#Ganjil");
        System.out.println("Ketik '---' untuk berhenti memasukkan data enrollment.");

        // Loop untuk menerima input data enrollment yang sudah ada
        while (true) {
            String line = scanner.nextLine();
            if (line.equals("---")) { // Jika pengguna mengetik '---', berhenti input
                break;
            }

            String[] segments = line.split("#"); // Pisahkan input berdasarkan '#'
            if (segments.length == 4) { // Pastikan ada 4 segmen
                try {
                    String nim = segments[0];
                    String courseCode = segments[1];
                    String academicYear = segments[2];
                    String semester = segments[3];

                    // Buat objek Enrollment dan tambahkan ke list
                    Enrollment enrollment = new Enrollment(nim, courseCode, academicYear, semester);
                    existingEnrollments.add(enrollment);
                } catch (Exception e) { // Tangani jika ada error parsing
                    System.err.println("Peringatan: Format data enrollment tidak valid di baris '" + line + "'. Baris ini diabaikan.");
                }
            } else {
                System.err.println("Peringatan: Format input tidak sesuai (harus 4 segmen dipisahkan '#'). Baris ini diabaikan.");
            }
        }

        System.out.println("\n--- Tahap 2: Masukkan Query Pencarian Enrollment ---");
        System.out.println("Format: NIM#KODE_MATKUL#TAHUN_AJARAN#SEMESTER");
        System.out.println("Contoh: 12S2203#IF223#2023/2024#Ganjil");
        System.out.println("Ketik '---' untuk berhenti melakukan pencarian.");

        // Loop untuk menerima input query pencarian
        while (true) {
            String line = scanner.nextLine();
            if (line.equals("---")) { // Jika pengguna mengetik '---', berhenti query
                break;
            }

            String[] querySegments = line.split("#"); // Pisahkan query berdasarkan '#'
            if (querySegments.length == 4) { // Pastikan ada 4 segmen
                String queryNim = querySegments[0];
                String queryCourseCode = querySegments[1];
                String queryAcademicYear = querySegments[2];
                String querySemester = querySegments[3];
                String status = "None"; // Default status adalah 'None'

                // Lakukan pencarian di daftar enrollment yang sudah ada
                for (Enrollment existing : existingEnrollments) {
                    // Jika semua kriteria cocok, maka status 'Aktif'
                    if (existing.getNim().equals(queryNim) &&
                        existing.getCourseCode().equals(queryCourseCode) &&
                        existing.getAcademicYear().equals(queryAcademicYear) &&
                        existing.getSemester().equals(querySemester)) {
                        status = "Aktif";
                        break; // Jika sudah ditemukan, tidak perlu cek lagi
                    }
                }
                // Cetak hasil query beserta statusnya
                System.out.println(queryNim + "|" + queryCourseCode + "|" + queryAcademicYear + "|" + querySemester + "|" + status);
            } else {
                System.err.println("Peringatan: Format query tidak sesuai (harus 4 segmen dipisahkan '#'). Query ini diabaikan.");
            }
        }

        scanner.close(); // Tutup scanner
        System.out.println("\nProgram selesai.");
    }
}