package rpg;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class Enemy extends PlayerStats{
	Random rand = new Random();
	
	private int eStrength, eHP, eEXP, eLevel;
		public Enemy() {
			eLevel = 1;
			eStrength = 0;
			eHP = 100;
			eEXP = 0;
		}
		public void setEStats() {
			eLevel = rand.nextInt(getLevel());
			eStrength = (int) (1.5*eLevel);
			eHP = eLevel *75;
			eEXP = ThreadLocalRandom.current().nextInt(getEXP() / 30, getEXP()/20 + 1);


		}
		public void setEHP(int a) {
			eHP -= a;
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

}
