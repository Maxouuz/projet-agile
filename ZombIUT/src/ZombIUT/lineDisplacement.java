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


            Scanner sc = new Scanner(System.in);
            String choix;
            boolean isTrue = false;
            do {
                l.pick(p.getPosition(), p.getInventory()); 
                p.dispInventory();
                choix = sc.nextLine();
                Menu.clearScreen();
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

            }while(!isTrue && p.getInventory().inventory.size()<5);
            System.out.println("Vous avez récupéré 5 objets ! Vous n'avez plus de place et vous devez maintenant survivre.");
    }
}