package controllers;

import dataBase.DBManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DeactivateTermController",urlPatterns = "/term-list/deactivate_term")
public class DeactivateTermController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String termID=req.getParameter("termID");
        DBManager.deactivateTerm(Integer.parseInt(termID));
        resp.sendRedirect("/term-list");
    }
}
