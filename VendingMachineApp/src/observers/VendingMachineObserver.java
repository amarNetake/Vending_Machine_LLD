package observers;

import entities.VendingMachine;

public interface VendingMachineObserver {
	void onEvent(VendingMachine vendingMachine);
}
