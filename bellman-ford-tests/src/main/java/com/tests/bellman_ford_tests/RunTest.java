package com.tests.bellman_ford_tests;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

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
				
				// Prend les paramètres v et e : v => nombre de sommet, e => nombre arc
				int v = Integer.parseInt(deb.trim());
				deb = br.readLine();
				int e = Integer.parseInt(deb.trim());
				BellmanFord graph = new BellmanFord(v, e);
				
				
				// Itération de tous les arcs dans le fichier
				for (int i = 0; i < e; i++) {
					String[] line = br.readLine().split(" ");
					int poid = Integer.parseInt(line[2]);
					
					graph.edge[i].source = line[0].charAt(0);
					graph.edge[i].destination = line[1].charAt(0);
					graph.edge[i].weight = poid;
					
				}
				
				// Oracle
				String[] param = br.readLine().split(" ");
				int res = Integer.parseInt(br.readLine());
				
				// Résultat de l'algorithme
				int res_b = graph.BellmanFordAlgo(graph, param[0].charAt(0), param[1].charAt(0));
			
				// Vérification
				if (Integer.compare(res_b, res) == 0) {
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
