package main.java.graphe;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GrapheLArcsTest {

    @Test
    void testToString() {
        GrapheLArcs graphe = new GrapheLArcs();

        // Ajout de quelques arcs
        graphe.ajouterArc("A", "B", 5);
        graphe.ajouterArc("B", "C", 7);
        graphe.ajouterArc("C", "D", 3);
        graphe.ajouterArc("D", "A", 2);

        System.out.println(graphe);

    }



}