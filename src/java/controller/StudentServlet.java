/*
 * Project: IntegratedApp
 * Program: StudentServlet
 */
package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

import business.Course;
import business.Selected;
import business.Transcripts;
import data.CourseDB;
import data.SelectionDB;
import data.TranscriptsDB;
import javax.servlet.http.HttpSession;

public class StudentServlet extends HttpServlet { 
    
    public static final int MAX_NUM_STUDENT = 10;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request,response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
               
        ArrayList<Course> courseListing = new ArrayList();
        ArrayList<Selected> selectedList = new ArrayList();
        String message = "";
        String url = "";
        String action = request.getParameter("action"); 
        String studentID = request.getParameter("sid");
        String department = request.getParameter("dept");
        String semester = request.getParameter("semester");
        
        HttpSession session = request.getSession();
        session.setAttribute("studentID", studentID);
        session.setAttribute("department",department);
        session.setAttribute("semester", semester);

        if (action==null || action.equals("")){
            action = "View";   //default action
        }        

        switch (action) {
            case "Preview":
                courseListing = CourseDB.CourseListingGeneral(semester);
                request.setAttribute("courseListingGeneral", courseListing);
                request.setAttribute("current_semester", semester);
                url = "/courseOffered.jsp";
                break;
            case "View":     
                studentID = request.getParameter("sid");
                department = request.getParameter("dept");
                semester = request.getParameter("semester");
                courseListing = CourseDB.CourseListing(semester, department);
                request.setAttribute("sid", studentID);
                session.setAttribute("courseListing", courseListing);
                url = "/courseListing.jsp";
                break;
            case "EnterNewSelection":               
                studentID = request.getParameter("sid");
                department = request.getParameter("dept");
                semester = request.getParameter("semester");  
                courseListing = CourseDB.CourseListing(semester, department);
                int numOfStudent = 0;
                
                //delete "RegCode" from table transcripts_ and update "Enrolled" in table course_
                SelectionDB.clearSelected(semester, studentID); 
                
                //process selected[status.count]
                String[] selected = request.getParameterValues("selected");  
                if (selected != null) {
                    for (int i = 0; i < selected.length; i++)
                    {
                        int index = Integer.parseInt(selected[i])-1;
                        String code = courseListing.get(index).getRegCode();
                        Transcripts transcripts = new Transcripts();
                        transcripts.setStudentID(studentID);
                        transcripts.setRegCode(code);
                        numOfStudent = CourseDB.getEnrolled(code).getEnrolled();
                        if(  numOfStudent < MAX_NUM_STUDENT ){
                                //insert "RegCode" in table transcripts_ and update "Enrolled" in table course_
                                TranscriptsDB.insert(transcripts);
                                CourseDB.updateEnrolledPlusOne(code);
                        }
                    }   
                }               
                selectedList = SelectionDB.getSelected(semester, studentID);
                request.setAttribute("selectedList", selectedList);
                url = "/selectionResult.jsp";                
                break;                
                
            case "ViewPrevious":
                studentID = request.getParameter("sid");
                department = request.getParameter("dept");
                semester = request.getParameter("semester");
                selectedList = SelectionDB.getSelected(semester, studentID);
                request.setAttribute("selectedList", selectedList);
                url = "/selectionResult.jsp";    
                break;
        }
        getServletContext().
                getRequestDispatcher(url).
                forward(request, response);           
    }
}