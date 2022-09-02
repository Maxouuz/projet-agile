package ZombIUT;

import java.util.HashMap;

public class Inventory {

	HashMap<Ressources, Integer> inventory;
	
	public Inventory() {
		inventory = new HashMap();
	}
	
	public void add(Ressources c, int quantity) {
		if (inventory.size() < 5) {
			inventory.put(c, quantity);
		}		
	}
	
	public void remove(Ressources c, int quantity) {
		inventory.remove(c, quantity);
	}
	
	public void affichage () {
		inventory.forEach((key, value) -> {
			System.out.print("Vous avez: " + value + " de " + key);
		});
	}
	
	public void clearAll() {
		inventory.clear();
	}
	
	public void remplacer(Ressources r1, int quantity, Ressources r2, int quantity2) {
		inventory.forEach((key, value) -> {
			if (key == r1) {
				remove(r1, quantity);
				add(r2, quantity2);
			} else {
				System.out.println("Cet object ne ce trouve pas dans votre inventaire");
			}
		});
	}

	public HashMap<Ressources, Integer> getInventory() {
		return inventory;
	}
	
}