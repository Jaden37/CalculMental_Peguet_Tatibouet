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
    private static final String PAGE_CONNEXION_JSP = "/WEB-INF/jsp/connexion.jsp";
    private static final String HOME_PAGE_JSP = "/";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ConnexionBean model = new ConnexionBean();
        if(model.isConnected(request)){
            response.sendRedirect(request.getContextPath() + HOME_PAGE_JSP);
        }
        else {
            request.getRequestDispatcher(PAGE_CONNEXION_JSP).forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ConnexionBean model = new ConnexionBean();
        model.authentificate(request);
        request.setAttribute("connexionBean", model);
        doGet(request, response);
    }
}
