package net.jnickg.dnd.io.inv;

import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import net.jnickg.dnd.inv.*;
import net.jnickg.dnd.io.inv.InvCmd;

public enum MainCmd {
	NEW,
	LOAD,
	SAVE,
	HELP,
	EXIT
	
	;
	
	private static HashMap<String,MainCmd> aliasMap = new HashMap<>();
	
	// set up command aliases: this is run when the Command enum .class file is loaded,
	//						   the first time that a command is invoked by the user
	static
	{
		for (MainCmd cmd : MainCmd.values())
			if (cmd.aliases != null)
				for (String alias : cmd.aliases)
					aliasMap.put(alias, cmd);
	}
	
	private String[] variants;		// help will use this to print the variants of a command
	private String[] text;			// help will print this command-related text
	private String[] aliases;		// alternate names that can be typed in for a command
	
	MainCmd(String[] variants, String[] text, String[] aliases)
	{
		this.variants = variants;
		this.text = text;
		this.aliases = aliases;
	}

	// performs command, returns true if application should stop afterwards
	abstract public boolean doCommand(String[] line, PrintStream out, Set<Inventory> stdInv, Inventory curInv);
	
	public static MainCmd parse(String str) {
		str = str.toUpperCase();
		try {
			return MainCmd.valueOf(str);
		} catch (IllegalArgumentException e) {
			return aliasMap.get(str);
		} catch (NullPointerException e) {
			return null;
		}
	}
}
