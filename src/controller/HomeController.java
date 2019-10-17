package controller;

import model.ConnexionBean;
import model.HomeBean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
            homeModel.getUsers();
            request.setAttribute("homeBean", homeModel);
            request.getRequestDispatcher(HOME_PAGE_JSP).forward(request, response);
        }
        else {
            response.sendRedirect(request.getContextPath() + CONNEXION_PAGE_JSP);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
