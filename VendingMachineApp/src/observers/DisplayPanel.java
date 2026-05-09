package observers;

import entities.VendingMachine;
import enums.MachineStatus;

public class DisplayPanel implements VendingMachineObserver {

	@Override
	public void onEvent(VendingMachine vendingMachine) {
		MachineStatus status = vendingMachine.getCurrentState().getStatus();
		System.out.println("Current status: %s".formatted(status));
	}

}
