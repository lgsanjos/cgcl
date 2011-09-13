package utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;

public class Utils {

	public static String getCurrentPath(Object from){
		return System.getProperty("user.dir");
		//return "/" + from.getClass().getProtectionDomain().getCodeSource().getLocation().toString().substring(6);
	}
	
	public static String loadFromFile(String filePath) throws java.io.IOException {
		
	        StringBuffer fileData = new StringBuffer(1000);
	        BufferedReader reader = new BufferedReader(
	                new FileReader(filePath));
	        char[] buf = new char[1024];
	        int numRead=0;
	        while((numRead=reader.read(buf)) != -1){
	            fileData.append(buf, 0, numRead);
	        }
	        reader.close();
	        return fileData.toString();

	}
	
	public static String convertStreamToString(InputStream in) throws IOException {

		if (in != null) {
		    Writer writer = new StringWriter();
		
		    char[] buffer = new char[1024];
		    try {
		        Reader reader = new BufferedReader( new InputStreamReader(in, "UTF-8") );
		        int n;
		        while ((n = reader.read(buffer)) != -1) {
		            writer.write(buffer, 0, n);
		        }
		    } finally {
		        in.close();
		    }
		    return writer.toString();
		} else {        
		    return "";
		}
	}
	
	
    public static int countLetters(String str, char letter) {
        
        if (str == null)
            return 0;
        
        int counter = 0;
        
        for (int i = 0; i < str.length(); i++) {

            if (str.charAt(i) == letter)
                counter++;
        }
        
        return counter;
    }
    
	public static void saveToFile(String content, String filename) {
    	try {
    		filename = (Utils.getCurrentPath(System.out) + "/output/" +  filename.trim());
    		BufferedWriter out = new BufferedWriter(new FileWriter(filename));
    		out.write(content);
    		out.close();
    	} catch (IOException e) {
    		
    	}
    }
}
