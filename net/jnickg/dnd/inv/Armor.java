package net.jnickg.dnd.inv;

public class Armor
		extends Equippable {
	private enum ArmorType {
		LIGHT("light"){},
		MEDIUM("medium"){},
		HEAVY("heavy"){};
		
		String aType;
		ArmorType(String aType) { this.aType = aType; }
		String getAType() { return aType; }
	}
	
	private			int			bonusAC;
	private			int			maxDEX;
	private			int			penaltyACheck;
	private			ArmorType	armorType;

/* Constructors */
	public Armor() {
		super();
		bonusAC = 0;
		maxDEX = 0;
		penaltyACheck = 0;
		armorType = ArmorType.LIGHT;
	}

	// For "used" armor
	public Armor(String thisName, String thisNote, Double thisWeight, Integer thisValue,
			Integer thisHPmax, Integer thisHP, Integer thisHardness,
			Boolean isBroken, Integer bonusAC, Integer maxDEX,
			Integer penaltyACheck, String armorType) {
		super(thisName, thisNote, thisWeight, thisValue, thisHPmax, thisHP, thisHardness, isBroken);
		this.bonusAC = bonusAC;
		this.maxDEX = maxDEX;
		this.penaltyACheck = penaltyACheck;
		this.armorType = ArmorType.valueOf(armorType);
	}

	// For "new" armor
	public Armor(String thisName, String thisNote, Double thisWeight, Integer thisValue, 
			Integer thisHPmax, Integer thisHardness, Integer bonusAC,
			Integer maxDEX, Integer penaltyACheck, String armorType) {
		super(thisName, thisNote, thisWeight, thisValue, thisHPmax, thisHardness);
		this.bonusAC = bonusAC;
		this.maxDEX = maxDEX;
		this.penaltyACheck = penaltyACheck;
		this.armorType = ArmorType.valueOf(armorType);
	}

/* Printing Methods */
	@Override
	public String infoString() {
		StringBuilder armorStr = new StringBuilder();
		
		// TODO add a [!] box for broken armors
		armorStr.append(String.format(
				"Armor: %s; (+%d AC, %s, max DEX: %d) "
				+ "-- %.2f lbs\n\t%s",
				getItemName(), getBonusAC(), getArmorType(), getMaxDEX(),
				getItemWeight(), getItemNote()));
		return armorStr.toString();
	}

	@Override
	public String toString() {
		return getItemName();
	}

	public int getBonusAC() {
		return bonusAC;
	}
	public void setBonusAC(int bonusAC) {
		this.bonusAC = bonusAC;
	}

	public int getMaxDEX() {
		return maxDEX;
	}
	public void setMaxDEX(int maxDEX) {
		this.maxDEX = maxDEX;
	}

	public int getPenaltyACheck() {
		return penaltyACheck;
	}
	public void setPenaltyACheck(int penaltyACheck) {
		this.penaltyACheck = penaltyACheck;
	}

	public String getArmorType() {
		return armorType.getAType();
	}
	public void setArmorType(String armorType) {
		this.armorType = ArmorType.valueOf(armorType);
	}









}
