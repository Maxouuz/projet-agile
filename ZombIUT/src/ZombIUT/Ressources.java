package ZombIUT;

public enum Ressources {

	EAU("Bouteille d'eau"), PAIN("Morceau de Pain"), MASQUE("Masque à Gaz"), CARTE("Carte des alentours"), KIT("Kit de premier secours"), SAC("Un sac à dos basique"), HACHE("Outils simple pour ce défendre"), FUSIL("Arme à feu");
	
	private String nom;
	
	Ressources(String nom) {
		this.nom = nom;	
	}

	public String getNom() {
		return nom;
	}
	
}
