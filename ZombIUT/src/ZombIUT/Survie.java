package ZombIUT;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Survie {
	private static int jour = 1;
	static Scanner sc = new Scanner(System.in);


	public static void play(Player p){
		int x;
		boolean dead=false;
		int choix = 0;
		int dayWithoutDrink = 0;
		while(!dead) {
			// Choix d'action
			Menu.clearScreen();
			System.out.println("Jour :"+jour);
			System.out.println("Votre Status :");
			// afficher les barres
			p.dispWaterLvl();
			p.dispHungerLvl();
//			p.dispRadioactivityLvl();
//			p.dispSanityLvl();
			
//			System.out.println("A soif :"+p.isThirsty());
//			System.out.println("A Faim :"+p.isStarving());
			
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
				p.isEating();
			} else {

			}

			// Choix de sortie
			System.out.println("Voulez-vous boire ? 1: Oui 2: Non");

			choix = Survie.saisie1ou2();
			if(choix=='1') {
				p.isDrinking();
			} else {
				if(p.getWaterLvl() == 0) {
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
			jour++;
			
			if(p.getWaterLvl() == 0 && dayWithoutDrink == 3) {
				dead=true;
				System.out.println("Vous êtes mort le jour :"+jour);
			}
		}


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

}
