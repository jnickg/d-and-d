package net.jnickg.dnd;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
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
	
	// ItemList<Item, quantity>
	// TODO make this a TreeMap?
	private	HashMap<Item, Integer> 	itemList = new HashMap<>();
	
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
			Collection<Item> items = itemList.keySet();
			for (Item i : items) {
				itemStr.append(i.infoString() + "\n");
			}
		}
		return itemStr.toString();
	}
	
/* Item functions */
	public boolean addItem(Item thisItem, int quantity) {
		//Should this add as many as possible if sending over capacity, or none?
		if(weight + (thisItem.getItemWeight() * quantity) <= maxWeight) {	//if there is enough weight-room
			addWeight(thisItem.getItemWeight() * quantity);
			incNumItems(quantity);
			
			//If it already exists, combine existing quantity with quantity to add
			if(itemList.containsKey(thisItem))	quantity += itemList.get(thisItem);
			
			itemList.put(thisItem, quantity);	// add/replace KV pair
			return true;
		}
		else {
			System.out.println("Eror: adding this item would put you over capacity!\n\tDidn't add any items");
			return false;
		}
	}
	
	public List<Item> findItem(String thisItem) {
		List<Item> foundItems = new ArrayList<Item>();
		for(Item i: itemList.keySet()) {
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
		if (itemList.isEmpty()) return weight;	//if there are no items just return the weight
		
		// Otherwise, iterate through all items in the list,
		// and add their weight times their quantity 
		Set<Item> iList = itemList.keySet();
		for (Item i : iList) {
			weight += (i.getItemWeight() * itemList.get(i));
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
		Collection<Integer> items = itemList.values();
		for (Integer i : items) {
			numItems += i;
		}
		return numItems;
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
