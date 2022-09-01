package ZombIUT;

import java.util.ArrayList;

public class lineDisplacement {

    public static void main(String[] args) {
        Lane l = new Lane();
        int playerPosition = 0;
        l.print(playerPosition);

        playerPosition+=11;
        System.out.println("MOUVEMENT");
        l.print(playerPosition);
    }
}
