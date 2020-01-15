package Control.Commands;

import Control.Command;
import Model.Cashier;
import Model.Status;
import View.CashierDisplay;

public class FreeCommand implements Command {

    private Cashier cashier;

    public FreeCommand(Cashier cashier) {
        this.cashier = cashier;
    }

    @Override
    public void execute() {
        cashier.setStatus(Status.FREE);
    }
}
