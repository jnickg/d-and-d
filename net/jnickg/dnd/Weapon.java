package net.jnickg.dnd;

public class Weapon 
		extends Item {
	
	private			enum		DmgType {
		BLUDGEONING("blunt"),
		NONE("nontyped"),
		NONLETHAL("nonlethal"),
		PIERCING("piercing"),
		SLASHING("slashing");
		
		String dmgType;
		DmgType(String dmgType) { this.dmgType = dmgType; }
		String getDmgType() { return dmgType; }
	}
	
	private			String		wpnDmg;		// Should be formatted as static number, or NdX
	private			boolean		ranged;		// False if the item is a reach weapon
	private			double		wpnRange;	// Range in feet -- only used if ranged is true
	private			DmgType		wpnDmgType;	// Type of damage. Will be used for dmg reduction later on.
	
	public Weapon() {
		super();
		wpnDmg = "1";
		ranged = false;
		wpnRange = 0;
		wpnDmgType = DmgType.NONE;
		
	}

	public Weapon(String thisName, String thisNote, Double thisWeight,
			String wpnDmg, Boolean ranged, Double wpnRange,
			String wpnDmgType) {
		super(thisName, thisNote, thisWeight);
		this.wpnDmg = wpnDmg;	// TODO ensure this is correct when it's input to avoid future errors. See above.
		this.ranged = ranged;
		this.wpnRange = wpnRange;
		this.wpnDmgType = DmgType.valueOf(wpnDmgType); 
	}
	
	public String getDmgType() {
		return wpnDmgType.getDmgType();
	}
	
	public String getWpnDmg() {
		return wpnDmg;
	}

	/**
	 * Returns a preformatted string of this weapon's information
	 * in the following format:
	 * 		Broadsword (2d6, melee) -- 13 lbs.
	 * 			This sword is amazing!
	 * perhaps this should be improved?
	 * 
	 * @return The string as described above.
	 */
	public String infoString() {
		StringBuilder wpnString = new StringBuilder();
		// TODO Better way to do the following?
		String range = "melee";
		if(ranged) range = (String.valueOf(wpnRange) + "ft.");
		
		wpnString.append(String.format("Weapon: %s; (%s %s damage, %s) "
				+ "-- %.2f lbs\n\t%s", getItemName(), getWpnDmg(),
				getDmgType(), range, getItemWeight(), getItemNote()));
		return wpnString.toString();
	}
	
	public String toString() {
		return getItemName();
	}

	/**
	 * Interprets the weapon's damage (# or NdX) and returns rolled
	 * damage. 
	 * 
	 * @return The damage dealt.
	 */
	public int rollDamage(int bonus) {
		int dmg = 0;	// Total damage
		
		// If static number, return damage
		if (!wpnDmg.contains("d")) return Integer.parseInt(wpnDmg);
		
		// Convert wpnDmg string into numbers
		String dice = wpnDmg; // Temporary string TODO necessary?
		String[] xdx = new String[2]; // Used to hold NdX where N is numDice and X is dieFace
		xdx = dice.split("d");
		int numDice = Integer.parseInt(xdx[0]);
		int dieFace = Integer.parseInt(xdx[1]);
		
		// Roll 1 die for all Dice in NdX
		for(int i=0; i<numDice; i++) {
			dmg += Math.ceil((Math.random()*dieFace));
		}
		
		return dmg+bonus;
	}
	//TODO move this method to Dice class.
}
