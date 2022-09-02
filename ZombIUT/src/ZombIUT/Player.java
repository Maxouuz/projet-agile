package ZombIUT;

public class Player {
	private final String NAME;
	private final static int MAXWATERLVL = 5;
	private int waterLvl;
	private boolean isThirsty;
	private Inventory inventory;
	private Coordonates position;
	
	public Player(String name) {
		NAME = name;
		isThirsty = false;
		waterLvl = MAXWATERLVL;
		inventory = new Inventory();
		position = new Coordonates(0, 0);
	}
	
	public int getWaterLvl() {
		return waterLvl;
	}
	
	public boolean isThirsty() {
		return isThirsty;
	}
	
	public void dayPast() {
		waterLvl -= 1;
		if(waterLvl <= 3) 
			isThirsty = true;
	}
	
	public void setPosition(int x, int y) {
		position.setX(x);
		position.setY(y);
	}

	public Coordonates getPosition() {
		return position;
	}
	
	public void setPosition(Coordonates other) {
		position = other;
	}
	
	//TODO
	public void dispInventory() {
		inventory.affichage();
	}
	
	public Inventory getInventory() {
		return inventory;
	}


	public void dispWaterLvl() {
		for(int i = 0 ; i < waterLvl ; i++)
			System.out.print("💧");
		System.out.println();
	}

	@Override
	public String toString() {
		return "Player [NAME=" + NAME + ", waterLvl=" + waterLvl + ", isThirsty=" + isThirsty + ", inventory="
				+ inventory + ", position=" + position + "]";
	}
	
	
}
