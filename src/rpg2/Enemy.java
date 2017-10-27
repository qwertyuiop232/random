package rpg2;

import java.util.Random;

class Enemy{
	Random rand = new Random();
	
	private int eStrength, eHP, eEXP, eLevel;
		Enemy() {
			eLevel = 0;
			eStrength = 0;
			eHP = 0;
			eEXP = 0;
		}
		void setEStats(int level) {
			eLevel = rand.nextInt(level) +1;
			eStrength = (int) (2.2 * eLevel);
			eHP = eLevel * 110;
			eEXP = (int) (Math.random() * 30 * eLevel + 15 * eLevel) ;

		}
		int[] getEStats() {
			int[] a =  {eLevel, eHP, eEXP, eStrength};
			return a;
		}

}
