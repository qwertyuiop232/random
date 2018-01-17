package adventureGame;

public class CurrentRoom {
	boolean boss;
	Rooms room; 
	int x,y;
	boolean[][] boundaryMap; // [x], [y]
	int[][] tileMap;
	boolean spawnable;
	
	public CurrentRoom(int roomID) {
		room = gmInventory.getRoom(roomID);
	// paint tile map
		spawnable = room.getSpawnable();
		
	}
	
	public void move(int direction) {
	// 1 up, 2 up right, 3 right, 4 down right, 5 down, 6 down left, 7 left, 8 top left
		if(direction == 1) {
			if(boundaryMap[x + 1][y]) {
				y++;
			}
			// char faces up
			// paint moving animation
			
		}else if(direction == 2) {
			if(boundaryMap[x + 1][y - 1]) {
				x++;
				y++;
			}

		}else if(direction == 3) {
			if(boundaryMap[x + 1][y]) {
				
			}
			
		}else if(direction == 4) {
			if(boundaryMap[x + 1][y - 1]) {
			x++;
			y--;
			}
		}else if(direction == 5) {
			if(boundaryMap[x][y - 1]) {
				y--;
			}
		}else if(direction == 6) {
			if(boundaryMap[x - 1][y - 1]) {
				x--;
				y--;
			}
		}else if(direction == 7) {
			if(boundaryMap[x - 1][y]) {
				x--;
			}
		}else if(direction == 8) {
			if(boundaryMap[x - 1][y + 1]) {
				x--;
				y++;
			}
		}
		enemyCheck();
	}
	public void paintTile() {
		
	}
	public void enemyCheck() {
		if(tileMap[x + 1][y] == -9) {
			
		}else if(tileMap[x + 1][y + 1] == -9) {
			
		}else if(tileMap[x][y + 1] == -9) {
			
		}else if(tileMap[x - 1][y + 1] == -9) {
			
		}else if(tileMap[x - 1][y] == -9) {
			
		}else if(tileMap[x - 1][y - 1] == -9) {
			
		}else if(tileMap[x][y - 1] == -9) {
			
		}else if(tileMap[x + 1][y - 1] == -9) {
			
		}
	}
	public void interact() {
		
	}

}
