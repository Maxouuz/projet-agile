package ZombIUT;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Survie {
	static Scanner sc = new Scanner(System.in);


	public static void play(Player p){
		int x;
		boolean dead=false;
		int choix = 0;
		int dayWithoutDrink = 0;
		while(!dead) {
			// Choix d'action
			Menu.clearScreen();
			System.out.println("Jour :"+p.getDaysSurvived());
			System.out.println("Votre Status :");
			// afficher les barres
			p.dispWaterLvl();
			p.dispHungerLvl();

			
			if(p.isStarving()) {
				System.out.println("Il a faim");
			}
		    if(p.isThirsty()) {
		    	System.out.println("Il a soif");
		    }
			
			System.out.println("Inventaire :");
			p.dispInventory();
			System.out.println();
			System.out.println("Voulez-vous manger ? 1: Oui 2: Non");
			

			choix = Survie.saisie1ou2();

			if(choix=='1') {
				if(p.getInventory().sameObject(Ressources.valueOf("PAIN"))){
					p.eat();
					p.getInventory().remove(Ressources.valueOf("PAIN"), 1);
				} else {
					System.out.println("Vous n'avez pas de quoi manger");
				}

			} 

			
			System.out.println("Voulez-vous boire ? 1: Oui 2: Non");
			
			choix = Survie.saisie1ou2();
			
			if(choix=='1') {
				if(p.getInventory().sameObject(Ressources.valueOf("EAU"))) {
					p.drink();
					p.getInventory().remove(Ressources.valueOf("EAU"), 1);	
				}else {
					System.out.println("Vous n'avez pas de quoi boire");
					if(p.getThirst() == 0) {
						dayWithoutDrink++;
					}
				}
			} 
			
			if(choix=='2') {
					if(p.getThirst() == 0) {
						dayWithoutDrink++;
					}
				
			}
			
			
			
			System.out.println("Voulez-vous sortir ? 1: Oui 2: Non");
			// si oui : evenement aleatoire 
			choix = Survie.saisie1ou2();

			if(choix=='1') {
				// Choix evenement
				System.out.println("La porte est bloqué");
			}
			
			System.out.println("La nuit tombe");

			try {
				TimeUnit.SECONDS.sleep(2);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			p.dayPass();
			
			
			if(p.getThirst() == 0 && dayWithoutDrink == 3) {
				dead=true;
				System.out.println("Vous êtes mort le jour :"+p.getDaysSurvived());
			}
		}
		writeScore(p);
		p.toJSON();

	}



	public static char saisie1ou2() {
		String chaine = sc.nextLine();
		while (chaine.equals("") || chaine.charAt(0) - '0' < 1 || chaine.charAt(0) - '0' > 2 || chaine.length() != 1) {
			System.out.print("\t\t Saisie invalide, veuillez entrer un chiffre valide : ");			

			chaine = sc.nextLine();
		}
		return chaine.charAt(0);
	}

	public static void main(String[] args) {
		Survie.play(new Player("ouisiti"));
	}
	
	public static void writeScore(Player p) {
		
		try
		{
		 FileWriter fw = new FileWriter("ressources/score.txt",true);
		 fw.write(""+p.getName()+" : "+p.getDaysSurvived()+" jours\n");
		 fw.close();
		}
		catch(IOException ioe)
		{
	        System.out.println("An error occurred.");
	        ioe.printStackTrace();
		}
	}	

}
