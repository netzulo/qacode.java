package ntz.files;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.util.ArrayList;
/**
* @author netzulo.com
* @since 2016-08-03
* @version 0.5.6
* @updateFrom 0.5.1
*/
import java.util.Hashtable;
import java.util.List;
import java.util.Properties;

import ntz.exceptions.FileManagerException;
public class FileManager {
	/******************************************************************************************************************/
	public final static String PATH_MYSQL = "/libs/configs/db/mysql.properties";
	public final static String PATH_TESTLINK = "/libs/configs/testlink/testlink.properties";
	/******************************************************************************************************************/

	public static List<String> readFileFromPath(String path) throws FileManagerException {
		ArrayList<String> lanes = new ArrayList<>();
		String lane;
		try {
			FileReader file = new FileReader(path);

			BufferedReader buffer = new BufferedReader(file);
			while ((lane = buffer.readLine()) != null) {
				lanes.add(lane);
			}
			buffer.close();
		} catch (Exception e) {
			throw new FileManagerException("[FileManager][ERROR]: at read file "+ path);
		}
		return lanes;
	}
	
	/**
	 * Need complete pathname + filename + extension to works
	 * */
	public static Hashtable<String, String> readProperties(String path, String... _props) throws FileManagerException{
		Hashtable<String, String> props = new Hashtable<>();
		Properties propsFile = new Properties();
		InputStream is = null;
		try {
			//is =Class.class.getResourceAsStream(path);
			is = new FileInputStream(new File(System.getProperty("user.dir")+path));
			propsFile.load(is);		
			//Validate if file was loaded rightly
			if(propsFile != null && is!= null){
				//Validate parameters
				if(_props.length > 0){
					for (String _prop : _props) {
						//GET property from file and put into HashTable
						props.put(_prop, propsFile.getProperty(_prop));
					}
				}
			}								
		} catch (Exception e) {
			throw new FileManagerException("[FileManager][ERROR]: at read properties file on "+ path);
		}		
		
		return props;		
	} 
}
