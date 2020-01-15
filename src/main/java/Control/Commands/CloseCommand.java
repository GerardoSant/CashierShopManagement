package Control.Commands;

import Control.Command;
import Model.Cashier;
import Model.Status;

public class CloseCommand implements Command {
    private Cashier cashier;

    public CloseCommand(Cashier cashier) {
        this.cashier = cashier;
    }


    @Override
    public void execute() {
        cashier.setStatus(Status.CLOSED);
    }
}
