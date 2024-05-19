package main.java.graphe;

import java.util.ArrayList;
import java.util.List;

public class ListeAdj extends Graphe {

    GrapheLArcs g;
    GrapheLArcs.Arc arc ;
    private int nbSommet;
    int tailleSommet;

    public ListeAdj( GrapheLArcs g){
        this.g = g;
        this.nbSommet = g.gettaille();
        this.tailleSommet  = g.gettaillelistesommet() ;

    }

    public String toString(){
        StringBuilder sb = new  StringBuilder("{");
        sb.append(nbSommet);
        sb.append(",");
        for (int i = 0; i < tailleSommet;  ++i) {
            sb.append(g.getSommets().get(i));// ici on a eu faux quand on a mit indexof ça retourne l'index et non la valeur
            String sommet = g.getSommets().get(i);
            sb.append(",");
            sb.append(g.gettaillesucc(sommet));
            sb.append(",");
            for (int j = 0; j < g.gettaillesucc(sommet); ++j) {
                sb.append(g.getSucc(sommet).get(j));
            }

            if( i >=  tailleSommet-1 ){
                sb.append("");
            }
            else {
                sb.append(",");
            }
        }
        sb.append("}");
        return sb.toString();
    }


























    @Override
    public void ajouterSommet(String noeud) {}

    @Override
    public void ajouterArc(String source, String destination, Integer valeur) {}

    @Override
    public void oterSommet(String noeud) {

    }

    @Override
    public void oterArc(String source, String destination) {

    }

    @Override
    public List<String> getSommets() {
        return List.of();
    }

    @Override
    public List<String> getSucc(String sommet) {
        return List.of();
    }

    @Override
    public boolean contientSommet(String sommet) {
        return false;
    }

    @Override
    public boolean contientArc(String src, String dest) {
        return false;
    }

    @Override
    public int getValuation(String src, String dest) {
        return 0;
    }

}


