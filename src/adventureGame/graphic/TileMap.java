package adventureGame.graphic;

import java.util.*;

public class TileMap {
	private static int[][] map;
	private static int mapHeight;
	private static int mapWidth;
	private static boolean[][] boundaryMap; 
	
	public TileMap(String fileName) {
		
		Scanner scan = new Scanner(fileName);
		mapHeight = Integer.parseInt(scan.nextLine());
		mapWidth = Integer.parseInt(scan.nextLine());
		map = new int[mapWidth][mapHeight];
		boundaryMap = new boolean[mapWidth][mapHeight];
		
		for(int i = 0; i < mapHeight; i++) {
			
			for(int j = 0; j < mapWidth; j++) {
				map[i][j] = scan.nextInt();
			}
		}
		scan.close();
	}
	public int[][] getMap() {
		return map;
	}
	public void setMap(int x, int y, int value) {
		map[x][y] = value;
	}
	public boolean[][] boundaryMap() {
		for(int i = 0; i < mapHeight; i++) {
			
			for(int j = 0; j < mapWidth; j++) {
				if(map[i][j] >0) {
					boundaryMap[i][j] = true;
				}else {
					boundaryMap[i][j] = false;
				}
			}
		}
		return boundaryMap;
	}
	
}
