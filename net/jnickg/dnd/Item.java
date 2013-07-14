package net.jnickg.dnd;

/** This class defines the Items which populate a Character's
 *  Inventory.
 * */
public class Item {	//make this abstract eventually
/* Enums */
	public enum ItemType {
		WEAPON, ARMOR, ACCESSORY, TOOL, COMPONENT, CURRENCY, TREASURE, NONE
		//add traits of each type: ex. weapons have dmg, crit, range, etc.
	}
	
/* Variable Declarations */
	private 			ItemType		itemType;
	private 			String			itemName;
	private 			String			itemNote;
	private 			double			itemWeight;
	
/* Constructors */
	Item() {
		itemType = ItemType.NONE;
		itemName = "";
		itemNote = "";
		itemWeight = 0.0;
	}
	
	Item(ItemType thisType, String thisName, String thisNote, Double thisWeight) {
		itemType = thisType;
		itemName = thisName;
		itemNote = thisNote;
		itemWeight = thisWeight;
	}
	
/* Sets */
	public void setItemNote(String thisNote) {
		itemNote = thisNote;
	}
	
	
/* Gets */
	public ItemType getItemType() {
		return itemType;
	}
	
	public String getItemName() {
		return itemName;
	}
	
	public String getItemNote() {
		return itemNote;
	}
	
	public double getItemWeight() {
		return itemWeight;
	}
}
