package main.java.graphe;

import main.java.graphe.tousGraphes.ListeAdj;

public class Main {
    public static void main(String[] args) {
//
//
//        GrapheLArcs.Arc g1  = new GrapheLArcs.Arc("A", "B",7),
//                        g2 = new GrapheLArcs.Arc("B" , "C ", 8 );
//
//
//        System.out.println(g1);
//        System.out.println(g2);
//        GrapheLArcs graphe = new GrapheLArcs();
//        graphe.ajouterArc("A", "B",4);
//        graphe.ajouterArc("c", "d",5);
//        graphe.ajouterArc("k", "r",8);
//        System.out.println(graphe);

        ListeAdj l = new ListeAdj();
        l.ajouterSommet("A");
        l.ajouterSommet("B");
        l.ajouterSommet("C");
        l.ajouterArc("A", "B",18);
        l.ajouterArc("C", "B",18);
        l.ajouterArc("C", "A",18);
        l.ajouterArc("B", "B",18);



        System.out.println(l);
    }
}
