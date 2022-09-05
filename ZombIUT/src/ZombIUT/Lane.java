package ZombIUT;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Lane {
    
    final int SIZE = 40;
    ArrayList<String> stuff = new ArrayList();
    
    public Lane() {
        int i = 0;
        int nbObjets=0;
        boolean isTrue=true;
        while (isTrue) {
        	while(i < SIZE ) {
        		Random randPres = new Random();
        		//	Random randObject = new Random();
            	if(randPres.nextInt(4) == 0){
            		nbObjets++;
            		int rand=randPres.nextInt(8);
            		for(Ressources r : Ressources.values()) {
            			if(rand==r.getPlace()) {
            			stuff.add(r.getNom());
            			}
            		}
                
            	}else {
            		//	randObject.doubles
            		stuff.add("   ");
            	}
            
            	i++;
        	}
        	
        	if(nbObjets>=5) {
        		isTrue = false;
        	}else {
        		stuff.clear();
        	}
        }
        
    }
    
    protected boolean allowDisplacement(Coordonates playerPosition, int displacement) {
        boolean bool = false;
        if((displacement ==1 ||displacement == 5) && inBoard(playerPosition, displacement)|| ((displacement ==-1 ||displacement == -5) && inBoard(playerPosition, displacement))) {
            bool = true;
        }
        return bool;
    }
    
    protected boolean inBoard(Coordonates playerPosition, int displacement) {
        boolean in = true;
        if((playerPosition.getX()+displacement<0  || playerPosition.getX()+displacement>=SIZE )) {
            in = false;
        }
        return in;
    }
    
    protected void move (Coordonates playerPosition) {
            Scanner sc = new Scanner(System.in);
            String choix;
            boolean isTrue = false;
            do {
            	choix = sc.nextLine();
            		if(choix.equals("q")) {
            			int displacement = -1;
            			if(allowDisplacement(playerPosition, displacement)) {
            	            playerPosition.setX(playerPosition.getX()+displacement);
            			}
            			print(playerPosition);
            			isTrue = true;
            		}else if(choix.equals("d")) {
            			if(allowDisplacement(playerPosition, 1)) {
            	            playerPosition.setX(playerPosition.getX()+1);
            			}
            			print(playerPosition);
            			isTrue = true;
            		}else if(choix.equals("z")) {
            			if(allowDisplacement(playerPosition, -5)) {
            	            playerPosition.setX(playerPosition.getX()-5);
            			}
            			print(playerPosition);
            			isTrue = true;
            		}else if(choix.equals("s")) {
            			if(allowDisplacement(playerPosition, 5)) {
            	            playerPosition.setX(playerPosition.getX()+5);
            			}
            			print(playerPosition);
            			isTrue = true;
            		}
            		
            		else {
            			System.out.println("veuillez choisir la gauche ou la droite");
            		}
    
            		
            }while(!isTrue );
            
            
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
        System.out.println(Menu.ANSI_BLUE_BACKGROUND+"Souhaitez vous l'ajouter à votre inventaire ? (o/n)"+Menu.ANSI_RESET);
        Scanner sc = new Scanner (System.in);
        String choix;
        boolean isTrue = false;
        while(!isTrue) {
        	choix = sc.nextLine();
            if(choix.equals("o")) {
                System.out.println(Menu.ANSI_YELLOW+"Cet objet à été ajouté à votre inventaire"+Menu.ANSI_RESET);
                isTrue = true;
                return true;

            }else if(choix.equals("n")) {
                System.out.println(Menu.ANSI_CYAN+"L'objet reste sur le sol"+Menu.ANSI_RESET);
                isTrue = true;
                return false;
            }else {
                System.out.println(Menu.ANSI_YELLOW+"Veuillez utiliser o ou n"+Menu.ANSI_RESET);
            }
        }
        return true;

    }
    
    protected void replace(Coordonates playerPosition) {
    	stuff.remove(playerPosition.getX());
    	stuff.add(playerPosition.getX(),"   ");
    }
    
    protected void print(Coordonates playerPosition) {
    	Menu.clearScreen();
    	System.out.print("|");
        for (int i =0; i<SIZE; i++) {
            if(i==playerPosition.getX()) {
                System.out.print(Menu.ANSI_RED+" x"+Menu.ANSI_RESET+" |");
            }else if(stuff.get(i).equals("   ")) {
                System.out.print(Menu.ANSI_RED+""+ stuff.get(i)+"|"+Menu.ANSI_RESET);
            }else {
            	System.out.print(Menu.ANSI_YELLOW+"***"+Menu.ANSI_RESET+"|");
            }
            if(i%5==4 && i<38) {
            	System.out.println();
            	System.out.print("|");
            }
            
        }
        
        
        System.out.println("		"+stuff.get(playerPosition.getX()));
        
    }
   
   
}