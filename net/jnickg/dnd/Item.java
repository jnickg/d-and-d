package net.jnickg.dnd;

/** This abstract class provides a basic definition for all Items
 *  which populate a Character's Inventory. Used by the Inventory
 *  class.
 * */
public abstract class Item {
	
/* Variable Declarations */
	private 			String			itemName;
	private 			String			itemNote;
	private 			double			itemWeight;
	private				int				itemHPmax, itemHP;
	private				int				itemHardness;
	private				boolean			itemBroken;
	// TODO pre-empt typed damage reductions--the above currently functions as DR itemHardness vs. all.
	
/* Constructors */
	Item() {
		itemName = "";
		itemNote = "";
		itemWeight = 0.0;
		itemHPmax = 1;
		itemHP = itemHPmax;
		itemHardness = 0;
		itemBroken = false;
	}
	
	// For a new item
	Item(String thisName, String thisNote, Double thisWeight, Integer thisHPmax, Integer thisHardness) {
		itemName = thisName;
		itemNote = thisNote;
		itemWeight = thisWeight;
		itemHPmax = thisHPmax;
		itemHP = thisHPmax;
		itemHardness = thisHardness;
		itemBroken = false;
	}
	
	// For an existing item
	Item(String thisName, String thisNote, Double thisWeight, Integer thisHPmax, Integer thisHP, Integer thisHardness, Boolean isBroken) {
		itemName = thisName;
		itemNote = thisNote;
		itemWeight = thisWeight;
		itemHPmax = thisHPmax;
		itemHP = thisHP;
		itemHardness = thisHardness;
		itemBroken = isBroken;
	}
	
/* toString style functions */
	public abstract String infoString();
	public abstract String toString();
		
/* itemName functions */
	public String getItemName() {
		return itemName;
	}
	
/* itemNote functions */
	public String getItemNote() {
		return itemNote;
	}
	public void setItemNote(String thisNote) {
		itemNote = thisNote;
	}
	
/* itemWeight functions */
	public double getItemWeight() {
		return itemWeight;
	}
	

/* HP functions */
	public int takeDMG(int damage) {
		int dmg = damage - itemHardness;
		
		if(dmg < 0) return itemHP;
		
		itemHP -= (dmg);
		
		if(itemHP <= 0) {
			breakItem();
			itemHP = 0;
		}
		return itemHP;
	}
	
	public int takeRepair(int value) {
		itemHP += value;
		if(itemHP > 0) fixItem();	// Currently means item is not broken if it has any HP
		if(itemHP > itemHPmax) itemHP = itemHPmax;
		return itemHP;
	}
	
/* Break functions */
	public void breakItem() {
		itemBroken = true;
	}
	public void fixItem() {
		itemBroken = false;
	}
	public boolean isBroken() {
		return itemBroken;
	}
}