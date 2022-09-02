package ZombIUT;

import java.util.ArrayList;
import java.util.Random;

public class lineDisplacement {

    public static void main(String[] args) {
        Lane l = new Lane();
        int playerPosition = 0;
        l.print(playerPosition);
        playerPosition+=1;
        System.out.println("MOUVEMENT");
        l.print(playerPosition);
    }
}
