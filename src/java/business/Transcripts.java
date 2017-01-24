/*
 * Program: Transcripts.java
 */
package business;

public class Transcripts {
    private String studentID;
    private String regCode;
    private String firstName;
    private String lastName;
    private String term;
    private String courseNo;
    private String title;
    private String instructor;
    private String daysTimes;
    private String credits;    
    private int gradePoints;
    private String letterGrade;
    
    public Transcripts(){
        studentID = "";
        regCode = "";
        firstName = "";
        lastName = "";
        term = "";
        courseNo = "";        
        title ="";
        instructor = "";
        daysTimes = "";
        credits = "";        
        gradePoints = 0;
        letterGrade = "";        
    }

    public void setStudentID(String studentID){
        this.studentID = studentID;
    }
    public void setRegCode(String regCode){
        this.regCode = regCode;
    }
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }
    public void setLastName(String lastName){
        this.lastName = lastName;
    }
    public String getStudentID(){
        return this.studentID;
    }
    public String getRegCode(){
        return this.regCode;
    }
    public String getFirstName(){
        return this.firstName;
    }
    public String getLastName(){
        return this.lastName;
    }
    public String getTerm(){
        return term;
    }
    public void setTerm(String term){
        this.term = term;
    }

    public String getCourseNo(){
        return courseNo;
    }
    public void setCourseNo(String courseNo){
        this.courseNo = courseNo;
    }    
    public String getTitle(){
        return title;
    }
    public void setTitle(String title){
        this.title = title;
    }    
    public String getInstructor(){
        return instructor;
    }
    public void setInstructor(String instructor){
        this.instructor = instructor;
    }

    public String getDaysTimes(){
        return daysTimes;
    }
    public void setDaysTimes(String daysTimes){
        this.daysTimes = daysTimes;
    }
    public String getCredits(){
        return credits;
    }
    public void setCredits(String credits){
        this.credits = credits;
    }

    public void setGradePoints(int gradePoints){
        this.gradePoints = gradePoints;
    }
    public int getGradePoints(){
        return gradePoints;
    }
    public void setLetterGrade(String letterGrade){
        this.letterGrade = letterGrade;
    }
    public String getLetterGrade(){
        return letterGrade;
    }
}
