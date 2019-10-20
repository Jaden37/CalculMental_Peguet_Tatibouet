package controller;

import model.ConnexionBean;
import model.HomeBean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = "/home")
public class HomeController extends HttpServlet {
    private static final String HOME_PAGE_JSP = "/WEB-INF/jsp/home.jsp";
    private static final String CONNEXION_PAGE_JSP = "/connexion";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ConnexionBean model = new ConnexionBean();
        if(model.isConnected(request)){
            HomeBean homeModel = new HomeBean();
            //on enregistre les 10 user ayant fait le meilleur score
            homeModel.getUsers();
            request.setAttribute("homeBean", homeModel);
            request.getRequestDispatcher(HOME_PAGE_JSP).forward(request, response);
            HttpSession session = request.getSession();
            //on set le nombre de question et de bonne réponse à 0 pour le prochain test de l'utilisateur
            session.setAttribute("nbQuestion",0);
            session.setAttribute("nbVictoire",0);
        }
        else {
            response.sendRedirect(request.getContextPath() + CONNEXION_PAGE_JSP);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
