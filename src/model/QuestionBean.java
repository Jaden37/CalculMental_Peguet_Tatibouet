package model;

import bo.Resultat;
import bo.User;
import dal.DAOFactory;
import dal.ResultatDAOJDBC;
import dal.UserDAOJDBC;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.DataOutput;
import java.io.Serializable;
import java.sql.ResultSet;
import java.util.Date;
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
        //test pour valider le résultat de l'utilisateur, il peux rentrer une valeur arrondi à 0.0001 près
        //ce test à du être mis en place ) cause de la conversion et de l'arrondi de l'ordinateur des valeurs
        //et surtout à la longeur des résultat fournis
        if (Math.abs(userAnswer - correctAnswer.pop()) < EPSILON){
            System.out.println("Résultat Correct");
            //si le résultat est correct on incrémente de 1 le nombre de bonnes
            session.setAttribute("nbVictoire", (int) session.getAttribute("nbVictoire") + 1);
        }else {
            System.out.println("Résultat incorrect");
        }
        //dans tous les cas on incrémente de 1 le nombre de question traitée
        session.setAttribute("nbQuestion", (int) session.getAttribute("nbQuestion") + 1);
        System.out.println("Nombre total de question éffectué : " + session.getAttribute("nbQuestion"));
    }

    public void checkBestScore(HttpServletRequest request){
        System.out.println("Modification du user");
        HttpSession session = request.getSession();
        UserDAOJDBC dao = (UserDAOJDBC) DAOFactory.getUserDAO();
        User user = (User) session.getAttribute("isConnected");
        //on regarde si le score que viens de faire l'utilisateur est supérieur ) son ancien bestScore
        if(user.getBestScore() < (int) session.getAttribute("nbVictoire")){
            try {
                user.setBestScore((Integer) session.getAttribute("nbVictoire"));
                System.out.println("id user" + user.getId());
                //si oui on enregistre ce résultat dans la BDD
                dao.update(user);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void registerScore(HttpServletRequest request){
        //a la fin du test on enregistre le score de l'utilisateur en créant un nouveaux résultat
        System.out.println("Enregistrement du score de l'utilisateur");
        HttpSession session = request.getSession();
        ResultatDAOJDBC dao = (ResultatDAOJDBC) DAOFactory.getResultatDAO();
        User user = (User) session.getAttribute("isConnected");
        Resultat resultat = new Resultat();
        resultat.setScore((int) session.getAttribute("nbVictoire"));
        java.util.Date date = new Date();
        resultat.setDateHeure(new java.sql.Timestamp(date.getTime()));
        resultat.setIdUser(user.getId());
        try {
            dao.create(resultat);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
