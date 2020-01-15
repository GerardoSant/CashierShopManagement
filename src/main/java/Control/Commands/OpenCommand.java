package Control.Commands;

import Control.Command;
import Model.Cashier;
import Model.Status;

public class OpenCommand implements Command {

    Cashier cashier;

    public OpenCommand(Cashier cashier) {
        this.cashier = cashier;
    }

    public void execute() {
        cashier.setStatus(Status.BUSY);
    }
}
