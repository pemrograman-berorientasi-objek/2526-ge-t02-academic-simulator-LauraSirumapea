package academic.model;

/**
 * @laura 12S24057 - Laura Awise

 */
// File: academic/model/Course.java

public class Course {
    private String code;
    private String name;
    private int credits; // SKS
    private String passingGrade; // Grade nilai akhir, contoh: A, B, C, D, E

    // Constructor
    public Course(String code, String name, int credits, String passingGrade) {
        this.code = code;
        this.name = name;
        this.credits = credits;
        this.passingGrade = passingGrade;
    }

    // Getters
    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public int getCredits() {
        return credits;
    }

    public String getPassingGrade() {
        return passingGrade;
    }

    // toString() untuk format output yang diminta
    @Override
    public String toString() {
        return code + "|" + name + "|" + credits + "|" + passingGrade;
    } 
} 