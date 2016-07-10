package usingSimpleArrays;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class MaxTotal {

	public static int degree = 4;
	
	public static void main(String[] args) {
	
		Long startTime = System.currentTimeMillis();
		
		int[][] input = buildInputArray();
		
		int[][] maxTotals = initMaxTotalsArray(input);
		
		
		
		
		Long timeTaken = System.currentTimeMillis() - startTime;
		System.out.println("Time taken in ms: " + timeTaken);		
	}

	private static int[][] buildInputArray() {
		
		int[][] input = new int[degree][degree];
		
		try
		{
			Path path = Paths.get("/Users/pdeshmane/Documents/workspace/projecteuler_problem18/src/input1.txt");
			Scanner sc = new Scanner(path);
			
			for (int i = 0; i < degree; i++) {
				String line = sc.nextLine();
				String[] res = line.split("\\s+");
				for (int j = 0; j <= i; j++) {
					input[i][j] = Integer.parseInt(res[j]);
				}
			}
			
			sc.close();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
		return input;
	}
	
	private static int[][] initMaxTotalsArray(int[][] input) {
		int[][] maxTotals = new int[degree][degree];
		for (int i = 0; i < degree; i++) {
			for (int j = 0; j <= i; j++) {
				maxTotals[i][j] = -1;
			}
		}
		return maxTotals;
	}

}
