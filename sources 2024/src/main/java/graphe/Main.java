package main.java.graphe;

import main.java.graphe.Interface.IGraphe;
import main.java.graphe.dijkstra.Dijkstra;
import main.java.graphe.tousGraphes.GraphImporter;
//import main.java.graphe.tousGraphes.GrapheLArcs;
import main.java.graphe.tousGraphes.GrapheLArcs;
import main.java.graphe.tousGraphes.ListeAdj;
import main.java.graphe.tousGraphes.arc.Arc;

import java.util.HashMap;
import java.util.Map;

import static main.java.graphe.dijkstra.Dijkstra.dijkstra;

public class Main {
    public static void main(String[] args) {
//
//

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
//
//        GrapheLArcs l = new GrapheLArcs();
//        l.peupler("A-C(2), A-D(1), "
//                + "B-G(3), "
//                + "C-H(2), "
//                + "D-B(3), D-C(5), D-E(3), "
//                + "E-C(1), E-G(3), E-H(7), "
//                + "F:, "
//                + "G-B(2), G-F(1), "
//                + "H-F(4), H-G(2), "
//                + "I-H(10), "
//                + "J:");
//        System.out.println(l);
//
       Map<String, Integer> distance = new HashMap<>();
       Map<String, String> prev = new HashMap<>();
//
//        for (Map.Entry<String, Integer> entry : result.entrySet()) {
//            System.out.println("Distance de A a " + entry.getKey() + " est " + entry.getValue());
//        }



      IGraphe g = new GrapheLArcs();
        Arc a = GraphImporter.importer("./graphes/full/g-301-1.txt", g);
        long debut = System.nanoTime();
        Dijkstra.dijkstra(g, a.getSource(), distance, prev);
        long fin = System.nanoTime();
        HashMap<String, Integer> result = dijkstra(g, a.getSource(), distance, prev);

        System.out.println("dijkstra a dure " + (fin - debut)/1000000 + " millisecondes");


//        GrapheLArcs l = new GrapheLArcs();
//        l.peupler("A-C(2), A-D(1), "
//                + "B-G(3), "
//                + "C-H(2), "
//                + "D-B(3), D-C(5), D-E(3), "
//                + "E-C(1), E-G(3), E-H(7), "
//                + "F:, "
//                + "G-B(2), G-F(1), "
//                + "H-F(4), H-G(2), "
//                + "I-H(10), "
//                + "J:");
//
//
////        System.out.println(l);
//
//        GrapheLArcs graphe = new GrapheLArcs();
//        graphe.peupler("A-C(2), A-D(1), "
//                + "B-G(3), "
//                + "C-H(2), "
//                + "J:,"
//                + "D-B(3), D-C(5), D-E(3), "
//                + "E-C(1), E-G(3), E-H(7), "
//                + "F:, "
//                + "G-B(2), G-F(1), "
//                + "H-F(4), H-G(2), "
//                + "I-H(10), "
//                );
//
//        System.out.println(graphe);


    }
}
