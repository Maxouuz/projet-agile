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
            randPres.doubles(0,1);
            if(randPres.equals(0)){
                stuff.add("    ");
            }else {
                //randObject.doubles
                stuff.add("/");
            }
            
            i++;
        }
    }
    
    protected boolean allowDisplacement(int playerPosition, int displacement) {
        boolean bool = false;
        if((displacement==1 && inBoard(playerPosition, displacement)) || (displacement ==-1 && inBoard(playerPosition, displacement))) {
            bool = true;
        }
        return bool;
    }
    
    protected boolean inBoard(int playerPosition, int displacement) {
        boolean in = true;
        if(playerPosition+displacement<0  || playerPosition+displacement>SIZE) {
            in = false;
        }
        return in;
    }
    
    protected void move (int playerPosition, int displacement) {
        if(allowDisplacement(playerPosition, displacement)) {
            playerPosition+=displacement;
            
        }
    }
    
    protected void print(int playerPosition) {
        for (int i =0; i<SIZE; i++) {
            if(i==playerPosition) {
                System.out.println("|X|");
            }else {
                System.out.println("|"+ stuff.get(i)+"|");
            }
            
        }
        
    }
   
    
}