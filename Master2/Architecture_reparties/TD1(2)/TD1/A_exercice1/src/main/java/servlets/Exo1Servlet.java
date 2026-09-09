package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = "/")
public class Exo1Servlet extends HttpServlet {
    final String LELOGIN = "sullivan";
    final String PASSWORD = "kiwi";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String Lelogin =  request.getParameter("login");
    String Lepassword =  request.getParameter("password");

    if(LELOGIN.equals(Lelogin) && PASSWORD.equals(Lepassword)){
        request.getSession().setAttribute("nom_personne",Lelogin);
        request.getRequestDispatcher("/WEB-INF/bonjour.jsp").forward(request, response);
    }else{
        doGet(request,response);
    }
    }
}
