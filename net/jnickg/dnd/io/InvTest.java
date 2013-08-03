package net.jnickg.dnd.io;

import java.io.PrintStream;
import java.util.HashSet;
import java.util.Set;

import net.jnickg.dnd.inv.*;
import net.jnickg.dnd.io.StdCLInput;
import net.jnickg.dnd.io.inv.MainCmd;

public class InvTest {

	public static void main(String[] args) {
		PrintStream out = new PrintStream(System.out);
		String[]	line;	// The next line of input
		MainCmd		mcmd;	// The main menu command
		//InvCmd		icmd;	// Actually will belong in MainCmd
		boolean		stop = false;
		
		Set<Inventory>	stdInv = new HashSet<>();
		Inventory		curInv = new Inventory();
		out.print("Welcome to the CLI Inventory manager\n"
				+ "Please note that command input will only listen to the\n"
				+ "first character you give it"
				+ "[Here are the rest of the introductory instructions]\n\n");
		do {
			out.print(">");
			line = StdCLInput.getLineWords();
			if (line==null) continue;
			mcmd = MainCmd.parse(line[0]);
			if (mcmd != null)
            	try { stop = mcmd.doCommand(line, out, stdInv, curInv); }
            	catch (RuntimeException e) { System.out.println(e.getMessage()); continue; }
            else {
                System.out.printf("command error: user typed \"%s\"%n", line[0]);
                continue;
            	}
			
		} while (!stop);
	}
	
	public static void printMainMenu(PrintStream out) {
		out.print("");
	}	
	public static void printInvMenu(PrintStream out) {
		
	}

}
