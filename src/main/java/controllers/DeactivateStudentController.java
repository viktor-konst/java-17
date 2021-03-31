package controllers;

import dataBase.DBManager;
import entity.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "DeactivateStudentController", urlPatterns = "/students/deactivate")
public class DeactivateStudentController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String[] studentsID= req.getParameterValues("selected");
        if(studentsID==null){
            req.setAttribute("message", "2");
            ArrayList<Student> students= DBManager.getAllActiveStudents();
            req.setAttribute("students",students);
            req.getRequestDispatcher("/WEB-INF/jsp/students.jsp").forward(req,resp);
            return;
        }
        for (String stID: studentsID){
            DBManager.deactivateStudent(Integer.parseInt(stID));
        }
        resp.sendRedirect("/students");
    }
}
