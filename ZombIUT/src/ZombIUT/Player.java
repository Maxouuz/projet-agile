package ZombIUT;

public class Player {
	private final static int MAXWATERLVL = 5;
	private int waterLvl;
	private boolean isThirsty;
	private Inventory inventory;
	private Coordonates position;
	
	public Player() {
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
	
	
	
	public void dispWaterLvl() {
		for(int i = 0 ; i < waterLvl ; i++)
			System.out.println("💧");
	}
}
