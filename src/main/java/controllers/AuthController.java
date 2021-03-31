package controllers;

import dataBase.DBManager;
import entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "AuthController" , urlPatterns = "/auth")
public class AuthController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/index.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("username");
        String password = req.getParameter("password");


        HttpSession session = req.getSession();


        if (password == "" || userName == "") {
            req.setAttribute("message", "3");
            req.getRequestDispatcher("/index.jsp").forward(req, resp);


        } else {
            User user = DBManager.getThisUser(userName);
            if(user.getLogin() == null){
                req.setAttribute("message", "3");
                req.getRequestDispatcher("/index.jsp").forward(req, resp);
                return;
            }
            if(!password.equals(user.getPassword())){
                req.setAttribute("message", "3");
                req.getRequestDispatcher("/index.jsp").forward(req, resp);
                return;
            }

                session.setAttribute("userName", user.getLogin());
                session.setAttribute("userRole", user.getRoles().get(0).getRole());

                resp.sendRedirect("/home");



        }
    }
}
