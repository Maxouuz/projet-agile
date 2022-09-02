package ZombIUT;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Events {

	private static String separator = File.separator;
	private static String path = Paths.get(".").normalize().toAbsolutePath() + separator + "ressources" + separator + "Events.csv";
	private static List<List<String>> lines = new ArrayList();
	
	public static void main(String[] args) {
		dropEvent();
	}

	/* format du fichier CSV: Events
	 * col1: nom de l'evenement
	 * col2: reponse "oui"
	 * col3: reponse "non"
	 * col4: object affecté
	 * col5: quantité modifier
	 * col6: delai avant nouvel usage*/
	public static void collecteDonner () {
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
	
	public static String dropEvent() {
		collecteDonner();
		String res = "";
		
		/*for (int i = 0; i < lines.size() && res.equals(null); i++) {
			if (lines.get(i).get(5).equals("0")) {
				res = lines.get( new Random().nextInt( lines.size()+1)).toString();
			}
		} */
		
		System.out.println(lines.toString()); // temp
		System.out.println(lines.get( new Random().nextInt( lines.size())).get(0).toString()); // temp
		return res;
	}
}