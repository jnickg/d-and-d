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
	
/* itemList Functions */
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
	
	public Item getItem(String thisItem) {
		Item foundItem = null;
		for(Item i: itemList.keySet()) {
			if (i.getItemName().equalsIgnoreCase(thisItem)) foundItem=i;
		}
		return foundItem;
	}
	// TODO overload with int argument to search by index???
	
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
				invStr.append(i.infoString() + "\n");
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
		// TODO Add a boolean to check whether its been updated
		// since last weight calc, instead of doing it this way.
		
		//or, you know, just have it recalculate every time you add
		//but don't do that because it's not needed.
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
	
	// TODO add a way to handle weight of coins. doing that later.
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

/* numItems Functions */
	int getNumItems() {
		// TODO add a boolean "ifchanged" to detect
		// changes since last calculation
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
		if (itemList.isEmpty()) return numItems;	//if there are no items just return 0
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
