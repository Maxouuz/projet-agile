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
			MenuDuDebut();
			
			System.out.println("Choix:");
			

			while(x!=1 && x!=2 && x!=3) {    
			  x = sc.nextInt();
			} 
			
			if(x==1) {
				
				
				System.out.println();
				System.out.println("Pseudo 1:");
				String name = sc.next();
				Player p = new Player(name);
				System.out.println(p);
				
				
			} else if (x==2) {
				regle();
				System.out.println("Entrer une touche pour revenir");
				x = sc.nextInt();
				

			} else if (x==3){
				
			}else if (x==4){
				
			}	else if (x==5){
				ff=false;
			}		
		}
				return 42;
	}
	
	public static void MenuDuDebut() {
		System.out.println("Bienvenue dans ZombIUT");
		System.out.println("Choix :");
		System.out.println("1: Play ");
		System.out.println("2: Rules");
		System.out.println("3: Reload");
		System.out.println("4: Score");
		System.out.println("5: Exit");
	}
	
	
	public static void regle() {
		System.out.println("oui");

	}
	
	
}
