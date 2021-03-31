package controllers;

import dataBase.DBManager;
import entity.Group;
import entity.Lesson;
import entity.Term;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "ModifyTermController", urlPatterns = "/term-list/modify-term")
public class ModifyTermController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String termID=req.getParameter("termID");
        if(req.getParameter("termName")==null){
            ArrayList<Lesson> lessons= DBManager.getAllActiveLessons();
            Term term =DBManager.getThisTerm(Integer.parseInt(termID));
            ArrayList<Lesson> lessonsOfTerm=DBManager.getAllLessonsOfTerm(Integer.parseInt(termID));

            req.setAttribute("term",term);
            req.setAttribute("lessons",lessons);
            req.setAttribute("lessonsOfTerm",lessonsOfTerm);
            req.getRequestDispatcher("/WEB-INF/jsp/modify-term.jsp").forward(req,resp);
            return;
        }
        if(req.getParameter("termName").equals("") || req.getParameter("duration").equals("") || req.getParameter("lessons").equals("")){
            req.setAttribute("message","1");
            ArrayList<Lesson> lessons= DBManager.getAllActiveLessons();
            Term term =DBManager.getThisTerm(Integer.parseInt(termID));
            ArrayList<Lesson> lessonsOfTerm=DBManager.getAllLessonsOfTerm(Integer.parseInt(termID));
            req.setAttribute("term",term);
            req.setAttribute("lessons",lessons);
            req.setAttribute("lessonsOfTerm",lessonsOfTerm);
            req.getRequestDispatcher("/WEB-INF/jsp/modify-term.jsp").forward(req,resp);
            return;
        }
        DBManager.deactivateTerm(Integer.parseInt(termID));
        String name= req.getParameter("termName");
        String duration= req.getParameter("duration");
        String[] idOfLessons =req.getParameterValues("lessons");
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
