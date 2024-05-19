package main.java.graphe.dijkstra;

import main.java.graphe.Interface.IGraphe;

import java.util.*;

public class Dijkstra {

    public static HashMap<String, Integer> dijkstra(IGraphe g, String arcSource, Map<String, Integer> distance, Map<String, String> prev) {
        PriorityQueue<Node> queue = new PriorityQueue<>(); // file de priorité des neoeud  pas encore visité
        Set<String> visite = new HashSet<>();  // noeud visité

        distance.put(arcSource, 0);// initialiser la source avec distance a 0
        queue.add(new Node(arcSource, 0)); // ajout noeud source dans la file de priorité

        while (!queue.isEmpty()) {
            Node currentNode = queue.poll();  // Récupère le noeud avec la distance la plus courte dans la file

            if (!visite.add(currentNode.nom)) { // verifie que le noeud n'est pas deja visité
                continue;
            }

            for (String voisinDuNoeud : g.getSucc(currentNode.nom)) { // Parcourt tous les voisins du noeud courant
                if (visite.contains(voisinDuNoeud)) { // verifie que le voision n'a pas été deja visité
                    continue;
                }
                int newDistance = distance.get(currentNode.nom) + g.getValuation(currentNode.nom, voisinDuNoeud);

                    // Met à jour la distance et le precedent si un chemin plus court est trouvé
                if (newDistance < distance.getOrDefault(voisinDuNoeud, Integer.MAX_VALUE)) {
                    distance.put(voisinDuNoeud, newDistance);
                    prev.put(voisinDuNoeud, currentNode.nom);
                    queue.add(new Node(voisinDuNoeud, newDistance)); // Ajoute le voisin dans la file de priorité
                }
            }
        }

        return new HashMap<>(distance);
    }


}
