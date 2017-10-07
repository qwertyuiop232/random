package rpg2;

class Battle {

	private static int userDmg, eDmg, userHP, eHP;
	private boolean isECrit, isUCrit;
	


	Battle() {

		userDmg = 0;
		eDmg = 0;
		userHP = 0;
		eHP = 0;
		isECrit = false;
		isUCrit = false;
	}
	void setFight(int hp, int strength, int eStrength, int ehp, int uLuck, int eLuck) {
		isECrit = false;
		isUCrit = false;
		userDmg = (int) (Math.random() * Math.pow(strength, 0.5) * 3 + strength);
		eDmg = (int) (Math.random() * Math.pow(eStrength, 0.5) * 3 + eStrength );
		userHP = hp - eDmg;
		eHP = ehp - userDmg;
		
		if (Math.random() * 100 + 10 + eLuck/7 > 100 ) {
			eDmg *= 2;
			isECrit = true;
		}
		if (Math.random() * 100 + 5 + uLuck/7 > 100 ) {
			userDmg *=2;
			isUCrit = true;
		}
		if (userHP < 0) 
			userHP = 0;
		
		 
		if (eHP < 0) 
			eHP = 0;

	}
	 int[] getFight() {
		
		int[] results = {userHP, eHP, userDmg, eDmg};
		return results;
	}
	 boolean[] getCrit() {
		boolean[] crit = {isUCrit, isECrit};
		return crit;
	}
}
