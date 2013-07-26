package net.jnickg.dnd;

import java.util.*;
import java.io.*;


public class CLItest {
	
	
	public static void main(String[] arg){
		
		InputStream in;
		in = System.in;
		
		Scanner sc = new Scanner(in);
		String ans;
		
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
				makeChar(sc);
				continue;
			}
			else if(ans.equals("exit")){
				System.out.print("\n\nBYE...");
				break;
			}
		}	
		
		sc.close();
	}
	
	public static void makeChar(Scanner sc){
		
		String answer;
		Integer num;
		
		//build guy
		Character guy = new Character();
		
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
		
		
//		guy.setCharCHA(13);	
//		guy.setCharCON(13);
//		guy.setCharDEX(13);
//		guy.setCharINT(13);
//		guy.setCharSTR(13);
//		guy.setCharWIS(13);
//		
//		guy.setCharEyes("Blue");
//		guy.setCharGender("male");
//		guy.setCharHair("Blond");
//		guy.setCharHeight(6);
//		guy.setCharWeight(150);
//		
//		guy.setCharHP(12);
//		guy.setCharDMG(6);
//		
//		guy.setCharNLDMG(0);
//		guy.setCharSkin("Whitey");
//		guy.setCharSpeed(30);
		

		
	}
}
