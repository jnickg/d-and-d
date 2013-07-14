package net.jnickg.dnd;

import java.util.Random;

/**Dice class
 * This class rolls some shit
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
}
