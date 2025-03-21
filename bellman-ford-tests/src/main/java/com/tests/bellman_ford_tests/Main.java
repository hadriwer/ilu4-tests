package com.tests.bellman_ford_tests;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		RunTest.runTestCase("tests_cases.txt");
		RunTest.runTestCase("question3.txt");
		RunTest.runTestCase("negative_weight_cycle.txt");
	}

}
