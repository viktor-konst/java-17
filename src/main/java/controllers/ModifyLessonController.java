package controllers;

import dataBase.DBManager;
import entity.Group;
import entity.Lesson;
import entity.Student;

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
@WebServlet(name ="ModifyLessonController", urlPatterns = "/lessons/modify-lesson")
public class ModifyLessonController extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String lessonId = req.getParameter("selected");
        if(lessonId==null){
            req.setAttribute("message", "1");
            ArrayList<Lesson> lessons= DBManager.getAllActiveLessons();
            req.setAttribute("lessons",lessons);
            req.getRequestDispatcher("/WEB-INF/jsp/lessons.jsp").forward(req,resp);
            return;
        }
        if(req.getParameter("lessonName")==(null)){
            Lesson lesson=DBManager.getThisLesson(lessonId);
            req.setAttribute("lesson",lesson);
            req.getRequestDispatcher("/WEB-INF/jsp/modify-lesson.jsp").forward(req, resp);
            return;
        }
        if(req.getParameter("lessonName").equals("")){
            req.setAttribute("message","2");
            Lesson lesson=DBManager.getThisLesson(lessonId);
            req.setAttribute("lesson",lesson);
            req.getRequestDispatcher("/WEB-INF/jsp/modify-lesson.jsp").forward(req, resp);
            return;
        }
        DBManager.modifyLesson(lessonId,req.getParameter("lessonName"));
        resp.sendRedirect("/lessons");

    }}
