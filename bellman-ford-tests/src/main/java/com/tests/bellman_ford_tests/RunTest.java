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
	
	public static void runTestCase(String path) throws FileNotFoundException, IOException {
		int num_test = 1, testSucc = 0; // Compteur de tests
		
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			String deb;
			
			System.out.println("Début du jeu de test du fichier : " + path);
			while ((deb = br.readLine()) != null) {
				// Début de la création du test
				System.out.println("----------------------------");
				System.out.print("Test " + num_test + " : ");
				
				int v = Integer.parseInt(deb.trim());
				int e = Integer.parseInt(deb.trim());
				BellmanFord graph = new BellmanFord(v, e);
				
				
				for (int i = 0; i < e; i++) {
					String[] line = br.readLine().split(" ");
					int poid = Integer.parseInt(line[2]);
					
					graph.edge[i].source = line[0];
					graph.edge[i].destination = line[1];
					graph.edge[i].weight = poid;
					
				}
				
				String[] param = br.readLine().split(" ");
				double res = Double.parseDouble(br.readLine());
				BellmanFordShortestPath<String, DefaultWeightedEdge> bellmanFord = new BellmanFordShortestPath<>(graph);
				double res_bf = bellmanFord.getPathWeight(param[0], param[1]);
			
				// Vérification
				if (Double.compare(res_bf, res) == 0) {
					System.out.println("pass");
					testSucc++;
				}
				else {
					System.out.println("fail");
				}
				
				num_test++;
				
			} // end while 
			System.out.println();
			System.out.println("Nombre de tests réussis : " + (float)testSucc / (num_test - 1) * 100 + " %");
			System.out.println();
		} // end try
		catch (IOException e) {
            e.printStackTrace();
        }
	}
}
