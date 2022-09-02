package ZombIUT;

import java.util.HashMap;
import java.util.Map;

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
			System.out.print("Vous avez: " + value + " de " + key+"\n");
			
		});
		System.out.println("Vous disposez de "+compteObjets()+" objets");
	}
	
	public int compteObjets() {
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
	
	public void remplacer(Ressources r1, int quantity, Ressources r2, int quantity2) {
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