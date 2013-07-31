package net.jnickg.dnd.inv;

import java.util.ArrayList;
import java.util.List;

public class InvTest {

	public static void main(String[] args) {
		Inventory myInv = new Inventory(100.0);
		System.out.print(myInv.toString());
		myInv.addWeapon("Steel Sword", "inscribed with runes",
				2.0, 10, 10, "1d8", false, 0.0, "SLASHING", 2);
		System.out.print(myInv.toString());
		myInv.addWeapon("Club", "cracked",
				4.5, 5, 7, "1d6", false, 0.0, "BLUDGEONING", 1);
		System.out.print(myInv.toString());
		myInv.addWeapon("Longbow", "made by elves",
				2.2, 3, 10, "1d8", true, 90.0, "PIERCING", 1);
		System.out.print(myInv.toString() + myInv.itemString());
		
		searchPrint(myInv, "Steel Sword");
		
		myInv.addArmor("Iron Cauldron Armor", "Made for Korgeth by Davik",
				15.0, 15, 10, 4, 2, -4, "HEAVY", 1);
		
		myInv.addStdGenItem("NAME", 2);
		
		System.out.print(myInv.toString() + myInv.itemString());
		
	}
	
	public static void searchPrint(Inventory inv, String srch) {
		List<Item> foundItems = new ArrayList<>(inv.findItem(srch));
		for (Item i: foundItems) {
			System.out.println(i.infoString());
		}	
	}

}
