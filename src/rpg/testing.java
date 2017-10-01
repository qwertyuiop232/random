package rpg;


public class testing {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int userHP;
		
		PlayerStats playerVitality;
		
		playerVitality = new PlayerStats();
		
		playerVitality.setVitality(10);
			

		playerVitality.setTotHP();
		playerVitality.setInitHP();
		userHP = playerVitality.getTotHP();
		
		playerVitality.setHeal();
		userHP = playerVitality.getCurrentHP();
				
		System.out.println("HP: " + userHP);
		
	}

}
