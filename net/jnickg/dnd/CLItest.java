package net.jnickg.dnd;

import java.util.*;
import java.io.*;


public class CLItest {
	
	
	public static void main(String[] arg){
		
		InputStream in;
		in = System.in;
		
		Scanner sc = new Scanner(in);
		String ans;
		Character guy = new Character();
		
		System.out.println("DnD Char Sheet Tester by JnickG and Castlez\n");
		while(true){
			System.out.print("What would you like to do? (help for options) ");
			ans = sc.next().toString();
			System.out.println(ans);
			if(ans.equals("help")){
				System.out.println("\nmkchar		-		make a character\n\n"+
								    "display		-		Show the made char\n\n"+
						            "exit		-		Closes program\n");
			}
			else if(ans.equals("mkchar")){
				makeChar(sc, guy);
				continue;
			}
			else if(ans.equals("exit")){
				System.out.print("\n\nBYE...");
				break;
			}
			else if(ans.equals("print")){
				printchar(guy);
			}
		}	
		
		sc.close();
	}
	
	public static void makeChar(Scanner sc, Character guy){
		
		String answer;
		Integer num;

		System.out.print("\n\nName: ");
		answer = sc.next().toString();
		guy.setCharName(answer);
		
		System.out.print("\n\nAge: ");
		num = sc.nextInt();
		guy.setCharAge(num);
		
		System.out.print("\n\nAlignment: ");
		answer = sc.next();
		guy.setCharAlignment(answer);
		
		
		Boolean cont = false;
		do{
			
			System.out.print("\n\nClass: ");
			answer = sc.next();
			try {guy.setCharClass(answer.toUpperCase());}
			catch(java.lang.IllegalArgumentException e){
				System.out.print("\nNot a class...");
				continue;
			}		
			cont=true;
		}while(!cont);
		
		System.out.print("\n\nAmount of XP: ");
		num = sc.nextInt();
		guy.addXP(num);
		
		System.out.print("\n\nDeity: ");
		answer = sc.next();
		guy.setCharDeity(answer);
		
		
		guy.setCharCHA(13);	
		guy.setCharCON(13);
		guy.setCharDEX(13);
		guy.setCharINT(13);
		guy.setCharSTR(13);
		guy.setCharWIS(13);
		
		guy.setCharEyes("Blue");
		guy.setCharGender("male");
		guy.setCharHair("Blond");
		guy.setCharHeight(6);
		guy.setCharWeight(150);
		
		guy.setCharHP(12);
		guy.setCharDMG(6);
		
		guy.setCharNLDMG(0);
		guy.setCharSkin("Whitey");
		guy.setCharSpeed(30);
		

		
	}
	
	public static void printchar(Character guy){
		//print guy
				System.out.println("\nPrinting your guy:\n\n");
				
				//Personal Info
				System.out.println("\nPersonal Info\n");
				for(int p = 0;p<guy.getClassNum();p++){
				System.out.println("Class " + (p+1) + ": " + guy.getCharClass(p).getName());
				}
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
				System.out.println("\nCurrent Level: " + guy.getCharLevel());
				System.out.println("Total XP: " + guy.getCharExperience());
				
				//Combat
				System.out.println("\nCombat\n");
				System.out.println("BAB: " + guy.getCharBAB());
				System.out.println("Speed: " + guy.getCharSpeed());
				
			
		
	}
}
