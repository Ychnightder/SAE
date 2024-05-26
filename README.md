# SAE 2.02 - Graphes Orientés Valués

## Introduction
L'objectif du projet était de créer une application Java pour manipuler des
graphes orientés valués et déterminer le plus court chemin entre des stations
du métro parisien.
<hr>

### Membres de l'équipe
-     BATIKH Mohamed
-     HADJ MESSAOUD Souleymane
-     HDIDOU Rita
-     PIERRE Ychnightder
-     RONSIN Jade

<hr>

## Structure du projet

### Partie I : Représentation des graphes
###### Les classe qui on été Code :  

#### GrapheLArcs
Cette classe représente un graphe à l'aide d'une liste d'arcs. 
Chaque arc connecte deux nœuds avec un poids spécifié. 
Les nœuds sont identifiés par des entiers de 1 à n.

#### GrapheLAdj
Cette classe représente un graphe à l'aide de listes d'adjacence. 
Chaque nœud a une liste d'arcs sortants avec leurs poids respectifs.

<hr>

### Partie II : Algorithme du plus court chemin de Dijkstra et étude comparative

#### Implémentation de l'algorithme de Dijkstra

```java
package main.java.graphe.dijkstra;

import main.java.graphe.Interface.IGraphe;

import java.util.*;

public class Dijkstra {

    public static HashMap<String, Integer> dijkstra(IGraphe g, String arcSource, Map<String, Integer> distance, Map<String, String> prev) {
        PriorityQueue<Node> queue = new PriorityQueue<>(); // file de priorité des neoeud pas encore visités
        Set<String> visite = new HashSet<>();  // nœuds visités

        distance.put(arcSource, 0); // initialiser la source avec distance à 0
        queue.add(new Node(arcSource, 0)); // ajout du nœud source dans la file de priorité

        while (!queue.isEmpty()) {
            Node currentNode = queue.poll();  // Récupère le nœud avec la distance la plus courte dans la file

            if (!visite.add(currentNode.nom)) { // vérifie que le nœud n'est pas déjà visité
                continue;
            }

            for (String voisinDuNoeud : g.getSucc(currentNode.nom)) { // Parcourt tous les voisins du nœud courant
                if (visite.contains(voisinDuNoeud)) { // vérifie que le voisin n'a pas été déjà visité
                    continue;
                }
                int newDistance = distance.get(currentNode.nom) + g.getValuation(currentNode.nom, voisinDuNoeud);

                // Met à jour la distance et le précédent si un chemin plus court est trouvé
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

class Node implements Comparable<Node> {
    String nom;
    int distance;

    public Node(String nom, int distance) {
        this.nom = nom;
        this.distance = distance;
    }

    @Override
    public int compareTo(Node autre) {
        return Integer.compare(this.distance, autre.distance);
    }
}
```

<hr>

### Dijkstra TEST 

#### GrapheLArcs
DorogovtsevMendes jusqu'a 10 000

Barabasi jusqu'a 10 002

Full-Connected jusqu'a 101

#### GrapheLAdj
DorogovtsevMendes jusqu'a 1 000 000 

Barabasi jusqu'a 1 000 002

Full-Connected jusqu'a 1001
