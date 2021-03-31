package controllers;

import dataBase.DBManager;
import entity.Group;
import entity.Student;
import entity.StudentProgress;
import entity.Term;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

@WebServlet( name = "ModifyStudentController", urlPatterns = "/students/modify_student")
public class ModifyStudentController extends HttpServlet {
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
        if(req.getParameter("firstname")==(null)){
            Student student = DBManager.getThisStudent(Integer.parseInt(studentId));
            ArrayList<Group> groups=DBManager.getAllActiveGroup();
            req.setAttribute("groups",groups);
            req.setAttribute("student", student);
            req.getRequestDispatcher("/WEB-INF/jsp/modify-student.jsp").forward(req, resp);
            return;
        }
        if(req.getParameter("firstname").equals("") || req.getParameter("lastname").equals("") || req.getParameter("group").equals("") || req.getParameter("date").equals("")){
            req.setAttribute("message","2");
            ArrayList<Group> groups=DBManager.getAllActiveGroup();
            req.setAttribute("groupList",groups);
            req.getRequestDispatcher("/WEB-INF/jsp/modify-student.jsp").forward(req, resp);
            return;
        }
        String string = req.getParameter("date");
        DateFormat format = new SimpleDateFormat("dd/MM/yy", Locale.ENGLISH);
        Date date = null;
        try {
            date = format.parse(string);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        DateFormat formatToDB=new SimpleDateFormat("yyyy-MM-dd");
        String dateFormatToDB = formatToDB.format(date);

        DBManager.modifyStudent(Integer.parseInt(studentId),req.getParameter("firstname"),req.getParameter("lastname"),Integer.parseInt(req.getParameter("group")),dateFormatToDB);
        resp.sendRedirect("/students");




    }
}
