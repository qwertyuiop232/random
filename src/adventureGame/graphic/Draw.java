package adventureGame.graphic;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Draw extends JPanel{
	private static Image image = null;
	private static final String STONE_TILE= "C:/Users/Victor/ICS3U1KoV/random/src/adventureGame/images/stoneTile.png";
	private static final String WOOD_FLOOR= "C:/Users/Victor/ICS3U1KoV/random/src/adventureGame/images/woodFloorTile.png";
	private static final long serialVersionUID = 1L;
	private static int x = 0, y = 0;
	private static final int TILE_SIZE = 30;
	private static int[][] tileArr;

	public Draw(int[][] tileArr) {
		setPreferredSize(new Dimension(500,500));
		setBackground(Color.CYAN);
		try {
			image = ImageIO.read(new File(WOOD_FLOOR));
		}catch (IOException e) {
			e.printStackTrace();
		}
		image = image.getScaledInstance(TILE_SIZE, TILE_SIZE, Image.SCALE_DEFAULT);
		Draw.tileArr = tileArr;
		repaint();
	}
	@Override
	public void paintComponent(Graphics g) {
        // This stuff is standard, and should be in any paintComponent method. 
        super.paintComponent(g);
        
		g.drawImage(image, x, y, TILE_SIZE, TILE_SIZE, null);
	}
	
}
