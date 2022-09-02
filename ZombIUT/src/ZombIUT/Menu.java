package ZombIUT;

import java.util.Scanner;

public class Menu {
	//Main
	public static void main(String[] args) {
		System.out.println("Bienvenue dans ZombIUT");
		System.out.println("Choix :");
		System.out.println("1: Play ");
		System.out.println("2: Rules");
		System.out.println("3: Reload");
		System.out.println("4: Score");
		System.out.println("5: Exit");
		
		String choix = saisieValideChoix();
		if(choix.equals("1")) {
			Scanner sc = new Scanner(System.in);
			String name =sc.nextLine();
			Player p = new Player(name);
			System.out.println(p);
		}
				
	}
	

	
	
	public static String saisieValideChoix() {
		Scanner sc = new Scanner(System.in);
		String chaine = sc.nextLine();
		while (chaine.equals("")
				|| (!chaine.equals("1") && !chaine.equals("2") && !chaine.equals("3") && !chaine.equals("4") && !chaine.equals("5") )) {
			System.out.print("\t\t\t\t Saisie invalide, veuillez entrer un choix valide : ");
			chaine = sc.nextLine();
		}
		return chaine;
	}
	
}
