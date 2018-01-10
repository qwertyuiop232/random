package adventureGame;

public class items {
	private int invQuantity;
	private String name;
	
	public items(String name, int cost) {
		this.name = name;
	}
	public void addItem(int added) {
		invQuantity += added;
	}
	public int getQTY() {
		return invQuantity;
	}
	public String getName() {
		return name;
	}
}
