package ZombIUT;

public class Coordonates {
    private int x, y;

    public Coordonates( int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Coordonates other = (Coordonates) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}

    
    
//ceci sont les coordonées du joueur.
}
