package main.java.graphe;

public class Main {
    public static void main(String[] args) {


        GrapheLArcs.Arc g1  = new GrapheLArcs.Arc("A", "B",7),
                        g2 = new GrapheLArcs.Arc("B" , "C ", 8 );


        System.out.println(g1);
        System.out.println(g2);
        GrapheLArcs graphe = new GrapheLArcs();
        graphe.ajouterArc("A", "B",4);
        graphe.ajouterArc("c", "d",5);
        graphe.ajouterArc("k", "r",8);
        System.out.println(graphe);

        ListeAdj l = new ListeAdj(graphe);
        System.out.println(l);



    }
}
