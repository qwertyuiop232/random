package rpg2;

import java.util.Random;

public class Enemy{
	Random rand = new Random();
	
	private int eStrength, eHP, eEXP, eLevel;
		public Enemy() {
			eLevel = 0;
			eStrength = 0;
			eHP = 0;
			eEXP = 0;
		}
		public void setEStats(int level) {
			eLevel = rand.nextInt(level) +1;
			eStrength = (int) (1.5 * eLevel);
			eHP = eLevel * 80;
			eEXP = (int) (rand.nextInt((int) (20 * level)) + 15 * level) ;

		}
		public int[] getEStats() {
			int[] a =  {eLevel, eHP, eEXP, eStrength};
			return a;
		}

}
