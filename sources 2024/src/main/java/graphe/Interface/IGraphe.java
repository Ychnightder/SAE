package main.java.graphe.Interface;

import java.util.HashMap;
import java.util.List;

// ajouterSommet ne fait rien si un sommet est deja present
// ajouterArc leve une IllegalArgumentException si l'arc est deja present
// ajouterArc ajoute les sommets s'ils ne sont pas deja presents
// oterSommet ne fait rien si le sommet n'est pas dans le graphe
// oterArc leve une IllegalArgumentException si l'arc n'est pas present
public interface IGraphe extends IGrapheConst {
	void ajouterSommet(String noeud);
	void ajouterArc(String source, String destination, Integer valeur);
	void oterSommet(String noeud);
	void oterArc(String source, String destination);
	
	// construit un graphe vide a partir d'une chaine
	// au format "A-B(5), A-C(10), B-C(3), C-D(8), E:";
	default void peupler(String str) { 
	    assert this.getSommets().isEmpty();
	    String[] arcs = str.split(",\\s*");
	    for (String arc : arcs) {
	        String[] elements = arc.trim().split("-");
	        // extrait le noeud source et te ":" si nécessaire dans le nom
	        String src = elements[0].replaceAll(":", "");
	        ajouterSommet(src);
	        if (elements.length == 1)
	        	continue; // pas de destination
	        String target = elements[1];
	        if (!target.isEmpty()) {
	             String dest = target.substring(0, target.indexOf('('));
	             int val = Integer.parseInt(target
	                	.substring(target.indexOf('(') + 1,
	                				   target.indexOf(')')));
	             ajouterSommet(dest);
	             ajouterArc(src, dest, val);
	        }
	    }

	}

	default HashMap<String, Integer> dijkstra(String source){
		assert(this.getSommets().contains(source));
		// choix du'une hashmap pour stocker le sommet et sa valuation
		HashMap<String, Integer> tableau_dijkstra = new HashMap<String, Integer>();

		List<String> liste_successeurs = this.getSucc(source);   // succ

		String sommet_courant = liste_successeurs.get(0);  // 1er succ
		String sommet_suivant = source;

		int valuation_sommet_courant = getValuation(source, sommet_courant); // valeur 1er

		int minimum = valuation_sommet_courant;  // valeur 1er aussi

		String sommet_minimum = sommet_courant;  // sommet en string

		//boucle pour parcourir les successeurs

		for(int k=0; k < this.getSommets().size(); ++k) {

			for (int i = 0; i < liste_successeurs.size(); ++i) {  // for succ

				sommet_courant = liste_successeurs.get(i);  //  for Sc

				valuation_sommet_courant = getValuation(sommet_suivant, sommet_courant); // valeur Sc

				if (!tableau_dijkstra.containsKey(sommet_courant) || tableau_dijkstra.get(sommet_courant) >= valuation_sommet_courant) {
					tableau_dijkstra.put(sommet_courant, valuation_sommet_courant);
				} else if (tableau_dijkstra.get(sommet_courant) < tableau_dijkstra.get(sommet_suivant) + valuation_sommet_courant) {
					tableau_dijkstra.put(sommet_courant, tableau_dijkstra.get(sommet_courant) + valuation_sommet_courant);
				}

			}
			for (int compteur = 0; compteur < tableau_dijkstra.size(); ++compteur) {
				if (tableau_dijkstra.get(compteur) < minimum) {
					minimum = valuation_sommet_courant;
					sommet_minimum = sommet_courant;
				}
			}
			sommet_suivant = sommet_minimum;
			liste_successeurs = this.getSucc(sommet_suivant);
		}
		return tableau_dijkstra;
//		System.out.println(tableau_dijkstra);

	}

}

