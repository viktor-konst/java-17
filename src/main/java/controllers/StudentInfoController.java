package controllers;

import dataBase.DBManager;
import entity.Lesson;
import entity.Student;
import entity.StudentProgress;
import entity.Term;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "StudentInfoController", urlPatterns = "/student-info")
public class StudentInfoController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String studentId = req.getParameter("selected");
        if(studentId==null){
        req.setAttribute("message", "1");
            ArrayList<Student> students= DBManager.getAllActiveStudents();
            req.setAttribute("students",students);
            req.getRequestDispatcher("/WEB-INF/jsp/students.jsp").forward(req,resp);
            return;
        }
        Student student = DBManager.getThisStudent(Integer.parseInt(studentId));

        ArrayList<Term> terms= DBManager.getAllActiveTerm();
        Term defaultTerm;
        if(req.getParameter("termID")==null){
            defaultTerm = terms.get(0);
        } else {
             defaultTerm =DBManager.getThisTerm(Integer.parseInt(req.getParameter("termID")));
        }
        req.setAttribute("defaultTerm",defaultTerm);

        req.setAttribute("student", student);
        ArrayList<StudentProgress> studentProgress = DBManager.getThisStudentProgress(Integer.parseInt(studentId), defaultTerm.getId());
        double sumOfmarks=0;
        int quantity=0;
        double averageMark=0;
        for (StudentProgress stpr: studentProgress){
            if (stpr.getMark()>0){

               quantity++;
            }sumOfmarks=sumOfmarks+stpr.getMark();
        }
        if (quantity>0){
            averageMark=sumOfmarks/quantity;
        }

        req.setAttribute("averageMark",averageMark);
        req.setAttribute("terms", terms);
        req.setAttribute("studentProgress", studentProgress);
        req.getRequestDispatcher("/WEB-INF/jsp/this-student.jsp").forward(req, resp);
    }
}
