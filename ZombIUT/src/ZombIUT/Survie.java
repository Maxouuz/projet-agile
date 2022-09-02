package ZombIUT;

import java.util.Scanner;

public class Survie {
	private static int jour = 1;
	static public Scanner sc;
	public Survie() {
		sc = new Scanner(System.in);
	}


	public static void play(Player p){
        boolean dead=false;
        int choix = 0;
		while(!dead) {
			// Choix d'action
			
			System.out.println("Voulez-vous manger ? 1: Oui 2: Non");
			choix = Survie.saisie1ou2();
			if(choix=='1') {
				
			} 
			
			// Choix de sorti
			System.out.println("Voulez-vous boire ? 1: Oui 2: Non");
			
			choix = Survie.saisie1ou2();
			if(choix=='1') {
				
			} 
			System.out.println("Voulez-vous sortir ? 1: Oui 2: Non");
			// si oui : evenement aleatoire 
			// si non : day++s
			choix = Survie.saisie1ou2();
			if(choix=='1') {
				
			} 
			
			jour++;
			
			
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

    	play(new Player("ouististi"));
    }
	
}
