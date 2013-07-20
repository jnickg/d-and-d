package net.jnickg.dnd;

public class InvTest {

	public static void main(String[] args) {
		Inventory myInv = new Inventory(100.0);
		System.out.print(myInv.toString());
		myInv.addItem(new Weapon("Steel Sword", "inscribed with runes",
				2.0, "1d8", false, 0.0, "SLASHING"), 2);
		System.out.print(myInv.toString());
		myInv.addItem(new Weapon("Club", "cracked",
				4.5, "1d6", false, 0.0, "BLUDGEONING"), 1);
		System.out.print(myInv.toString());
		myInv.addItem(new Weapon("Longbow", "made by elves",
				2.2, "1d8", true, 90.0, "PIERCING"), 1);
		System.out.print(myInv.toString());
	}

}
