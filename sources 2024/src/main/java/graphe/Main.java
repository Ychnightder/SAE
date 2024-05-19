package main.java.graphe;

import main.java.graphe.tousGraphes.ListeAdj;

import java.util.HashMap;
import java.util.Map;

import static main.java.graphe.dijkstra.Dijkstra.dijkstra;

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

//       ListeAdj l = new ListeAdj();
//        l.ajouterSommet("A");
//        l.ajouterSommet("B");
//        l.ajouterSommet("C");
//        l.ajouterArc("A", "B",18);
//        l.ajouterArc("C", "B",18);
//        l.ajouterArc("C", "A",18);
//        l.ajouterArc("B", "B",18);
//
//        System.out.println(l);

        ListeAdj l = new ListeAdj();
        l.peupler("A-C(2), A-D(1), "
                + "B-G(3), "
                + "C-H(2), "
                + "D-B(3), D-C(5), D-E(3), "
                + "E-C(1), E-G(3), E-H(7), "
                + "F:, "
                + "G-B(2), G-F(1), "
                + "H-F(4), H-G(2), "
                + "I-H(10), "
                + "J:");
        System.out.println(l);

        Map<String, Integer> distance = new HashMap<>();
        Map<String, String> prev = new HashMap<>();
        HashMap<String, Integer> result = dijkstra(l, "A", distance, prev);

        for (Map.Entry<String, Integer> entry : result.entrySet()) {
            System.out.println("Distance de A a " + entry.getKey() + " est " + entry.getValue());
        }
    }
}
