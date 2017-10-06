package rpg;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class Enemy extends Stats{
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
			eStrength = (int) (1.5*eLevel);
			eHP = eLevel *75;
			eEXP = ThreadLocalRandom.current().nextInt(getEXP() / 30, getEXP()/20 + 1);

		}
		public int getELevel() {
			return eLevel;
		}
		public int getEHP() {
			return eHP;
		}
		public int getEEXP() {
			return eEXP;
		}
		public int getEStrength() {
			return eStrength;
		}
		public int[] getEStats() {
			int[] a =  {eLevel, eHP, eEXP, eStrength};
			return a;
		}

}
