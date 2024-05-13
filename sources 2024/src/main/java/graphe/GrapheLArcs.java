package main.java.graphe;
import main.java.graphe.Interface.PasDansLaListeException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class GrapheLArcs extends Graphe {

    // ici la premiere classe a crée (mohamed qui a ecrit ça )
    private List <Arc> arcs;
    private List <String> sommet;
    public GrapheLArcs() {
        arcs  = new ArrayList<>();
        sommet = new ArrayList<>();
        // la j'hesite a faire une class interne Arc et donc la cette partie marchera c'est pour verifier si deux sommets peuvent etre bon (mohamed)
    }


    @Override
    public void ajouterArc (String source , String Dest , Integer Valeur ){
        for (Arc Arc : arcs) {
            if (source.equals(Arc.getSource()) && Dest.equals(Arc.getDest()) ||  Valeur <0) {
                throw new IllegalArgumentException( "l'arc existe deja ");
            }
        }
        arcs.add(new Arc( source , Dest , Valeur));
    }
    @Override
    public String toString() {
//        StringBuilder sb  = new StringBuilder("{");
//
//        for (int i = 0; i < arcs.size(); i++) {
//            sb.append(arcs.get(i).toString());
//
//           if( i >=  arcs.size()-1 ){
//               sb.append("");
//           }
//           else {
//               sb.append(",");
//           }
//        }
//        sb.append("}");
//        return sb.toString();
        StringBuilder sb  = new StringBuilder();
        sort();
        sortSommet();
        boolean ajout = false;
        int i=0;
        int compteur_nombre_arcs = 0;
        for(String noeud : getSommets()){
            i=0;
            ajout= false;


            for(; i<arcs.size(); ++i ){

                if(arcs.get(i).sommet.compareTo(noeud) == 0){

                    sb.append(noeud);
                    sb.append("-");
                    sb.append(arcs.get(i).getDest());
                    sb.append("(");
                    sb.append(getValuation(arcs.get(i).sommet, arcs.get(i).succeseur));
                    sb.append(")");

                    if( compteur_nombre_arcs <= arcs.size() )
                        sb.append(", ");
                    ajout=true;
                    ++compteur_nombre_arcs;
                }


            }
            if(!ajout){
                sb.append(noeud);
                sb.append(":");
                if (compteur_nombre_arcs <= arcs.size() ) {
                    sb.append(", ");
                }
                ++compteur_nombre_arcs;

            }

            }




        return sb.toString();
    }



    @Override
    public List<String> getSommets() {
//        List <String> sommet = new ArrayList<String>();
//        for (Arc Arc : arcs) {
//              String source = Arc.getSource();
//              String destination = Arc.getDest();
//
//              if (!sommet.contains(source)) {
//                  sommet.add(new String(source));
//              }
//              if (!sommet.contains(destination)){
//                  sommet.add(new String(destination));
//              }
//
//
//              System.out.println(Arc);
//        }
//
//        return sommet ;
        return sommet;
    }
    public int gettaillelistesommet (){
        int t = getSommets().size(); ;
        return t ;
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
    public int  gettaillesucc (String sommet ){
        return getSucc(sommet).size();
    }

    /**
     * @param src
     * @param dest
     * @return
     */
    @Override
    public int getValuation(String src, String dest)   {
        for (Arc Arc : arcs) {
            if (src.equals(Arc.getSource()) && dest.equals(Arc.getDest()) ) {
                return Arc.getValeur() ;
            }
        }
        throw new IllegalArgumentException("l'arc n'existe pas ");

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
        if(!sommet.contains(noeud))
            sommet.add(noeud);
    }
    @Override
    public boolean contientSommet(String noeud) {
        return sommet.contains(noeud);
    }
    @Override
    public void oterSommet(String noeud) {
        for(int i = 0; i<sommet.size(); ++i)
            if(noeud.compareTo(sommet.get(i)) == 0) {
                sommet.remove(i);
                return;
            }
    }
    @Override
    public void oterArc(String source, String destination) throws IllegalArgumentException {
        for(int i = 0; i < arcs.size(); ++i){
            if(arcs.get(i).sommet.compareTo(source) == 0 && arcs.get(i).succeseur.compareTo(destination) == 0){
                arcs.remove(i);
                return;
            }

        }
        throw new IllegalArgumentException();
    }
    public void sortSommet(){
        Collections.sort(sommet);
    }

    public void sort(){
        ArrayList<Arc> liste_triee = new ArrayList<>();
        Arc arc_min;

        for (int i = 0; i< arcs.size(); ++i){

            arc_min = arcs.get(i);

            if(!liste_triee.contains(arc_min)){

                for(Arc arc_verif : arcs){
                        if(!arc_min.equals(arc_verif) && !liste_triee.contains(arc_verif)){

                            if(arc_min.sommet.compareTo(arc_verif.getSource()) >=1){

                                arc_min = arc_verif;

                            }

                            else if(arc_min.sommet.compareTo(arc_verif.getSource() )==0){

                                if(arc_min.getDest().compareTo(arc_verif.getDest() )>=1){

                                    arc_min = arc_verif;


                                }

                            }
                        }


                }
                liste_triee.add(arc_min);
                i=0;
            }
        }

        arcs = liste_triee;
    }

    public static class Arc {


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
            return sommet  ;
        }

        public String getDest() {
            return succeseur;
        }

        public int getValeur() {
            return Valeur;
        }

        public boolean equals(Arc autre_arc){
            return this.sommet == autre_arc.sommet && this.succeseur == autre_arc.succeseur;
        }

        @Override
        public String toString() {
            return "(" + sommet + ", " + succeseur + ")" + Valeur;
        }
    }
    public int gettaille (){
        int t = arcs.size();
        return t ;
    }



}








