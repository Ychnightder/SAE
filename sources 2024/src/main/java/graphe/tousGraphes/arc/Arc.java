package main.java.graphe.tousGraphes.arc;

public  class Arc {


    private String sommet ;
    private String succeseur ;
    private int  Valeur;

    public Arc (String Source , String Dest , int  Valeur) {
        this.sommet = Source;
        this.succeseur = Dest;
        if (Valeur <0) {
            throw new IllegalArgumentException("la valeur doit etre positive ");
        }
        else {
            this.Valeur = Valeur;
        }
    }

    public String getSource() {
        return sommet;
    }

    public String getDestination() {
        return succeseur;
    }

    public int getValuation() {
        return Valeur;
    }


    @Override
    public String toString() {
        return  sommet + "-"+ succeseur+"("+Valeur+")" ;
    }
}


