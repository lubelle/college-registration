/*
 * Program: Selected.java
 */
package business;

public class Selected {
    private String regCode;
    private String department;
    private String courseNo;
    private String title;
    private String instructor;
    private String term;
    private String daysTimes;
    private String credits;
    private String room;
    private double cost;
    
    public Selected(){
        this.regCode = "";
        this.department = "";
        this.courseNo = "";
        this.title = "";
        this.instructor = "";
        this.term = "";
        this.daysTimes = "";
        this.credits = "";
        this.room = "";
        this.cost = 0.0;
    }

    public String getRegCode() {
        return regCode;
    }

    public void setRegCode(String regCode) {
        this.regCode = regCode;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getCourseNo() {
        return courseNo;
    }

    public void setCourseNo(String courseNo) {
        this.courseNo = courseNo;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public String getDaysTimes() {
        return daysTimes;
    }

    public void setDaysTimes(String daysTimes) {
        this.daysTimes = daysTimes;
    }

    public String getCredits() {
        return credits;
    }

    public void setCredits(String credits) {
        this.credits = credits;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    
}
