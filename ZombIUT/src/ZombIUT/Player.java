package ZombIUT;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Player {

	private String name;
	private final static int MAXTHIRST = 3;
	private final static int MAXHUNGERLVL = 3;
	private final static int MAXHEALTLVL = 5;
	private final static int MAXSANITYLVL = 5;
	private final static int MAXRADIOACTIVITYLVL = 5;
	private final static int THIRSTTRESHOLD = 3;
	private final static int STARVATIONTRESHOLD = 3;
	private int daysSurvived;
	private int thirst;
	private int hungerLvl;
	private int healtLvl;
	private int sanityLvl;
	private int radioactivityLvl;
	private boolean isThirsty;
	private boolean isStarving;
	private Inventory inventory;
	private Coordonates position;

	public Player(String name) {
		this.name = name;
		daysSurvived = 0;
		isThirsty = false;
		isStarving = false;
		thirst = MAXTHIRST;
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

	public int getDaysSurvived() {
		return daysSurvived;
	}

	public int getHungerLvl() {
		return hungerLvl;
	}

	public int getThirst() {
		return thirst;
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

	public String getName() {
		return name;
	}

	public void dayPass() {
		if (thirst > 0) {
			thirst -= 1;
		}

		if (hungerLvl > 0) {
			hungerLvl -= 1;
		}

		if (hungerLvl > 0) {
			sanityLvl -= 1;
		}
		if (thirst < THIRSTTRESHOLD)
			isThirsty = true;
		if (hungerLvl < STARVATIONTRESHOLD)
			isStarving = true;
		if (hungerLvl == 0 || thirst == 0) {
			healtLvl = 0;
		}
		if (sanityLvl == 0) {
			healtLvl -= 1;
		}
		if (radioactivityLvl == MAXRADIOACTIVITYLVL) {
			healtLvl -= 1;
		}
		if (hungerLvl == 0 && thirst == 0) {
			healtLvl -=1;
		}

		daysSurvived++;
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

	public void dispInventory() {
		inventory.displayInventory();
	}

	public void minusHealtLvl(int newHeal) {
		healtLvl = healtLvl-newHeal; 
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
		for (int i = 0; i < thirst; i++)
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

	public void eat() {
		if (hungerLvl <= MAXHUNGERLVL)
			hungerLvl = hungerLvl + 2;
		if (hungerLvl > STARVATIONTRESHOLD)
			isStarving = false;
	}

	public void drink() {
		if (thirst <= MAXTHIRST)
			thirst = thirst + 2;
		if (thirst > THIRSTTRESHOLD)
			isThirsty = false;
	}

	public void increaseRadiation() {
		if (radioactivityLvl < MAXRADIOACTIVITYLVL)
			radioactivityLvl++;
	}

	@Override
	public String toString() {
		return "Player [NAME=" + name + ", waterLvl=" + thirst + ", hungerLvl=" + hungerLvl + ", healtLvl=" + healtLvl
				+ ", sanityLvl=" + sanityLvl + ", radioactivityLvl=" + radioactivityLvl + ", isThirsty=" + isThirsty
				+ ", isStarving=" + isStarving + ", inventory=" + inventory + ", position=" + position + "]";
	}

	/*
	 * FORMAT DU FICHIER DE SAUVEGARDE
	 */
	public void toJSON() {
		// Instanciation du créateur de JSON
		JSONObject json = new JSONObject();
		JSONArray inventaire = new JSONArray();

		json.put("daysSurvived", daysSurvived);
		json.put("waterlvl", thirst);
		json.put("hungerlvl", hungerLvl);
		json.put("healtlvl", healtLvl);
		json.put("sanitylvl", sanityLvl);

		for (Map.Entry<Ressources, Integer> entry : inventory.getInventory().entrySet()) {
			JSONObject obj = new JSONObject();
			obj.put("nom", entry.getKey());
			obj.put("quantite", entry.getValue());
			inventaire.put(obj);
		}
		json.put("inventaire", inventaire);
		// Ecriture du texte dans le fichier:
		try (Writer fichier = new FileWriter(getName() + ".json")) {
			json.write(fichier, 4, 0);
		} catch (IOException e) {
			System.out.println("Impossible de créer le fichier !");
			e.printStackTrace();
		}

	}

	public void jSonToString(String name) {
		
		try {
			String fichier = Files.readString(Paths.get(name + ".json"));
			JSONObject jsonO = new JSONObject(fichier);
			this.daysSurvived = Integer.parseInt(jsonO.get("daysSurvived").toString());
			this.healtLvl = (int) jsonO.get("healtlvl");
			this.hungerLvl = (int) jsonO.get("hungerlvl");
			this.name = fichier.toString();
			this.sanityLvl = (int) jsonO.get("sanitylvl");
			
			JSONArray inventaire = jsonO.getJSONArray("inventaire");
			
			for (int i = 0; i < inventaire.length(); i++) {
				JSONObject key = inventaire.getJSONObject(i);
				int value = key.getInt("quantite");
				Ressources r = Ressources.valueOf(key.getString("nom"));
				inventory.add(r, value);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}