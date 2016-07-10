import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;


public class MaxTotal {

	private static int degree = 100;
	
	public static void main(String[] args) {
		
		Long startTime = System.currentTimeMillis();
		
		Element[][] input = buildInput();
		
		//displayInput(input);
		
		for (int i = degree-1; i >= 0; i--) 
		{
			for (int j = i; j >= 0; j--) 
			{
				if(i == degree-1)
				{
					Element elem = input[i][j];
					elem.setMaxTotal(elem.getVal());
				}
				else
				{
					Element currElem = input[i][j];
					Element leftElem = input[i+1][j];
					Element rightElem = input[i+1][j+1];
					
					int sumLeft = currElem.getVal() + leftElem.getMaxTotal();
					int sumRight = currElem.getVal() + rightElem.getMaxTotal();
					int max = Math.max(sumLeft, sumRight);
					currElem.setMaxTotal(max);
					
				}
			}
		}
		
		System.out.println((input[0][0]).getMaxTotal());
		
		Long endTime = System.currentTimeMillis();
		Long timeTaken = endTime - startTime;
		System.out.println("Time taken in ms: " + timeTaken);
	}
	
	private static Element[][] buildInput()
	{
		Element[][] input = new Element[degree][degree];
		try 
		{
			Path path = Paths.get("./src/input3.txt");
			Scanner sc = new Scanner(path);
			
			for (int i = 0; i < degree; i++) 
			{
				String line = sc.nextLine();
				String[] res = line.split("\\s+");
				
				for (int j = 0; j <= i; j++) 
				{
					int num = Integer.parseInt(res[j]);
					Element elem = new Element(num);
					input[i][j] = elem;
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
	
//	private static void displayInput(Element[][] input) {
//		for (int i = 0; i < input.length; i++) {
//			System.out.println();
//			for (int j = 0; j <= i; j++) 
//			{
//				Element elem = input[i][j];
//				System.out.print(elem.getVal() + "\t");
//				
//			}
//		}
//	}

}

