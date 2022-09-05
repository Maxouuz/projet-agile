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

            Lane l = new Lane();
            l.print(p.getPosition());
            do {
            	l.pick(p.getPosition(), p.getInventory()); 
    			p.dispInventory();
            	l.move(p.getPosition());
            		
            			
        
            		
            }while( p.getInventory().countObjects()<5);
            System.out.println("Vous avez récupéré 5 objets ! Vous n'avez plus de place et vous devez maintenant survivre.");
    }
}

                