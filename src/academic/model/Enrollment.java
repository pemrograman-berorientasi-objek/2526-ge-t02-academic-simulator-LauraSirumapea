package academic.model;

/**
 * @author 12S24057-Laura Awise
*/
public class Enrollment {
    private String courseCode; // Kode Mata Kuliah
    private String nim;        // NIM Mahasiswa
    private String academicYear; // Tahun Ajaran, contoh: "2023/2024"
    private String semester;     // Semester, contoh: "Ganjil" atau "Genap"
    private String grade;      // Tambahan grade, meskipun di Task 4 outputnya 'None', kita bisa simpan jika diperlukan

    // Constructor
    public Enrollment(String courseCode, String nim, String academicYear, String semester) {
        this.courseCode = courseCode;
        this.nim = nim;
        this.academicYear = academicYear;
        this.semester = semester;
        this.grade = "None"; // Default grade, atau bisa di-set sesuai input jika ada
    }

    // Getters
    public String getCourseCode() {
        return courseCode;
    }

    public String getNim() {
        return nim;
    }

    public String getAcademicYear() {
        return academicYear;
    }

    public String getSemester() {
        return semester;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    // toString() untuk format output yang diminta, termasuk status (None)
    @Override
    public String toString() {
        return courseCode + "|" + nim + "|" + academicYear + "|" + semester + "|" + grade;
    } 
} 