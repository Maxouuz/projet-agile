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
import java.util.ArrayList;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;


public class Player {
	private String name;
	private final static int MAXWATERLVL = 3;
	private final static int MAXHUNGERLVL = 3;
	private final static int MAXHEALTLVL = 3;
	private final static int MAXSANITYLVL = 3;
	private final static int MAXRADIOACTIVITYLVL = 5;
	private int daysSurvived;
	private int waterLvl;
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
		daysSurvived = 1;
		isThirsty = false;
		isStarving = false;
		waterLvl = MAXWATERLVL;
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

	public int getWaterLvl() {
		return waterLvl;
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
		if (waterLvl > 0) {
			waterLvl -= 1;
		}

		if (hungerLvl > 0) {
			hungerLvl -= 1;
		}

		if (hungerLvl > 0) {
			sanityLvl -= 1;
		}

		if (waterLvl < 3)
			isThirsty = true;
		if (hungerLvl < 3)
			isStarving = true;
		if (hungerLvl == 0 || waterLvl == 0) {
			healtLvl = 0;
		}
		if (sanityLvl == 0) {
			healtLvl -= 1;
		}
		if (radioactivityLvl == 5) {
			healtLvl -= 1;
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
		inventory.affichage();
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
		for (int i = 0; i < waterLvl; i++)
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

	public void isEating() {
		if(hungerLvl<=MAXHUNGERLVL) {
			hungerLvl=hungerLvl+2;
		} 
	}

	public void isDrinking() {
		if (waterLvl <= MAXWATERLVL) {
			waterLvl = waterLvl + 2;
		}
	}

	@Override
	public String toString() {
		return "Player [NAME=" + name + ", waterLvl=" + waterLvl + ", hungerLvl=" + hungerLvl + ", healtLvl=" + healtLvl
				+ ", sanityLvl=" + sanityLvl + ", radioactivityLvl=" + radioactivityLvl + ", isThirsty=" + isThirsty
				+ ", isStarving=" + isStarving + ", inventory=" + inventory + ", position=" + position + "]";
	}
	
	/*FORMAT DU FICHIER DE SAUVEGARDE
	 * */
    public void toJSON(){
        // Instanciation du créateur de JSON
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        // Convertion de la HashMap en texte
        String nom = gson.toJson(name);
        String daysurvived = gson.toJson(daysSurvived);
        String waterlvl = gson.toJson(waterLvl);
        String hungerlvl = gson.toJson(hungerLvl);
        String sanitylvl = gson.toJson(sanityLvl);
        String healtlvl = gson.toJson(healtLvl);
        String inventaire =  gson.toJson(inventory);
        // Ecriture du texte dans le fichier: Sauvegarde.json
        try(FileWriter fichier = new FileWriter("Sauvegarde.json")){
            fichier.write(nom);
            fichier.write(healtlvl);
            fichier.write(hungerlvl);
            fichier.write(waterlvl);
            fichier.write(sanitylvl);
        	fichier.write(inventaire);
            fichier.close();
        } catch(IOException e){
            System.out.println("Impossible de créer le fichier !");
            e.printStackTrace();
        }

    }

}