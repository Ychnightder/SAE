package main.java.graphe.dijkstra;

 class Node implements Comparable<Node>{
     public String getNom() {
         return nom;
     }

     String nom;

     public int getDistance() {
         return distance;
     }

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
