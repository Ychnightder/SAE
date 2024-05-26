package main.java.graphe.arc;

public class Arc {
    private String sommet;
    private String succeseur;
    private int valeur;

    public Arc(String source, String dest, int valeur) {
        this.sommet = source;
        this.succeseur = dest;
        if (valeur < 0) {
            throw new IllegalArgumentException("La valeur doit être positive.");
        } else {
            this.valeur = valeur;
        }
    }

    public String getSource() {
        return sommet;
    }

    public String getDestination() {
        return succeseur;
    }

    public int getValuation() {
        return valeur;
    }

    @Override
    public String toString() {
        return sommet + "-" + succeseur + "(" + valeur + ")";
    }
}
