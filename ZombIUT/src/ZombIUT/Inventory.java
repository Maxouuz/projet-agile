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
	
}