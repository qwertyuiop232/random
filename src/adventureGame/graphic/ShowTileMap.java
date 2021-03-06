package adventureGame.graphic;

import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class ShowTileMap {
	static Scanner scan;
	static int[][] tileArr;
	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				init();
			}
			
		});
	}

	public static void init() {
		JFrame frame = new JFrame();
		File file = new File("C:\\Users\\Victor\\ICS3U1KoV\\random\\src\\adventureGame\\images\\floor1");
		setTileMap(file);

		frame.setSize(700, 700);
		frame.setLocation(1000, 200);
		frame.setTitle("Project 1");
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(new Draw(tileArr), BorderLayout.CENTER);
 	}
	public static void setTileMap(File file) {
		String line;
		int column;
		int row;
		
		try {
			scan = new Scanner(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		column = scan.nextInt();
		row = scan.nextInt();
		scan.nextLine();
		
		tileArr = new int[row][column];
		for(int i = 0; i < row; i++) {
			line = scan.nextLine();
			for(int j = 0; j < column; j++) {
				int num = Integer.parseInt(line.substring(j, j + 1));
				tileArr[i][j] =  num;
			}
		}

	
	}

 }
