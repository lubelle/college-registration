/*
 *  Project : IntegratedApp
 *  Program : InstructorServlet
 */
package controller;

import business.Transcripts;
import data.TranscriptsDB;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class InstructorServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {     
        HttpSession session = request.getSession();
        ArrayList<Transcripts> transcriptList = new ArrayList();
        String action = request.getParameter("action");
        String url = "/instructor/";         
        if (action == null){
                action = "ViewReports" ; //default action
        }       
        switch (action) {
            case "EnterGrade":   
                String instr = request.getParameter("instr");
                String termCourseNo = request.getParameter("termCourseNo");

                String term = termCourseNo.substring(0, termCourseNo.indexOf("/"));
                String courseNo = termCourseNo.substring(termCourseNo.indexOf("/")+1, termCourseNo.length());


                session.setAttribute("instr", instr);
                session.setAttribute("term",term);
                session.setAttribute("courseNo", courseNo);
                transcriptList = TranscriptsDB.enterGrade(instr, term, courseNo);
                request.setAttribute("transcriptList", transcriptList);  
                url = "/gradeInput.jsp";
                break;
            case "SaveToDB":
                term = request.getParameter("term");
                courseNo = request.getParameter("courseNo");
                //prepare the data bean, save to DB
                String regCode = request.getParameter("regCode");
                String[] studentID = request.getParameterValues("studentID");
                String[] gradePoints = request.getParameterValues("gradePoints");
                String[] letterGrade = request.getParameterValues("letterGrade");
                
                if (studentID != null){
                    for(int row=0; row < studentID.length; row++){
                        Transcripts grades = new Transcripts();
                        grades.setStudentID(studentID[row]);
                        grades.setRegCode(regCode);
                        grades.setGradePoints(Integer.parseInt(gradePoints[row]));
                        grades.setLetterGrade(letterGrade[row]);
                        TranscriptsDB.update(grades);
                    }
                    request.setAttribute("term", term);
                    request.setAttribute("courseNo", courseNo);
                    url = "/confirmation.jsp";
                }   
                break;
            case "ViewReports":
                instr = request.getParameter("instr");
                termCourseNo = request.getParameter("termCourseNo");

                term = termCourseNo.substring(0, termCourseNo.indexOf("/"));
                courseNo = termCourseNo.substring(termCourseNo.indexOf("/")+1, termCourseNo.length());
                
                session.setAttribute("instr", instr);
                session.setAttribute("term",term);
                session.setAttribute("courseNo", courseNo);
                transcriptList = TranscriptsDB.enterGrade(instr, term, courseNo);
                request.setAttribute("transcriptList", transcriptList);  
                url = "/gradeReport.jsp";
                break;                
            default:
                break;
        }
        getServletContext().
                getRequestDispatcher(url).
                forward(request, response);           
    }
}
