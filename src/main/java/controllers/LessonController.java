package controllers;

import dataBase.DBManager;
import entity.Lesson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "LessonController", urlPatterns = "/lessons")
public class LessonController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArrayList<Lesson> lessons= DBManager.getAllActiveLessons();
        req.setAttribute("lessons",lessons);
        req.getRequestDispatcher("/WEB-INF/jsp/lessons.jsp").forward(req,resp);
    }
}
