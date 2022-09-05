package Test;


import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ZombIUT.Player;

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
		assertEquals(5, p1.getHungerLvl());
		assertEquals(5, p1.getThirst());
		assertEquals(5, p1.getSanityLvl());
		assertEquals(0, p1.getDaysSurvived());
		p1.dayPass();
		assertEquals(0, p1.getRadioactivityLvl());
		assertEquals(5, p1.getHealtLvl());
		assertEquals(4, p1.getHungerLvl());
		assertEquals(4, p1.getThirst());
		assertEquals(4, p1.getSanityLvl());
		assertEquals(1, p1.getDaysSurvived());
	}
	
	@Test
	public void eatTest() {
		p1.dayPass();
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
		p1.dayPass();
		assertTrue(p1.isThirsty());
		p1.drink();
		p1.dayPass();
		assertFalse(p1.isThirsty());
		assertEquals(3, p1.getThirst());
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
}
