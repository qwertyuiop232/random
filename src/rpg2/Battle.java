package rpg2;

public class Battle {

	private static int userDmg, eDmg, userHP, eHP;
	private boolean eCrit, uCrit;
	


	public Battle() {

		userDmg = 0;
		eDmg = 0;
		userHP = 0;
		eHP = 0;
		eCrit = false;
		uCrit = false;
	}
	public void setFight(int hp, int strength, int eStrength, int ehp, int uLuck, int eLuck) {
		eCrit = false;
		uCrit = false;
		userDmg = (int) (Math.random() * strength * 10 + strength *5);
		eDmg = (int) (Math.random() * eStrength * 10 + eStrength  *5);
		userHP = hp - eDmg;
		eHP = ehp - userDmg;
		
		if (Math.random() * 100 + 10 + eLuck/7 > 100 ) {
			eDmg *= 2;
			eCrit = true;
		}
		if (Math.random() * 100 + 5 + uLuck/7 > 100 ) {
			userDmg *=2;
			uCrit = true;
		}
		if (userHP < 0) 
			userHP = 0;
		
		 
		if (eHP < 0) 
			eHP = 0;

	}
	public int[] getFight() {
		
		int[] results = {userHP, eHP, userDmg, eDmg};
		return results;
	}
	public boolean[] getCrit() {
		boolean[] crit = {uCrit, eCrit};
		return crit;
	}
}
