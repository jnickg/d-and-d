package net.jnickg.dnd.inv;

public abstract class Equippable
		extends Item {
/* Variable Members */
	public			boolean			equipped;

/* Constructors */
	public Equippable() {
		super();
	}

	public Equippable(String thisName, String thisNote, Double thisWeight,
			Integer thisHPmax, Integer thisHardness) {
		super(thisName, thisNote, thisWeight, thisHPmax, thisHardness);
		equipped = false;
	}

	public Equippable(String thisName, String thisNote, Double thisWeight,
			Integer thisHPmax, Integer thisHP, Integer thisHardness,
			Boolean isBroken) {
		super(thisName, thisNote, thisWeight, thisHPmax, thisHP, thisHardness,
				isBroken);
		equipped = false;
	}
	
	public void equipSet(boolean isEquipped) {
		equipped = isEquipped;
	}
	
	public void equipItem() {
		equipped = true;
	}
	public void unequipItem() {
		equipped = false;
	}
	
	public boolean isEquipped() {
		return equipped;
	}
	
	public boolean equipToggle() {
		equipped = !(equipped);
		return equipped;
	}

	public abstract String infoString();
	public abstract String toString();

}
