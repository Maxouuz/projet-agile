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
            	stuff.add("***");
                
            }else {
                //randObject.doubles
                stuff.add(" 0 ");
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
            }else {
                System.out.print(""+ stuff.get(i)+"|");
            }
            
        }
        System.out.println();
        
    }
   
    
}
