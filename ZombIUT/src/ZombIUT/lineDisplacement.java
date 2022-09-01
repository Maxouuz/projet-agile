package ZombIUT;

import java.util.ArrayList;

public class lineDisplacement {
	
	public static void main(String[] args) {
		Lane l = new Lane();
		int playerPosition = 0;
		l.move(playerPosition, 1);
		l.print(playerPosition);
		l.move(playerPosition, -1);
	}
}
