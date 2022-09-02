package ZombIUT;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class lineDisplacement {

    public static void main(String[] args) {

    	play();
    }
    
        public static void play() {
        	Player p  = new Player ("jfj");
        	
            Lane l = new Lane();
            l.print(p.getPosition());
            
            boolean isTrue = false;
            do {
            	l.pick(p.getPosition(), p.getInventory()); 
    			p.dispInventory();
            	l.move(p.getPosition());
            		
            			
        
            		
            }while( p.getInventory().compteObjets()<5);
            System.out.println("Vous avez récupéré 5 objets ! Vous n'avez plus de place et vous devez maintenant survivre.");
    }
}

