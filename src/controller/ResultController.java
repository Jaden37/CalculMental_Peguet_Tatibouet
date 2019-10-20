package controller;

import bo.User;
import dal.UserDAOJDBC;
import model.ConnexionBean;
import model.QuestionBean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = "/result")
public class ResultController extends HttpServlet {
    private static final String RESULT_PAGE_JSP = "/WEB-INF/jsp/result.jsp";
    private static final String CONNEXION_PAGE_JSP = "/connexion";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ConnexionBean model = new ConnexionBean();
        HttpSession session = request.getSession();
        if(model.isConnected(request) && (int) session.getAttribute("nbQuestion") >= 10){
            request.setAttribute("nbVictoire", session.getAttribute("nbVictoire"));
            request.setAttribute("nbQuestion", session.getAttribute("nbQuestion"));
            QuestionBean questionBean = new QuestionBean();
            //on vérifie sur le score que viens de faire l'utilisateur est meilleur que son dernier score
            questionBean.checkBestScore(request);
            //dans tous les cas on enregistre le score de l'utilisateur
            questionBean.registerScore(request);
            request.getRequestDispatcher(RESULT_PAGE_JSP).forward(request, response);
        }else {
            response.sendRedirect(request.getContextPath() + CONNEXION_PAGE_JSP);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
