package net.jnickg.dnd.inv;

public class Treasure
		extends Item {

	private			int			rarity;	// Rarity index as described in DMG
	
	public Treasure() {
		super();
		rarity = 0;
	}

	public Treasure(String thisName, String thisNote, Double thisWeight,
			Integer thisValue, Integer thisHPmax, Integer thisHardness,
			Integer thisRarity) {
		super(thisName, thisNote, thisWeight, thisValue, thisHPmax,
				thisHardness);
		rarity = thisRarity;
	}

	public Treasure(String thisName, String thisNote, Double thisWeight,
			Integer thisValue, Integer thisHPmax, Integer thisHP,
			Integer thisHardness, Boolean isBroken, Integer thisRarity) {
		super(thisName, thisNote, thisWeight, thisValue, thisHPmax, thisHP,
				thisHardness, isBroken);
		rarity = thisRarity;
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
	
/* rarity Methods */
	public int getRarity() {
		return rarity;
	}
	
	public void setRarity(Integer thisRarity) {
		rarity = thisRarity;
	}

}
