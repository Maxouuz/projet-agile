package ZombIUT;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class lineDisplacement {

    public static void main(String[] args) {
    	Player p = new Player("name");
        play(p);
    }

        public static void play(Player p) {
        	p.getInventory().add(Ressources.EAU, 2);
        	p.getInventory().add(Ressources.PAIN, 2);
        	System.out.println("Vous commencez avec 2 eaux et 2 pains." );
            Lane l = new Lane();
            l.print(p.getPosition());
        	l.pick(p.getPosition(), p.getInventory()); 
            do {
    			p.dispInventory();
            	l.move(p.getPosition());
            	l.pick(p.getPosition(), p.getInventory()); 
            		
            			
        
            		
            }while( p.getInventory().countObjects()<9);
            System.out.println("Vous avez récupéré 5 objets ! Vous n'avez plus de place et vous devez maintenant survivre.");
    }
}

                