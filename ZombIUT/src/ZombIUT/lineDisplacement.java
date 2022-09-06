package ZombIUT;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class lineDisplacement {

    public static void main(String[] args) {
    	Player p = new Player("name");
        play(p);
    }

        public static void play(Player p) {
        	p.getInventory().add(Ressources.EAU, 2);
        	p.getInventory().add(Ressources.PAIN, 2);
        	System.out.println("Vous commencez avec 2 eaux et 2 pains." );
        	p.dispInventory();
        	try {
				TimeUnit.SECONDS.sleep(4);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            Lane l = new Lane();
            System.out.println("Utilisez Z,Q,S,D pour vous déplacer ! \n");
            l.print(p.getPosition());
        	l.pick(p.getPosition(), p.getInventory()); 
            do {
    			p.dispInventory();
    			System.out.println("Utilisez Z,Q,S,D pour vous déplacer ! \n");
            	l.move(p.getPosition());
            	l.pick(p.getPosition(), p.getInventory()); 
            		
            			
        
            		
            }while( p.getInventory().countObjects()<9);
            System.out.println("Vous avez récupéré 5 objets ! Vous n'avez plus de place et vous devez maintenant survivre.");
    }
}

                