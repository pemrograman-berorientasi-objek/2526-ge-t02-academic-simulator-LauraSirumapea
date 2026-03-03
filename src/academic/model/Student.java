package academic.model;

/**
 * @author 12S24057-Laura Awise 
 */
public class Student {
    private String nim;
    private String name;
    private int entranceYear; // Tahun Masuk
    private String major;     // Program Studi

    // Constructor
    public Student(String nim, String name, int entranceYear, String major) {
        this.nim = nim;
        this.name = name;
        this.entranceYear = entranceYear;
        this.major = major;
    }

    // Getters
    public String getNim() {
        return nim;
    }

    public String getName() {
        return name;
    }

    public int getEntranceYear() {
        return entranceYear;
    }

    public String getMajor() {
        return major;
    }

    // toString() untuk format output yang diminta
    @Override
    public String toString() {
        return nim + "|" + name + "|" + entranceYear + "|" + major;
    } 
}