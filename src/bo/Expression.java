package bo;

import java.util.Random;
import java.util.Stack;
import java.util.concurrent.ThreadLocalRandom;

public class Expression {
    private static String binaires[] = {"+", "-", "*", "/"};
    private static String unaires[] = {"inv", "rac"};
    private Stack<Double> pile;
    private String chaineCalcul;
    private Boolean first;

    public String getChaineCalcul() {
        return chaineCalcul;
    }

    public void setChaineCalcul(String chaineCalcul) {
        this.chaineCalcul = chaineCalcul;
    }

    public Stack<Double> getPile() {
        return pile;
    }

    public void setPile(Stack<Double> pile) {
        this.pile = pile;
    }

    public Expression() {
        pile = new Stack<>();
        chaineCalcul = "";
        first = true;
    }

//    retourne un double aléatoire
    public Double random(Double min, Double max) {
        return ThreadLocalRandom.current().nextDouble(min, max);
    }

//    retourne un int aléatoire
    public int random(int min, int max) {
        Random r = new Random();
        return r.nextInt(max - min) + min;
    }
//  séléctionne une opération unaire au hasard
    public void randomUnaire() {
        Double temp = pile.pop();
        if(random(0,10) > 5){
            System.out.println("Calcul de l'inverse  : " + temp);
//            chaineCalcul = chaineCalcul + "(1/" + temp + ")";
            chaineCalcul = "(1/" + chaineCalcul + ")";
            temp = 1 / temp;
        }else {
            System.out.println("Calcul de la racine  : " + temp);
//            chaineCalcul = chaineCalcul + "(racine(" + temp + "))";
            chaineCalcul = "(racine(" + chaineCalcul + "))";
            temp = Math.sqrt(temp);
        }
        pile.push(temp);
    }

//    ajoute un nombre dans la pile
    public void randomPush(){
        Double r = random(0.0, 100.0);
//      on arrondi le nombre à 2 chiffres après la virgule
        r = Math.floor(r * 100) / 100;
        pile.push(r);
        System.out.println("Ajout d'un nombre dans la pile : " + r);
        if(first){
            chaineCalcul = "" + r + "";
            first = false;
        }
    }

    public void randomBinaire(){
//        dernier élément inséré de ma pile
        Double temp1 = pile.pop();
//        premier élément inséré dans ma pile (ou résultat de plusieurs calculs précedent)
        Double temp2 = pile.pop();
        int r = random(0,4);
        switch (r)
        {
            case 0:
                System.out.println("Addition de : " + temp2 + " avec " + temp1);
                chaineCalcul = "(" + chaineCalcul + " + " + temp1 + ")";
                temp1 = temp2 + temp1;
                break;
            case 1:
                System.out.println("Soustraction de : " + temp2 + " avec " + temp1);
                chaineCalcul = "(" + chaineCalcul + " - " + temp1 + ")";
                temp1 = temp2 - temp1;
                break;
            case 2:
                System.out.println("Multiplication de : " + temp2 + " avec " + temp1);
                chaineCalcul = "(" + chaineCalcul + " * " + temp1 + ")";
                temp1 = temp2 * temp1;
                break;
            case 3:
                System.out.println("Division de : " + temp2 + " avec " + temp1);
                chaineCalcul = "(" + chaineCalcul + " / " + temp1 + ")";
                temp1 = temp2 / temp1;
                break;
        }
        pile.push(temp1);
    }

    public void generateExpression(int length) {
//      on met un premier chiffre dans la pile
        randomPush();
//      en fonction de la longueur souhaité de la pile
        for (int i = 0; i < length; i++) {
            System.out.println("Dans la boucle");
//            si la pile contient un seul élément
            if (pile.size() == 1) {
                System.out.println("La pile contient 1 élément");
//                si c'est le dernier parcour de la boucle on ne rajoute pas de nombre dans la pile
                if(i == length -1 ){
                    randomUnaire();
                }else {
                    //on tire au hasard : rajouter un nombre OU effectuer une opération avec un unaire
                    if (random(0, 10) > 5) {
                        randomPush();
                    } else {
                        //on tire au hasard le type d'unaire choisi
                        randomUnaire();
                    }
                }
            } else if (pile.size() >= 2) {
                System.out.println("La pile contient " + pile.size() + " élément");
                //  si c'est le dernier parcour de la boucle on ne rajoute pas de nombre dans la pile
                if(i == length -1 ){
                    randomBinaire();
                }else {
                    int r = random(0,10);
                    if (r < 5){
                        //on tire au hasard le type d'unaire choisi
                        randomUnaire();
                    }else {
                        randomBinaire();
                    }
                }
            }
        }
        System.out.println("--------------FIN DE LA GENERATION--------------");
    }
}