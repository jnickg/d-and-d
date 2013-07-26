package net.jnickg.dnd;

public class Weapon 
		extends Equippable {
	
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
	
	
/* Constructors */
	public Weapon() {
		super();
		wpnDmg = "1";
		ranged = false;
		wpnRange = 0;
		wpnDmgType = DmgType.NONE;
		
	}

	// Creates a "new" weapon. Good for most cases.
	public Weapon(String thisName, String thisNote, Double thisWeight, Integer thisHPMax, Integer thisHardness,
			String wpnDmg, Boolean ranged, Double wpnRange,
			String wpnDmgType) {
		super(thisName, thisNote, thisWeight, thisHPMax, thisHardness);
		this.wpnDmg = wpnDmg;	// TODO ensure this is correct when it's input to avoid future errors. See above.
		this.ranged = ranged;
		this.wpnRange = wpnRange;
		this.wpnDmgType = DmgType.valueOf(wpnDmgType); 
	}
	
	// Creates a "used" weapon
	public Weapon(String thisName, String thisNote, Double thisWeight,
			Integer thisHPmax, Integer thisHP, Integer thisHardness, Boolean thisBroken,
			String wpnDmg, Boolean ranged, Double wpnRange, String wpnDmgType) {
		super(thisName, thisNote, thisWeight, thisHPmax, thisHP, thisHardness, thisBroken);
		this.wpnDmg = wpnDmg;	// TODO ensure this is correct when it's input to avoid future errors. See above.
		this.ranged = ranged;
		this.wpnRange = wpnRange;
		this.wpnDmgType = DmgType.valueOf(wpnDmgType); 
	}
	
/* Printing Methods */
	/**
	 * Returns a preformatted string of this weapon's information
	 * in the following format:
	 * 		Broadsword (2d6, melee) -- 13 lbs.
	 * 			This sword is amazing!
	 * perhaps this should be improved?
	 * 
	 * @return The string as described above.
	 */
	@Override
	public String infoString() {
		StringBuilder wpnString = new StringBuilder();
		
		String range = "melee";
		if(ranged) range = (String.valueOf(wpnRange) + "ft.");
		
		// TODO add a [!] box for broken weapons
		wpnString.append(String.format("Weapon: %s; (%s %s damage, %s) "
				+ "-- %.2f lbs\n\t%s", getItemName(), getWpnDmg(),
				getDmgType(), range, getItemWeight(), getItemNote()));
		return wpnString.toString();
	}
	
	@Override
	public String toString() {
		return getItemName();
	}
	
/* Damage Functions */
	public String getDmgType() {
		return wpnDmgType.getDmgType();
	}
	
	public String getWpnDmg() {
		return wpnDmg;
	}
}
