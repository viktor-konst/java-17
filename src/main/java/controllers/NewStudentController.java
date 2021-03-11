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
import java.util.ArrayList;

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
       req.setCharacterEncoding("UTF-8");
        DBManager.createStudent(req.getParameter("firstname"),req.getParameter("lastname"),Integer.parseInt(req.getParameter("group")),req.getParameter("date"));
        resp.sendRedirect("/students");
    }
}
