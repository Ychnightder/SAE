package main.java.graphe;
import main.java.graphe.Interface.PasDansLaListeException;
import java.util.ArrayList;
import java.util.List;


public class GrapheLArcs extends Graphe {
    Arc Arc ;
    // ici la premiere classe a crée (mohamed qui a ecrit ça )
    private List <Arc> arcs;
    public GrapheLArcs() {
        arcs  = new ArrayList<>();
        // la j'hesite a faire une class interne Arc et donc la cette partie marchera c'est pour verifier si deux sommets peuvent etre bon (mohamed)
    }


    @Override
    public void ajouterArc (String source , String Dest , Integer Valeur ){
        for (Arc Arc : arcs) {
            if (source.equals(Arc.getSource()) && Dest.equals(Arc.getDest())||  Valeur <0) {
                throw new IllegalArgumentException( "l'arc existe deja ");
            }
        }
        arcs.add(new Arc( source , Dest , Valeur));
    }
    @Override
    public String toString() {
        StringBuilder sb  = new StringBuilder("{");
        for (int i = 0; i < arcs.size(); i++) {
            sb.append(Arc.toString());
           if( i==arcs.size() ){
               sb.append("");
           }
           else {
               sb.append(", ");
           }
        }
        sb.append("}");
        return sb.toString();
    }



    @Override
    public List<String> getSommets() {
        List <String> sommet = new ArrayList<String>();
        for (Arc Arc : arcs) {
            sommet.add(new String(Arc.getSource()));
//              String source = Arc.getSource();
//              sommet.add(new String(source));
        }
        return sommet ;
    }

    /**
     * @param sommet
     * @return
     */
    @Override
    public List<String> getSucc(String sommet) {
        List<String>succ = new ArrayList<>();
        for (Arc Arc : arcs) {
            if (Arc.getSource().equals(sommet)) {
                succ.add(new String(Arc.getDest()));
            }
        }
        return succ;
    }

    /**
     * @param src
     * @param dest
     * @return
     */
    @Override
    public int getValuation(String src, String dest)   {
        int  s = 0;
        for (Arc Arc : arcs) {
            if (src != Arc.getSource() && src != Arc.getDest() || Arc.getValeur()<0) {
                throw new IllegalArgumentException("l'arc n'existe pas ou est une valuation negative ");
            } else {
                s  = Arc.getValeur();
            }
        }
        return s ;
    }


    /**
     * @param src
     * @param dest
     * @return
     */
    @Override
    public boolean contientArc(String src, String dest) {
        for (Arc Arc : arcs) {
            if (src.equals(Arc.getSource()) && dest.equals(Arc.getDest())) {
                return true;
            }
        }
        return false;
    }





    @Override
    public void ajouterSommet(String noeud) {

    }
    @Override
    public boolean contientSommet(String sommet) {
        return false;
    }
    @Override
    public void oterSommet(String noeud) {

    }
    @Override
    public void oterArc(String source, String destination) {

    }





    public class Arc {
        private String sommet ;
        private String succeseur ;
        private int  Valeur;

        public Arc (String Source , String Dest , int  Valeur) {
            this.sommet = Source;
            this.succeseur = Dest;
            this.Valeur = Valeur;
        }

        public String getSource() {
            return sommet  ;
        }

        public String getDest() {
            return succeseur;
        }

        public int getValeur() {
            return Valeur;
        }


        @Override
        public String toString() {
            return "(" + sommet + ", " + succeseur + ")";
        }
    }



}
