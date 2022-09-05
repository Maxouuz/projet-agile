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
			if(p.getDaysSurvived()%5==0) {
				System.out.println(Menu.ANSI_RED_BACKGROUND+"Voulez vous sauvegader le jeu et quitter ? 1: Oui 2: Non"+Menu.ANSI_RESET);
				choix = Survie.saisie1ou2();
				
				if(choix=='1') {
					p.toJSON();
					System.exit(0);
				
			}
			}
			Menu.clearScreen();
			System.out.println(Menu.ANSI_RED_BACKGROUND+"Jour :"+p.getDaysSurvived()+Menu.ANSI_RESET);
			System.out.println("Votre Status :"+Menu.ANSI_RESET);
			// afficher les barres
			p.dispHealtLvl();
			p.dispHungerLvl();
			p.dispWaterLvl();

			
			if(p.isStarving()) {
				System.out.println(Menu.ANSI_RED+"Vous avez faim"+Menu.ANSI_RESET);
			}
		    if(p.isThirsty()) {
		    	System.out.println(Menu.ANSI_RED+"Vous avez soif"+Menu.ANSI_RESET);
		    }
			
			System.out.println(Menu.ANSI_RED+"Inventaire :"+Menu.ANSI_RESET);
			p.dispInventory();
			System.out.println();

			
			System.out.println(Menu.ANSI_RED_BACKGROUND+"Voulez-vous manger ? 1: Oui 2: Non"+Menu.ANSI_RESET);
			choix = Survie.saisie1ou2();

			if(choix=='1') {
				if(p.getInventory().sameObject(Ressources.valueOf("PAIN"))){
					p.eat();
					p.getInventory().remove(Ressources.valueOf("PAIN"), 1);
				} else {
					System.out.println(Menu.ANSI_YELLOW+"Vous n'avez pas de quoi manger"+Menu.ANSI_RESET);
				}

			} 

			
			System.out.println(Menu.ANSI_RED_BACKGROUND+"Voulez-vous boire ? 1: Oui 2: Non"+Menu.ANSI_RESET);
			
			choix = Survie.saisie1ou2();
			
			if(choix=='1') {
				if(p.getInventory().sameObject(Ressources.valueOf("EAU"))) {
					p.drink();
					p.getInventory().remove(Ressources.valueOf("EAU"), 1);	
					dayWithoutDrink =0;
				}else {
					System.out.println(Menu.ANSI_YELLOW+"Vous n'avez pas de quoi boire"+Menu.ANSI_RESET);
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
			
			
			
			System.out.println(Menu.ANSI_RED_BACKGROUND+"Voulez-vous sortir ? 1: Oui 2: Non"+Menu.ANSI_RESET);
			// si oui : evenement aleatoire 
			choix = Survie.saisie1ou2();

			if(choix=='1') {
				if(!p.getInventory().inventory.containsKey(Ressources.MASQUE)) {
					p.minusHealtLvl(1);
				}
				// Choix evenement
				Events e = new Events();
				e.collecteDonner();
				e.dropEvent(p);

			}
			
			System.out.println(Menu.ANSI_RED+"La nuit tombe"+Menu.ANSI_RESET);

			try {
				TimeUnit.SECONDS.sleep(3);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			p.dayPass();
			
			
			if((p.getThirst() == 0 && dayWithoutDrink == 3)|| p.getHealtLvl()<=0) {
				dead=true;
				System.out.println(Menu.ANSI_RED_BACKGROUND+"Vous êtes mort le jour :"+p.getDaysSurvived());
				try {
					TimeUnit.SECONDS.sleep(4);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
		writeScore(p);
		//p.toJSON();

	}



	public static char saisie1ou2() {
		String chaine = sc.nextLine();
		while (chaine.equals("") || chaine.charAt(0) - '0' < 1 || chaine.charAt(0) - '0' > 2 || chaine.length() != 1) {
			System.out.print("\t\t Saisie invalide, veuillez entrer un chiffre valide : "+Menu.ANSI_RESET);			

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
