package Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.HashMap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ZombIUT.Coordonates;
import ZombIUT.Inventory;
import ZombIUT.Player;
import ZombIUT.Ressources;

public class PlayerTest {
	private Player p1;

	@BeforeEach
	public void initialize() {
		p1 = new Player("p1");
	}

	@Test
	public void dayPassTest() {
		assertEquals(0, p1.getRadioactivityLvl());
		assertEquals(5, p1.getHealtLvl());
		assertEquals(3, p1.getHungerLvl());
		assertEquals(3, p1.getThirst());
		assertEquals(0, p1.getDaysSurvived());
		p1.dayPass();
		assertEquals(0, p1.getRadioactivityLvl());
		assertEquals(5, p1.getHealtLvl());
		assertEquals(2, p1.getHungerLvl());
		assertEquals(2, p1.getThirst());
		assertEquals(1, p1.getDaysSurvived());
	}

	@Test
	public void eatTest() {
		p1.dayPass();
		p1.dayPass();
		assertTrue(p1.isStarving());
		p1.eat();
		p1.dayPass();
		assertFalse(p1.isStarving());
	}

	@Test
	public void drinkTest() {
		p1.dayPass();
		p1.dayPass();
		assertTrue(p1.isThirsty());
		p1.drink();
		p1.dayPass();
		assertFalse(p1.isThirsty());
		assertEquals(2, p1.getThirst());
	}

	@Test
	public void radioactivityTest() {
		p1.increaseRadiation();
		assertEquals(1, p1.getRadioactivityLvl());
		p1.increaseRadiation();
		p1.increaseRadiation();
		p1.increaseRadiation();
		p1.increaseRadiation();
		assertEquals(5, p1.getRadioactivityLvl());
		p1.increaseRadiation();
		assertEquals(5, p1.getRadioactivityLvl());
		p1.dayPass();
		assertEquals(4, p1.getHealtLvl());
	}

	@Test
	public void inventoryTest() {
		HashMap<Ressources, Integer> truc = new HashMap<>();
		assertTrue(truc.equals(p1.getInventory().getInventory()));
		truc.put(Ressources.CARTE, 1);
		assertFalse(truc.equals(p1.getInventory().getInventory()));
		Inventory tmp = new Inventory();
		tmp.add(Ressources.CARTE, 1);
		p1.setInventory(tmp);
		assertTrue(truc.equals(p1.getInventory().getInventory()));
	}

	@Test
	public void getNameTest() {
		assertEquals("p1", p1.getName());
	}

	@Test
	public void positionTest() {
		Coordonates c = new Coordonates(0, 0);
		assertEquals(c, p1.getPosition());
		c.setX(2);
		assertFalse(p1.getPosition().equals(c));
		p1.getPosition().setX(2);
		c.setY(6);
		assertFalse(p1.getPosition().equals(c));
		p1.setPosition(c);
		assertEquals(c, p1.getPosition());
		assertEquals(2, p1.getPosition().getX());
		assertEquals(6, p1.getPosition().getY());
		assertFalse(c.equals(null));
		assertFalse(c.equals(Ressources.CARTE));
	}
	
}
