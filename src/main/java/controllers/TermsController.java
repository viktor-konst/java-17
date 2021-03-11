package controllers;

import dataBase.DBManager;
import entity.Lesson;
import entity.Term;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "TermsController",urlPatterns = "/term-list")
public class TermsController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArrayList<Term> terms=DBManager.getAllActiveTerm();
        ArrayList<Lesson> lessons= DBManager.getAllLessonsOfTerm(6);
        req.setAttribute("lessons",lessons); req.setAttribute("terms",terms);

        req.getRequestDispatcher("/WEB-INF/jsp/term-list.jsp").forward(req,resp);
    }
}
