/**
 *  Import the libraries that have the functions for file manipulation
 */

import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;


// Main Class
public class AporteForoPoli {

	// Main Function
	public static void main(String[] args) {
		// String type variables
		String content = "Test Write!!!!";
	    String filename = "test.txt";
	    
	    // I write the content
	    writeToFile(filename, content);
	    
	    // I read the content and store the result in a variable
	    String result = readFromFile(filename);
	    
	    System.out.printf("\nResultado de la lectura: \n" + result);
	}
	
	public static void writeToFile(String filename, String content) {
		// Implement try catch to handle errors
	      try (FileWriter fileWriter = new FileWriter(filename)) {
	    	  // I write the content
	          fileWriter.write(content);
	          System.out.println("Datos escritos en el archivo: " + filename);
	      } catch (IOException e) {
	         System.out.println(e);
	      }
	  }
	
	public static String readFromFile(String filename) {
		/**
		 *  I create a StringBuilder to accumulate the lines of text read from the file. 
		 *  StringBuilder is used here to efficiently build a long string of text.
		 */
        StringBuilder content = new StringBuilder();
        
        /**
         * I create a BufferedReader that reads the file specified in filename using a FileReader.
         * BufferedReader improves reading efficiency.
         */
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            // I go through the lines of the file
            while ((line = reader.readLine()) != null) {
                content.append(line);
            }
        } catch (IOException e) {
        	System.out.println(e);
        }
        
        // Return the content obtained from reading
        return content.toString();
    }

}
