package ZombIUT;

import java.util.ArrayList;
import java.util.Random;

public class Lane {
    
    final int SIZE = 10;
    ArrayList stuff = new ArrayList();
    
    public Lane() {
        int i = 0;
        while(i < SIZE) {
            Random randPres = new Random();
            //Random randObject = new Random();
            
            if(randPres.nextInt(3) == 0){
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
