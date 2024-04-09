package main.java.graphe;

import static org.junit.jupiter.api.Assertions.*;

class GrapheLArcsTest {

    public class TestGrapheLArcs {
        public static void main(String[] args) {
            // Création d'un graphe
            GrapheLArcs graphe = new GrapheLArcs();

            // Ajout de quelques arcs
            graphe.ajouterArc("A", "B", 5);
            graphe.ajouterArc("B", "C", 7);
            graphe.ajouterArc("C", "D", 3);
            graphe.ajouterArc("D", "A", 2);

            // Affichage des arcs ajoutés
            System.out.println("Arcs du graphe : " + graphe);

            // Affichage des sommets
            System.out.println("Sommets du graphe : " + graphe.getSommets());

            // Affichage des successeurs de chaque sommet
            System.out.println("Successeurs de A : " + graphe.getSucc("A"));
            System.out.println("Successeurs de B : " + graphe.getSucc("B"));
            System.out.println("Successeurs de C : " + graphe.getSucc("C"));
            System.out.println("Successeurs de D : " + graphe.getSucc("D"));

            // Obtention de la valuation entre certains sommets
            System.out.println("Valuation de A->B : " + graphe.getValuation("A", "B"));
            System.out.println("Valuation de C->D : " + graphe.getValuation("C", "D"));

            // Vérification de la présence de certains arcs
            System.out.println("Arc A->B présent : " + graphe.contientArc("A", "B"));
            System.out.println("Arc D->C présent : " + graphe.contientArc("D", "C"));

            // Tentative d'ajout d'un arc avec une valuation négative
            try {
                graphe.ajouterArc("A", "E", -4); // Valeur négative
            } catch (IllegalArgumentException e) {
                System.out.println("Erreur : " + e.getMessage());
            }
        }
    }


}