/*
 * Program: Course.java
 */
package business;

public class Course {
    private String regCode;
    private String department;
    private String courseNo;
    private String title;
    private String term;
    private String daysTimes;
    private String credits;
    private String room;
    private double cost;
    private int enrolled;
    private String instructor;
    private boolean isSelected;
    
    public Course(){
        regCode = "";
        department = "";
        courseNo = "";        
        title ="";
        term = "";
        daysTimes = "";
        credits = "";
        room = "";
        cost = 0.0;
        enrolled = 0;
        instructor = "";
        isSelected = false;
    }
    public Course(String regCode, String department, String courseNo, 
                  String title, String term, String daysTimes, 
                  String credits, String room, double cost, 
                  int enrolled, String instructor, boolean isSelected){
        this.regCode = regCode;
        this.department = department;
        this.courseNo = courseNo;
        this.title = title;
        this.term = term;
        this.daysTimes = daysTimes;
        this.credits = credits;
        this.room = room;
        this.cost = cost;
        this.enrolled = enrolled;
        this.instructor = instructor;
        this.isSelected = isSelected;
    }
    public String getRegCode(){
        return regCode;
    }
    public void setRegCode(String regCode){
        this.regCode = regCode;
    }
    public String getDepartment(){
        return department;
    }
    public void setDepartment(String department){
        this.department = department;
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
    public String getTerm(){
        return term;
    }
    public void setTerm(String term){
        this.term = term;
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
    public String getRoom(){
        return room;
    }
    public void setRoom(String room){
        this.room = room;
    }
    public double getCost(){
        return cost;
    }
    public void setCost(double cost){
        this.cost = cost;
    }
    public int getEnrolled(){
        return enrolled;
    }
    public void setEnrolled(int enrolled){
        this.enrolled = enrolled;
    }
    public String getInstructor(){
        return instructor;
    }
    public void setInstructor(String instructor){
        this.instructor = instructor;
    }
    public void isSelected(Boolean isSelected){
        this.isSelected = isSelected;
    }
    public boolean getIsSelected(){
        return isSelected;
    }
}