package controller;

import bo.Expression;
import model.ConnexionBean;
import model.QuestionBean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = "/question")
public class QuestionController extends HttpServlet {
    private static final String EVALUATION_PAGE_JSP = "/WEB-INF/jsp/question.jsp";
    private static final String CONNEXION_PAGE_JSP = "/connexion";
    private static final String RESULT_PAGE_JSP = "/result";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ConnexionBean model = new ConnexionBean();
        if(model.isConnected(request)){
            HttpSession session = request.getSession();
            if((int) session.getAttribute("nbQuestion") >= 3){
                response.sendRedirect(request.getContextPath() + RESULT_PAGE_JSP);
            }
            else {
                Expression expression = new Expression();
                expression.generateExpression(3);
                request.setAttribute("expression", expression);
                session.setAttribute("pile", expression.getPile());
                request.getRequestDispatcher(EVALUATION_PAGE_JSP).forward(request, response);
            }
        }
        else {
            response.sendRedirect(request.getContextPath() + CONNEXION_PAGE_JSP);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Je suis dans le doPost");
        QuestionBean model = new QuestionBean();
        model.checkAnswer(request);
        request.setAttribute("answer", model);
        doGet(request, response);
    }
}
