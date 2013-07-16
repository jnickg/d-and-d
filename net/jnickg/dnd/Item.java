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
	
/* Constructors */
	Item() {
		itemName = "";
		itemNote = "";
		itemWeight = 0.0;
	}
	
	Item(String thisName, String thisNote, Double thisWeight) {
		itemName = thisName;
		itemNote = thisNote;
		itemWeight = thisWeight;
	}
	
/* Sets */
	public void setItemNote(String thisNote) {
		itemNote = thisNote;
	}
	
	
/* Gets */
	/**
	 * Returns the item's name as a String
	 * 
	 * @return the Item's name
	 */
	public String getItemName() {
		return itemName;
	}
	
	/**
	 * Returns a note about the item as a
	 * String.
	 * 
	 * @return the note about the Item.
	 */
	public String getItemNote() {
		return itemNote;
	}
	
	/** 
	 * Returns the item's weight as a double.
	 * 
	 * @return the item's weight.
	 */
	public double getItemWeight() {
		return itemWeight;
	}
}
