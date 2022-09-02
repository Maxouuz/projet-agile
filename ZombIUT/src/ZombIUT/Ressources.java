package ZombIUT;

public enum Ressources {

	EAU("bouteille d'eau"), PAIN("morceau de pain");
	
	private String nom;
	
	Ressources(String nom) {
		this.nom = nom;	
	}

	public String getNom() {
		return nom;
	}
	
}
