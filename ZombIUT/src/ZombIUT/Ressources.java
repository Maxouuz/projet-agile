package ZombIUT;

public enum Ressources {

    EAU("Eau : Bouteille d'eau",0), PAIN("Pain : Morceau de Pain",1), MASQUE("Masque : Masque à Gaz",2), CARTE("Carte : Carte des alentours",3), KIT("Kit : Kit de premier secours",4), SAC("Sac : Un sac à dos basique",5), HACHE("Hache : Outils simple pour se défendre",6), FUSIL("Fusil : Arme à feu",7);
    
    private String nom;
    private int place;
    Ressources(String nom, int place) {
        this.nom = nom;    
        this.place = place;
    }

    public String getNom() {
        return nom;
    }
    public int getPlace() {
        return place;
    }
    

}
