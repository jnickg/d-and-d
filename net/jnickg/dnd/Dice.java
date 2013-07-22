package net.jnickg.dnd;

import java.util.Random;

/**Dice class
 * this class is used to make a dice bag basically dude.
 */
public class Dice {
	//random generator
	Random rand=new Random();
	
	//returns an Integer Roll taking your bonus as an arg
	/** @param die
	 * @param bonus
	 */
	Integer roll(Integer die, Integer bonus){
		//random number in the die-1 THEN +1 because it can be 0 otherwise
		Integer roll = rand.nextInt(die-1)+1;
		roll = roll + bonus;
		return roll;
	}
	
	//returns the chance of meeting a dice check
	double chance(double die, double check, double bonus){
		double a = (((die-(check-bonus)+1)/die) * 100);
		Math.round(a);
		if(a>100) {a=100;}
		return a;
	}
	
	public int makeRoll(String ndx, int bonus) {
		int result = 0;	// Total damage
		
		// If static number, return damage
		if (!ndx.contains("d")) return Integer.parseInt(ndx);
		
		// Convert wpnDmg string into numbers
		String[] dice = ndx.split("d"); // Temporary string TODO necessary?

		int numDice = Integer.parseInt(dice[0]);
		int dieFace = Integer.parseInt(dice[1]);
		
		// Roll 1 die for all Dice in NdX
		for(int i=0; i<numDice; i++) {
			result += Math.ceil((Math.random()*dieFace));
		}
		
		return result+bonus;
	}
}
