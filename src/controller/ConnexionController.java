package controller;

import model.ConnexionBean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/connexion")
public class ConnexionController extends HttpServlet {
    private static final String CONNEXION_PAGE_JSP = "/WEB-INF/jsp/connexion.jsp";
    private static final String HOME_PAGE_JSP = "/";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // si la connexion à déjà été établie, on accède directement à la home page
        ConnexionBean model = new ConnexionBean();
        if(model.isConnected(request)){
            response.sendRedirect(request.getContextPath() + HOME_PAGE_JSP);
        }
        // sinon on est redirigé sur la page de connexion
        else {
            request.getRequestDispatcher(CONNEXION_PAGE_JSP).forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // lors de la validation du formulaire de connexion on vérifie l'extience des données en base
        // on appelle ensuite la fonction doGet() qui redirigera vers la page correspondante
        ConnexionBean model = new ConnexionBean();
        model.authentificate(request);
        request.setAttribute("connexionBean", model);
        doGet(request, response);
    }
}
