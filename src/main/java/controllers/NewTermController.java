package controllers;

import dataBase.DBManager;
import entity.Group;
import entity.Lesson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "NewTermController", urlPatterns = "/term-list/new-term")
public class NewTermController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            ArrayList<Lesson> lessons = DBManager.getAllActiveLessons();
            req.setAttribute("lessons",lessons);
            req.getRequestDispatcher("/WEB-INF/jsp/new-term.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name= req.getParameter("termName");
       String duration= req.getParameter("duration");
       String[] idOfLessons =req.getParameterValues("lessons");
       if(name.equals("") || duration.equals("")|| idOfLessons.length==0){
           ArrayList<Lesson> lessons = DBManager.getAllActiveLessons();
           req.setAttribute("lessons",lessons);
           req.setAttribute("message","1");
           req.getRequestDispatcher("/WEB-INF/jsp/new-term.jsp").forward(req, resp);
           return;
       }
       ArrayList<Lesson> lessonsID= new ArrayList<>();
       for(String idOflsn: idOfLessons){
           Lesson lesson = new Lesson();
           lesson.setId(Integer.parseInt(idOflsn));
           lessonsID.add(lesson);
       }
       DBManager.addNewTerm(name,duration,lessonsID);
       resp.sendRedirect("/term-list");
    }
}
