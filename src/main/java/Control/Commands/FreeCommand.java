package Control.Commands;

import Control.Command;
import Model.Cashier;
import Model.Status;
import View.CashierDisplay;

public class FreeCommand implements Command {

    private Cashier cashier;
    private CashierDisplay nextCashierDisplay;

    public FreeCommand(Cashier cashier, CashierDisplay nextCashierDisplay) {
        this.cashier = cashier;
        this.nextCashierDisplay = nextCashierDisplay;
    }

    @Override
    public void execute() {
        cashier.setStatus(Status.FREE);
        nextCashierDisplay.show(cashier);
    }
}
