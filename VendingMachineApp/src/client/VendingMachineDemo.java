package client;

import entities.Item;
import entities.Slot;
import entities.VendingMachine;
import enums.Coin;

public class VendingMachineDemo {
	public static void main(String[] args) {
		VendingMachine vendingMachine = VendingMachine.getInstance();
		
		Item item = new Item.Builder("COKE")
							.itemId("102")
							.cost(12)
							.build();
		
		Slot slot = new Slot.Builder(10)
							.slotId("34")
							.item(item)
							.quantity(0)
							.build();
		
		vendingMachine.addSlot(slot);
		
		vendingMachine.getInventory().restock("34", 5);
		
		vendingMachine.selectItem("34");
		vendingMachine.cancelTransaction();
		
		System.out.println();
		
		vendingMachine.selectItem("34");
		vendingMachine.insertAmount(Coin.FIVE);
		vendingMachine.insertAmount(Coin.TEN);
		vendingMachine.insertAmount(Coin.TWO);
		
		vendingMachine.dispenseItem();
	}
}
