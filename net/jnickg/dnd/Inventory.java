package net.jnickg.dnd;

/** This class defines a Character's Inventory,
 * which contains Items as well as Money. 
 */
public class Inventory {
/* Variable Declarations */
	private				double		maxWeight;
	private				int			numItems;
	private				int			money;
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
		numItems = 0;
		money = 0;
	}
	
	Inventory(double maxWeight, int money) {
		numItems = 0;
		this.money = money;
	}
	// Add constructor for copying an existing inventory
	
/* Gets */
	double getMaxWeight() {
		return maxWeight;
	}
	int getNumItems() {
		return numItems;
	}
	int getMoney() {
		return money;
	}
	
/* Sets */
	//Weight Sets
	void setMaxWeight(double maxWeight) {
		this.maxWeight = maxWeight;
	}
	
	//Item Sets
	void setNumItems(int numItems) {
		this.numItems = numItems;
	}	
	int incNumItems() {
		return ++numItems;
	}
	int decNumItems() {
		return --numItems;
	}
	
	//Money Sets
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
