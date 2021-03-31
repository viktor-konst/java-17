package filters;

import dataBase.DBManager;
import entity.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AuthFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        HttpSession session = request.getSession(false);
        String loginURI = request.getContextPath() + "/auth";


        boolean loggedIn = session != null && session.getAttribute("userName") != null;
        boolean loginRequest = request.getRequestURI().equals(loginURI);
        if (loggedIn) {
            request.setAttribute("role", session.getAttribute("userRole"));
        }
        if (loggedIn || loginRequest) {

            chain.doFilter(request, response);
        } else {
            if (request.getRequestURI().equals("/resources/css/style.css")) {
                chain.doFilter(request, response);
            } else {
               if(loggedIn && request.getRequestURI().equals("/index.jsp")){
                   response.sendRedirect("/home");
               } else {
                   response.sendRedirect(loginURI);
               }

            }

        }
    }

    @Override
    public void destroy() {

    }
}
