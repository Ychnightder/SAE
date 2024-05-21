package main.java.graphe.tousGraphes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ListeAdj extends Graphe {
//                   sommet   +  sommetDestination et valeur
    private HashMap < String ,   HashMap<String,     Integer> > ListAdj;

    public ListeAdj(){
        this.ListAdj = new HashMap<>();
    }

    public String toString(){
       StringBuilder sb = new  StringBuilder();
        List<String> sommets = getSommets();
        boolean premier = true;

            for (String sommetCourant : sommets){
                if (!premier){
                    sb.append(", ");
                }
                else{
                    premier = false;
                }
               List<String> listSucc = getSucc(sommetCourant);
                if (listSucc.isEmpty()){
                    sb.append(sommetCourant).append(":");
                }{
                    for(int i = 0; listSucc.size() > i; i++){
                        String successeur = listSucc.get(i);
                        if (i > 0) {
                            sb.append(", ");
                        }
                        sb.append(sommetCourant).append("-").append(successeur).append("(").append(getValuation(sommetCourant, successeur)).append(")");
                    }
                }

            }

       return sb.toString();
    }

    @Override
    public void ajouterSommet(String noeud) {
        ListAdj.putIfAbsent(noeud, new HashMap<>());
    }

    @Override
    public void ajouterArc(String source, String destination, Integer valeur) {
        if (valeur < 0) {
            throw new IllegalArgumentException("Valuation negative");
        }

        if (this.ListAdj.containsKey(source) && this.ListAdj.get(source).containsKey(destination)) {
            throw new IllegalArgumentException("Arc deja present");
        }

        this.ajouterSommet(source);
        this.ajouterSommet(destination);
        this.ListAdj.get(source).put(destination, valeur);
    }

    @Override
    public void oterSommet(String noeud) {
        if (!this.ListAdj.containsKey(noeud)) {
            return;
        }
        this.ListAdj.remove(noeud);
        for(HashMap<String ,Integer> resteDeLaListe : this.ListAdj.values()){
                resteDeLaListe.remove(noeud);
        }
    }

    @Override
    public void oterArc(String source, String destination) {
        if (!this.ListAdj.containsKey(source) || !this.ListAdj.get(source).containsKey(destination)) {
            throw new IllegalArgumentException("Arc deja present");
        }
        this.ListAdj.get(source).remove(destination);
    }

    @Override
    public List<String> getSommets() {
       ArrayList listS = new ArrayList<>(this.ListAdj.keySet());
        listS.sort(null);
        return listS;
    }

    @Override
    public List<String> getSucc(String sommet) {
        if (!this.ListAdj.containsKey(sommet)) {
            return new ArrayList<>();
        }
        ArrayList listSucc = new ArrayList<>(this.ListAdj.get(sommet).keySet());
        listSucc.sort(null);
        return listSucc;
    }

    public int  gettaillesucc (String sommet ){
        return getSucc(sommet).size();
    }

    @Override
    public boolean contientSommet(String sommet) {
        return this.ListAdj.containsKey(sommet);
    }

    @Override
    public boolean contientArc(String src, String dest) {
        return this.ListAdj.containsKey(src) && this.ListAdj.get(src).containsKey(dest);
    }

    @Override
    public int getValuation(String src, String dest) {
        if (!this.ListAdj.containsKey(src) || !this.ListAdj.get(src).containsKey(dest)) {
            return 0;
        }
        return this.ListAdj.get(src).get(dest);
    }

}


