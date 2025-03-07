package com.tests.bellman_ford_tests;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.jgrapht.Graph;
import org.jgrapht.alg.shortestpath.BellmanFordShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleDirectedWeightedGraph;

public class RunTest {
	
	public static void runTestCase() throws FileNotFoundException, IOException {
		String path = "tests_cases.txt";
		int num_test = 1; // Compteur de tests
		
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			String deb;
			
			System.out.println("Début du jeu de test.");
			while ((deb = br.readLine()) != null) {
				// Début de la création du test
				System.out.println("----------------------------");
				System.out.print("Test " + num_test + " : ");
				Graph<String, DefaultWeightedEdge> graph = new SimpleDirectedWeightedGraph<>(DefaultWeightedEdge.class);
				int nombre_sommet_graphe = Integer.parseInt(deb.trim());
				
				for (int i = 0; i < nombre_sommet_graphe; i++) {
					String[] line = br.readLine().split(" ");
					double poid = Double.parseDouble(line[2]);
					
					graph.addVertex(line[0]);
					graph.addVertex(line[1]);
					graph.setEdgeWeight(graph.addEdge(line[0], line[1]), poid);
					
				}
				
				String[] param = br.readLine().split(" ");
				double res = Double.parseDouble(br.readLine());
				BellmanFordShortestPath<String, DefaultWeightedEdge> bellmanFord = new BellmanFordShortestPath<>(graph);
				double res_bf = bellmanFord.getPathWeight(param[0], param[1]);
				
				// Vérification
				if (Double.compare(res_bf, res) == 0) {
					System.out.println("pass");
				}
				else {
					System.out.println("fail");
				}
				num_test++;
				
			} // end while 
		} // end try
		catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		runTestCase();
	}

}
