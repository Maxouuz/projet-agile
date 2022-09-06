package ZombIUT;

import java.util.HashMap;

public class Inventory {

	HashMap<Ressources, Integer> inventory;

	public Inventory() {
		inventory = new HashMap();
	}

	public boolean add(Ressources c, int quantity) {
		
			inventory.put(c, quantity);
			return true;
		
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
	public void addRemove (Ressources r1, String string) {
		int i = Integer.parseInt(string);
		if(inventory.containsKey(r1)) {
			inventory.put(r1, i+ inventory.get(r1));
		}else {
			inventory.put(r1,1);
		}
		if(inventory.get(r1)==0) {
			inventory.remove(r1);
		}
		
	}

	public HashMap<Ressources, Integer> getInventory() {
		return inventory;
	}

}