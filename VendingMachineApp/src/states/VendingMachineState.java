package states;

import entities.VendingMachine;
import enums.Coin;
import enums.MachineStatus;

public interface VendingMachineState {
	
	void selectItem(VendingMachine vendingMachine, String slotId);
	void insertAmount(VendingMachine vendingMachine, Coin coin);
	void dispenseItem(VendingMachine vendingMachine);
	void cancelTransaction(VendingMachine vendingMachine);
	MachineStatus getStatus();
}
