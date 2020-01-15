package Control.Commands;

import Control.Command;
import Model.Cashier;
import Model.Status;

public class BusyCommand implements Command {

    private Cashier cashier;

    public BusyCommand(Cashier cashier) {
        this.cashier = cashier;
    }

    @Override
    public void execute() {
        cashier.setStatus(Status.BUSY);
    }
}
