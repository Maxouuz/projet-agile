package ZombIUT;

public class Player {
	private final String NAME;
	private final static int MAXWATERLVL = 5;
	private final static int MAXHUNGERLVL = 5;
	private final static int MAXHEALTLVL = 5;
	private final static int MAXSANITYLVL = 5;
	private final static int MAXRADIOACTIVITYLVL = 5;
	private int waterLvl;
	private int hungerLvl;
	private int healtLvl;
	private int sanityLvl;
	private int radioactivityLvl;
	private boolean isThirsty;
	private boolean isStarving;
	private Inventory inventory;
	private Coordonates position;

	public Player(String name) {
		NAME = name;
		isThirsty = false;
		isStarving = false;
		waterLvl = MAXWATERLVL;
		hungerLvl = MAXHUNGERLVL;
		healtLvl = MAXHEALTLVL;
		sanityLvl = MAXSANITYLVL;
		radioactivityLvl = 0;
		inventory = new Inventory();
		position = new Coordonates(0, 0);
	}

	public int getRadioactivityLvl() {
		return radioactivityLvl;
	}

	public int getSanityLvl() {
		return sanityLvl;
	}

	public int getHealtLvl() {
		return healtLvl;
	}

	public int getHungerLvl() {
		return hungerLvl;
	}

	public int getWaterLvl() {
		return waterLvl;
	}

	public boolean isStarving() {
		return isStarving;
	}

	public boolean isThirsty() {
		return isThirsty;
	}

	public Inventory getInventory() {
		return inventory;
	}

	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}

	public void dayPast() {
		waterLvl -= 1;
		hungerLvl -= 1;
		sanityLvl -= 1;
		if (waterLvl < 3)
			isThirsty = true;
		if (hungerLvl < 3)
			isStarving = true;
		if (hungerLvl == 0 || waterLvl == 0) {
			healtLvl = 0;
		}
		if (sanityLvl == 0) {
			healtLvl -= 1;
		}
		if(radioactivityLvl == 5) {
			healtLvl -= 1;
		}
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

	// TODO
	public void dispInventory() {
		inventory.affichage();
	}

	public void dispHealtLvl() {
		for (int i = 0; i < healtLvl; i++)
			System.out.print("❤️");
		System.out.println();
	}

	public void dispRadioactivityLvl() {
		for (int i = 0; i < radioactivityLvl; i++)
			System.out.print("❤☢️");
		System.out.println();
	}

	public void dispWaterLvl() {
		for (int i = 0; i < waterLvl; i++)
			System.out.print("💧");
		System.out.println();
	}

	public void dispHungerLvl() {
		for (int i = 0; i < hungerLvl; i++)
			System.out.print("🍗");
		System.out.println();
	}

	public void dispSanityLvl() {
		for (int i = 0; i < sanityLvl; i++)
			System.out.print("🧼");
		System.out.println();
	}

	@Override
	public String toString() {
		return "Player [NAME=" + NAME + ", waterLvl=" + waterLvl + ", hungerLvl=" + hungerLvl + ", healtLvl=" + healtLvl
				+ ", sanityLvl=" + sanityLvl + ", radioactivityLvl=" + radioactivityLvl + ", isThirsty=" + isThirsty
				+ ", isStarving=" + isStarving + ", inventory=" + inventory + ", position=" + position + "]";
	}

}