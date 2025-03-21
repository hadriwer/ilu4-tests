package com.tests.bellman_ford_tests;
import java.util.Arrays;


/**
 * 		Implémentation de Bellman-Ford
 */
public class BellmanFord {	
	// Graph is Created Using Edge Class
    static class Edge {
    	int weight;
    	char source, destination;

        Edge() {
        	weight = 0;
            source = destination = ' ';
        }
    }

    int V, E;
    Edge edge[];

    // Constructor to initialize the graph
    BellmanFord(int v, int e) {
        V = v;
        E = e;
        edge = new Edge[e];
        for (int i = 0; i < e; ++i)
            edge[i] = new Edge();
    }

    // Bellman-Ford Algorithm to find shortest paths from source to all vertices
    int BellmanFordAlgo(BellmanFord graph, char source, char arrivee) {
        int V = graph.V, E = graph.E;
        int dist[] = new int[V];

        // Step 1: Initialize distances from source to all other vertices as INFINITE
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[source-65] = 0;

        // Step 2: Relax all edges |V| - 1 times.
        for (int i = 1; i < V; ++i) {
            for (int j = 0; j < E; ++j) {
                char u = graph.edge[j].source;
                char v = graph.edge[j].destination;
                int weight = graph.edge[j].weight;
                if (dist[u-65] != Integer.MAX_VALUE && dist[u-65] + weight < dist[v-65])
                    dist[v-65] = dist[u-65] + weight;
            }
        }

        // Step 3: Check for negative-weight cycles
        for (int j = 0; j < E; ++j) {
            char u = graph.edge[j].source;
            char v = graph.edge[j].destination;
            int weight = graph.edge[j].weight;
            if (dist[u-65] != Integer.MAX_VALUE && dist[u-65] + weight < dist[v-65]) {
                System.out.println("Graph contains negative weight cycle");
                return 1;
            }
        }

        // Print distances from source to all vertices
//        printDistances(dist, V);
        
        return dist[arrivee-65];
    }
}
