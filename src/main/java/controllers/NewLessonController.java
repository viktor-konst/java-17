package controllers;

import dataBase.DBManager;
import entity.Group;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "NewLessonController", urlPatterns = "/lessons/new-lesson")
public class NewLessonController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.getRequestDispatcher("/WEB-INF/jsp/new-lesson.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("lessonName").equals("")) {
            req.setAttribute("message", "1");
            req.getRequestDispatcher("/WEB-INF/jsp/new-lesson.jsp").forward(req, resp);
            return;
        }
        DBManager.createLesson(req.getParameter("lessonName"));
        resp.sendRedirect("/lessons");
    }
}
