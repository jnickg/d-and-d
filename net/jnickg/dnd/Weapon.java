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
	
	private			int			wpnDmg;
	private			boolean		ranged;
	private			double		wpnRange;
	private			DmgType		wpnDmgType;
	
	public Weapon() {
		super();
		wpnDmg = 0;
		ranged = false;
		wpnRange = 0;
		wpnDmgType = DmgType.NONE;
		
	}

	public Weapon(String thisName, String thisNote, Double thisWeight, Integer wpnDmg, Boolean ranged, Double wpnRange, String wpnDmgType) {
		super(thisName, thisNote, thisWeight);
		this.wpnDmg = wpnDmg;
		this.ranged = ranged;
		this.wpnRange = wpnRange;
		this.wpnDmgType = DmgType.valueOf(wpnDmgType); 
	}

	
}
