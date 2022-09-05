package Test;


import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ZombIUT.Inventory;
import ZombIUT.Ressources;

public class InventoryTest {
	private Inventory i;
	
	@BeforeEach
	private void initialize() {
		i = new Inventory();
	}
	
	@Test
	private void addTest() {
		assertTrue(i.getInventory().isEmpty());
		i.add(Ressources.EAU, 2);
		assertFalse(i.getInventory().isEmpty());
		assertTrue(i.add(Ressources.CARTE, 1));
		assertTrue(i.add(Ressources.FUSIL, 1));
		assertTrue(i.add(Ressources.HACHE, 1));
		assertTrue(i.add(Ressources.KIT, 1));
		assertFalse(i.add(Ressources.PAIN, 1));
	}
}
