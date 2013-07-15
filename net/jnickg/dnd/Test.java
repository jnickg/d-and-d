package net.jnickg.dnd;


//tests getters and setters
public class Test {

	public static void main(String[] args) {
		
		//create a character object
		Character guy = new Character();
		
		//welcome user
		System.out.println("Welcome to a test for DnD app By JnickG! (Version 1.0)");
		System.out.print("were going to make a character. then print it out!");
		
		//build guy
		guy.setCharAge(20);
		guy.setCharAlignment("law good");
		guy.setCharBAB(3);
		guy.setCharCHA(13);
		guy.setCharCON(13);
		guy.setCharDeity("god");
		guy.setCharDEX(13);
		guy.setCharECL(500);
		guy.setCharExperience(500);
		guy.setCharEyes("blue");
		guy.setCharGender("male");
		guy.setCharHair("black");
		guy.setCharHeight(6);
		guy.setCharHP(12);
		guy.setCharDMG(6);
		guy.setCharINT(13);
		guy.setCharName("test guy");
		guy.setCharNLDMG(0);
		guy.setCharSkin("white");
		guy.setCharSpeed(30);
		guy.setCharSTR(13);
		guy.setCharWeight(150);
		guy.setCharWIS(13);
		guy.setHitDie(8);
			
		//print guy
		System.out.println("\nPrinting your guy:\n\n");
		
		//Personal Info
		System.out.println("Personal Info\n");
		System.out.println("Name: " + guy.getCharName());
		System.out.println("Age: " + guy.getCharAge());
		System.out.println("Gender: " + guy.getCharGender());
		System.out.println("Height: " + guy.getCharHeight());
		System.out.println("Weight: " + guy.getCharWeight());
		System.out.println("Hair color: " + guy.getCharHair());
		System.out.println("Eye Color: " + guy.getCharEyes());
		System.out.println("Skin Color: " + guy.getCharSkin());
		System.out.println("Diety: " + guy.getCharDeity());
		
		//Abilities
		System.out.println("\nAbilities\n");
		System.out.println("Str: " + guy.getCharSTR());
		System.out.println("Dex: " + guy.getCharDEX());
		System.out.println("Con: " + guy.getCharCON());
		System.out.println("Int: " + guy.getCharINT());
		System.out.println("Wis: " + guy.getCharWIS());
		System.out.println("Cha: " + guy.getCharCHA());
		
		//Vitals
		System.out.println("\nVitals\n");
		System.out.println("Health (max/current): " + guy.getCharHP() + "/" + (guy.getCharHP()-guy.getCharDMG()));
		System.out.println("Non-Lethal Damage: " + guy.getCharNLDMG());
		System.out.println("Hit Die: " + guy.getHitDie());
		
		//Experience
		System.out.println("\nExperience: " + guy.getCharExperience());
		System.out.println("To next level: " + guy.getCharECL());
		
		//Combat
		System.out.println("\nCombat\n");
		System.out.println("BAB: " + guy.getCharBAB());
		System.out.println("Speed: " + guy.getCharSpeed());
		
	}

}
