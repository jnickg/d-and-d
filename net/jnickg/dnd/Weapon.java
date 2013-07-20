package net.jnickg.dnd;

public class Weapon extends Item {
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
	
	private			String		wpnDmg;		// Should be formatted as static number, or XdX
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

	public Weapon(String thisName, String thisNote, Double thisWeight, String wpnDmg, Boolean ranged, Double wpnRange, String wpnDmgType) {
		super(thisName, thisNote, thisWeight);
		this.wpnDmg = wpnDmg;
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
	 * Returns a preformatted string of this weapon's information in the following format:
	 * 		Broadsword (2d6, melee) -- 13 lbs.
	 * 			This sword is amazing!
	 * perhaps this should be improved?
	 * 
	 * @return The string as described above.
	 */
	public String toString() {
		StringBuilder wpnString = new StringBuilder();
		// Better way to do the following?
		String range = "melee";
		if(ranged) range = (String.valueOf(wpnRange) + "ft.");
		
		wpnString.append(String.format("Weapon: %s; (%s %s damage, %s) -- %.2f lbs\n\t%s", getItemName(), getWpnDmg(), getDmgType(), range, getItemWeight(), getItemNote()));
		return wpnString.toString();
	}
	
	//Complete this!
	public int rollDamage() {
		int dmg = 0;
		
		return dmg;
	}
}
