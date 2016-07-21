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
		ArrayList<String> casos = new ArrayList<>();
		String cadena;
		FileReader file = new FileReader(path);

		BufferedReader buffer = new BufferedReader(file);
		while ((cadena = buffer.readLine()) != null) {
			casos.add(cadena);
		}
		buffer.close();

		return casos;
	}
}
