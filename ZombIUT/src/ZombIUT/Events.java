package ZombIUT;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Events {
	
	private String separator = File.separator;
	private String path = System.getenv() + separator + "ZombiIUT" + separator + "ressources" + separator + "Event.csv";
	
	
	public void collecteDonner () {
		try (BufferedReader fichier = new BufferedReader(new FileReader(path))) {
			String line = fichier.readLine();
			while (line != null) {  
				
			}  
		} catch (IOException e) {  
			e.printStackTrace();  
		}
		
	}

}