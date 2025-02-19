package academic.model;

/**
 * @author 12S23003_Chrismansyah Siahaan
 * @author 12S23015_Kevin Kristoforus Samosir
 */

public class Student {
    private String id;
    private String name;
    private int year;
    private String major;
    
    public Student(String id, String name, int year, String major) {
        this.id = id;
        this.name = name;
        this.year = year;
        this.major = major;
    }

    public String getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public int getYear() {
        return year;
    }
    public String getMajor() {
        return major;
    }
    
    @Override
    public String toString() {
        return id + "|" + name + "|" + year + "|" + major;
    }
}