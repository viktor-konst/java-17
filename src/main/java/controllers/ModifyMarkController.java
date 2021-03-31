package controllers;

import dataBase.DBManager;
import entity.StudentProgress;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ModifyMarkController", urlPatterns = "/student-info/modify-mark")
public class ModifyMarkController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


       String[] mark= req.getParameterValues("marks");
       String[] spID= req.getParameterValues("selectedMark");
       for (int i=0; i<spID.length;i++){
           DBManager.modifyThisMark(Integer.parseInt(spID[i]),Integer.parseInt(mark[i]));
       }

       resp.sendRedirect("/students");
    }
}
