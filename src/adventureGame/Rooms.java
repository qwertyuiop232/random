package adventureGame;

public class Rooms {
	private String name;
	private int ID;
	private boolean[][] boundaryMap; // 1 non moveable or false
	private int[][] tileMap;
	private int bossID;
	private boolean spawnable;
	private boolean bossAlive;
	private int[] mob = new int[3];
	private static TileMap tileMapClass;
	
	public Rooms(String name, int ID, int bossID, String mapFile, String tileFile) {
		this.name = name;
		this.ID = ID;
		this.bossID = bossID;
		spawnable = false;
		bossAlive = true;
		tileMapClass = new TileMap(tileFile);
		tileMap = tileMapClass.getMap();
		boundaryMap = tileMapClass.boundaryMap();
	}
	public Rooms(String name, int ID, boolean spawnable, int mob1, int mob2, int mob3, String mapFile, String tileFile) {
		this.name = name;
		this.ID = ID;
		this.spawnable = spawnable;
		bossAlive = false;
		mob[0] = mob1;
		mob[1] = mob2;
		mob[2] = mob3;
		tileMapClass = new TileMap(tileFile);
		tileMap = tileMapClass.getMap();
		boundaryMap = tileMapClass.boundaryMap();

	}
	public int getID() {
		return ID;
	}
	public String getName() {
		return name;
	}
	public boolean[][] getBoundaryMap() {
		return boundaryMap;
	}
	public int[][] getTileMap() {
		return tileMap;
	}
	public boolean getSpawnable() {
		return spawnable;
	}
	public int getBossID() {
		return bossID;
	}
	public boolean bossAlive() {
		return bossAlive;
	}
	public void bossDead() {
		bossAlive = false;
	}
	
}
