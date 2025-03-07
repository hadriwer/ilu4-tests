package com.tests.bellman_ford_tests;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Parse {
	
	public static void loadTestCase() throws FileNotFoundException, IOException {
		String path = "tests_cases.txt";
		
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			String line;
			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}
		} catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		loadTestCase();
	}

}
