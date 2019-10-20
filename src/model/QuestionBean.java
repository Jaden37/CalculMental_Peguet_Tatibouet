package model;

import bo.User;
import dal.DAOFactory;
import dal.UserDAOJDBC;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.DataOutput;
import java.io.Serializable;
import java.util.Stack;

public class QuestionBean implements Serializable {
    private static final String FORM_FIELD_ANSWER= "answer";
    public static final double EPSILON = 0.0001;

    private Double userAnswer;

    public Double getUserAnswer() {
        return userAnswer;
    }

    public void setUserAnswer(Double userAnswer) {
        this.userAnswer = userAnswer;
    }

    public QuestionBean() {
    }

    public void checkAnswer(HttpServletRequest request){
        System.out.println("Check answer");
        userAnswer = Double.valueOf(request.getParameter(FORM_FIELD_ANSWER));
        System.out.println("User Answer : " + userAnswer);
        HttpSession session = request.getSession();
        Stack<Double> correctAnswer = (Stack<Double>) session.getAttribute("pile");
        System.out.println("Correct Answer : " + correctAnswer);
        if (Math.abs(userAnswer - correctAnswer.pop()) < EPSILON){
            System.out.println("Résultat Correct");
            session.setAttribute("nbVictoire", (int) session.getAttribute("nbVictoire") + 1);
        }else {
            System.out.println("Résultat incorrect");
        }
        session.setAttribute("nbQuestion", (int) session.getAttribute("nbQuestion") + 1);
        System.out.println("Nombre total de question éffectué : " + session.getAttribute("nbQuestion"));
    }

    public void checkBestScore(HttpServletRequest request){
        System.out.println("Modification du user");
        HttpSession session = request.getSession();
        UserDAOJDBC dao = (UserDAOJDBC) DAOFactory.getUserDAO();
        User user = (User) session.getAttribute("isConnected");
        if(user.getBestScore() < (int) session.getAttribute("nbVictoire")){
            try {
                QuestionBean questionBean = new QuestionBean();
                user.setBestScore((Integer) session.getAttribute("nbVictoire"));
                System.out.println("id user" + user.getId());
                dao.update(user);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }
}
