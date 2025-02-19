package academic.model;

/**
 * @author 12S23003_Chrismansyah Siahaan
 * @author 12S23015_Kevin Kristoforus Samosir
 */
public class Course {
    private String code;
    private String course_name;
    private int credits;
    private String grade;

    public Course(String code, String course_name, int credits, String grade) {
        this.code = code;
        this.course_name = course_name;
        this.credits = credits;
        this.grade = grade;
    }
    
    public String getCode() {
        return code;
    }
    public String getName() {
        return course_name;
    }
    public int getCredits() {
        return credits;
    }
    public String getGrade() {
        return grade;
    }

    
    @Override
    public String toString() {
    return code + "|" + course_name + "|" + credits + "|" + grade;
    }
}
