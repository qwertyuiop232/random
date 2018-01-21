package adventureGame.graphic;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Draw extends JPanel{
	private static Image image;
	private static final String STONE_TILE = "C:/Users/Victor/ICS3U1KoV/random/src/adventureGame/images/stoneTile.png";
	private static final String WOOD_FLOOR = "C:/Users/Victor/ICS3U1KoV/random/src/adventureGame/images/woodFloorTile.png";
	private static final String WALL_VERT = "C:/Users/Victor/ICS3U1KoV/random/src/adventureGame/images/Earth backed walls on grid lines/Wall,1Square,Vertical.png";
	private static final String WALL_HOR = "C:/Users/Victor/ICS3U1KoV/random/src/adventureGame/images/Earth backed walls on grid lines/Wall,1Square.png";
	private static final long serialVersionUID = 1L;
	private static int x = 0, y = 0;
	private static final int TILE_SIZE = 40;
	private int[][] tileArr;
	private static Image[] imageList = new Image[20];
	private static int counter = 0;
	
	public Draw(int[][] tileArr) {
		setPreferredSize(new Dimension(700,700));
		setBackground(Color.CYAN);
		setImageList();
		this.tileArr = tileArr;
		
		repaint();
	}
	private void setImageList() {
		addImageList(STONE_TILE);
		addImageList(WALL_VERT);
		addImageList(WALL_HOR);
	}
	@Override
	public void paintComponent(Graphics g) {
        // This stuff is standard, and should be in any paintComponent method. 
        super.paintComponent(g);
        
        for(int i = 0; i < 17; i++) {
        	
        	for(int j = 0; j < 50; j++) {
        		
        		switch(tileArr[i][j]) {
        		case 0: image = imageList[0];
        		break;
        		case 1: image = imageList[1];
        		break;
        		case 2: image = imageList[2];
        		default: break;
        		}
 
        		image = image.getScaledInstance(TILE_SIZE, TILE_SIZE, Image.SCALE_DEFAULT);

        	g.drawImage(image, x + j * TILE_SIZE, y + i * TILE_SIZE, TILE_SIZE, TILE_SIZE, null);
        	}
        	g.drawImage(imageList[0], 0, 0, 40, 40, null);
        }
	}
	public void addImageList(String file) {
		try {
			imageList[counter] = ImageIO.read(new File(file));
		}catch (IOException e) {
			e.printStackTrace();
		}
		
		counter++;
	}
	
}
