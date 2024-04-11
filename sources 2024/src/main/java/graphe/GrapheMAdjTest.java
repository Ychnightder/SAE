package main.java.graphe;

import static org.junit.jupiter.api.Assertions.*;

class GrapheMAdjTest {

        public static  void main(String[] args) {
                GrapheMAdj g = new GrapheMAdj();

                 g.ajouterSommet("A");
                 g.ajouterSommet("B");
                 g.ajouterSommet("C");
                 g.ajouterSommet("D");


                g.ajouterArc("A", "B", 5);
                g.ajouterArc("B", "C", 7);
                g.ajouterArc("C", "D", 3);
                g.ajouterArc("D", "A", 2);

                // Affichage des successeurs de chaque sommet
                System.out.println("Successeurs de A : " + g.getSucc("A"));
                System.out.println("Successeurs de B : " + g.getSucc("B"));
                System.out.println("Successeurs de C : " + g.getSucc("C"));
                System.out.println("Successeurs de D : " + g.getSucc("D"));

                // Vérification de la présence de certains arcs
                System.out.println("Arc A->B présent : " + g.contientArc("A", "B"));
                System.out.println("Arc D->C présent : " + g.contientArc("D", "C"));

                // Obtention de la valuation entre certains sommets
                System.out.println("Valuation de A->B : " + g.getValuation("A", "B"));
                System.out.println("Valuation de C->D : " + g.getValuation("C", "D"));


        }
}