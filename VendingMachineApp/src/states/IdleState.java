package states;

import entities.Item;
import entities.VendingMachine;
import enums.Coin;
import enums.MachineStatus;

public class IdleState implements VendingMachineState {

	@Override
	public void selectItem(VendingMachine vendingMachine, String slotId) {
		boolean isAvailable = vendingMachine.isAvailable(slotId);
		if(isAvailable==false) {
			System.out.println("Sorry selected item is out of stock... Choose another item...");
			return;
		}
		Item item = vendingMachine.getInventory().getItem(slotId);
		vendingMachine.setSelectedItem(item);
		System.out.println("YOU SELECTED ITEM: %s".formatted(item));
		vendingMachine.setState(new ItemSelectedState());
		vendingMachine.notifyAllObservers();
	}

	@Override
	public void insertAmount(VendingMachine vendingMachine, Coin coin) {
		System.out.println("Please select the item first...");
		System.out.println("Inserted coin: "+coin);
		int balance = vendingMachine.getBalance() +  coin.getValue(); //By mistake if someone put the coin before selecting item we shall still count it
		vendingMachine.setBalance(balance);

	}

	@Override
	public void dispenseItem(VendingMachine vendingMachine) {
		System.out.println("Please select item first...");

	}

	@Override
	public void cancelTransaction(VendingMachine vendingMachine) {
		if(vendingMachine.getBalance()>0) {
			System.out.println("Refunding amount %d".formatted(vendingMachine.getBalance()));
			vendingMachine.setBalance(0);
		}
		System.out.println("Transaction has been terminated...");
		vendingMachine.setSelectedItem(null);
		vendingMachine.setState(new IdleState());
	}

	@Override
	public MachineStatus getStatus() {
		return MachineStatus.IDLE;
	}

}
