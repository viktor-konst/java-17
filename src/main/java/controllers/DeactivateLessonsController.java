package controllers;

import dataBase.DBManager;
import entity.Lesson;
import entity.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
@WebServlet(name = "DeactivateLessonsController", urlPatterns = "/lessons/deactivate-lessons")
public class DeactivateLessonsController extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String[] lessonID= req.getParameterValues("selected");
        if(lessonID==null){
            req.setAttribute("message", "2");
            ArrayList<Lesson> lessons= DBManager.getAllActiveLessons();
            req.setAttribute("lessons",lessons);
            req.getRequestDispatcher("/WEB-INF/jsp/lessons.jsp").forward(req,resp);
            return;
        }
        for (String lsID: lessonID){
            DBManager.deactivateLesson(Integer.parseInt(lsID));
        }
        resp.sendRedirect("/lessons");
    }
}
