package ZombIUT;

public enum Ressources {

    EAU("EAU",0), PAIN("PAIN",1), MASQUE("MASQUE",2), CARTE("CARTE",3), KIT("KIT",4), SAC("SAC",5), HACHE("HACHE",6), FUSIL("FUSIL",7);
    
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
