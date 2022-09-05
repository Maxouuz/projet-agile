package Test;


import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

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
	public void addTest() {
		assertTrue(i.getInventory().isEmpty());
		i.add(Ressources.EAU, 2);
		assertFalse(i.getInventory().isEmpty());
		assertTrue(i.add(Ressources.CARTE, 1));
		assertTrue(i.add(Ressources.FUSIL, 1));
		assertTrue(i.add(Ressources.HACHE, 1));
		assertTrue(i.add(Ressources.KIT, 1));
		assertFalse(i.add(Ressources.PAIN, 1));
	}
	
	@Test
	public void sameObjectTest() {
		i.add(Ressources.EAU, 1);
		assertTrue(i.sameObject(Ressources.EAU));
		assertFalse(i.sameObject(Ressources.CARTE));
	}
	
	@Test
	public void countObjectsTest() {
		i.add(Ressources.CARTE, 1);
		i.add(Ressources.FUSIL, 1);
		i.add(Ressources.HACHE, 1);
		i.add(Ressources.KIT, 1);
		assertEquals(4, i.countObjects());
	}
	
	@Test
	public void clearTest() {
		i.add(Ressources.CARTE, 1);
		i.add(Ressources.FUSIL, 1);
		i.add(Ressources.HACHE, 1);
		i.add(Ressources.KIT, 1);
		assertEquals(4, i.countObjects());
		i.clearAll();
		assertEquals(0, i.countObjects());
	}
	
	
}
