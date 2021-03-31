package controllers;

import dataBase.DBManager;
import entity.Group;
import entity.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.http.HttpClient;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

@WebServlet(name = "NewStudentController", urlPatterns = "/students/new-student")
public class NewStudentController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArrayList<Group> groups=DBManager.getAllActiveGroup();
        req.setAttribute("groupList",groups);
        req.getRequestDispatcher("/WEB-INF/jsp/new-student.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       if(req.getParameter("firstname").equals("") || req.getParameter("lastname").equals("") || req.getParameter("group").equals("") || req.getParameter("date").equals("")){
              req.setAttribute("message","1");
           ArrayList<Group> groups=DBManager.getAllActiveGroup();
           req.setAttribute("groupList",groups);
           req.getRequestDispatcher("/WEB-INF/jsp/new-student.jsp").forward(req, resp);
              return;
       }
        String string = req.getParameter("date");
        DateFormat format = new SimpleDateFormat("dd-MM-yy", Locale.ENGLISH);
        Date date = null;
        try {
            date = format.parse(string);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        DateFormat formatToDB=new SimpleDateFormat("yyyy-MM-dd");
        String dateFormatToDB = formatToDB.format(date);

        DBManager.createStudent(req.getParameter("firstname"),req.getParameter("lastname"),Integer.parseInt(req.getParameter("group")),dateFormatToDB);
        resp.sendRedirect("/students");
    }
}
