package net.jnickg.dnd;

public class Armor
		extends Item {

	public Armor() {
		// TODO Auto-generated constructor stub
	}

	public Armor(String thisName, String thisNote, Double thisWeight,
			Integer thisHPmax, Integer thisHardness) {
		super(thisName, thisNote, thisWeight, thisHPmax, thisHardness);
		// TODO Auto-generated constructor stub
	}

	public Armor(String thisName, String thisNote, Double thisWeight,
			Integer thisHPmax, Integer thisHP, Integer thisHardness,
			Boolean isBroken) {
		super(thisName, thisNote, thisWeight, thisHPmax, thisHP, thisHardness,
				isBroken);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String infoString() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}

}
