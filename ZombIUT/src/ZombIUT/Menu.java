package ZombIUT;

import java.util.Scanner;


public class Menu {
	//Main
	
	
	//Color
	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_CYAN= "\u001B[36m";
    
    
    //Background
    public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
    public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
    public static final String ANSI_RED_BACKGROUND
    = "\u001B[41m";
    public static final String ANSI_BLUE_BACKGROUND
    = "\u001B[44m";
	public static Scanner sc;

	public Menu() {
		sc = new Scanner(System.in);
	}

	public static void main(String[] args) {
		Menu m = new Menu();
		m.menu();

	}

	
	public static void menu() {
		int x;
		boolean ff = true;

		while(ff) {
			x=0;
			clearScreen();
			MenuDuDebut();
			System.out.println("Choix:"+ANSI_RESET);
			x= saisieValideMenu();

			clearScreen();
			if(x=='1') {


				System.out.println();
				System.out.println(ANSI_RED+"Pseudo :"+ANSI_RESET);
				String name = sc.next();
				Player p = new Player(name);
				// mettre le jeu
				clearScreen();
				lineDisplacement.play(p);
				Survie.play(p);
			} else if (x=='2') {
				regle();
				System.out.println(ANSI_YELLOW+"Entrer une touche pour sortir"+ANSI_RESET);	
				x = saisieRetourMenu();

			} else if (x=='3'){
				System.out.println();
				System.out.println(ANSI_RED+"Pseudo :"+ANSI_RESET);
				Player p = new Player(sc.next());
				p.jSonToString(p.getName());
				System.out.println("Nombre de jours survecu" + p.getDaysSurvived());
				Survie.play(p);
			} else if (x=='4'){
				tabScore.readFile();
				System.out.println(ANSI_YELLOW+"Entrer une touche pour sortir"+ANSI_RESET);	
				x = saisieRetourMenu();
			} else if (x=='5'){
				System.out.println(ANSI_RED+"Merci a bientôt !"+ANSI_RESET);
				
				ff=false;
			}		
		}
	}

	public static void MenuDuDebut() {
		System.out.println(ANSI_YELLOW_BACKGROUND +ANSI_RED+"               BIENVENUE DANS ZOMBIUT"+ANSI_RESET);
		System.out.println(ANSI_YELLOW+"   1: PLAY ");
		System.out.println("   2: RULES");
		System.out.println("   3: Reload");
		System.out.println("   4: SCORES");
		System.out.println("   5: EXIT"+ANSI_RESET );
	}


	public static void regle() {
		System.out.println("Bienvenue dans Zomb'IUT. Dans ce jeu vous devrez survivre dans un monde apocalyptique plein de rebondissements !  \n"
				+ "Votre but ? Faire les bons choix afin de survivre le plus longtemps possible ! \n \n"
				+ "Liste des touches pour la partie 1 : \n"
				+ "Z : haut\n"
				+ "Q : gauche\n"
				+ "S : bas\n"
				+ "D : droite\n"
				+ "ATTENTION : SI VOUS SORTEZ TROP SANS MASQUE VOUS RISQUEZ DE PERDRE LA PARTIE !");

	}

	public static char saisieValideMenu() {
		String chaine = sc.nextLine();
		while (chaine.equals("") || chaine.charAt(0) - '0' < 1 || chaine.charAt(0) - '0' > 5 || chaine.length() != 1) {
				System.out.print(ANSI_RED_BACKGROUND+"\t\t Saisie invalide, veuillez entrer un chiffre valide : "+ANSI_RESET);			

			chaine = sc.nextLine();
		}
		return chaine.charAt(0);
	}
	
	public static char saisieRetourMenu() {
		String chaine = sc.nextLine();
		while (chaine.equals("")) {
				System.out.print(ANSI_RED_BACKGROUND+"\t\t Saisie invalide, veuillez entrer un chiffre valide : "+ANSI_RESET);			

			chaine = sc.nextLine();
		}
		return chaine.charAt(0);
	}

	public static void clearScreen() {  
		System.out.println(System.lineSeparator().repeat(70));
	}  


}
