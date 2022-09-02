package ZombIUT;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class lineDisplacement {

    public static void main(String[] args) {

    	Player p  = new Player ("jfj");
    	
        Lane l = new Lane();
        l.print(p.getPosition());
        

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
    }
        	
        	
        //l.move(p.getPosition(), 1);
        //System.out.println("MOUVEMENT");
        //l.print(p.getPosition());

        
        public static void play() {
        	Player p  = new Player ("jfj");
        	
            Lane l = new Lane();
            l.print(p.getPosition());
            

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
    }
}

