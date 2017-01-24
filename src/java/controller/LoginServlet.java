/*
 * Project : IntegratedApp
 * Program : LoginServlet
 */
package controller;

import data.UserDB;
import java.io.IOException;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {
    public static final String CURRENT_SEMESTER = "Winter_2015";
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            
            String url = "/login.jsp";
            
            //get current action
            String action = request.getParameter("action");
            if (action == null){
                action = "verify";  //default action
            }
            
            //perform action and set URL to appropriate page
            if (action.equals("verify")){
                url = "/login.jsp";  //the "login" page
            }
            else if (action.equals("register")){
                //get parameters from the request
                String userName = request.getParameter("userName");
                String password = request.getParameter("password");
                String message="";
                HttpSession session = request.getSession();
               
                if (UserDB.isStudent(userName, password)){
                    //student menu
                    session.setAttribute("studentID", userName);                   
                    url = "/student/";                    
                } else if (UserDB.isInstructor(userName, password)){
                    //instructor menu
                    session.setAttribute("facultyName", userName);
                    url = "/instructor/";
                } else {
                    //can't find the user
                    message = "Invalid entry!";
                    url = "/login.jsp";
                }
                request.setAttribute("message",message);                
            }
            getServletContext()
                    .getRequestDispatcher(url)
                    .forward(request,response);
    }
}
