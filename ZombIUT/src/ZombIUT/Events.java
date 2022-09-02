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

	private String separator = File.separator;
	private String path = Paths.get(".").normalize().toAbsolutePath() + separator + "ressources" + separator + "Events.csv";
	private List<List<String>> lines = new ArrayList();


	/* format du fichier CSV: Events
	 * col1: nom de l'evenement
	 * col2: reponse "oui"
	 * col3: reponse "non"
	 * col4: object affecté
	 * col5: quantité modifier
	 * col6: delai avant nouvel usage*/
	public void collecteDonner () {
		String delimiter = ";";
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
		String res = "";
		int alea = new Random().nextInt(lines.size());

		if (lines.get(alea).get(5).equals("0")) {
			res = lines.get(alea).get(0).toString();
		} else {
			res = dropEvent();
		}
		
		return res;
	}

}