package net.jnickg.dnd;

public class Weapon extends Item {
	private			enum		DmgType {
		BLUDGEONING("b"),
		NONE("-"),
		NONLETHAL("nl"),
		PIERCING("p"),
		SLASHING("s");
		
		String dmgType;
		DmgType(String dmgType) { this.dmgType = dmgType; }
		String getDmgType() { return dmgType; }
	}
	
	private			String		wpnDmg;	//should be formatted as static number, or XdX
	private			boolean		ranged;
	private			double		wpnRange;
	private			DmgType		wpnDmgType;
	
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

	/**
	 * Returns a preformatted string of this weapon's information in the following format:
	 * 		Broadsword (2d6) -- 13 lbs.
	 * perhaps this should be improved?
	 * 
	 * @return The string as described above.
	 */
	public String toString() {
		StringBuilder wpnString = new StringBuilder();
		// Better way to do the following?
		String range = "melee";
		if(this.ranged) range = String.valueOf(wpnRange);
		// Redo with formatted strings
		wpnString.append(this.getItemName() + " (" + wpnDmg + " " + range + ") -- " + this.getItemWeight() + " lbs.");
		return wpnString.toString();
	}
	
	//Complete this!
	public int rollDamage() {
		int dmg = 0;
		
		return dmg;
	}
}
