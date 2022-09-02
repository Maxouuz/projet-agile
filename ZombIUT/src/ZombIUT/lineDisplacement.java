package ZombIUT;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class lineDisplacement {

    public static void main(String[] args) {
<<<<<<< HEAD
    	
=======
    	/*System.out.print("Entrez votre pseudo :");
    	
    	Scanner sc= new Scanner(System.in);
    	String nom = sc.nextLine();
    	
    	System.out.println("Vous vous appelez "+ nom);*/
>>>>>>> 534e066492bd4083ce8a594721def3f38ffdced1
    	Player p  = new Player ("jfj");
    	
        Lane l = new Lane();
        l.print(p.getPosition());
        
<<<<<<< HEAD
        Scanner sc = new Scanner(System.in);
        String choix;
        boolean isTrue = false;
        while(!isTrue) {
        	choix = sc.nextLine();
        		if(choix.equals("q")) {
        			l.move(p.getPosition(), -1);
        			l.print(p.getPosition());
        			        			
        		}else if(choix.equals("d")) {
        			l.move(p.getPosition(), 1);
        			l.print(p.getPosition());
        			
        		}else if(choix.equals("exit")){
        			isTrue = true;
        			
        		}else {
        			System.out.println("veuillez choisir la gauche ou la droite");
        		}
        		
        }
        	
        	
        //l.move(p.getPosition(), 1);
        //System.out.println("MOUVEMENT");
        //l.print(p.getPosition());
=======
        
        l.move(p.getPosition(), 1);
        System.out.println("MOUVEMENT");
        l.print(p.getPosition());
>>>>>>> 534e066492bd4083ce8a594721def3f38ffdced1
    }
}

