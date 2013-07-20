package net.jnickg.dnd;

import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

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
	private	HashMap<Item, Integer> 	itemList = new HashMap<>();	// stores instances of Items inside the inventory

	// The below is probably not necessary
	/* Class Enums */
	//	private				enum		Coin{
	//			CP(1), SP(10), GP(20), PP(100)
	//			private int value;
	//			private Coin(int value) {
	//				this.value = value;
	//			}
	//	};
	
/* Constructors */
	Inventory() {
		maxWeight = 0.0;
		weight = 0.0;
		numItems = 0;
		money = 0;
	}
	
	Inventory(double maxWeight) {
		this.maxWeight = maxWeight;
		numItems = 0;
		weight = 0;
		money = 0;
	}
	
	Inventory(double maxWeight, double weight, int money) {
		this.maxWeight = maxWeight;
		numItems = 0;
		this.weight = weight;
		this.money = money;
	}
	// Add constructor for copying an existing inventory
	
	
	
	
	
/* itemList Functions */
	
	// Should this be public or private?
	public boolean addItem(Item thisItem, int quantity) {
		if(weight + (thisItem.getItemWeight() * quantity) <= maxWeight) {	//if there is enough weight-room
			addWeight(thisItem.getItemWeight() * quantity);
			incNumItems(quantity);
			
			//If it already exists, combine existing quantity with quantity to add
			if(itemList.containsKey(thisItem))	quantity += itemList.get(thisItem);
			
			itemList.put(thisItem, quantity);	// add/replace KV pair
			return true;
		}
		else {
			System.out.println("Eror: adding this item would put you over capacity!");
			return false;
		}
	}
	
	// I'm worried that this HashMap will not be useful if the key is an actual instance...
	// Going ahead and trying it anyways.
	// Creates a new item and attempts to add it to the inventory
//	public Item createItem(String thisName, String thisNote, Double thisWeight, int quantity) {
//		Item newItem = new Item(thisName, thisNote, thisWeight);
//		addItem(newItem, quantity);
//		return newItem;
//	}
	
	public String toString() {
		StringBuilder invStr = new StringBuilder();
		invStr.append(String.format("Inventory: %.2f lbs, %d items\n", getWeight(), getNumItems()));
		if (itemList.isEmpty()) {
			invStr.append("This inventory is empty.\n\n");
			return invStr.toString();
		}
		else {
			Collection<Item> items = itemList.keySet();
			for (Item i : items) {
				invStr.append(i.toString() + "\n");
			}
		}
		invStr.append("\n\n");
		return invStr.toString();
	}
	
	
	
	
/* maxWeight Functions */
	void setMaxWeight(double maxWeight) {
		this.maxWeight = maxWeight;
	}
	
	double getMaxWeight() {
		return maxWeight;
	}
	
	
	
	
	
/* weight Functions */
	double getWeight() {
		// Eventually add a boolean to check whether its been updated
		// since last weight calc, instead of doing it this way.
		return calculateWeight();
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
	
	//need to add a way to handle weight of coins. doing that later.
	//resets weight to zero and adds the weights for all items
	double calculateWeight() {
		weight = 0;
		if (itemList.isEmpty()) return weight;	//if there are no items just return the weight
		
		// Otherwise, iterate through all items in the list, and add their weight times their quantity 
		Set<Item> iList = itemList.keySet();
		for (Item i : iList) {
			weight += (i.getItemWeight() * itemList.get(i));
		}
		weight = Math.round(weight*10)/10;
		return weight;
	}
	
	
	
	
	
/* numItems Functions */
	int getNumItems() {
		//add a boolean "ifchanged" to detect changes since last calculation
		return calculateNumItems();
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
		if (itemList.isEmpty()) return numItems;	//if there are no items just return the weight
		Collection<Integer> items = itemList.values();
		for (Integer i : items) {
			numItems += i;
		}
		return numItems;
	}
	
	
	
	
/* money Functions */
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
