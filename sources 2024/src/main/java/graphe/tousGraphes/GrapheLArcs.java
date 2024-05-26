package main.java.graphe.tousGraphes;

import main.java.graphe.tousGraphes.arc.Arc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class GrapheLArcs extends Graphe {
    private List<String> sommets;
    private List<Arc> listeArc;

    public GrapheLArcs() {
        sommets = new ArrayList<>();
        listeArc = new ArrayList<>();
    }


@Override
public String toString() {
    StringBuilder sb  = new StringBuilder();
    Collections.sort(sommets);
    boolean ajout = false;
    int i=0;
    int compteur_nombre_arcs = 0;
    for(String noeud : getSommets()){
        i=0;
        ajout= false;

        for(; i<listeArc.size(); ++i ){

            if(listeArc.get(i).getSource().compareTo(noeud) == 0){
                sb.append(noeud);
                sb.append("-");
                sb.append(listeArc.get(i).getDestination());
                sb.append("(");
                sb.append(getValuation(listeArc.get(i).getSource(), listeArc.get(i).getDestination()));
                sb.append(")");

                if( compteur_nombre_arcs <= listeArc.size() )
                    sb.append(", ");
                ajout=true;
                ++compteur_nombre_arcs;
            }
        }
        if(!ajout){
            sb.append(noeud);
            sb.append(":");
            if (compteur_nombre_arcs <= listeArc.size() ) {
                sb.append(", ");
            }
            ++compteur_nombre_arcs;

        }

    }

    if (sb.length() > 0 && sb.charAt(sb.length() - 2) == ',') {
        sb.delete(sb.length() - 2, sb.length());
    }


    return sb.toString();
}










    @Override
    public void ajouterSommet(String noeud) {
        if (!sommets.contains(noeud)) {
            sommets.add(noeud);
        }
    }


    @Override
    public void ajouterArc(String source, String destination, Integer valeur) {
        if (valeur < 0) {
            throw new IllegalArgumentException("La valuation ne peut pas être négative.");
        }
        if (!sommets.contains(source)) {
            sommets.add(source);
        }
        if (!sommets.contains(destination)) {
            sommets.add(destination);
        }
        if (contientArc(source, destination)) {
            throw new IllegalArgumentException("L'arc  existe déjà");
        }
        if (!contientArc(source, destination)) {
            Arc arc = new Arc(source, destination, valeur);
            listeArc.add(arc);
            listeArc.sort(Comparator.comparing(Arc::getSource).thenComparing(Arc::getDestination));
        }



    }




    @Override
    public void oterSommet(String noeud) {
        if (sommets.contains(noeud)) {
            sommets.remove(noeud);
            listeArc.removeIf(arc -> arc.getSource().equals(noeud) || arc.getDestination().equals(noeud));

        }
    }

    @Override
    public void oterArc(String source, String destination) {
        for(int i = 0; i < listeArc.size(); ++i){
            if(listeArc.get(i).getSource().compareTo(source) == 0 && listeArc.get(i).getDestination().compareTo(destination) == 0){
                listeArc.remove(i);
                return;
            }

        }
        throw new IllegalArgumentException();
    }

    @Override
    public List<String> getSommets() {
        return new ArrayList<>(sommets);
    }

    @Override
    public List<String> getSucc(String sommet) {
        List<String> successeurs = new ArrayList<>();
        for (Arc arc : listeArc) {
            if (arc.getSource().equals(sommet)) {
                successeurs.add(arc.getDestination());
            }
        }

        return successeurs;
    }

    @Override
    public int getValuation(String src, String dest) {
        for (Arc arc : listeArc) {
        if (arc.getSource().equals(src) && arc.getDestination().equals(dest)) {
            return arc.getValuation();
        }
    }
       throw new IllegalArgumentException("L'arc n'existe pas ");
    }

    @Override
    public boolean contientSommet(String sommet) {
        return sommets.contains(sommet);
    }

    @Override
    public boolean contientArc(String src, String dest) {
        for (Arc Arc : listeArc) {
            if (src.equals(Arc.getSource()) && dest.equals(Arc.getDestination())) {
                return true;
            }
        }
        return false;
    }
}

