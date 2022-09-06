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
import java.util.Scanner;

public class Events {

	private String separator = File.separator;
	private String path = Paths.get(".").normalize().toAbsolutePath() + separator + "ressources/Events.csv";
	private List<List<String>> lines = new ArrayList();


	/* format du fichier CSV: Events
	 * col1: nom de l'evenement
	 * col2: reponse "oui"
	 * col3: reponse "non"
	 * col4: object affecté
	 * col5: quantité modifier
	 * col6: delai avant nouvel usage || si 10 alors peux sortir*/
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

	
	public void dropEvent(Player p ) {
		String res = "";
		int alea=0;
		while (res.equals("")) {
			alea = new Random().nextInt(lines.size());
			if (lines.get(alea).get(5).equals("0") && (p.getInventory().inventory.containsKey(Ressources.valueOf(lines.get(alea).get(3)))|| (Integer.parseInt(lines.get(alea).get(4))>=0))) {
				res= lines.get(alea).get(0).toString();
				lines.get(alea).set(5, Integer.parseInt( lines.get(alea).get(5) + 1) + "");
				
				
			}
			
		}
		
		for (int i = 0; i < lines.size(); i++) {
			if (lines.get(i).get(5).equals(lines.size())) {
				lines.get(i).set(5, "0");
			}
		}
		System.out.println(res+" (o/n)");
		choice(alea,p);
	}
	public void choice(int alea,Player p) {
		
		Scanner sc = new Scanner(System.in);
		String res;
		boolean isTrue=true;
		while(isTrue) {
			res = sc.nextLine();
			if(res.equals("o")){
				Ressources r = Ressources.valueOf(lines.get(alea).get(3).toString());
				if(p.getInventory().inventory.containsKey(r)) {
					System.out.println( lines.get(alea).get(1).toString());
					isTrue = false;
					perteOuGain(alea, p, 3);
				}else {
					System.out.println("Vous n'avez pas l'objet necessaire pour faire cette quête");
					isTrue = false;
				}
			}else if(res.equals("n")){
				Ressources r = Ressources.valueOf(lines.get(alea).get(6).toString());
				if(p.getInventory().inventory.containsKey(r)) {
					System.out.println(lines.get(alea).get(2).toString());
					isTrue = false;
					perteOuGain(alea, p, 6);
				}else {
					System.out.println("Vous n'avez pas l'objet necessaire pour faire cette quête");
					isTrue = false;
				}
			}else {
				System.out.println("o/n");
			}
		}
	}
	
	public void perteOuGain(int alea,Player p,int vf) {
		Ressources r = Ressources.valueOf(lines.get(alea).get(vf).toString());
		p.getInventory().addRemove(r, lines.get(alea).get(vf+1).toString());
		
		
		
		
		
	}
	
}
