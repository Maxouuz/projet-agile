package ZombIUT;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Lane {
    
    final int SIZE = 10;
    ArrayList<String> stuff = new ArrayList();
    
    public Lane() {
        int i = 0;
        while(i < SIZE) {
            Random randPres = new Random();
            //Random randObject = new Random();
            
            if(randPres.nextInt(2) == 0){
            	int rand=randPres.nextInt(8);
            	for(Ressources r : Ressources.values()) {
            		if(rand==r.getPlace()) {
            			stuff.add(r.getNom());
            		}
            	}
                
            }else {
                //randObject.doubles
                stuff.add("   ");
            }
            
            i++;
        }
    }
    
    protected boolean allowDisplacement(Coordonates playerPosition, int displacement) {
        boolean bool = false;
        if((displacement==1 && inBoard(playerPosition, displacement)) || (displacement ==-1 && inBoard(playerPosition, displacement))) {
            bool = true;
        }
        return bool;
    }
    
    protected boolean inBoard(Coordonates playerPosition, int displacement) {
        boolean in = true;
        if(playerPosition.getX()+displacement<0  || playerPosition.getX()+displacement>=SIZE) {
            in = false;
        }
        return in;
    }
    
    protected void move (Coordonates playerPosition, int displacement) {
        if(allowDisplacement(playerPosition, displacement)) {
            playerPosition.setX(playerPosition.getX()+displacement);
            
        }
    }
    
    
    
    protected void pick (Coordonates playerPosition, Inventory inventaire) {
    	
        if( !stuff.get(playerPosition.getX()).equals("   ")) {
        	if(questionPick(playerPosition)) {
        		Ressources objet =  Ressources.valueOf(stuff.get(playerPosition.getX()).toString());
        		if(inventaire.sameObject(objet )) {
        			inventaire.add(objet, inventaire.inventory.get(objet)+1);
        			replace(playerPosition);
      
        		}else {
        			inventaire.add(objet,1);
        			replace(playerPosition);
        		}
        	}
        	

        }
    }
    
    protected boolean questionPick(Coordonates playerPosition) {
    	System.out.println("Ceci est un(e) "+ stuff.get(playerPosition.getX()).toString());
        System.out.println("Souhaitez vous l'ajouter à votre inventaire ? (o/n)");
        Scanner sc = new Scanner (System.in);
        String choix;
        boolean isTrue = false;
        while(!isTrue) {
        	choix = sc.nextLine();
            if(choix.equals("o")) {
                System.out.println("Cet objet à été ajouté à votre inventaire");
                isTrue = true;
                return true;

            }else if(choix.equals("n")) {
                System.out.println("L'objet reste sur le sol");
                isTrue = true;
                return false;
            }else {
                System.out.println("Veuillez utiliser o ou n");
            }
        }
        return true;

    }
    
    protected void replace(Coordonates playerPosition) {
    	stuff.remove(playerPosition.getX());
    	stuff.add(playerPosition.getX(),"   ");
    }
    
    protected void print(Coordonates playerPosition) {
    	System.out.print("|");
        for (int i =0; i<SIZE; i++) {
            if(i==playerPosition.getX()) {
                System.out.print("X|");
            }else if(stuff.get(i).equals("   ")) {
                System.out.print(""+ stuff.get(i)+"|");
            }else {
            	System.out.print(" *** |");
            }
            
        }
        
        
        System.out.println("		"+stuff.get(playerPosition.getX()));
        
    }
   
   
}