package adventureGame;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Rooms {
	private String name;
	private String description;
	private int ID;
	private String roomMap;
	private ArrayList<Integer> row;
	private ArrayList<ArrayList<Integer>> map;
	
	public Rooms(String name, String description, int ID, String roomMap) {
		this.name = name;
		this.description = description;
		this.ID = ID;
		this.roomMap = roomMap;
		setMap();
	}

	private void setMap() {
		try(BufferedReader br = new BufferedReader(new FileReader(roomMap))) {
			String currentLine;
			while((currentLine = br.readLine()) != null) {
				if(currentLine.isEmpty()) {
					continue;
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}

	public int getID() {
		return ID;
	}
	public String getName() {
		return name;
	}
	public String getDescription() {
		return description;
	}
	
	
}
