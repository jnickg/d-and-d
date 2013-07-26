package net.jnickg.dnd;

import java.util.ArrayList;
import java.util.List;

import net.jnickg.dnd.Item;


/** This class defines a Character's Inventory,
 * which contains Items as well as Money. ..
 * test change!!!
 */
public class Inventory {

/* Variable Declarations */
	private				double		maxWeight;
	private				double		weight;
	private				int			numItems;
	private				int			money;
	
	private	List<Item> 	itemList = new ArrayList<>();
	
/* Constructors */
	Inventory() {
		maxWeight = 0.0;
		weight = 0.0;
		numItems = 0;
		money = 0;
	}
	
	Inventory(double maxWeight) {	// Null inventory
		this.maxWeight = maxWeight;
		numItems = 0;
		weight = 0;
		money = 0;
	}
	
	Inventory(double maxWeight, int money) { // Used for an ECL1 character 
		this.maxWeight = maxWeight;
		numItems = 0;
		weight = 0;
		this.money = money;
	}
	
	// TODO Add constructor for copying an existing inventory
	
/* Printing Functions */
	// Returns a string with the inventory's weight and number of items
	public String toString() {
		StringBuilder invStr = new StringBuilder();
		invStr.append(String.format("Inventory: %.2f lbs, %d items\n", getWeight(), getNumItems()));
		return invStr.toString();
	}
	
	// Returns a String containing each item in the inventory
	public String itemString() {
		StringBuilder itemStr = new StringBuilder();
		if (itemList.isEmpty()) {
			itemStr.append("This inventory is empty.");
			return itemStr.toString();
		}
		else {
			for (Item i : itemList) {
				itemStr.append(i.infoString() + "\n");
			}
		}
		return itemStr.toString();
	}
	
/* Item functions */
	public boolean addItem(Item thisItem, int quantity) {
		// TODO Should this add as many as possible if sending over capacity, or none?
		
		if(weight + (thisItem.getItemWeight() * quantity) <= maxWeight) {	//if there is enough weight-room
			addWeight(thisItem.getItemWeight() * quantity);
			incNumItems(quantity);
			
			for(int i = 0; i < quantity; i++) {
				itemList.add(thisItem);
			}
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean addGeneralItem(String thisName, String thisNote, Double thisWeight,
			Integer thisHPmax, Integer thisHardness,
			Integer quantity) {
		GeneralItem thisGItem = new GeneralItem(thisName, thisNote, thisWeight,
				thisHPmax, thisHardness);
		if (addItem(thisGItem, quantity)) return true;
		return false;
	}
	
	public boolean addWeapon(String thisName, String thisNote, Double thisWeight,
			Integer thisHPmax, Integer thisHardness, String wpnDmg,
			Boolean ranged, Double wpnRange, String wpnDmgType,
			Integer quantity) {
		Weapon thisWeapon = new Weapon(thisName, thisNote, thisWeight,
				thisHPmax, thisHardness, wpnDmg, ranged, wpnRange,
				wpnDmgType);
		if (addItem(thisWeapon, quantity)) return true;
		return false;
	}
	
	public boolean addArmor(String thisName, String thisNote, Double thisWeight,
			Integer thisHPmax, Integer thisHardness, Integer bonusAC,
			Integer maxDEX, Integer penaltyACheck, String armorType,
			Integer quantity) {
		Armor thisArmor = new Armor(thisName, thisNote, thisWeight,
				thisHPmax, thisHardness, bonusAC, maxDEX, penaltyACheck,
				armorType);
		if (addItem(thisArmor, quantity)) return true;
		return false;
	}
	
	public List<Item> findItem(String thisItem) {
		List<Item> foundItems = new ArrayList<Item>();
		for(Item i: itemList) {
			if (i.getItemName().equalsIgnoreCase(thisItem)) foundItems.add(i);
		}
		return foundItems;
	}
	
/* weight Functions */
	double getWeight() {
		return weight;
	}
	
	void setWeight(double weight) {
		this.weight = weight;
	}
	
	double addWeight(double moreWeight) {
		weight += moreWeight;
		return weight;
	}
	
	double rmvWeight(double lessWeight) {
		weight -= lessWeight;
		return weight;
	}
	
	// resets weight to zero and adds the weights for all items
	double calculateWeight() {
		weight = 0;
		if (itemList.isEmpty()) return weight;	//if there are no items return 0
		
		// Otherwise, iterate through all items in the list,
		// and add their weight times their quantity 
		for (Item i : itemList) {
			weight += (i.getItemWeight());
		}
		weight = Math.round(weight*10)/10;
		return weight;
	}
	
	void setMaxWeight(double maxWeight) {
		this.maxWeight = maxWeight;
	}
	
	double getMaxWeight() {
		return maxWeight;
	}

/* numItems Functions */
	int getNumItems() {
		return numItems;
	}
	
	void setNumItems(int numItems) {
		this.numItems = numItems;
	}	
	
	int incNumItems(int newItems) {
		numItems += newItems;
		return numItems;
	}
	
	int decNumItems(int fwrItems) {
		numItems -= fwrItems;
		return numItems;
	}
	
	// Resets the number of items to zero and adds the quantity for all items
	int calculateNumItems() {
		numItems = 0;
		if (itemList.isEmpty()) return numItems;	//if there are no items just return 0
		return itemList.size();
	}

/* money Functions */
// TODO Take weight into account when adding coins.
	int getMoney() {
		return money;
	}
	void setMoney(int money) {
		this.money = money;
	}
	int addMoney(int amount) {
		money += amount;
		return money;
	}
	int rmvMoney(int amount) {
		money -= amount;
		return money;
	}
}
