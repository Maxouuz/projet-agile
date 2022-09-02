package ZombIUT;

import java.util.Scanner;


public class Menu {
	//Main
	static Scanner sc;

	public Menu() {
		sc = new Scanner(System.in);
	}

	public static void main(String[] args) {
		Menu m = new Menu();
		m.menu();

	}


	public static int menu() {
		int x;
		boolean ff = true;

		while(ff) {
			x=0;
			clearScreen();
			MenuDuDebut();

			System.out.println("Choix:");
			x= saisieValideMenu();

			clearScreen();
			if(x=='1') {


				System.out.println();
				System.out.println("Pseudo :");
				String name = sc.next();
				Player p = new Player(name);
				System.out.println(p);
				// mettre le jeu
				clearScreen();
				lineDisplacement.play();

			} else if (x=='2') {
				regle();
				System.out.println("Entrer 1 pour revenir");	
				x = saisieRetourMenu();

			} else if (x=='3'){

			} else if (x=='4'){

			} else if (x=='5'){
				System.out.println("Merci a bientôt !");
				ff=false;
			}		
		}
		return 42;
	}

	public static void MenuDuDebut() {
		System.out.println("Bienvenue dans ZombIUT");
		System.out.println("1: Play ");
		System.out.println("2: Rules");
//		System.out.println("3: Reload");
//		System.out.println("4: Score");
		System.out.println("5: Exit");
	}


	public static void regle() {
		System.out.println("Survie à l'IUT");

	}

	public static char saisieValideMenu() {
		String chaine = sc.nextLine();
		while (chaine.equals("") || chaine.charAt(0) - '0' < 1 || chaine.charAt(0) - '0' > 5 || chaine.length() != 1) {
				System.out.print("\t\t Saisie invalide, veuillez entrer un chiffre valide : ");			

			chaine = sc.nextLine();
		}
		return chaine.charAt(0);
	}
	
	public static char saisieRetourMenu() {
		String chaine = sc.nextLine();
		while (chaine.equals("") || chaine.charAt(0) - '0' < 1 || chaine.charAt(0) - '0' > 1 || chaine.length() != 1) {
				System.out.print("\t\t Saisie invalide, veuillez entrer un chiffre valide : ");			

			chaine = sc.nextLine();
		}
		return chaine.charAt(0);
	}

	public static void clearScreen() {  
		System.out.println(System.lineSeparator().repeat(70));
	}  


}
