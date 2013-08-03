package net.jnickg.dnd.io.inv;

import java.util.HashMap;
import java.util.Map;

import net.jnickg.dnd.inv.*;

public enum InvCmd {
	INFO,
	PRINT,
	ADD,
	REMOVE,
	SAVE,
	HELP,
	EXIT
	
	;
	
	private static HashMap<String,InvCmd> aliasMap = new HashMap<>();
	
	// set up command aliases: this is run when the Command enum .class file is loaded,
	//						   the first time that a command is invoked by the user
	static
	{
		for (InvCmd cmd : InvCmd.values())
			if (cmd.aliases != null)
				for (String alias : cmd.aliases)
					aliasMap.put(alias, cmd);
	}
	
	private String[] variants;		// help will use this to print the variants of a command
	private String[] text;			// help will print this command-related text
	private String[] aliases;		// alternate names that can be typed in for a command
	
	InvCmd(String[] variants, String[] text, String[] aliases)
	{
		this.variants = variants;
		this.text = text;
		this.aliases = aliases;
	}

	// performs command, returns true if application should stop afterwards
	abstract public boolean doCommand(String[] line, Inventory inv);
	
	public static InvCmd parse(String str) {
		str = str.toUpperCase();
		try {
			return InvCmd.valueOf(str);
		} catch (IllegalArgumentException e) {
			return aliasMap.get(str);
		} catch (NullPointerException e) {
			return null;
		}
	}
}
