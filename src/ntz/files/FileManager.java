package ntz.files;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
/**
* @author netzulo.com
* @since 2013-01-1
* @version 0.5.1
*/
public class FileManager {

	/******************************************************************************************************************/

	public static ArrayList<String> readFileFromPath(String path) throws FileNotFoundException, IOException {
		ArrayList<String> testcases = new ArrayList<>();
		String cadena;
		FileReader file = new FileReader(path);

		BufferedReader buffer = new BufferedReader(file);
		while ((cadena = buffer.readLine()) != null) {
			testcases.add(cadena);
		}
		buffer.close();

		return testcases;
	}
	
	
	public static String toJson(String toStringObject){
		String asJson = "";		
		if(toStringObject != null){
			asJson = toStringObject.replace("[", "{\" ");
			asJson = toStringObject.replace("]", " \"}");
			asJson = toStringObject.replace("=", "\" : \"");	
		}	
		return asJson;		
	}
}
