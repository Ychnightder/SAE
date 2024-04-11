import main.java.graphe.GrapheLArcs;
import main.java.graphe.ListeAdj;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

@Test
public void testGetListeAdjacence() {
    GrapheLArcs g = new GrapheLArcs(); /* Initialisez votre graphe avec les données appropriées */
    g.ajouterSommet("A");
    g.ajouterSommet("B");
    g.ajouterSommet("C");
    g.ajouterArc("A", "B", 1);
    g.ajouterArc("A", "C", 1);

    ListeAdj listeAdj = new ListeAdj(g);
    String liste = listeAdj.getListeAdjacence();

    // Vérifiez le contenu de la liste d'adjacence
    assertEquals("{3,0,2,1,2,0,0,0}", liste);
}
