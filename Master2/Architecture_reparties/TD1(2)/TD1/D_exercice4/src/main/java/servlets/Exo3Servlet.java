package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = {"/"})
public class Exo3Servlet extends HttpServlet {
    private String aDeviner=null;
    private StringBuilder devine=null;
    private int nbEssaisRestants;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO ce qui est fait au premier appel
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO ce qui est fait pour les appels suivants...
    }


    private void setaDeviner(String Deviner) {
        this.aDeviner=aDeviner;
        this.devine=new StringBuilder("_".repeat(aDeviner.length()));
        this.nbEssaisRestants=10;
    }

    private boolean test(char carac){
        boolean res=false;
        for (int last=0;last!=-1;last=aDeviner.indexOf(carac,last)) {
            res = true;
            devine.setCharAt(last, carac);
        }
        if (res==false) {
            nbEssaisRestants--;
        }
        return res;
    }
}
