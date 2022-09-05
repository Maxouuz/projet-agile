package ZombIUT;

import java.util.HashMap;

public class Inventory {

	HashMap<Ressources, Integer> inventory;

	public Inventory() {
		inventory = new HashMap();
	}

	public boolean add(Ressources c, int quantity) {
		if (inventory.size() < 5) {
			inventory.put(c, quantity);
			return true;
		} else
			return false;
	}

	public void remove(Ressources c, int quantity) {
		inventory.remove(c, quantity);
	}

	public void displayInventory() {
		inventory.forEach((key, value) -> {
			System.out.print("Vous avez: " + value + " de " + key + "\n");

		});
		System.out.println("Vous disposez de " + countObjects() + " objets");
	}

	public int countObjects() {
		int total = 0;
		for (Integer x : inventory.values()) {
			total += x;
		}
		return total;
	}

	public void clearAll() {
		inventory.clear();
	}

	public boolean sameObject(Ressources r) {
		return inventory.containsKey(r);
	}

	public void replace(Ressources r1, int quantity, Ressources r2, int quantity2) {
		inventory.forEach((key, value) -> {
			if (key == r1) {
				remove(r1, quantity);
				add(r2, quantity2);
			} else {
				System.out.println("Cet objet ne se trouve pas dans votre inventaire");
			}
		});
	}

	public HashMap<Ressources, Integer> getInventory() {
		return inventory;
	}

}