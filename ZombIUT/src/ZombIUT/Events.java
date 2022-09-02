package ZombIUT;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Events {

	private String separator = File.separator;
	private String path = System.getenv() + separator + "ZombiIUT" + separator + "ressources" + separator + "Event.csv";
	private List<List<String>> lines = new ArrayList();
	
	public void collecteDonner () {
		String delimiter = ",";
		String line;
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			while((line = br.readLine()) != null){
				List<String> values = Arrays.asList(line.split(delimiter));
				lines.add(values);
			}
		} catch (IOException e){
			e.printStackTrace();
		}
	}
	
	public String dropEvent() {
		collecteDonner();
		return lines.get( new Random().nextInt(3)).toString();
	}
	
	
}