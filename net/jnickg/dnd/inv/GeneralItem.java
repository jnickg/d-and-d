package net.jnickg.dnd.inv;

public class GeneralItem
		extends Item {

/* Constructors */
	public GeneralItem() {
		super();
	}

	// For a "new" item
	public GeneralItem(String thisName, String thisNote, Double thisWeight,
			Integer thisHPmax, Integer thisHardness) {
		super(thisName, thisNote, thisWeight, thisHPmax, thisHardness);
	}

	// For a "used" item
	public GeneralItem(String thisName, String thisNote, Double thisWeight,
			Integer thisHPmax, Integer thisHP, Integer thisHardness,
			Boolean isBroken) {
		super(thisName, thisNote, thisWeight, thisHPmax, thisHP, thisHardness,
				isBroken);
	}

	@Override
	public String infoString() {
		StringBuilder infoStr = new StringBuilder();
		infoStr.append(String.format("Item: %s -- %.2f lbs\n\t%s",
				this.getItemName(), this.getItemWeight(), this.getItemNote()));
		return infoStr.toString();
	}

	@Override
	public String toString() {
		return this.getItemName();
	}

}
