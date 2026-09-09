package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = "/")
public class Exo2Servlet extends HttpServlet {
    private final String[] options={"Beau","Couvert","Pluie","Neige"};

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        toJsp(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        toJsp(request,response);
    }

    private void toJsp(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("options",options);
        request.getRequestDispatcher("WEB-INF/meteo.jsp").forward(request,response);
    }
}
