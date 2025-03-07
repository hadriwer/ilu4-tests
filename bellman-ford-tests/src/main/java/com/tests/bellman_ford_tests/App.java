package com.tests.bellman_ford_tests;
import org.jgrapht.Graph;
import org.jgrapht.alg.shortestpath.BellmanFordShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleDirectedWeightedGraph;


/**
 * Hello world!
 */
public class App {	
	
    public static void main(String[] args) {
    	Graph<String, DefaultWeightedEdge> graph = new SimpleDirectedWeightedGraph<>(DefaultWeightedEdge.class);
    	
    	// Ajout des sommets
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");

        // Ajout des arêtes pondérées
        graph.setEdgeWeight(graph.addEdge("A", "B"), 1);
        graph.setEdgeWeight(graph.addEdge("B", "C"), 2);
        graph.setEdgeWeight(graph.addEdge("A", "C"), 4);
        graph.setEdgeWeight(graph.addEdge("C", "D"), 1);
        graph.setEdgeWeight(graph.addEdge("B", "D"), 5);

        // Exécution de l'algorithme de Bellman-Ford
        BellmanFordShortestPath<String, DefaultWeightedEdge> bellmanFord = new BellmanFordShortestPath<>(graph);
        System.out.println("Chemin le plus court de A à D : " + bellmanFord.getPath("A", "D"));
        System.out.println("Poids du chemin : " + bellmanFord.getPathWeight("A", "D"));
    }
}
