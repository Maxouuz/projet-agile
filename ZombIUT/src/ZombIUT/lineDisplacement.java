package ZombIUT;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class lineDisplacement {

    public static void main(String[] args) {
    	/*System.out.print("Entrez votre pseudo :");
    	
    	Scanner sc= new Scanner(System.in);
    	String nom = sc.nextLine();
    	
    	System.out.println("Vous vous appelez "+ nom);*/
    	Player p  = new Player ("jfj");
    	
        Lane l = new Lane();
        l.print(p.getPosition());
        
        
        l.move(p.getPosition(), 1);
        System.out.println("MOUVEMENT");
        l.print(p.getPosition());
    }
}
