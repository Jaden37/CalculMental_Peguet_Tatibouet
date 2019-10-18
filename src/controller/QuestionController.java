package controller;

import bo.Question;
import model.ConnexionBean;
import model.HomeBean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/evaluation")
public class QuestionController extends HttpServlet {
    private static final String EVALUATION_PAGE_JSP = "/WEB-INF/jsp/evaluation.jsp";
    private static final String CONNEXION_PAGE_JSP = "/connexion";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ConnexionBean model = new ConnexionBean();
        if(model.isConnected(request)){
            Question question = new Question();
            question.setLibelle("Mon opération");
            question.setResultat(2.00);
            question.getLibelle();
            question.getResultat();
            request.setAttribute("question", question);
            request.getRequestDispatcher(EVALUATION_PAGE_JSP).forward(request, response);
        }
        else {
            response.sendRedirect(request.getContextPath() + CONNEXION_PAGE_JSP);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
