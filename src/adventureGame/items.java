package adventureGame;

public class items {
	private String name;
	private int ID;
	private int cost;
	
	public items(int newID, String name, int cost) {
		this.name = name;
		ID = newID;
		this.cost = cost;
	}
	public String getName() {
		return name;
	}
	public int getID() {
		return ID;
	}
	public void setID(int newID) {
		ID = newID;
	}
	public int getCost() {
		return cost;
	}

}
